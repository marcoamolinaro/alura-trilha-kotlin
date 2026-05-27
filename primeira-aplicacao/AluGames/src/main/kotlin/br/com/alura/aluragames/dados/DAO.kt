package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Jogo
import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(
    protected val manager: EntityManager,
    protected val entityType: Class<TEntity>) {

    abstract fun toEntity(plano: TModel): TEntity

    abstract fun toModel(entity: TEntity): TModel

    open fun getLista(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map {
            entity -> toModel(entity)
        }
    }

    open fun adicionar(plano: TModel) {
        val entity = toEntity(plano)

        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun recuperarPorId(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun apagar(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }


}
