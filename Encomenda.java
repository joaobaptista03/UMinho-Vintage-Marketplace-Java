import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    public enum Dimensao {grande, medio, pequeno}
    public enum Estado {pendente, finalizada, expedida}

    private List<Artigo> artigos;
    private Dimensao dimensao;
    private float precoFinal;
    private float precoExpedicao;
    private Estado estado;
    private LocalDate dataCriada;

    public Encomenda() {
        this.artigos = new ArrayList<Artigo>();
        this.dimensao = Dimensao.pequeno;
        this.precoFinal = 0;
        this.precoExpedicao = 0;
        this.estado = Estado.pendente;
        this.dataCriada = LocalDate.now();
    }

    public Encomenda(List<Artigo> artigos, Dimensao dimensao, float precoFinal, float precoExpedicao, Estado estado, LocalDate dataCriada) {
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.precoExpedicao = precoExpedicao;
        this.estado = estado;
        this.dataCriada = dataCriada;
    }

    public Encomenda(Encomenda e) {
        this.artigos = e.getArtigos();
        this.dimensao = e.getDimensao();
        this.precoFinal = e.getPrecoFinal();
        this.precoExpedicao = e.getPrecoExpedicao();
        this.estado = e.getEstado();
        this.dataCriada = e.getDataCriada();
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }

    public float getPrecoExpedicao() {
        return precoExpedicao;
    }

    public void setPrecoExpedicao(float precoExpedicao) {
        this.precoExpedicao = precoExpedicao;
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

    public void addArtigo(Artigo a) {
        this.artigos.add(a);
    }

    public void remArtigo(String cod) {
        this.artigos.removeIf(a -> a.getCod().equals(cod));
    }

    public double calcPrecoFinal() {
        return this.artigos.stream()
                .mapToDouble(a -> getPrecoFinal())
                .sum();
    }
}
