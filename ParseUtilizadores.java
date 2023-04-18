import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseUtilizadores {
    public static Map<Integer, Utilizador> get(Map<String, Artigo> marketplace) {
        Map<Integer, Utilizador> utilizadores = new HashMap<>();
        try {
            File input = new File("users_txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parsing = line.split(";");
                Utilizador user = new Utilizador(
                        parsing[0],
                        parsing[1],
                        parsing[2],
                        Integer.parseInt(parsing[3]),
                        ParseArtigosUtilizador.venda(marketplace, Integer.parseInt(parsing[3])),
                        new HashMap<>(),
                        Float.parseFloat(parsing[4])
                );

                utilizadores.put(user.getNrFiscal(), user);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return utilizadores;
    }
}
