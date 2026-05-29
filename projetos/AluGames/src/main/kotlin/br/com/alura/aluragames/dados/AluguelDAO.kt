package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Aluguel
import org.example.br.com.alura.aluragames.utils.toEntity
import org.example.br.com.alura.aluragames.utils.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(
            objeto.gamer.toEntity(),
            objeto.jogo.toEntity(),
            objeto.periodo)
            .apply {
                id = objeto.id
                valorDoAluguel = objeto.valorDoAluguel
            }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(
            entity.gamer.toModel(),
            entity.jogo.toModel(),
            entity.periodo
        ).apply {
            id = entity.id
        }
    }
}