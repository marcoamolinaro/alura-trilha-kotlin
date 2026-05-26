package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Plano
import org.example.br.com.alura.aluragames.modelo.PlanoAssinatura
import org.example.br.com.alura.aluragames.modelo.PlanoAssinaturaEntity
import org.example.br.com.alura.aluragames.modelo.PlanoAvulso
import org.example.br.com.alura.aluragames.modelo.PlanoAvulsoEntity
import org.example.br.com.alura.aluragames.modelo.PlanoEntity
import javax.persistence.EntityManager

class PlanoDAO(manage: EntityManager): DAO<Plano, PlanoEntity>(manage, PlanoEntity::class.java) {

    override fun toEntity(objeto: Plano): PlanoEntity {
        return if (objeto is PlanoAssinatura) {
            PlanoAssinaturaEntity(
                objeto.tipo,
                objeto.mensalidade,
                objeto.jogosIncluidos,
                objeto.percentualDescontoReputacao,
                objeto.id)
        } else {
            PlanoAvulsoEntity(
                objeto.tipo,
                objeto.id)
        }
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return if (entity is PlanoAssinaturaEntity) {
            PlanoAssinatura(
                entity.tipo,
                entity.mensalidade,
                entity.jogosIncluidos,
                entity.percentualDescontoReputacao,
                entity.id)
        } else {
            PlanoAvulso(
                entity.tipo,
                entity.id
            )
        }
    }
}