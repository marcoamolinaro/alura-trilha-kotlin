package br.scm.dados

import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.persistence.EntityManagerFactory


object Banco {
    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("musicasbd")
        return factory.createEntityManager()
    }
}