package org.hxl.cinema.list

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import java.io.IOException
import java.net.UnknownHostException

class CinemaPaging<T: Any>(private val getList: suspend (page: Int) -> List<T>): PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getList(nextPageNumber)
            Log.d("PAGING", "load: ${response.size}")
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = if (response.isEmpty()) null else nextPageNumber + 1,
                LoadResult.Page.COUNT_UNDEFINED,
                LoadResult.Page.COUNT_UNDEFINED
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