import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Map<String, Artigo> marketplace = ParseArtigos.get();
        Map<Integer, Utilizador> utilizadores = ParseUtilizadores.get(marketplace);
        List<Encomenda> encomendas = new ArrayList<>();
        LocalDate data = LocalDate.now();

        for(Artigo a : marketplace.values()) System.out.println(a.toString());
        for(Utilizador u : utilizadores.values()) System.out.println(u.toString());
        for (Encomenda e : encomendas) System.out.println(e.toString());
        System.out.println(data);

        Interactive.start(marketplace, utilizadores, encomendas, data);
    }
}