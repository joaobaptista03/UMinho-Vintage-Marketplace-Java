public class ParseNewTransportadora {
    public static Transportadora parse(String[] parse) {
        return new Transportadora(
                parse[0],
                Float.parseFloat(parse[1]),
                Float.parseFloat(parse[2]),
                Float.parseFloat(parse[3]),
                Float.parseFloat(parse[4]),
                Float.parseFloat(parse[5]),
                Integer.parseInt(parse[6])
        );
    }
}
