import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseNewEncomenda {
    public static Map<String,Encomenda> parse(String[] parse, Map<String, Artigo> marketplace) {
        int nrArtigos = Integer.parseInt(parse[0]);

        Map<String,Encomenda> encomendasMap = new HashMap<>();

        for(int i = 0; i < nrArtigos; i++) {
            String transportadoraTemp = marketplace.get(parse[i+1]).getTransportadora();
            if (!encomendasMap.containsKey(transportadoraTemp)) {
                List<String> newEncArt = new ArrayList<>(); newEncArt.add(marketplace.get(parse[i+1]).getCod());
                encomendasMap.put(transportadoraTemp, new Encomenda(newEncArt, Encomenda.Estado.pendente, LocalDate.parse(parse[nrArtigos + 2])));
            }
            else encomendasMap.get(transportadoraTemp).addArtigo(marketplace.get(parse[i+1]).getCod());
        }

        return encomendasMap;
    }
}
