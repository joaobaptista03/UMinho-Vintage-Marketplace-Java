import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<Artigo> marketplace = ParseArtigos.get();
        List<Utilizador> utilizadores = ParseUtilizador.get(marketplace);
        LocalDate data = LocalDate.now();

        marketplace.stream().forEach(a -> System.out.println(a.toString()));
        utilizadores.stream().forEach(u -> System.out.println(u.toString()));
    }
}
