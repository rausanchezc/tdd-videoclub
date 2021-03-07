package org.rsanchezc.service

import org.rsanchezc.domain.Film
import org.rsanchezc.domain.Order
import org.rsanchezc.repository.FilmRepository

class FilmServiceImpl(private val filmRepository: FilmRepository): FilmService {
    override fun getAllByRating(order: Order): List<Film> {
        return filmRepository.findAllOrderByRating(order)
    }
}