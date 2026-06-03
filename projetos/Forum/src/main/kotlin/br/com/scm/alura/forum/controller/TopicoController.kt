package br.com.scm.alura.forum.controller

import br.com.scm.alura.forum.dto.TopicoAtualizarForm
import br.com.scm.alura.forum.dto.TopicoForm
import br.com.scm.alura.forum.dto.TopicoPorCategoriaDTO
import br.com.scm.alura.forum.dto.TopicoView
import br.com.scm.alura.forum.service.TopicoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    @Cacheable("listaDeTopicos")
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 5, sort=["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable) : Page<TopicoView> {
        return topicoService.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long) : TopicoView? {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun cadastrar(
        @RequestBody @Valid form: TopicoForm,
        uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView> {
        val topicoView = topicoService.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun atualizar(@RequestBody @Valid form: TopicoAtualizarForm): ResponseEntity<TopicoView> {
        val topicoView = topicoService.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun deletar(@PathVariable id: Long) {
        topicoService.deletar(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoriaDTO> {
        return topicoService.relatorio()
    }
}