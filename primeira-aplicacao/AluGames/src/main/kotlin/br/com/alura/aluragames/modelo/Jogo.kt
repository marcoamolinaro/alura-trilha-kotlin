package org.example.br.com.alura.aluragames.modelo

data class Jogo(
    val titulo: String,
    val capa: String) {

    var descricao:String? = null
    override fun toString(): String {
        return "Meu Jogo:\n" +
                  "\tTitulo: $titulo\n" +
                  "\tCapa: $capa \n" +
                  "\tDescricao: $descricao"
    }
}