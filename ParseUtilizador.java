import jdk.jshell.execution.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseUtilizador {
    public static List<Utilizador> get(List<Artigo> marketplace) {
        List <Utilizador> utilizadores = new ArrayList<>();
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
                        new ArrayList<>(),
                        Float.parseFloat(parsing[4])
                );

                utilizadores.add(user);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return utilizadores;
    }
}
