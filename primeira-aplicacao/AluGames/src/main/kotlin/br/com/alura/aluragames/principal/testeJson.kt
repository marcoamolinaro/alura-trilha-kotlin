package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Periodo
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

    //println(gamer1)
    //println(jogo1)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(15))

    val aluguel1 = gamer1.alugaJogo(jogo1, periodo1)
    val aluguel2 = gamer1.alugaJogo(jogo2, periodo2)
    val aluguel3 = gamer1.alugaJogo(jogo3, periodo3)

    var totalAluguel: Double = 0.0

    println("\nO(A) gamer ${gamer1.nome} alugou o(s) jogo(s):")
    println("%-35s %-12s %-15s".format("Nome do jogo", "Preço", "Periodo (dias)"))
    println("-".repeat(64))

    gamer1.jogosAlugados.forEach {
        val titulo = it?.jogo?.titulo ?: "-"
        val preco = it?.jogo?.preco ?: 0.0
        val periodoDias = it?.periodo?.emDias ?: 0

        println("%-35s R$ %-9.2f %-15d".format(titulo, preco, periodoDias))
        totalAluguel += it?.valorDoAluguel ?: 0.0
    }

    println("-".repeat(64))
    println("Valor total de R$ ${"%.2f".format(totalAluguel)}")
}