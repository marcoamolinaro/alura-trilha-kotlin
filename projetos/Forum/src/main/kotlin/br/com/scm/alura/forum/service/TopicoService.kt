package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.dto.TopicoAtualizarForm
import br.com.scm.alura.forum.dto.TopicoForm
import br.com.scm.alura.forum.dto.TopicoView
import br.com.scm.alura.forum.exception.NotFoundException
import br.com.scm.alura.forum.mapper.TopicoFormMapper
import br.com.scm.alura.forum.mapper.TopicoViewMapper
import br.com.scm.alura.forum.model.Topico
import br.com.scm.alura.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicoRepository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String? = "Tópico não encontrado"
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable) : Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            topicoRepository.findAll(paginacao)
        } else {
            topicoRepository.findByCursoNome(nomeCurso, paginacao)
        }

        return topicos.map{
                t -> TopicoViewMapper().map(t)
            }
    }

    fun buscarPorId(id: Long) : TopicoView? {
        val topico = topicoRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: TopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: TopicoAtualizarForm): TopicoView {
        val topico = topicoRepository.findById(form.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }
}