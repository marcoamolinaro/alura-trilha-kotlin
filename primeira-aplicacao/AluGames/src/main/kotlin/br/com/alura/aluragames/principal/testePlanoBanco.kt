package org.example.br.com.alura.aluragames.principal

import org.example.br.com.alura.aluragames.dados.Banco
import org.example.br.com.alura.aluragames.dados.PlanoDAO
import org.example.br.com.alura.aluragames.modelo.PlanoAssinatura
import org.example.br.com.alura.aluragames.modelo.PlanoAvulso

fun main() {
    val avulso = PlanoAvulso("BRONZE")
    val prata = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    val ouro = PlanoAssinatura("OURO", 19.90, 5, 0.20)
    val platina = PlanoAssinatura("PLATINA", 29.90, 10, 0.30)
    val diamante = PlanoAssinatura("DIAMANTE", 49.90, 20, 0.50)

    val manager = Banco.getEntityManager()
    val planoDAO = PlanoDAO(manager)

    //planoDAO.adicionar(avulso)
    //planoDAO.adicionar(prata)
    //planoDAO.adicionar(ouro)
    //planoDAO.adicionar(platina)
    //planoDAO.adicionar(diamante)

    val listPlanos = planoDAO.getLista()
    println("Lista de Planos $listPlanos")

    manager.close()
}