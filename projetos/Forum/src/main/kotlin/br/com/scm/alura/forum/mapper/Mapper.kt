package br.com.scm.alura.forum.mapper

interface Mapper<Topico, TopicoView> {
    fun map(t: Topico): TopicoView
}
