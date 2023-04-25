import java.util.HashMap;

public class ParseNewUtilizador {
    public static Utilizador parse(String[] parse) {
        return new Utilizador(
                Integer.parseInt(parse[0]),
                parse[1],
                parse[2],
                parse[3],
                Integer.parseInt(parse[4]),
                new HashMap<>(),
                new HashMap<>(),
                Float.parseFloat(parse[5])
        );
    }
}
