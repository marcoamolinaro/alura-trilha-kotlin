package org.example.br.com.alura.aluragames.servicos

import com.google.gson.Gson
import org.example.br.com.alura.aluragames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    fun buscaJogo(id: String) :InfoJogo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient? = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response: HttpResponse<String?>? = client!!
            .send(request, BodyHandlers.ofString())

        val json = response?.body()

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }
}