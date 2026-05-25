package org.example.br.com.alura.aluragames.dados

import org.example.br.com.alura.aluragames.dados.Banco.obterConexao
import org.example.br.com.alura.aluragames.modelo.Jogo
import java.sql.SQLException

class JogoDAO {
    fun getJogos(): List<Jogo> {
        val conexao = obterConexao()
        val listJogos = mutableListOf<Jogo>()

        if (conexao != null) {
            try {
                val statement = conexao.createStatement()

                val resultSet = statement.executeQuery("SELECT * FROM jogos")

                while (resultSet.next()) {
                    val id = resultSet.getInt("id")
                    val titulo = resultSet.getString("titulo")
                    val capa = resultSet.getString("capa")
                    val preco = resultSet.getDouble("preco")
                    val descricao = resultSet.getString("descricao")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    listJogos.add(jogo)
                }

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

        return listJogos
    }

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
}