package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.PlanoAvulsoEntity
import org.example.br.com.alura.aluragames.modelo.PlanoEntity
import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val nome: String = "Nome do Gamer",
    val email: String = "email@email.com",
    val dataNascimento:String? = null,
    val usuario:String? = null,

    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()
) {

}