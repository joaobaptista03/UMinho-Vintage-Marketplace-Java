import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Save {
    public static void now(Map<String, Artigo> marketplace, Map<Integer, Utilizador> utilizadores, List<Encomenda> encomendas, LocalDate data, Map<String, Transportadora> transportadoras) {
        try {
            File utilizadores_output = new File("output/utilizadores.txt");
            FileWriter utilizadores_write = new FileWriter(utilizadores_output);

            File artigos_output = new File("output/artigos.txt");
            FileWriter artigos_write = new FileWriter(artigos_output);

            File encomendas_output = new File("output/encomendas.txt");
            FileWriter encomendas_write = new FileWriter(encomendas_output);

            File transportadoras_output = new File("output/transportadoras.txt");
            FileWriter transportadoras_write = new FileWriter(transportadoras_output);

            File data_output = new File("output/data.txt");
            FileWriter data_write = new FileWriter(data_output);

            for (Utilizador u : utilizadores.values()) utilizadores_write.write(u.toString() + "\n");
            utilizadores_write.close();

            for (Artigo a : marketplace.values()) artigos_write.write(a.toString() + "\n");
            artigos_write.close();

            for (Encomenda e : encomendas) encomendas_write.write(e.toString() + "\n");
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
}
