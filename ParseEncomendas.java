import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseEncomendas {
    public static Map<String, List<Encomenda>> get(Map<String, Artigo> marketplace) {
        Map<String,List<Encomenda>> encomendasMap = new HashMap<>();
        try {
            File input = new File("input/encomendas.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parse = line.split(";");

                Map<String, Encomenda> temp = ParseNewEncomenda.parse(parse, marketplace);
                temp.forEach((key, value) -> {
                    if (!encomendasMap.containsKey(key)) {
                        List<Encomenda> tempList = new ArrayList<>(); tempList.add(value);
                        encomendasMap.put(key, tempList);
                    }
                    else encomendasMap.get(key).add(value);
                });
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return encomendasMap;
    }
}
