import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Encomenda {
    public enum Dimensao {grande, medio, pequeno}

    public enum Estado {pendente, finalizada, expedida}

    private List<String> artigos;
    private Dimensao dimensao;
    private Estado estado;
    private LocalDate dataCriada;

    public Encomenda() {
        this.artigos = new ArrayList<>();
        this.dimensao = Dimensao.pequeno;
        this.estado = Estado.pendente;
        this.dataCriada = LocalDate.now();
    }

    public Encomenda(List<String> artigos, Estado estado, LocalDate dataCriada) {
        this.artigos = new ArrayList<>();
            this.artigos.addAll(artigos);
        if (artigos.size() == 1) this.dimensao = Dimensao.pequeno;
            else if (artigos.size() <= 5) this.dimensao = Dimensao.medio;
            else this.dimensao = Dimensao.grande;
        this.estado = estado;
        this.dataCriada = dataCriada;
    }

    public Encomenda(Encomenda e) {
        this.artigos = e.getArtigos();
        this.dimensao = e.getDimensao();
        this.estado = e.getEstado();
        this.dataCriada = e.getDataCriada();
    }

    public List<String> getArtigos() {
        List<String> new_artigos = new ArrayList<>();
            new_artigos.addAll(this.artigos);
        return new_artigos;
    }

    public void setArtigos(List<String> artigos) {
        this.artigos = new ArrayList<>();
        this.artigos.addAll(artigos);
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(LocalDate dataCriada) {
        this.dataCriada = dataCriada;
    }

    public void addArtigo(String a) {
        this.artigos.add(a);
    }

    public void remArtigo(String cod) {
        this.artigos.removeIf(a -> a.equals(cod));
    }

    public float calcPrecoFinal(Map<String, Artigo> marketplace) {
        float total = 0;
        for(String cod : this.artigos) {
            float satisfacao;
            if (marketplace.get(cod).getCondicao().equals(Artigo.Condicao.novo)) satisfacao = 0.5F;
            else satisfacao = 0.25F;
            total += marketplace.get(cod).getPrecoTotal() + satisfacao;
        }

        return total;
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public String toString() {
        return "Encomenda;" + artigos + ";" + dimensao + ";" + estado + ";" + dataCriada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return Objects.equals(artigos, encomenda.artigos) && dimensao == encomenda.dimensao && estado == encomenda.estado && Objects.equals(dataCriada, encomenda.dataCriada);
    }
}