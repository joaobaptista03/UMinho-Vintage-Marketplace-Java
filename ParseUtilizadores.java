import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseUtilizadores {
    public static Map<Integer, Utilizador> get() {
        Map<Integer, Utilizador> utilizadores = new HashMap<>();
        try {
            File input = new File("input/utilizadores.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parsing = line.split(";");
                Utilizador user = new Utilizador(
                        Integer.parseInt(parsing[0]),
                        parsing[1],
                        parsing[2],
                        parsing[3],
                        Integer.parseInt(parsing[4]),
                        GestãoVintage.getArtigosUtilizador(Integer.parseInt(parsing[0])),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        Float.parseFloat(parsing[5])
                );

                utilizadores.put(user.getCodigo(), user);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return utilizadores;
    }
}
