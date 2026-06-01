package br.com.scm.alura.forum.repository

import br.com.scm.alura.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}