package org.hxl.network.mapper.detail

import org.hxl.model.movies.detail.SpokenLanguage
import org.hxl.network.model.detail.SpokenLanguageDTO

fun SpokenLanguageDTO.mapToModel(): SpokenLanguage {
    return SpokenLanguage(
        englishName,
        iso6391,
        name
    )
}