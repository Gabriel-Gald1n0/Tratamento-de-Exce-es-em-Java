package Conta;

// Exceção personalizada para conta inexistente
public class ContaInexistenteException extends Exception {
    public ContaInexistenteException(String message) {
        super(message);
    }
}

