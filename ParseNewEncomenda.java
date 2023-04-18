import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseNewEncomenda {
    public static Encomenda parse(String[] parse, Map<String, Artigo> marketplace) {
        int nrArtigos = Integer.parseInt(parse[0]);
        List<Artigo> artigos = new ArrayList<>();
        for(int i = 0; i < nrArtigos; i++) artigos.add(marketplace.get(parse[i+1]).clone());

        Encomenda.Dimensao dimensao;
            if (parse[nrArtigos + 1].equalsIgnoreCase("pequeno")) dimensao = Encomenda.Dimensao.pequeno;
            else if (parse[nrArtigos + 1].equalsIgnoreCase("medio")) dimensao = Encomenda.Dimensao.medio;
            else dimensao = Encomenda.Dimensao.grande;

        Encomenda.Estado estado;
            if (parse[nrArtigos + 4].equalsIgnoreCase("pendente")) estado = Encomenda.Estado.pendente;
            else if (parse[nrArtigos + 4].equalsIgnoreCase("finalizada")) estado = Encomenda.Estado.finalizada;
            else estado = Encomenda.Estado.expedida;

        return new Encomenda(
            artigos,
            dimensao,
            Float.parseFloat(parse[nrArtigos + 2]),
            Float.parseFloat(parse[nrArtigos + 3]),
            estado,
            LocalDate.parse(parse[nrArtigos + 5])
        );
    }
}
