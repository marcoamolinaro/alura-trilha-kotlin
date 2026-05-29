package br.scm.dados

import javax.persistence.EntityManager
import javax.persistence.Persistence

object Banco
    fun getEntityManager(): EntityManager {
        val factory = Persistence.createEntityManagerFactory("musicas")
        return factory.createEntityManager()
    }
}