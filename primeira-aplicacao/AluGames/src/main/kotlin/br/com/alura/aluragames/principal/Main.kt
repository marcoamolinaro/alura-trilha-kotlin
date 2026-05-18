package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.modelo.Jogo
import org.example.br.com.alura.aluragames.servicos.ConsumoApi
import org.example.br.com.alura.aluragames.utils.transoformarEmIdade
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)
    println(gamer)
    println("Idade do ${gamer.nome}: " + gamer.dataNascimento?.transoformarEmIdade())

    println("Cadastro do gamer concluído com sucesso!\n Dados do gamer: $gamer")

    do {
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

            gamer.jogosBuscados.add(meuJogo)

            print(meuJogo.toString())
        }

        println("\nDeseja realizar outra busca? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("S", true))

    println("Jogos buscados:\n ${gamer.jogosBuscados.joinToString("\n")}")

    println("\nJogos ordenados por título: ")
    gamer.jogosBuscados.sortedBy { it?.titulo }

    gamer.jogosBuscados.forEach {
        println("Título: ${it?.titulo}")
    }

    val jogosFiltrados = gamer.jogosBuscados.filter{
        it?.titulo?.contains("batman", true) ?: false
    }
    print ("\nJogos filtrados:\n ${jogosFiltrados.joinToString("\n")}")

    println("\nDeseja excluir algum jogo da lista original (S/N) ?")
    val opcao = leitura.nextLine()

    if (opcao.equals("S", true)) {
        println(gamer.jogosBuscados.joinToString("\n"))
        println("\nInforme a posição do jogo a ser excluído (1, 2, 3...)")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\nLista atualizada:\n ${gamer.jogosBuscados.joinToString("\n")}")

    println("Busca realizada com sucesso!")
}
