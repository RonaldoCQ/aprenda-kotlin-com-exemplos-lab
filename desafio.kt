enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(
    val nome: String, 
    val login: String, 
    val idade: Int
)

data class ConteudoEducacional(
    val nome: String, 
    val nivel: Nivel, 
    val duracao: Int
) {
        init {
            require(duracao in listOf(60, 120, 240)) { "A duração deve ser 60, 120 ou 240 minutos." }
        }
}

data class Formacao(
    val nome: String, 
    val nivel: Nivel, 
    val conteudos: List<ConteudoEducacional>
) {
        val matriculados = mutableListOf<Aluno>()

        fun matricular(aluno: Aluno) {
            matriculados.add(aluno)
            println("${aluno.nome} teve a matricula efutuada com sucesso na formação: $nome")
        }

        fun exibirConteudos() {
            conteudos.forEach {
                println("Conteúdo: ${it.nome} | Nível: ${it.nivel} | Duração: ${it.duracao} minutos")
            }
        }
}

fun main() {
    val aluno1 = Aluno("João Silva", "J0Silva", 25)
    val aluno2 = Aluno("Maria Oliveira", "MarihOli", 30)
    val aluno3 = Aluno("Pedro Souza", "Nobody", 28)

    val conteudoBasico = ConteudoEducacional("Introdução a linguagem de programação Kotlin", Nivel.BASICO, 60)
    val conteudoIntermediario = ConteudoEducacional("JavaScript do zero, em uma abordagem imersiva e prática", Nivel.INTERMEDIARIO, 120)
    val conteudoDificil = ConteudoEducacional("Desenvolvimento de Android Avançado", Nivel.DIFICIL, 240)

    val formacaoKotlin = Formacao("Introdução à Kotlin", Nivel.BASICO, listOf(conteudoBasico))
    val formacaoAndroid = Formacao("Formação JavaScript Developer ", Nivel.INTERMEDIARIO, listOf(conteudoIntermediario))
    val formacaoMicroservicos = Formacao("Formação Android", Nivel.DIFICIL, listOf(conteudoDificil))

    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.exibirConteudos()

    println()

    formacaoAndroid.matricular(aluno2)
    formacaoAndroid.exibirConteudos()

    println()

    formacaoMicroservicos.matricular(aluno3)
    formacaoMicroservicos.exibirConteudos()
}

