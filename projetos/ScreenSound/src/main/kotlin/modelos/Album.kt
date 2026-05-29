package br.scm.modelos

class Album(
    val titulo: String = "Título do Album",
    val banda: Banda = Banda(),
    val id: Int = 0
) {

    override fun toString(): String {
        return "Título do Album: $banda, ID: $id"
    }
}