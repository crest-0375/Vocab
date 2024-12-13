package com.app.vocab.features.home.data.mappers

import com.app.vocab.features.home.data.repository.dto.WordDto
import com.app.vocab.features.home.domain.model.Word

fun WordDto.toWord(): Word {
    return Word(word = this.word)
}