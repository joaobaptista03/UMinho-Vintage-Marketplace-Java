import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseArtigosUtilizador {
    public static List<String> venda(Map<String, Artigo> marketplace, int codUtilizador){
        List<String> artigos = new ArrayList<>();
        for(Artigo a : marketplace.values()) {
            if (a.getCodUtilizador() == codUtilizador) artigos.add(a.getCod());
        }

        return artigos;
    }
}
