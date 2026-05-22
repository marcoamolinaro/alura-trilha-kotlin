package org.example.br.com.alura.aluragames.modelo

data class Jogo(
    val titulo: String,
    val capa: String): Recomendavel {

    var preco = 0.0
    var descricao: String? = null
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota !in 1..10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
        this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "\nMeu Jogo: \n" +
            "Título: $titulo \n" +
            "Capa: $capa \n" +
            "Descricao: $descricao\n" +
            "Preço: $preco\n" +
            "Reputação: %.2f".format(media)
    }

}