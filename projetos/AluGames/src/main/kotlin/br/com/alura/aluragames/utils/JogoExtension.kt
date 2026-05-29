package org.example.br.com.alura.aluragames.utils

import org.example.br.com.alura.aluragames.dados.JogoEntity
import org.example.br.com.alura.aluragames.modelo.InfoJogoJson
import org.example.br.com.alura.aluragames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao!!, this.id)
}