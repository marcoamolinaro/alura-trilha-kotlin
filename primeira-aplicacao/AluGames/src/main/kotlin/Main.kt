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

    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

    val meuJogo = Jogo(
        titulo = meuInfoJogo.info.title,
        capa = meuInfoJogo.info.thumb
    )

    println(meuJogo)

}