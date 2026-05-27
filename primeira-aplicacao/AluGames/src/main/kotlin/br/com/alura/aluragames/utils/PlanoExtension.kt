package org.example.br.com.alura.aluragames.utils

import org.example.br.com.alura.aluragames.dados.GamerEntity
import org.example.br.com.alura.aluragames.modelo.Plano
import org.example.br.com.alura.aluragames.modelo.PlanoAssinatura
import org.example.br.com.alura.aluragames.modelo.PlanoAssinaturaEntity
import org.example.br.com.alura.aluragames.modelo.PlanoAvulso
import org.example.br.com.alura.aluragames.modelo.PlanoAvulsoEntity
import org.example.br.com.alura.aluragames.modelo.PlanoEntity

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(
            this.tipo,
            this.mensalidade,
            this.jogosIncluidos,
            this.percentualDescontoReputacao,
            this.id)
    } else {
        PlanoAvulsoEntity(
            this.tipo,
            this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(
            this.tipo,
            this.mensalidade,
            this.jogosIncluidos,
            this.percentualDescontoReputacao,
            this.id)
    } else {
        PlanoAvulso(
            this.tipo,
            this.id
        )
    }
}