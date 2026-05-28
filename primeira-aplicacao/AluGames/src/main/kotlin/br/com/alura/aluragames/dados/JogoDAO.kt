package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Jogo
import org.example.br.com.alura.aluragames.utils.toEntity
import javax.persistence.EntityManager

class JogoDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity{
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao!!, entity.id)
    }

}