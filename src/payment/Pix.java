package payment;

public class Pix extends FormaPagamento {
    @Override
    public boolean validarPagamento(double valor) {
        // Lógica de validação para Pix
        return valor > 0; // Exemplo: qualquer valor positivo é válido
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento(valor)) {
            System.out.println("Pagamento de R$" + valor + " processado via Pix.");
        } else {
            System.out.println("Pagamento inválido com Pix.");
        }
    }
}
