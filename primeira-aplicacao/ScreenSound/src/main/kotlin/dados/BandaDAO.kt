package br.scm.dados

import br.scm.extensions.toEntity
import br.scm.extensions.toModel
import br.scm.modelos.Banda
import javax.persistence.EntityManager

class BandaDAO(manager: EntityManager):
    DAO<Banda, BandaEntity>(manager, BandaEntity::class.java)

{
    override fun toEntity(model: Banda): BandaEntity {
        return model.toEntity()
    }

    override fun toModel(entity: BandaEntity): Banda {
        return entity.toModel()
    }
}