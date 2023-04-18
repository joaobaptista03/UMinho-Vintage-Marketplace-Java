import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseArtigos {
    public static List<Artigo> get() {
        List<Artigo> artigos = new ArrayList<>();
        try {
            File input = new File("artigos_txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parse = line.split(";");
                if (parse[0].equalsIgnoreCase("TShirt")) artigos.add(ParseTShirt.parse(parse));
                else if (parse[0].equalsIgnoreCase("Mala")) artigos.add(ParseMala.parse(parse));
                else if (parse[0].equalsIgnoreCase("Sapatilha")) artigos.add(ParseSapatilha.parse(parse));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return artigos;
    }
}
