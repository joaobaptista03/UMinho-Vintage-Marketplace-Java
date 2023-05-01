import java.util.Objects;

public class Sapatilha extends Artigo {
    private int tamanho;
    private boolean atacadores;
    private String cor;
    private int anoColecao;
    private boolean premium;

    public Sapatilha() {
        super();
        this.tamanho = 0;
        this.atacadores = false;
        this.cor = "";
        this.anoColecao = 0;
        this.premium = false;
    }

    public Sapatilha(int codUtilizador, Condicao condicao, float estado, int donos, String descricao, String marca, String cod, float precoBase, float correcaoPreco, String transportadora, int tamanho, boolean atacadores, String cor, int anoColecao, boolean premium) {
        super(codUtilizador, condicao, estado, donos, descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.anoColecao = anoColecao;
        this.premium = premium;
    }

    public Sapatilha(Sapatilha s) {
        super(s);
        this.tamanho = s.getTamanho();
        this.atacadores = s.isAtacadores();
        this.cor = s.getCor();
        this.anoColecao = s.getAnoColecao();
        this.premium = s.isPremium();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isAtacadores() { return atacadores; }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public float getPrecoTotal() {
        if (this.premium) return (this.getPrecoBase() + this.getCorrecaoPreco());
        return (this.getPrecoBase() - this.getCorrecaoPreco());
    }

    public Sapatilha clone() {
        return new Sapatilha(this);
    }

    public String toString() {
        return "Sapatilha;" + super.toString() + ";" + tamanho + ";" + atacadores + ";" + cor + ";" + anoColecao + ";" + premium;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sapatilha sapatilha = (Sapatilha) o;
        return tamanho == sapatilha.tamanho && atacadores == sapatilha.atacadores && premium == sapatilha.premium && Objects.equals(cor, sapatilha.cor) && anoColecao == sapatilha.getAnoColecao();
    }

}
