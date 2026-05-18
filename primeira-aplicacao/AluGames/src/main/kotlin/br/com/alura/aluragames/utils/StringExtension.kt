import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.transoformarEmIdade(): Int {
    val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val hoje = LocalDate.now()
    var dataNascimento: LocalDate? = null

    val resultado = runCatching {
        dataNascimento = LocalDate.parse(this, formater)
    }

    resultado.onSuccess {
        idade = Period.between(dataNascimento, hoje).years
    }

    resultado.onFailure {
        throw DateTimeParseException("Data de nascimento em formato inválido. Use o formato dd/MM/yyyy", this, 0)
    }

    return idade
}