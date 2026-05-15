package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o ID do jogo:")
    val id = leitura.nextLine()

    val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val client: HttpClient? = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build()

    val response: HttpResponse<String?>? = client!!
        .send(request, BodyHandlers.ofString())

    val json = response?.body()

    //println(json)

    /*
    try {
        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        val meuJogo = Jogo(
            titulo = meuInfoJogo.info.title,
            capa = meuInfoJogo.info.thumb
        )
        println(meuJogo)
    } catch (e: Exception) {
        println("Ocorreu um erro ao criar o jogo: ${e.message}")
    }
*/

    var meuJogo:Jogo? = null

    val resultado = runCatching {
        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        meuJogo = Jogo(
            titulo = meuInfoJogo.info.title,
            capa = meuInfoJogo.info.thumb
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
