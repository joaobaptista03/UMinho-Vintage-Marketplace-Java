import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Interactive {
    public static void start(Map<String, Artigo> marketplace, Map<Integer, Utilizador> utilizadores, Map<String, List<Encomenda>> encomendas, LocalDate data, Map<String, Transportadora> transportadoras) {
        System.out.println("Digite \"--help\" para listar os comandos disponíveis, ou \"exit\" para terminar.");

        Scanner stdIN = new Scanner(System.in);
        while (stdIN.hasNextLine()) {
            String line = stdIN.nextLine();
            String[] parse_command = line.split(" ", 2);

            if (parse_command.length == 1) {
                if (line.equalsIgnoreCase("exit")) return;

                if (line.equalsIgnoreCase("save")) Save.now(marketplace, utilizadores, encomendas, data, transportadoras);

                else if (line.equalsIgnoreCase("--help")) {
                    System.out.println("Criar um novo utilizador -> addUtilizador <codigo>;<email>;<nome>;<morada>;<nrFiscal>;<totVendas>");

                    System.out.println("\nCriar uma nova Mala -> addMala <codUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<comprimento>;<largura>;<altura>;<material>;<anoColecao>;<premium (true/false)>.");
                    System.out.println("Criar uma nova TShirt -> addTShirt <codUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<tamanho>;<padrao>.");
                    System.out.println("Criar uma nova Sapatilha -> addSapatilha <codUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<tamanho>;<atacadores (true/false)>;<cor>;<anoLancamento>;<premium (true/false)>.");

                    System.out.println("\nCriar uma nova Transportadora -> addTransportadora <nome>");

                    System.out.println("\nDepois de todos os artigos e utilizadores adicionados, pode criar uma nova Encomenda.");
                    System.out.println("Criar uma nova Encomenda -> addEncomenda <nrArtigos>;<codArtigo1>;<codArtigoN>;<precoExpedicao>;<estado>;<dataCriada>");

                    System.out.println("\nFinalmente, pode avançar no tempo!");
                    System.out.println("Avançar no tempo -> mudarData <nrDias>");
                }
            }

            else if (parse_command.length == 2){
                String[] parse = ("ignore;" + parse_command[1]).split(";");
                String[] parse2 = (parse_command[1]).split(";");

                if (parse_command[0].equalsIgnoreCase("addUtilizador")) {
                    Utilizador temp = ParseNewUtilizador.parse(parse2).clone();
                    utilizadores.put(temp.getCodigo(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addMala")) {
                    Mala temp = ParseMala.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getCodUtilizador()).getVender().add(temp.getCod());
                }
                else if (parse_command[0].equalsIgnoreCase("addTShirt")) {
                    TShirt temp = ParseTShirt.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getCodUtilizador()).getVender().add(temp.getCod());
                }
                else if (parse_command[0].equalsIgnoreCase("addSapatilha")) {
                    Sapatilha temp = ParseSapatilha.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getCodUtilizador()).getVender().add(temp.getCod());
                }
                else if (parse_command[0].equalsIgnoreCase("addTransportadora")) {
                    Transportadora temp = ParseNewTransportadora.parse(parse2).clone();
                    transportadoras.put(temp.getNome(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addEncomenda")) {
                    ParseNewEncomenda.parse(parse2, marketplace).forEach((key, value) -> encomendas.get(key).add(value));
                }
                else if (parse_command[0].equalsIgnoreCase("mudarData")) {
                    data = data.plusDays(Integer.parseInt(parse_command[1]));
                }

                // TESTES (REMOVER)
                for (Artigo a : marketplace.values()) System.out.println(a.toString());
                for (Utilizador u : utilizadores.values()) System.out.println(u.toString());
                for (List<Encomenda> l : encomendas.values()) {
                    for(Encomenda e : l) System.out.println(e.toString());
                }
                for (Transportadora t : transportadoras.values()) System.out.println(t.toString());
                System.out.println(data);
                // TESTES (REMOVER)
            }
        }
    }
}

