public class Transportadora {
    private String nome;

    public Transportadora() {
        this.nome = "";
    }

    public Transportadora(String nome) {
        this.nome = nome;
    }

    public Transportadora(Transportadora t) {
        this.nome = t.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
