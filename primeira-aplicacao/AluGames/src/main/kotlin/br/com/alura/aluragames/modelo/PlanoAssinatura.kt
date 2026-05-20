package org.example.br.com.alura.aluragames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidae: Double,
    val jogosIncluidos: Int) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes =
            aluguel.gamer.jogoDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (totalJogosNoMes <= jogosIncluidos) {
            0.0
        } else {
            super.obterValor(aluguel)
        }
    }
}
