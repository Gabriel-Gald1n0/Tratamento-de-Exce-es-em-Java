package Conta;

public class ContaEspecial extends ContaBancaria {
    protected float limite;

    public ContaEspecial(String nome, int num, float saldo, float limite) {
        super(nome, num, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero.\n");
        }

        // Depuração: Exibe o saldo e o limite disponível
        System.out.println("Saldo disponível (saldo + limite): " + (saldo + limite));

        // Verifica se o valor do saque ultrapassa o limite (saldo + limite)
        if (valor > saldo + limite) {
            throw new SaldoInsuficienteException("Valor ultrapassa o limite disponível.\n");
        }

        // Subtrai o valor do saque do saldo
        saldo -= valor;  

        // Exibe a mensagem de sucesso
        System.out.println("Saque de R$" + valor + " realizado com sucesso.\n");
    }
}
