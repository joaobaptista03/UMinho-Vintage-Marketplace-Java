import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ParseArtigos {
    public static Map<String, Artigo> get(GestãoVintage.TipoArtigoColecao tipo) {
        Map<String, Artigo> artigos = new HashMap<>();
        try {
            String file_path = "";
            if (tipo.equals(GestãoVintage.TipoArtigoColecao.marketplace)) file_path = "input/marketplace.txt";
                else file_path = "input/vendidos.txt";
                
            File input = new File(file_path);
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parse = line.split(";");
                if (parse[0].equalsIgnoreCase("TShirt")) {
                    TShirt temp = ParseTShirt.parse(parse);
                    artigos.put(temp.getCod(), temp);
                }
                else if (parse[0].equalsIgnoreCase("Mala")) {
                    Mala temp = ParseMala.parse(parse);
                    artigos.put(temp.getCod(), temp);
                }
                else if (parse[0].equalsIgnoreCase("Sapatilha")) {
                    Sapatilha temp = ParseSapatilha.parse(parse);
                    artigos.put(temp.getCod(), temp);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return artigos;
    }
}
