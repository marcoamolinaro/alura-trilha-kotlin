package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.dados.Banco
import org.example.br.com.alura.aluragames.dados.JogoDAO
import org.example.br.com.alura.aluragames.modelo.Jogo

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogoDAO(manager)

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo1 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    jogoDAO.adicionar(jogo1)

    val listaJogos: List<Jogo> = jogoDAO.getLista()

    println(listaJogos)

    manager.close()
}