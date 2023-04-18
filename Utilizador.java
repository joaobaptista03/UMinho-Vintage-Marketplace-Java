import java.util.*;

public class Utilizador {
    private String email;
    private String nome;
    private String morada;
    private int nrFiscal;
    private Map<String, Artigo> vender;
    private Map<String, Artigo> comprado;
    private float totVendas;

    public Utilizador() {
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nrFiscal = 0;
        this.vender = new HashMap<String, Artigo>();
        this.comprado = new HashMap<String, Artigo>();
        this.totVendas = 0;
    }

    public Utilizador(String email, String nome, String morada, int nrFiscal, Map<String, Artigo> vender, Map<String, Artigo> comprado, float totVendas) {
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nrFiscal = nrFiscal;
        this.vender = new HashMap<>();
            for (Artigo a : vender.values()) this.vender.put(a.getCod(), a.clone());
        this.comprado = new HashMap<>();
            for (Artigo a : comprado.values()) this.comprado.put(a.getCod(), a.clone());
        this.totVendas = totVendas;
    }

    public Utilizador(Utilizador u) {
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nrFiscal = u.getNrFiscal();
        this.vender = u.getVender();
        this.comprado = u.getComprado();
        this.totVendas = u.getTotVendas();
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

    public Map<String, Artigo> getVender() {
        Map<String, Artigo> newVender = new HashMap<>();
        for (Artigo a : this.vender.values()) newVender.put(a.getCod(), a.clone());

        return newVender;
    }

    public void setVender(Map<String, Artigo> vender) {
        this.vender = new HashMap<>();
        for (Artigo a : vender.values()) this.vender.put(a.getCod(), a.clone());
    }

    public Map<String, Artigo> getComprado() {
        Map<String, Artigo> newComprado = new HashMap<>();
        for (Artigo a : this.comprado.values()) newComprado.put(a.getCod(), a.clone());

        return newComprado;
    }

    public void setComprado(Map<String, Artigo> comprado) {
        this.comprado = new HashMap<>();
        for (Artigo a : comprado.values()) this.comprado.put(a.getCod(), a.clone());
    }

    public float getTotVendas() {
        return totVendas;
    }

    public void setTotVendas(float totVendas) {
        this.totVendas = totVendas;
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public String toString() {
        return "Utilizador{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", nrFiscal=" + nrFiscal +
                ", vender=" + vender +
                ", comprado=" + comprado +
                ", totVendas=" + totVendas +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return nrFiscal == that.nrFiscal && Float.compare(that.totVendas, totVendas) == 0 && Objects.equals(email, that.email) && Objects.equals(nome, that.nome) && Objects.equals(morada, that.morada) && Objects.equals(vender, that.vender) && Objects.equals(comprado, that.comprado);
    }

}
