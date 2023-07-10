package org.hxl.cinema.detail.series

import org.hxl.cinema.detail.base.BaseCinemaDetailsVM
import org.hxl.domain.useCases.cinema.series.GetSeriesById
import org.hxl.model.cinema.series.SeriesDetails

class SeriesDetailsVM(getSeriesById: GetSeriesById): BaseCinemaDetailsVM<SeriesDetails>(getSeriesById)