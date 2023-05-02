public class ParseSapatilha {
    public static Sapatilha parse(String[] parse) {
        Artigo.Condicao condicao;
        if (parse[2].equalsIgnoreCase("novo")) condicao = Artigo.Condicao.novo;
        else condicao = Artigo.Condicao.usado;

        Sapatilha s1 = new Sapatilha(
                Integer.parseInt(parse[1]),
                condicao,
                Float.parseFloat(parse[3]),
                Integer.parseInt(parse[4]),
                parse[5],
                parse[6],
                parse[7],
                Float.parseFloat(parse[8]),
                Float.parseFloat(parse[9]),
                parse[10],
                Integer.parseInt(parse[11]),
                parse[12].equalsIgnoreCase("true"),
                parse[13],
                Integer.parseInt(parse[14]),
                parse[15].equalsIgnoreCase("true")
        );

        return s1;
    }
}
