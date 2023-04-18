import java.util.Objects;

public class Artigo {
    public enum Condicao {novo, usado}

    private int fiscalUtilizador;
    private Condicao condicao;
    private String estado;
    private int donos;
    private String descricao;
    private String marca;
    private String cod; // alfanumérico
    private float precoBase;
    private float correcaoPreco;
    private Transportadora transportadora;

    public Artigo() {
        this.fiscalUtilizador = 0;
        this.condicao = Condicao.novo;
        this.estado = "";
        this.donos = 0;
        this.descricao = "";
        this.marca = "";
        this.cod = "";
        this.precoBase = 0;
        this.correcaoPreco = 0;
        this.transportadora = new Transportadora();
    }

    public Artigo(Integer fiscalUtilizador, Condicao condicao, String estado, int donos, String descricao, String marca, String cod, float precoBase, float correcaoPreco, Transportadora transportadora) {
        this.fiscalUtilizador = fiscalUtilizador;
        this.condicao = condicao;
        this.estado = estado;
        this.donos = donos;
        this.descricao = descricao;
        this.marca = marca;
        this.cod = cod;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.transportadora = transportadora;
    }

    public Artigo(Artigo a) {
        this.fiscalUtilizador = a.getFiscalUtilizador();
        this.condicao = a.getCondicao();
        this.estado = a.getEstado();
        this.donos = a.getDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.cod = a.getCod();
        this.precoBase = a.getPrecoBase();
        this.correcaoPreco = a.getCorrecaoPreco();
        this.transportadora = a.getTransportadora();
    }

    public int getFiscalUtilizador() {
        return fiscalUtilizador;
    }

    public void setFiscalUtilizador(int fiscalUtilizador) {
        this.fiscalUtilizador = fiscalUtilizador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDonos() {
        return donos;
    }

    public void setDonos(int donos) {
        this.donos = donos;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public float getCorrecaoPreco() {
        return correcaoPreco;
    }

    public void setCorrecaoPreco(float correcaoPreco) {
        this.correcaoPreco = correcaoPreco;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Artigo clone() { return new Artigo(this); }

    public String toString() {
        return "fiscalUtilizador=" + fiscalUtilizador +
                ", condicao=" + condicao +
                ", estado='" + estado + '\'' +
                ", donos=" + donos +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", cod='" + cod + '\'' +
                ", precoBase=" + precoBase +
                ", correcaoPreco=" + correcaoPreco +
                ", transportadora=" + transportadora;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return fiscalUtilizador == artigo.fiscalUtilizador && donos == artigo.donos && Float.compare(artigo.precoBase, precoBase) == 0 && Float.compare(artigo.correcaoPreco, correcaoPreco) == 0 && condicao == artigo.condicao && Objects.equals(estado, artigo.estado) && Objects.equals(descricao, artigo.descricao) && Objects.equals(marca, artigo.marca) && Objects.equals(cod, artigo.cod) && Objects.equals(transportadora, artigo.transportadora);
    }

}
