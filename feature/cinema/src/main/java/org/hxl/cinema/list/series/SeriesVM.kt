package org.hxl.cinema.list.series

import org.hxl.cinema.list.BaseCinemaVM
import org.hxl.domain.useCases.cinema.series.GetSeries
import org.hxl.model.cinema.series.SeriesListItem

class SeriesVM(getSeries: GetSeries): BaseCinemaVM<SeriesListItem>(getSeries)