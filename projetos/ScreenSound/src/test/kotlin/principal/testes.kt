package principal

import br.scm.dados.AlbumDAO
import br.scm.dados.Banco
import br.scm.dados.BandaDAO
import br.scm.modelos.Album
import br.scm.modelos.Banda

fun main(){

    val manager = Banco.getEntityManager()

    val albumDAO = AlbumDAO(manager)
    val bandaDAO = BandaDAO(manager)

    //val titas = Banda("Titãs")

    //bandaDAO.adicionar(titas)

    val titas = bandaDAO.recuperarPorId(1)

    println(titas)

    val goBack = Album("Go Back", titas)
    val cabecaDinossauro = Album("Cabeca Dinossauro", titas)


    albumDAO.adicionar(cabecaDinossauro)
    albumDAO.adicionar(goBack)

    val listaAlbuns = albumDAO.getLista()
    println(listaAlbuns)

    manager.close()

}