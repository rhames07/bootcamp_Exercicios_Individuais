public class Clt extends Funcionario {
    private int metasBatidas;
    private Hierarquia hierarquia;
    private double lucros;

    public Clt(Hierarquia hierarquia, int metasBatidas) {
        super.setTipo(TipoFuncionario.CLT);
        super.setSalario(hierarquia.salarioBase);
        this.hierarquia = hierarquia;
        this.metasBatidas = metasBatidas;
    }

    public Clt(Hierarquia hierarquia, double lucros) {
        super.setTipo(TipoFuncionario.CLT);
        super.setSalario(hierarquia.salarioBase);
        this.hierarquia = hierarquia;
        this.lucros = lucros;
    }

    public int getMetasBatidas() {
        return metasBatidas;
    }

    public void setMetasBatidas(int metasBatidas) {
        this.metasBatidas = metasBatidas;
    }

    public Hierarquia getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(Hierarquia hierarquia) {
        this.hierarquia = hierarquia;
    }

    public double getLucros() {
        return lucros;
    }

    public void setLucros(double lucros) {
        this.lucros = lucros;
    }

    @Override
    public double pagarSalario() {
        if (!(hierarquia == Hierarquia.DIRETOR)) {
            for (int i = 0; i < metasBatidas; i++) {
                super.setSalario(super.getSalario() + (super.getSalario() * hierarquia.bonificacao));
            }
            return super.getSalario();
        }
        super.setSalario(hierarquia.salarioBase + (this.lucros * 0.03));
        return super.getSalario();
    }

    @Override
    public String toString() {
        if (!(hierarquia == Hierarquia.DIRETOR)){
            return "CLT{" +
                    "hierarquia=" + hierarquia +
                    ", metasBatidas=" + metasBatidas +
                    ", salario=" + super.getSalario() +
                    '}';
        }
        return "CLT{" +
                "hierarquia=" + hierarquia +
                ", lucros=" + lucros +
                ", salario=" + super.getSalario() +
                '}';
    }
}
