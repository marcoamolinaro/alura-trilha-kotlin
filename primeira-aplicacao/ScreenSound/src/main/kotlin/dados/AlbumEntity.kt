package br.scm.dados

import javax.persistence.*

@Entity
@Table(name = "albums", schema = "public")
class AlbumEntity(
    val titulo: String = "Título do Album",

    @ManyToOne
    val banda: BandaEntity = BandaEntity(),

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0
) 