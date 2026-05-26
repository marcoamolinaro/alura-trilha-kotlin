package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Gamer
import javax.persistence.EntityManager
import kotlin.jvm.java

class GamerDAO(val manager: EntityManager) {

    fun getGamers(): List<Gamer>{
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map {
            entity -> Gamer(entity.nome,
                entity.email, entity.dataNascimento, entity.usuario, entity.Id)
        }
    }

    fun adicionarGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.id, gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}