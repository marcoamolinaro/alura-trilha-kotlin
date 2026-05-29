package principal

import org.example.br.com.alura.aluragames.dados.AluguelDAO
import org.example.br.com.alura.aluragames.dados.Banco
import org.example.br.com.alura.aluragames.dados.GamerDAO
import org.example.br.com.alura.aluragames.dados.JogoDAO
import org.example.br.com.alura.aluragames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()

    val jogoDAO = JogoDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = GamerDAO(manager).recuperarPorId(3)
    val jogo = JogoDAO(manager).recuperarPorId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}