package br.com.scm.alura.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.web.config.EnableSpringDataWebSupport

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}
