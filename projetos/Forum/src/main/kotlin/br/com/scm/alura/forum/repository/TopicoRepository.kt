package br.com.scm.alura.forum.repository

import br.com.scm.alura.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
    
}