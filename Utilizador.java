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
    private List<String> vendido;
    private List<String> comprado;
    private float totVendas;

    public Utilizador() {
        this.codigo = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nrFiscal = 0;
        this.vender = new ArrayList<>();
        this.vendido = new ArrayList<>();
        this.comprado = new ArrayList<>();
        this.totVendas = 0;
    }

    public Utilizador(int codigo, String email, String nome, String morada, int nrFiscal, List<String> vender, List<String> vendido, List<String> comprado, float totVendas) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nrFiscal = nrFiscal;
        this.vender = new ArrayList<>();
            this.vender.addAll(vender);
        this.vendido = new ArrayList<>();
            this.vendido.addAll(vendido);
        this.comprado = new ArrayList<>();
            this.comprado.addAll(comprado);
        this.totVendas = totVendas;
    }

    public Utilizador(Utilizador u) {
        this.codigo = u.getCodigo();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nrFiscal = u.getNrFiscal();
        this.vender = u.getVender();
        this.vendido = u.getVendido();
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
            newVender.addAll(this.vender);

        return newVender;
    }

    public void setVender(List<String> vender) {
        this.vender = new ArrayList<>();
            this.vender.addAll(vender);
    }

    public List<String> getVendido() {
        List<String> newVendido = new ArrayList<>();
        newVendido.addAll(this.vendido);

        return newVendido;
    }

    public void setVendido(List<String> vendido) {
        this.vendido = new ArrayList<>();
        this.vendido.addAll(vendido);
    }

    public List<String> getComprado() {
        List<String> newComprado = new ArrayList<>();
         newComprado.addAll(this.comprado);

        return newComprado;
    }

    public void setComprado(List<String> comprado) {
        this.comprado = new ArrayList<>();
            this.comprado.addAll(comprado);
    }

    public float getTotVendas() {
        return totVendas;
    }

    public void setTotVendas(float totVendas) {
        this.totVendas = totVendas;
    }

    public void removeVender(String a) {
        vender.remove(a);
    }

    public void adicionaVender(String a) {
        vender.add(a);
    }
    
    public void removeVendido(String a) {
        vendido.remove(a);
    }

    public void adicionaVendido(String a) {
        vendido.add(a);
    }

    public void removeComprado(String a) {
        comprado.remove(a);
    }

    public void adicionaComprado(String a) {
        comprado.add(a);
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public String toString() {
        return codigo + ";" + email + ";" + nome + ";" + morada + ";" + nrFiscal + ";" + vender + ";" + vendido + ";" + comprado + ";" + totVendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return codigo == that.codigo && nrFiscal == that.nrFiscal && Float.compare(that.totVendas, totVendas) == 0 && Objects.equals(email, that.email) && Objects.equals(nome, that.nome) && Objects.equals(morada, that.morada) && Objects.equals(vender, that.vender) && Objects.equals(vendido, that.vendido) && Objects.equals(comprado, that.comprado);
    }
}
