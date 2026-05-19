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

    println(gamer1)
    println(jogo1)

    val dias = 7L

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(dias))

    val aluguel = gamer1.alugaJogo(jogo1, periodo1)

    println("O(A) gamer ${gamer1.nome} alugou o " +
        "jogo ${jogo1.titulo} por R$ ${jogo1.preco} por um periodo de ${dias} dias")
    println(aluguel)
}