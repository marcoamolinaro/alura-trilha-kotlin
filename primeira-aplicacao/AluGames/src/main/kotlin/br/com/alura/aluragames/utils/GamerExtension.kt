package org.example.br.com.alura.aluragames.utils

import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(
            this.nome,
            this.email,
            this.dataNascimento,
            this.usuario)
}