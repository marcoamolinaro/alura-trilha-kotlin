package org.example.br.com.alura.aluragames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorDoAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "\nAluguel:\n" +
                "\tGamer: ${gamer.nome}\n" +
                "\tJogo: ${jogo.titulo}\n" +
                "\tValor do Alugue: R$ $valorDoAluguel"
    }
}
