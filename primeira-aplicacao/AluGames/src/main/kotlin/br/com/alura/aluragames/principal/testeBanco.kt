package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.dados.Banco

fun main() {
    val conexao = Banco.obterConexao()

    println(conexao)
}