package br.scm.dados

import br.scm.extensions.toEntity
import br.scm.extensions.toModel
import br.scm.modelos.Album
import javax.persistence.EntityManager

class AlbumDAO (manager: EntityManager)
    : DAO<Album, AlbumEntity>(manager, AlbumEntity::class.java) {

    override fun toEntity(model: Album): AlbumEntity {
        return model.toEntity()
    }

    override fun toModel(entity: AlbumEntity): Album {
        return entity.toModel()
    }
}