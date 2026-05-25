package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.modelo.Jogo

class JogoDAO {
/*
    fun adicionarJogo(jogo: Jogo) {
        val conexao = obterConexao()
        val insert = "INSERT INTO jogos (titulo, capa, preco, descricao) VALUES (?, ?, ?, ?)"

        if (conexao != null) {
            try {
                val statement = conexao.prepareStatement(insert)
                statement.setString(1, jogo.titulo)
                statement.setString(2, jogo.capa)
                statement.setDouble(3, jogo.preco)
                statement.setString(4, jogo.descricao)

                statement.executeUpdate()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                try {
                    conexao.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            }
        }
    }
 */

    fun getJogos(): List<Jogo> {
        val manager = Banco.getEntityManager()
        try {
           val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
            return query.resultList.map {
                entity -> Jogo(
                    entity.titulo,
                    entity.capa,
                    entity.preco,
                    entity.descricao!!,
                    entity.id)
            }
        } finally {
            manager.close()
        }
    }
}