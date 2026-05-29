package org.example.br.com.alura.aluragames.modelo

sealed class Plano(
    val tipo: String,
    var id: Int
) {

    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}