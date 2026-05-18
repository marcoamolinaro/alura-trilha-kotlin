package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}