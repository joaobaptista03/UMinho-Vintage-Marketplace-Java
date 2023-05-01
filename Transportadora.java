import java.util.Objects;

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

    public Transportadora clone() {
        return new Transportadora(this);
    }

    public String toString() {
        return "Transportadora;" + nome + "\n";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora that = (Transportadora) o;
        return Objects.equals(nome, that.nome);
    }
}
