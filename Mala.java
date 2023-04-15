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

    public Mala(String descricao, String marca, String cod, float precoBase, float correcaoPreco, float comprimento, float largura, float altura, String material, int anoColecao, boolean premium, Transportadora transportadora) {
        super(descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.material = material;
        this.anoColecao = anoColecao;
        this.premium = premium;
    } // nova

    public Mala(Condicao condicao, String estado, int donos, String descricao, String marca, String cod, float precoBase, float correcaoPreco, float comprimento, float largura, float altura, String material, int anoColecao, boolean premium, Transportadora transportadora) {
        super(condicao, estado, donos, descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.material = material;
        this.anoColecao = anoColecao;
        this.premium = premium;
    } // usada

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
}
