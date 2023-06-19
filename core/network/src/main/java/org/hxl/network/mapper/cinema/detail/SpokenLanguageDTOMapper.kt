package org.hxl.network.mapper.cinema.detail

import org.hxl.model.cinema.detail.SpokenLanguage
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO

fun SpokenLanguageDTO.mapToModel(): SpokenLanguage {
    return SpokenLanguage(
        englishName,
        iso6391,
        name
    )
}