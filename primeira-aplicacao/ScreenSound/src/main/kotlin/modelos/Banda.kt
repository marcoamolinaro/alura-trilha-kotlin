package br.scm.modelos

class Banda(
    val nome: String = "Nome da banda",
    val descricao: String = "Descricao da Banda",
    val id: Int = 0
) {
    override fun toString(): String {
        return "Nome do Banda: #$id - $nome"
    }
}