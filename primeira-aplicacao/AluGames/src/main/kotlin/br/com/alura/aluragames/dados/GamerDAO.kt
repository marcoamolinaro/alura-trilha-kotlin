package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.utils.toEntity
import org.example.br.com.alura.aluragames.utils.toModel
import javax.persistence.EntityManager
import kotlin.jvm.java

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(plano: Gamer): GamerEntity {
        return GamerEntity(
            plano.id,
            plano.nome,
            plano.email,
            plano.dataNascimento,
            plano.usuario,
            plano.plano.toEntity())
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento,
            entity.usuario,
            entity.id
        ).apply{plano = entity.plano.toModel()}
    }
}