package br.com.scm.alura.forum.dto

data class TopicoForm(
    var id: Long?,
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idUsuario: Long
)
