package folhaDePagamento;

public class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.2;
    }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.1;
    }
}
