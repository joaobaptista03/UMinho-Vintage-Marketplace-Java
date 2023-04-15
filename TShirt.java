public class TShirt extends Artigo {
    public enum Tamanho {S, M, L, XL}
    public enum Padrao {liso, riscas, palmeiras}

    private Tamanho tamanho;
    private Padrao padrao;

    public TShirt() {
        super();
        this.tamanho = Tamanho.S;
        this.padrao = Padrao.liso;
    }

    public TShirt(String descricao, String marca, String cod, float precoBase, float correcaoPreco, Tamanho tamanho, Padrao padrao, Transportadora transportadora) {
        super(descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.tamanho = tamanho;
        this.padrao = padrao;
    } // nova

    public TShirt(Condicao condicao, String estado, int donos, String descricao, String marca, String ood, float precoBase, float correcaoPreco, Tamanho tamanho, Padrao padrao, Transportadora transportadora) {
        super(condicao, estado, donos, descricao, marca, ood, precoBase, correcaoPreco, transportadora);
        this.tamanho = tamanho;
        this.padrao = padrao;
    } // usada

    public TShirt(TShirt t) {
        super(t);
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }
}
