import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Utilizador {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nrFiscal;
    private List<String> vender;
    private List<String> comprado;
    private float totVendas;

    public Utilizador() {
        this.codigo = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nrFiscal = 0;
        this.vender = new ArrayList<>();
        this.comprado = new ArrayList<>();
        this.totVendas = 0;
    }

    public Utilizador(int codigo, String email, String nome, String morada, int nrFiscal, List<String> vender, List<String>  comprado, float totVendas) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nrFiscal = nrFiscal;
        this.vender = new ArrayList<>();
            for (String a : vender) this.vender.add(a);
        this.comprado = new ArrayList<>();
        for (String a : comprado) this.comprado.add(a);
        this.totVendas = totVendas;
    }

    public Utilizador(Utilizador u) {
        this.codigo = u.getCodigo();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nrFiscal = u.getNrFiscal();
        this.vender = u.getVender();
        this.comprado = u.getComprado();
        this.totVendas = u.getTotVendas();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<String> getVender() {
        List<String> newVender = new ArrayList<>();
        for (String a : this.vender) newVender.add(a);

        return newVender;
    }

    public void setVender(List<String> vender) {
        this.vender = new ArrayList<>();
        for (String a : vender) this.vender.add(a);
    }

    public List<String> getComprado() {
        List<String> newComprado = new ArrayList<>();
        for (String a : this.comprado) newComprado.add(a);

        return newComprado;
    }

    public void setComprado(List<String> comprado) {
        this.comprado = new ArrayList<>();
        for (String a : comprado) this.comprado.add(a);
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
        return codigo + ";" + email + ";" + nome + ";" + morada + ";" + nrFiscal + ";" + "Vender: " + vender + ";" + comprado + ";" + totVendas;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return nrFiscal == that.nrFiscal && Float.compare(that.totVendas, totVendas) == 0 && Objects.equals(email, that.email) && Objects.equals(nome, that.nome) && Objects.equals(morada, that.morada) && Objects.equals(vender, that.vender) && Objects.equals(comprado, that.comprado);
    }

}
