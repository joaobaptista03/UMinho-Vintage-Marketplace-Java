import java.time.LocalDate;

public class Sapatilha extends Artigo {
    private int tamanho;
    private boolean atacadores;
    private String cor;
    private LocalDate lancamento;
    private boolean premium;

    public Sapatilha() {
        super();
        this.tamanho = 0;
        this.atacadores = false;
        this.cor = "";
        this.lancamento = LocalDate.now();
        this.premium = false;
    }

    public Sapatilha(String descricao, String marca, String cod, float precoBase, float correcaoPreco, int tamanho, boolean atacadores, String cor, LocalDate lancamento, boolean premium, Transportadora transportadora) {
        super(descricao, marca, cod, precoBase, correcaoPreco, transportadora);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.lancamento = lancamento;
        this.premium = premium;
    } // nova

    public Sapatilha(Artigo.Condicao condicao, String estado, int donos, String descricao, String marca, String ood, float precoBase, float correcaoPreco, int tamanho, boolean atacadores, String cor, LocalDate lancamento, boolean premium, Transportadora transportadora) {
        super(condicao, estado, donos, descricao, marca, ood, precoBase, correcaoPreco, transportadora);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.lancamento = lancamento;
        this.premium = premium;
    } // usada

    public Sapatilha(Sapatilha s) {
        super(s);
        this.tamanho = s.getTamanho();
        this.atacadores = s.isAtacadores();
        this.cor = s.getCor();
        this.lancamento = s.getLancamento();
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

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
