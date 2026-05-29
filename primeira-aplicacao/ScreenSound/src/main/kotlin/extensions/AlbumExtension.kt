package br.scm.extensions

import br.scm.dados.AlbumEntity
import br.scm.modelos.Album

fun Album.toEntity(): AlbumEntity {
	return AlbumEntity(this.titulo, this.banda.toEntity(), this.id)
}

fun AlbumEntity.toModel(): Album {
	return Album (this.titulo, this.banda.toModel(), this.id)
}