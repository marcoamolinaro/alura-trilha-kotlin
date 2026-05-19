package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Jogo
import org.example.br.com.alura.aluragames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()
//    val jogoApi = consumo.buscaJogo("143")
//
//    println("Lista de Gamers:\n $listaGamers")
//    println("\nJogo :\n $jogoApi")

    val gamer1 = listaGamers.get(3)
    val jogo1 = listaJogosJson.get(10)

    println(gamer1)
    println(jogo1)

    val aluguel = gamer1.alugaJogo(jogo1)

    println("O gamer ${gamer1.nome} alugou o ${jogo1.titulo} por ${jogo1.preco} reais")
    println(aluguel)
}