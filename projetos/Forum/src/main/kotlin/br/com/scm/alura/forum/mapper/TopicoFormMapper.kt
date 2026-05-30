package br.com.scm.alura.forum.mapper

import br.com.scm.alura.forum.dto.TopicoForm
import br.com.scm.alura.forum.model.Topico
import br.com.scm.alura.forum.service.CursoService
import br.com.scm.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService): Mapper<TopicoForm, Topico> {

    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idUsuario)
        )
    }
}
