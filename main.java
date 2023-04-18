import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Map<String, Artigo> marketplace = ParseArtigos.get();
        Map<Integer, Utilizador> utilizadores = ParseUtilizadores.get(marketplace);
        LocalDate data = LocalDate.now();

        for(Artigo a : marketplace.values()) System.out.println(a.toString());
        for(Utilizador u : utilizadores.values()) System.out.println(u.toString());

        Interactive.start(marketplace, utilizadores);
    }
}