package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Jogo
import org.example.br.com.alura.aluragames.servicos.ConsumoApi
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o ID do jogo:")
    val id = leitura.nextLine()

    val buscaApi = ConsumoApi()

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val informacaoJogo =  buscaApi.buscaJogo(id)

        meuJogo = Jogo(
            titulo = informacaoJogo.info.title,
            capa = informacaoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição especializada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)) {
            println("Insira a descrição personalizada para o jogo")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca realizada com sucesso!")
    }
}
