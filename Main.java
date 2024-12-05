import Conta.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ContaBancaria> contasCliente = new ArrayList<>();

        // Criando contas
        ContaPoupanca poupanca = new ContaPoupanca("Maria José", 12345, 2000.0f, 15);
        ContaEspecial especial = new ContaEspecial("Maria José", 67890, 1000.0f, 500.0f);

        contasCliente.add(poupanca);
        contasCliente.add(especial);

        // Testando operações
        try {
            // Operações que podem lançar exceções
            poupanca.sacar(500.0f); // Sucesso
            especial.sacar(1200.0f); // Sucesso
            poupanca.depositar(-300.0f); // Falha: Valor inválido
        } catch (SaldoInsuficienteException | ValorInvalidoException e) {
            // Multi-catch: Trata exceções personalizadas
            System.err.println("Erro na operação bancária: " + e.getMessage());
        } catch (Exception e) {
            // Captura qualquer outra exceção (geral)
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        // Calculando rendimento
        try {
            poupanca.calculaNovoSaldo(2.0f);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular rendimento: " + e.getMessage());
        }

        // Testando se a conta existe
        try {
            ContaBancaria conta = encontrarContaPorNumero(contasCliente, 12345); // Conta existente
            System.out.println("Conta encontrada: " + conta.cliente);
            
            conta = encontrarContaPorNumero(contasCliente, 99999); // Conta inexistente
            System.out.println("Conta encontrada: " + conta.cliente);
        } catch (ContaInexistenteException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        // Exibindo dados das contas
        for (ContaBancaria conta : contasCliente) {
            System.out.println("-------------------------------");
            System.out.println("Cliente: " + conta.cliente);  // Usando o método getter para acessar o cliente
            System.out.println("Número da Conta: " + conta.numConta);
            System.out.println("Saldo Atual: R$" + conta.saldo);
            if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo de conta: Conta Poupança");
            } else if (conta instanceof ContaEspecial) {
                System.out.println("Tipo de conta: Conta Especial");
            }
        }
    }

    // Método para encontrar uma conta pelo número
    public static ContaBancaria encontrarContaPorNumero(List<ContaBancaria> contas, int numeroConta) throws ContaInexistenteException {
        for (ContaBancaria conta : contas) {
            if (conta.numConta == numeroConta) {
                return conta; // Retorna a conta se encontrada
            }
        }
        throw new ContaInexistenteException("Conta com número " + numeroConta + " não encontrada."); // Lança exceção se não encontrar
    }
}
