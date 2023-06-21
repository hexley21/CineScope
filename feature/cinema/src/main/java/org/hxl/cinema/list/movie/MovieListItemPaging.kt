package org.hxl.cinema.list.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import org.hxl.model.cinema.movie.MovieListItem
import java.io.IOException
import java.net.UnknownHostException

class MovieListItemPaging(private val getMovieListItem: suspend (page: Int) -> List<MovieListItem>): PagingSource<Int, MovieListItem>() {
    override fun getRefreshKey(state: PagingState<Int, MovieListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieListItem> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getMovieListItem(nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        }
        catch (e: IOException) {
            LoadResult.Error(e)
        }
        catch (e: HttpException) {
            LoadResult.Error(e)
        }
        catch (e: UnknownHostException) {
            LoadResult.Error(e)
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}