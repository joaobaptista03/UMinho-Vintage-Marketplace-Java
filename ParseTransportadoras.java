import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseTransportadoras {
    public static Map<String, Transportadora> get() {
        Map<String, Transportadora> transportadoras = new HashMap<>();
        try {
            File input = new File("input/transportadoras.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parse = line.split(";");

                transportadoras.put(parse[0], ParseNewTransportadora.parse(parse));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return transportadoras;
    }
}
