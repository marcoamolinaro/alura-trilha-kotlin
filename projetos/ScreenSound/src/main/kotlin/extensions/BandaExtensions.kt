package br.scm.extensions

import br.scm.dados.BandaEntity
import br.scm.modelos.Banda

fun Banda.toEntity(): BandaEntity {
 return BandaEntity(this.nome, this.descricao, this.id)
}

fun BandaEntity.toModel(): Banda {
 return Banda(this.nome, this.descricao, this.id)
}