import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseArtigosUtilizador {
    public static Map<String, Artigo> venda(Map<String, Artigo> marketplace, int nrFiscal){
        Map<String, Artigo> artigos = new HashMap<>();
        for(Artigo a : marketplace.values()) {
            if (a.getFiscalUtilizador() == nrFiscal) artigos.put(a.getCod(), a.clone());
        }

        return artigos;
    }
}
