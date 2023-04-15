import java.util.ArrayList;
import java.util.List;

public class Utilizador {
    private String email;
    private String nome;
    private String morada;
    private int nrFiscal;
    private List<Artigo> vender;
    private List<Artigo> comprado;
    private float totVendas;

    public Utilizador() {
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nrFiscal = 0;
        this.vender = new ArrayList<Artigo>();
        this.comprado = new ArrayList<Artigo>();
        this.totVendas = 0;
    }

    public Utilizador(String email, String nome, String morada, int nrFiscal, List<Artigo> vender, List<Artigo> comprado, float totVendas) {
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nrFiscal = nrFiscal;
        this.vender = vender;
        this.comprado = comprado;
        this.totVendas = totVendas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNrFiscal() {
        return nrFiscal;
    }

    public void setNrFiscal(int nrFiscal) {
        this.nrFiscal = nrFiscal;
    }

    public List<Artigo> getVender() {
        return vender;
    }

    public void setVender(List<Artigo> vender) {
        this.vender = vender;
    }

    public List<Artigo> getComprado() {
        return comprado;
    }

    public void setComprado(List<Artigo> comprado) {
        this.comprado = comprado;
    }

    public float getTotVendas() {
        return totVendas;
    }

    public void setTotVendas(float totVendas) {
        this.totVendas = totVendas;
    }
}
