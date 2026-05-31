package br.com.scm.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoForm(
    @field:NotEmpty(message = "Título não pode ser vazio")
    @field:Size(min = 10, max = 100, message = "Título deve conter entre 10 e 100 caracteres")
    val titulo: String,

    @field:NotEmpty(message = "Mensagem não pode ser vazia")
    val mensagem: String,

    @field:NotNull(message = "ID do curso é obrigatório")
    val idCurso: Long,

    @field:NotNull(message = "ID do usuário é obrigatório")
    val idUsuario: Long
)
