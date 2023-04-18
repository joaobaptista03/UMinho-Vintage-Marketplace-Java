import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        this.vender = vender.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());;
        this.comprado = comprado.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());
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

    public List<Artigo> getVender() {
        return vender.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());
    }

    public void setVender(List<Artigo> vender) {
        this.vender = vender.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());
    }

    public List<Artigo> getComprado() {
        return comprado.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());
    }

    public void setComprado(List<Artigo> comprado) {
        this.comprado = comprado.stream()
                .map(a ->a.clone())
                .collect(Collectors.toList());;
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
