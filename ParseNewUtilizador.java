import java.util.HashMap;

public class ParseNewUtilizador {
    public static Utilizador parse(String[] parse) {
        return new Utilizador(
                parse[0],
                parse[1],
                parse[2],
                Integer.parseInt(parse[3]),
                new HashMap<>(),
                new HashMap<>(),
                Float.parseFloat(parse[4])
        );
    }
}
