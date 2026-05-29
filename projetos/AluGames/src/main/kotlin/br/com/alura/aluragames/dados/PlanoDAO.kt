package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.*
import org.example.br.com.alura.aluragames.utils.toEntity
import org.example.br.com.alura.aluragames.utils.toModel
import javax.persistence.EntityManager

class PlanoDAO(manage: EntityManager): DAO<Plano, PlanoEntity>(manage, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}