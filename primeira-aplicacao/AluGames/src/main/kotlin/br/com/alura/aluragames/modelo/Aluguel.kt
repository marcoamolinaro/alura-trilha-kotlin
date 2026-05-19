package org.example.br.com.alura.aluragames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo
) {

        override fun toString(): String {
            return "Aluguel:\n" +
                    "\tGamer: ${gamer.nome}\n" +
                    "\tJogo: ${jogo.titulo}"
        }
}
