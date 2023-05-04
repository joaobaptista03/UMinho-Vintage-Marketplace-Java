import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Map<String, Artigo> marketplace = ParseArtigos.get();
        Map<String, Artigo> vendidos = new HashMap<>();
        Map<Integer, Utilizador> utilizadores = ParseUtilizadores.get(marketplace);
        Map<String, List<Encomenda>> encomendas = ParseEncomendas.get(marketplace);
        Map<String, Transportadora> transportadoras = ParseTransportadoras.get();
        LocalDate data = LocalDate.now();

        // TESTES (REMOVER)
        System.out.println("\nMarketplace:");
        for (Artigo a : marketplace.values()) System.out.println(a.toString());

        System.out.println("\nVendidos:");
        for (Artigo a : vendidos.values()) System.out.println(a.toString());
        
        System.out.println("\nUtilizadores:");
        for (Utilizador u : utilizadores.values()) System.out.println(u.toString());
        
        System.out.println("\nEncomendas:");
        for (List<Encomenda> l : encomendas.values()) {
            for(Encomenda e : l) System.out.println(e.toString());
        }
        
        System.out.println("\nTransportadoras:");
        for (Transportadora t : transportadoras.values()) System.out.println(t.toString());
        
        System.out.println("\nData:");
        System.out.println(data);
        // TESTES (REMOVER)

        Interactive.start(marketplace, vendidos, utilizadores, encomendas, data, transportadoras);
    }
}