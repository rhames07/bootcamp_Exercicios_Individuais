public class Pj extends Funcionario{
    private double precoHora;
    private int horasTrabalhadas;

    public Pj(double precoHora, int horasTrabalhadas) {
        super.setTipo(TipoFuncionario.PJ);
        this.precoHora = precoHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double pagarSalario() {
        double salario = this.precoHora * this.horasTrabalhadas;
        super.setSalario(salario);
        return salario;
    }

    @Override
    public String toString() {
        return "PJ{" +
                "tipo=" + super.getTipo() +
                ", precoHora=" + precoHora +
                ", horasTrabalhadas=" + horasTrabalhadas +
                ", salario=" + super.getSalario() +
                '}';
    }
}
