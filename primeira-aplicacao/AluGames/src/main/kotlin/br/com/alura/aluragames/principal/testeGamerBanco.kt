package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.dados.Banco
import org.example.br.com.alura.aluragames.modelo.Gamer
import org.example.br.com.alura.aluragames.dados.GamerDAO
import org.example.br.com.alura.aluragames.dados.PlanoDAO

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val planoDAO = PlanoDAO(manager)

    gamer.plano = planoDAO.recuperarPorId(3)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}