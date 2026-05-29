package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Periodo
import javax.persistence.*

@Entity
@Table(name = "aluguel")
class AluguelEntity(
    @ManyToOne(fetch = FetchType.LAZY)
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne(fetch = FetchType.LAZY)
    val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()
    ) {
    var valorDoAluguel: Double = 0.0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}