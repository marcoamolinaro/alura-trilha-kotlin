package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.modelo.Gamer

fun main() {
    val gamer1 = Gamer(nome = "Gamer 1", email = "gamer1@gamil.com")
    println(gamer1)

    val gamer2 = Gamer(
        nome = "Gamer 2",
        email = "gamer2@gamil.com",
        dataNascimento = "10/10/2001",
        usuario = "usuario1")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "01/01/2000"
        it.usuario = "usuario2"
        it.idInterno = "1234"
    }

    println(gamer1)
}