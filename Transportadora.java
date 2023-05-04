import java.util.Objects;

public class Transportadora {
    private String nome;
    private float expedicaoPequeno, expedicaoMedio, expedicaoGrande;
    private float lucro;
    private float imposto;
    private int diasParaExpedicao;

    public Transportadora() {
        this.nome = "";
        this.expedicaoPequeno = 0;
        this.expedicaoMedio = 0;
        this.expedicaoGrande = 0;
        this.lucro = 0;
        this.imposto = 0;
        this.diasParaExpedicao = 0;
    }

    public Transportadora(String nome, float expedicaoPequeno, float expedicaoMedio, float expedicaoGrande, float lucro, float imposto, int diasParaExpedicao) {
        this.nome = nome;
        this.expedicaoPequeno = expedicaoPequeno;
        this.expedicaoMedio = expedicaoMedio;
        this.expedicaoGrande = expedicaoGrande;
        this.lucro = lucro;
        this.imposto = imposto;
        this.diasParaExpedicao = diasParaExpedicao;
    }

    public Transportadora(Transportadora t) {
        this.nome = t.getNome();
        this.expedicaoPequeno = t.getExpedicaoPequeno();
        this.expedicaoMedio = t.getExpedicaoMedio();
        this.expedicaoGrande = t.getExpedicaoGrande();
        this.lucro = t.getLucro();
        this.imposto = t.getImposto();
        this.diasParaExpedicao = t.getDiasParaExpedicao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getExpedicaoPequeno() {
        return expedicaoPequeno;
    }

    public void setExpedicaoPequeno(float expedicaoPequeno) {
        this.expedicaoPequeno = expedicaoPequeno;
    }

    public float getExpedicaoMedio() {
        return expedicaoMedio;
    }

    public void setExpedicaoMedio(float expedicaoMedio) {
        this.expedicaoMedio = expedicaoMedio;
    }

    public float getExpedicaoGrande() {
        return expedicaoGrande;
    }

    public void setExpedicaoGrande(float expedicaoGrande) {
        this.expedicaoGrande = expedicaoGrande;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }


    public int getDiasParaExpedicao() {
        return this.diasParaExpedicao;
    }

    public void setDiasParaExpedicao(int diasParaExpedicao) {
        this.diasParaExpedicao = diasParaExpedicao;
    }

    public float calcPrecoExpedicao(Encomenda.Dimensao d) {
        float valorBase = 0;
        if (d.equals(Encomenda.Dimensao.pequeno)) valorBase = expedicaoPequeno;
        else if (d.equals(Encomenda.Dimensao.medio)) valorBase = expedicaoMedio;
        else if (d.equals(Encomenda.Dimensao.grande)) valorBase = expedicaoGrande;

        return (valorBase * lucro * (1 + imposto)) * 0.9F;
    }

    public Transportadora clone() {
        return new Transportadora(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transportadora)) {
            return false;
        }
        Transportadora transportadora = (Transportadora) o;
        return Objects.equals(nome, transportadora.nome) && expedicaoPequeno == transportadora.expedicaoPequeno && expedicaoMedio == transportadora.expedicaoMedio && expedicaoGrande == transportadora.expedicaoGrande && lucro == transportadora.lucro && imposto == transportadora.imposto && diasParaExpedicao == transportadora.diasParaExpedicao;
    }

    @Override
    public String toString() {
        return nome + ";" + expedicaoPequeno + ";" + expedicaoMedio + ";" + expedicaoGrande + ";" + lucro + ";" + imposto + ";" + diasParaExpedicao;
    }
}
