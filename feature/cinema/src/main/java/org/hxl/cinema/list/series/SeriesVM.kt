package org.hxl.cinema.list.series

import org.hxl.cinema.list.base.BaseCinemaVM
import org.hxl.domain.useCases.cinema.series.GetSeries
import org.hxl.domain.useCases.prefs.CinemaResultUseCase
import org.hxl.model.cinema.series.SeriesListItem

class SeriesVM(
    getSeries: GetSeries,
    cinemaResult: CinemaResultUseCase
): BaseCinemaVM<SeriesListItem>(getSeries, cinemaResult)
