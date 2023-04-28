import java.util.HashMap;
import java.util.Map;

public class ParseArtigosUtilizador {
    public static Map<String, Artigo> venda(Map<String, Artigo> marketplace, int codUtilizador){
        Map<String, Artigo> artigos = new HashMap<>();
        for(Artigo a : marketplace.values()) {
            if (a.getCodUtilizador() == codUtilizador) artigos.put(a.getCod(), a.clone());
        }

        return artigos;
    }
}
