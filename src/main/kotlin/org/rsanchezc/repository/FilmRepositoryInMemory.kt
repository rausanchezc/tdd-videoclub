package org.rsanchezc.repository

import org.rsanchezc.domain.Film
import org.rsanchezc.domain.Order

class FilmRepositoryInMemory: FilmRepository {

    override fun findAllOrderByRating(order: Order): List<Film> {
        return if (order == Order.ASC) {
            STORED_FILMS.values.toList().sortedBy { it.rating }
        } else {
            STORED_FILMS.values.toList().sortedByDescending { it.rating }
        }
    }

    companion object {
        private val STORED_FILMS = hashMapOf(
            1 to Film(1, "Coco", 8.9F),
            2 to Film(2, "Klaus", 9.8F)
        )
    }
}