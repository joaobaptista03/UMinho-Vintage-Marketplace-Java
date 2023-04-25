import java.util.Objects;

public class Mala extends Artigo {
    private float comprimento, largura, altura;
    private String material;
    private int anoColecao;
    private boolean premium;

    public Mala() {
        super();
        this.comprimento = 0;
        this.largura = 0;
        this.altura = 0;
        this.material = "";
        this.anoColecao = 0;
        this.premium = false;
    }

    public Mala(int fiscalUtilizador, Condicao condicao, float estado, int donos, String descricao, String marca, String cod, float precoBase, float correcaoPreco, float comprimento, float largura, float altura, String material, int anoColecao, boolean premium, Transportadora transportadora) {
        super(fiscalUtilizador, condicao, estado, donos, descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.material = material;
        this.anoColecao = anoColecao;
        this.premium = premium;
    }

    public Mala(Mala m) {
        super(m);
        this.comprimento = m.getComprimento();
        this.largura = m.getLargura();
        this.altura = m.getAltura();
        this.material = m.getMaterial();
        this.anoColecao = m.getAnoColecao();
        this.premium = m.isPremium();
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) { this.altura = altura; }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public Mala clone() {
        return new Mala(this);
    }

    public String toString() {
        return "Mala{\n" +
                super.toString() +
                "\n     comprimento=" + comprimento +
                ", largura=" + largura +
                ", altura=" + altura +
                ", material='" + material + '\'' +
                ", anoColecao=" + anoColecao +
                ", premium=" + premium +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mala mala = (Mala) o;
        return Float.compare(mala.comprimento, comprimento) == 0 && Float.compare(mala.largura, largura) == 0 && Float.compare(mala.altura, altura) == 0 && anoColecao == mala.anoColecao && premium == mala.premium && Objects.equals(material, mala.material);
    }

}
