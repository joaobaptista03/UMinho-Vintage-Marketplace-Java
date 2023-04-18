import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParseArtigosUtilizador {
    public static List<Artigo> venda(List<Artigo> marketplace, int nrFiscal){
        List<Artigo> artigos = marketplace.stream()
                .filter(a -> a.getFiscalUtilizador() == nrFiscal)
                .map(a -> a.clone())
                .collect(Collectors.toList());

        return artigos;
    }
}
