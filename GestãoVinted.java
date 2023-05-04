import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestãoVinted {
    private static Map<String, Artigo> marketplace = ParseArtigos.get();
    private static Map<String, Artigo> vendidos = new HashMap<>();
    private static Map<Integer, Utilizador> utilizadores = ParseUtilizadores.get(marketplace);
    private static Map<String, List<Encomenda>> encomendas = ParseEncomendas.get(marketplace);
    private static Map<String, Transportadora> transportadoras = ParseTransportadoras.get();
    private static LocalDate data = LocalDate.now();

    public static Artigo getArtigoMarketplace(String cod) {
        return marketplace.get(cod).clone();
    }

    public static void addArtigoMarketplace(Artigo a) {
        marketplace.put(a.getCod(), a.clone());
    }

    public static void removeArtigoMarketplace(String cod) {
        marketplace.remove(cod);
    }

    public static Artigo getArtigoVendidos(String cod) {
        return vendidos.get(cod).clone();
    }

    public static void addArtigoVendidos(Artigo a) {
        vendidos.put(a.getCod(), a.clone());
    }

    public static void removeArtigoVendidos(String cod) {
        vendidos.remove(cod);
    }

    public static Utilizador getUtilizador(int cod) {
        return utilizadores.get(cod).clone();
    }

    public static void addUtilizador(Utilizador u) {
        utilizadores.put(u.getCodigo(), u.clone());
    }

    public static void removeUtilizador(int cod) {
        utilizadores.remove(cod);
    }

    public static void addUtilizadorVender(int codUser, String codArtigo) {
        utilizadores.get(codUser).getVender().add(codArtigo);
    }

    public static void removeUtilizadorVender(int codUser, String codArtigo) {
        utilizadores.get(codUser).getVender().remove(codArtigo);
    }

    public static List<Encomenda> getEncomendas(String transportadora) {
        return encomendas.get(transportadora).stream()
            .map(e -> e.clone())
            .collect(Collectors.toList());
    }

    public static void addEncomenda(String transportadora, Encomenda encomenda) {
        encomendas.get(transportadora).add(encomenda.clone());
    }

    public static void removeEncomenda(String transportadora, Encomenda e) {
        Iterator<Encomenda> it = encomendas.get(transportadora).iterator();
        while (it.hasNext()) {
            Encomenda encomenda = it.next();
            if (encomenda.equals(e)) it.remove();
        }
    }

    public static Transportadora getTransportadora(String transportadora) {
        return transportadoras.get(transportadora).clone();
    }

    public static void addTransportadora(Transportadora t) {
        transportadoras.put(t.getNome(), t.clone());
    }

    public static void removeTransportadora(String t) {
        transportadoras.remove(t);
    }

    public static LocalDate getData() {
        return data;
    }

    public static void mudarData(int dias) {
        data = data.plusDays(dias);
    }

    public static void testar() {
        System.out.println("\nMarketplace:");
        for (Artigo a : marketplace.values()) System.out.println(a.toString());

        System.out.println("\nVendidos:");
        for (Artigo a : vendidos.values()) System.out.println(a.toString());
        
        System.out.println("\nUtilizadores:");
        for (Utilizador u : utilizadores.values()) System.out.println(u.toString());
        
        System.out.println("\nEncomendas:");
        for (List<Encomenda> l : encomendas.values()) {
            for(Encomenda e : l) System.out.println(e.toString());
        }
        
        System.out.println("\nTransportadoras:");
        for (Transportadora t : transportadoras.values()) System.out.println(t.toString());
        
        System.out.println("\nData:");
        System.out.println(data);
    }

    public static void save() {
        try {
            File utilizadores_output = new File("output/utilizadores.txt");
            FileWriter utilizadores_write = new FileWriter(utilizadores_output);

            File marketplace_output = new File("output/marketplace.txt");
            FileWriter marketplace_writer = new FileWriter(marketplace_output);

            File vendidos_output = new File("output/vendidos.txt");
            FileWriter vendidos_writer = new FileWriter(vendidos_output);

            File encomendas_output = new File("output/encomendas.txt");
            FileWriter encomendas_write = new FileWriter(encomendas_output);

            File transportadoras_output = new File("output/transportadoras.txt");
            FileWriter transportadoras_write = new FileWriter(transportadoras_output);

            File data_output = new File("output/data.txt");
            FileWriter data_write = new FileWriter(data_output);

            for (Utilizador u : utilizadores.values()) utilizadores_write.write(u.toString() + "\n");
            utilizadores_write.close();

            for (Artigo a : marketplace.values()) marketplace_writer.write(a.toString() + "\n");
            marketplace_writer.close();

            for (Artigo a : vendidos.values()) vendidos_writer.write(a.toString() + "\n");
            vendidos_writer.close();

            for (List<Encomenda> l : encomendas.values())
                for(Encomenda e : l) encomendas_write.write(e.toString() + "\n");
            encomendas_write.close();

            for(Transportadora t : transportadoras.values()) transportadoras_write.write(t.toString() + "\n");
            transportadoras_write.close();

            data_write.write(data.toString());
            data_write.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void update() {

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
                        Artigo temp = marketplace.get(cod);
                        marketplace.remove(cod);
                        vendidos.put(cod, temp);
                    }
                    it.remove();
                }
            }
        });
    }
}
