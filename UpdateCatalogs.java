import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UpdateCatalogs {
    public static void now(Map<String, Artigo> marketplace, Map<Integer, Utilizador> utilizadores, Map<String, List<Encomenda>> encomendas, LocalDate data, Map<String, Transportadora> transportadoras) {

        encomendas.forEach( (transportadora, encomendasTransportadora) -> {
            int diasParaExpedicao = transportadoras.get(transportadora).getDiasParaExpedicao();
        
            Iterator<Encomenda> it = encomendasTransportadora.iterator();
            while (it.hasNext()) {
                Encomenda encomenda = it.next();

                LocalDate expedicaoPrevista = encomenda.getDataCriada().plusDays(diasParaExpedicao);
                if (data.isAfter(expedicaoPrevista) || data.isEqual(expedicaoPrevista)) {
                    for (String cod : encomenda.getArtigos()) {
                        utilizadores.get(marketplace.get(cod).getCodUtilizador()).removeVender(cod);
                        utilizadores.get(marketplace.get(cod).getCodUtilizador()).adicionaVendido(cod);
                        marketplace.remove(cod);
                    }
                    it.remove();
                }
            }
        });
    }
}