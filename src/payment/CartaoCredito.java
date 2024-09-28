package payment;

public class CartaoCredito extends FormaPagamento {
    @Override
    public boolean validarPagamento(double valor) {
        // Lógica de validação para cartão de crédito
        return valor <= 5000; // Exemplo: validação simples
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento(valor)) {
            System.out.println("Pagamento de R$" + valor + " processado via Cartão de Crédito.");
        } else {
            System.out.println("Pagamento inválido com Cartão de Crédito.");
        }
    }
}
