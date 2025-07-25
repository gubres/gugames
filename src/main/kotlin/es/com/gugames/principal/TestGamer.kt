import es.com.gugames.modelo.Gamer


fun main() {
    val gamer1 = Gamer("Gustavo", "gustavo@l.com")
    println(gamer1)

    val gamer2 = Gamer("Mirena", "mirenita22@mail.com", "01/09/1998", "mirenita22")
    println(gamer2)

    gamer1.let {
        it.fechaNacimiento = "28/09/1992"
        it.usuario = "gubres"
    }.also {
        println(gamer1.idInterno )
    }

    println(gamer1)
    gamer1.usuario = "gugu"
    println(gamer1)
}