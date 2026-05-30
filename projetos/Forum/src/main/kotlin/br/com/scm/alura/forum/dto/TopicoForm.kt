package br.com.scm.alura.forum.dto

data class TopicoForm(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idUsuario: Long
)
