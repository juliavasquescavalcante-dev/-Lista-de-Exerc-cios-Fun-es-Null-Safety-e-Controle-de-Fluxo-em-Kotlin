// ==========================================
// Questão 1: Sistema de Cupons Avançado
// ==========================================
fun calcularDesconto(valor: Double, cupom: String?): Double {
    return when (cupom) {
        "PROMO10" -> valor - 10.0
        "PROMO20" -> valor - 20.0
        else -> valor
    }
}

// ==========================================
// Questão 2: Auditoria de Entregas
// ==========================================
fun auditarEntregas(enderecos: List<String?>) {
    val enderecoPadrao = "Endereço Desconhecido"
    
    for (item in enderecos) {
        val enderecoFinal = item ?: enderecoPadrao
        
        if (enderecoFinal == enderecoPadrao) {
            println("Entrega Pendente: Falta de dados")
        } else {
            println("Rota traçada para: $enderecoFinal")
        }
    }
}

// ==========================================
// Questão 3: Validação de Perfil de Streaming
// ==========================================
fun validarBioInfantil(biografia: String?) {
    val tamanho = biografia?.length ?: 0
    
    if (tamanho <= 50) {
        println("Bio aceita")
    } else {
        println("Bio muito longa")
    }
}

// ==========================================
// Questão 4: Processamento de Transações Pix
// ==========================================
fun processarPix() {
    val transacoes: List<Double?> = listOf(50.0, null, 120.5, null, 10.0)
    var total = 0.0

    for (valor in transacoes) {
        if (valor != null) {
            total += valor
        } else {
            println("Transação ignorada")
        }
    }

    println("Valor total processado: R$ $total")
}

// ==========================================
// Questão 5: Classificação de Feedback de Motoristas
// ==========================================
fun avaliarMotorista(nota: Int?) {
    val notaFinal = nota ?: 0

    when (notaFinal) {
        5 -> println("Excelente corrida!")
        4 -> println("Boa corrida.")
        1, 2, 3 -> println("Precisamos melhorar.")
        0 -> println("Nenhuma avaliação fornecida.")
        else -> println("Nota fora do padrão.")
    }
}

// ==========================================
// Questão 6: Função Lambda para Cálculo de Gorjeta
// ==========================================
val calcularGorjeta: (Double?) -> Double = {
    if (it == null || it < 0.0) {
        0.0
    } else {
        it
    }
}

// ==========================================
// Questão 7: Limpeza de Banco de Dados de Usuários
// ==========================================
fun limparEmails(emails: List<String?>) {
    var contasInvalidas = 0

    for (email in emails) {
        val tamanho = email?.length ?: 0

        // Se email for nulo ou o tamanho for 0 (em branco "")
        if (email == null || tamanho == 0) {
            contasInvalidas += 1
            println("Aviso: Conta inválida detectada ($email). Marcada para deleção.")
        } else {
            println("Conta válida: $email")
        }
    }

    println("Total de contas que precisam ser apagadas: $contasInvalidas")
}

// ==========================================
// Execução e Testes de Todas as Questões
// ==========================================
fun main() {
    println("--- Teste Questão 1 ---")
    println("Preço final (PROMO10): R$ ${calcularDesconto(100.0, "PROMO10")}")
    println("Preço final (PROMO20): R$ ${calcularDesconto(100.0, "PROMO20")}")
    println("Preço final (Nulo): R$ ${calcularDesconto(100.0, null)}")
    println("Preço final (Invalido): R$ ${calcularDesconto(100.0, "NATAL50")}")

    println("\n--- Teste Questão 2 ---")
    val rotas = listOf("Rua das Flores, 123", null, "Av. Central, 450", null)
    auditarEntregas(rotas)

    println("\n--- Teste Questão 3 ---")
    validarBioInfantil("Gosta de desenhos e brincar no parque.")
    validarBioInfantil(null)
    validarBioInfantil("Esta é uma biografia propositalmente muito longa que excede o limite estipulado de cinquenta caracteres.")

    println("\n--- Teste Questão 4 ---")
    processarPix()

    println("\n--- Teste Questão 5 ---")
    avaliarMotorista(5)
    avaliarMotorista(4)
    avaliarMotorista(2)
    avaliarMotorista(null)

    println("\n--- Teste Questão 6 ---")
    println("Gorjeta (15.0): R$ ${calcularGorjeta(15.0)}")
    println("Gorjeta (null): R$ ${calcularGorjeta(null)}")
    println("Gorjeta (-5.0): R$ ${calcularGorjeta(-5.0)}")

    println("\n--- Teste Questão 7 ---")
    val listaEmails = listOf("user1@gmail.com", null, "", "dev@empresa.com", " ")
    limparEmails(listaEmails)
}
