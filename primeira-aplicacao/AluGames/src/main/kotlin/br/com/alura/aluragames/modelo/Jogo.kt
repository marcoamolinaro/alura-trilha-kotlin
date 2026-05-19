package org.example.br.com.alura.aluragames.modelo

data class Jogo(
    val titulo: String,
    val capa: String) {

    var preco = 0.0
    var descricao: String? = null

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
        this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
            "Título: $titulo \n" +
            "Capa: $capa \n" +
            "Descricao: $descricao" +
            "Preço: $preco"
    }

}