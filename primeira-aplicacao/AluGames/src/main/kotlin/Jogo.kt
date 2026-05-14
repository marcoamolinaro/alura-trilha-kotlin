package org.example

class Jogo(val titulo: String, val capa: String) {

    val descricao = ""
    override fun toString(): String {
        return "Meu Jogo:\n" +
                  "\tTitulo: $titulo\n" +
                  "\tCapa: $capa \n" +
                  "\tDescricao: $descricao"
    }
}