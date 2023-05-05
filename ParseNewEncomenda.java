import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseNewEncomenda {
    public static Map<String,Encomenda> parse(String[] parse) {
        int nrArtigos = Integer.parseInt(parse[0]);

        Map<String,Encomenda> encomendasMap = new HashMap<>();

        for(int i = 0; i < nrArtigos; i++) {
            Artigo tempA = GestãoVintage.getArtigoMarketplace(parse[i+1]);
            String transportadoraTemp = tempA.getTransportadora();

            if (!encomendasMap.containsKey(transportadoraTemp)) {
                List<String> newEncArt = new ArrayList<>(); newEncArt.add(tempA.getCod());
                encomendasMap.put(transportadoraTemp, new Encomenda(newEncArt, Encomenda.Estado.pendente, LocalDate.parse(parse[nrArtigos + 2])));
            }
            else encomendasMap.get(transportadoraTemp).addArtigo(tempA.getCod());
        }

        return encomendasMap;
    }
}