package org.example.br.com.alura.aluragames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorDoAluguel =
        jogo.preco * periodo.emDias

    override fun toString(): String {
        return "Aluguel:\n" +
                "\tGamer: ${gamer.nome}\n" +
                "\tJogo: ${jogo.titulo}\n" +
                "\tValor do Alugue: R$ $valorDoAluguel"
    }
}
