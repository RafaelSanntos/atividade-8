package payment;

public abstract class FormaPagamento {
    public abstract boolean validarPagamento(double valor);
    public abstract void processarPagamento(double valor);
}
