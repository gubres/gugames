import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEnEdad(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var edad = 0
    val fechaNacimiento = LocalDate.parse(this, formatter)
    val hoy = LocalDate.now()

    edad = Period.between(fechaNacimiento, hoy).years

    return edad
}