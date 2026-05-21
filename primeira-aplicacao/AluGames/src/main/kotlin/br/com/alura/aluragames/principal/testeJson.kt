package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.modelo.Periodo
import org.example.br.com.alura.aluragames.modelo.PlanoAssinatura
import org.example.br.com.alura.aluragames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()
//    val jogoApi = consumo.buscaJogo("143")
//
//    println("Lista de Gamers:\n $listaGamers")
//    println("\nJogo :\n $jogoApi")

    val gamer1 = listaGamers[3]
    val jogo1 = listaJogosJson[10]
    val jogo2 = listaJogosJson[13]
    val jogo3 = listaJogosJson[14]
    val jogo4 = listaJogosJson[2]

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(15))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))
    val periodo5 = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))

    gamer1.alugaJogo(jogo1, periodo1)
    gamer1.alugaJogo(jogo2, periodo2)
    gamer1.alugaJogo(jogo3, periodo3)
    gamer1.alugaJogo(jogo4, periodo4)

    imprimirRecibo(gamer1)

    println("\nJogos do mês 08: ${gamer1.jogoDoMes(8)}")

    val gamer2 = listaGamers[5]
    //gamer2.plano = PlanoAssinatura("PRATA", 9.90, 3)
    gamer2.alugaJogo(jogo1, periodo1)
    gamer2.alugaJogo(jogo2, periodo2)
    gamer2.alugaJogo(jogo3, periodo3)
    gamer2.alugaJogo(jogo4, periodo5)

    imprimirRecibo(gamer2)

    gamer2.recomendar(7)
    gamer2.recomendar(10)
    gamer2.recomendar(8)

    println(gamer2)

    gamer2.alugaJogo(jogo1, periodo1)

    imprimirRecibo(gamer2)

}

private fun imprimirRecibo(gamer1: Gamer) {
    var totalAluguel = 0.0

    println("\nO(A) gamer ${gamer1.nome} alugou o(s) jogo(s):")
    println(
        "%-35s %-12s %-15s %-12s"
            .format("Nome do jogo", "Preço", "Periodo (dias)", "Preço aluguel")
    )
    println("-".repeat(80))

    gamer1.jogosAlugados.forEach {
        val titulo = it?.jogo?.titulo ?: "-"
        val preco = it?.jogo?.preco ?: 0.0
        val periodoDias = it?.periodo?.emDias ?: 0
        val valorAluguel = it?.valorDoAluguel
        println("%-35s R$ %-9.2f %-15d R$ %-9.2f".format(titulo, preco, periodoDias, valorAluguel))
        totalAluguel += valorAluguel!!
    }

    println("-".repeat(80))
    println("Valor total de R$ ${"%.2f".format(totalAluguel)}")
}