import es.com.gugames.modelo.Gamer


fun main() {
    val gamer1 = Gamer("Gustavo", "gustavo@mail.com")
    println(gamer1)

    val gamer2 = Gamer("Mirena", "mirenita22@mail.com", "01/09/1998", "mirenita22")
    println(gamer2)

    gamer1.let {
        it.fechaNacimiento = "28/09/1992"
        it.usuario = "gubres"
        it.idInterno = "gubres#123"
    }

    println(gamer1 )
}