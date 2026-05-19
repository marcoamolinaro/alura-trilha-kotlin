package org.example.br.com.alura.aluragames.servicos

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.modelo.InfoGamerJson
import org.example.br.com.alura.aluragames.modelo.InfoJogo
import org.example.br.com.alura.aluragames.utils.criaGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    private fun consomeDados(url: String): String? {
        val client: HttpClient? = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response: HttpResponse<String?>? = client!!
            .send(request, BodyHandlers.ofString())

        return response?.body()
    }

    fun buscaJogo(id: String) :InfoJogo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consomeDados(url)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamers() :List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(url)

        val gson = Gson()

        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map {
            infoGamerJson -> infoGamerJson.criaGamer()
        }

        return listaGamerConvertida
    }
}