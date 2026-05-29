package br.scm.dados

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    val manager: EntityManager,
    val entityType: Class<TEntity>
) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    private fun prepareQuery(id: Int): TEntity? {
        val query = manager.createQuery(
            "SELECT e FROM ${entityType.simpleName} e WHERE e.id = :id", entityType
        )
        val entity = query.singleResult
        return entity
    }

    open fun getList(): List<TModel> {
        val query = manager.createQuery("SELECT e FROM ${entityType.simpleName} e", entityType)
        return query.resultList.map { toModel(it) }
    }

    open fun adicionar(model: TModel) {
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun recuperarPorId(id: Int): TModel {
        val entity = prepareQuery(id)
        return toModel(entity!!)
    }

    open fun apagar(id: Int) {
        val entity = prepareQuery(id)
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}

