package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.dto.TopicoDTO
import br.com.scm.alura.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService) {

    fun listar() : List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long) : Topico? {
        return topicos.find { it.id == id }
    }

    fun cadastrar(dto: TopicoDTO) {

        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idUsuario)
            )
        )
    }
}