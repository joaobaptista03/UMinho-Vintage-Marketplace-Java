import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Map<String, Artigo> marketplace = ParseArtigos.get();
        Map<Integer, Utilizador> utilizadores = ParseUtilizadores.get(marketplace);
        Map<String, List<Encomenda>> encomendas = ParseEncomendas.get(marketplace);
        Map<String, Transportadora> transportadoras = ParseTransportadoras.get();
        LocalDate data = LocalDate.now();

        // TESTES (REMOVER)
        System.out.println("");
        for(Artigo a : marketplace.values()) System.out.println(a.toString());
        for(Utilizador u : utilizadores.values()) System.out.println(u.toString());
        for (List<Encomenda> l : encomendas.values()) {
            for(Encomenda e : l) System.out.println(e.toString());
        }
        for (Transportadora t : transportadoras.values()) System.out.println(t.toString());
        System.out.println(data);
        System.out.println("");
        // TESTES (REMOVER)

        Interactive.start(marketplace, utilizadores, encomendas, data, transportadoras);
    }
}