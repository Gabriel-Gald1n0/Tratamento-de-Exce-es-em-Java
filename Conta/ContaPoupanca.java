package Conta;

public class ContaPoupanca extends ContaBancaria {
    protected int diaDeRendimento;

    public ContaPoupanca(String nome, int num, float saldo, int diaDeRendimento) {
        super(nome, num, saldo);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calculaNovoSaldo(float taxaRendimento) throws ValorInvalidoException {
        if (taxaRendimento <= 0) {
            throw new ValorInvalidoException("Taxa de rendimento inválida: " + taxaRendimento + "\n");
        }
        saldo += saldo * (taxaRendimento / 100);
        System.out.println("Novo saldo com rendimento aplicado: R$" + saldo + "\n");
    }
}
