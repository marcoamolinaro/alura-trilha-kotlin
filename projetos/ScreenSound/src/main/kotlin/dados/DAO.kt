package br.scm.dados

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    val manager: EntityManager,
    val entityType: Class<TEntity>
) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    private fun preparaQuery(id: Int): TEntity? {
        val query = manager.createQuery(
            "FROM ${entityType.simpleName} WHERE id = :id",
            entityType
        )
        query.setParameter("id", id)
        return query.singleResult
    }

    open fun getLista(): List<TModel> {
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
        val entity = preparaQuery(id)
        return toModel(entity!!)
    }

    open fun apagar(id: Int) {
        val entity = preparaQuery(id)
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}

