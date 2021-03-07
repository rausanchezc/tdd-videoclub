package org.rsanchezc.repository

import org.rsanchezc.domain.Film
import org.rsanchezc.domain.Order
import java.sql.Connection
import java.sql.SQLException

class FilmRepositoryImpl(private val connection: Connection): FilmRepository {
    override fun findAllOrderByRating(order: Order): List<Film> {
        val query = "SELECT id, title, rating FROM film ORDER BY rating $order"
         try {
            val resultSet = connection.prepareStatement(query).executeQuery()
            val films = mutableListOf<Film>()
            while (resultSet.next())  {
                films.add(Film(
                    id =  resultSet.getInt("id"),
                    title =  resultSet.getString("title"),
                    rating =  resultSet.getFloat("rating")
                ))
            }
            return films
        } catch (e: SQLException) {
            throw Exception("Unable to perform operation")
        }
    }
}