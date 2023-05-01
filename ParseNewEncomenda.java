import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseNewEncomenda {
    public static Encomenda parse(String[] parse, Map<String, Artigo> marketplace) {
        int nrArtigos = Integer.parseInt(parse[0]);
        List<String> artigos = new ArrayList<>();
        for(int i = 0; i < nrArtigos; i++) artigos.add(marketplace.get(parse[i+1]).getCod());

        Encomenda.Dimensao dimensao;
            if (nrArtigos == 1) dimensao = Encomenda.Dimensao.pequeno;
            else if (nrArtigos <= 5) dimensao = Encomenda.Dimensao.medio;
            else dimensao = Encomenda.Dimensao.grande;

        Encomenda.Estado estado;
            if (parse[nrArtigos + 2].equalsIgnoreCase("pendente")) estado = Encomenda.Estado.pendente;
            else if (parse[nrArtigos + 2].equalsIgnoreCase("finalizada")) estado = Encomenda.Estado.finalizada;
            else estado = Encomenda.Estado.expedida;

        return new Encomenda(
            artigos,
            dimensao,
            estado,
            LocalDate.parse(parse[nrArtigos + 2])
        );
    }
}
