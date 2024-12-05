package Conta;

public class ContaBancaria {
    public String cliente;
    public int numConta;
    public float saldo;

    public ContaBancaria(String nome, int num, float saldo) {
        this.cliente = nome;
        this.numConta = num;
        this.saldo = saldo;
    }

    public void sacar(float valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero.\n");
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.\n");
        }
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.\n");
    }

    public void depositar(float valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do depósito deve ser maior que zero.\n");
        }
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.\n");
    }
}
