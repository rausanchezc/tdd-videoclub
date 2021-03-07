package org.rsanchezc.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.rsanchezc.domain.Order
import org.rsanchezc.repository.FilmRepositoryInMemory
import org.rsanchezc.utils.Films.COCO
import org.rsanchezc.utils.Films.KLAUS

class FilmServiceTestShould {

    private val filmService: FilmService = FilmServiceImpl(FilmRepositoryInMemory())

    @Test
    fun `return films ordered by rating`() {
        assertEquals(
            filmService.getAllByRating(Order.DESC),
            listOf(KLAUS, COCO)
        )
    }
}