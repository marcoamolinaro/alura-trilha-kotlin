package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.utils.toEntity
import org.example.br.com.alura.aluragames.utils.toModel
import javax.persistence.EntityManager
import kotlin.jvm.java

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}