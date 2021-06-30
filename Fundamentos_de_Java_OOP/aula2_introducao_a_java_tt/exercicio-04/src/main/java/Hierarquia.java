public enum Hierarquia {
    TECNICO(3200, 0.05, 40, 0),
    ANALISTA(4000, 0.08, 40, 4),
    GERENTE(6000, 0.125, 36, 4),
    DIRETOR(15000, 0, 0, 0);

    public double salarioBase;
    public final double bonificacao;
    public final int horasSemanais;
    public final int descansoRemunerado;

    private Hierarquia(double salarioBase, double bonificacao, int horasSemanais, int descansoRemunerado){
        this.salarioBase = salarioBase;
        this.bonificacao = bonificacao;
        this.horasSemanais = horasSemanais;
        this.descansoRemunerado = descansoRemunerado;
    }
}
