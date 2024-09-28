package payment;

public class Boleto extends FormaPagamento {
    @Override
    public boolean validarPagamento(double valor) {
        // Lógica de validação para boleto
        return valor <= 1000; // Exemplo: validação simples
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento(valor)) {
            System.out.println("Pagamento de R$" + valor + " processado via Boleto.");
        } else {
            System.out.println("Pagamento inválido com Boleto.");
        }
    }
}
