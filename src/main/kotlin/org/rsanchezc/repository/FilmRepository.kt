package org.rsanchezc.repository

import org.rsanchezc.domain.Film
import org.rsanchezc.domain.Order

interface FilmRepository {
    fun findAllOrderByRating(order: Order): List<Film>
}