package org.rsanchezc.service

import org.rsanchezc.domain.Film
import org.rsanchezc.domain.Order

interface FilmService {
    fun getAllByRating(order: Order): List<Film>
}