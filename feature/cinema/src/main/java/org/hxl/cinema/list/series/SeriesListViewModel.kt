package org.hxl.cinema.list.series

import androidx.lifecycle.ViewModel
import org.hxl.domain.useCases.cinema.series.GetPopularSeries
import org.hxl.domain.useCases.cinema.series.GetTopSeries

class SeriesListViewModel(
    val getPopularSeries: GetPopularSeries,
    val getTopSeries: GetTopSeries
): ViewModel()