import java.util.HashMap;
import java.util.Map;

public class ParseArtigosUtilizador {
    public static Map<String, Artigo> venda(Map<String, Artigo> marketplace, int nrFiscal){
        Map<String, Artigo> artigos = new HashMap<>();
        for(Artigo a : marketplace.values()) {
            if (a.getCodUtilizador() == nrFiscal) artigos.put(a.getCod(), a.clone());
        }

        return artigos;
    }
}
