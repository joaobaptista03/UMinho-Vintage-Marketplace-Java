import java.time.LocalDate;

public class ParseSapatilha {
    public static Sapatilha parse(String[] parse) {
        Artigo.Condicao condicao;
        if (parse[2].equalsIgnoreCase("novo")) condicao = Artigo.Condicao.novo;
        else condicao = Artigo.Condicao.usado;

        Sapatilha s1 = new Sapatilha(
                Integer.parseInt(parse[1]),
                condicao,
                parse[3],
                Integer.parseInt(parse[4]),
                parse[5],
                parse[6],
                parse[7],
                Float.parseFloat(parse[8]),
                Float.parseFloat(parse[9]),
                Integer.parseInt(parse[10]),
                parse[11].equalsIgnoreCase("true"),
                parse[12],
                LocalDate.parse(parse[13]),
                parse[14].equalsIgnoreCase("true"),
                new Transportadora(parse[15])
        );

        return s1;
    }
}
