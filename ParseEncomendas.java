import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseEncomendas {
    public static List<Encomenda> get(Map<String, Artigo> marketplace) {
        List<Encomenda> encomendas = new ArrayList<>();
        try {
            File input = new File("input/encomendas.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parse = line.split(";");

                encomendas.add(ParseNewEncomenda.parse(parse, marketplace));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return encomendas;
    }
}
