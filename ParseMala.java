public class ParseMala {
    public static Mala parse(String[] parse) {
        Artigo.Condicao condicao;
            if (parse[2].equalsIgnoreCase("novo")) condicao = Artigo.Condicao.novo;
            else condicao = Artigo.Condicao.usado;

        Mala m1 = new Mala(
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
                Float.parseFloat(parse[11]),
                Float.parseFloat(parse[12]),
                Float.parseFloat(parse[13]),
                parse[14],
                Integer.parseInt(parse[15]),
                parse[16].equalsIgnoreCase("true")
        );

        return m1;
    }
}