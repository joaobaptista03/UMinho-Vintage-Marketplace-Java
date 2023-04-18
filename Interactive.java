import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Interactive {
    public static void start(Map<String, Artigo> marketplace, Map<Integer, Utilizador> utilizadores) {
        System.out.println("Digite \"--help\" para listar os comandos disponíveis, ou \"exit\" para terminar.");

        Scanner stdIN = new Scanner(System.in);
        while (stdIN.hasNextLine()) {
            String line = stdIN.nextLine();
            String[] parse_command = line.split(" ", 2);

            if (parse_command.length == 1) {
                if (line.equalsIgnoreCase("exit")) return;
                else if (line.equalsIgnoreCase("--help")) {
                    System.out.println("Criar um novo utilizador -> addUtilizador <email>;<nome>;<morada>;<nrFiscal>;<totVendas>");

                    System.out.println("\nCriar uma nova Mala -> addMala <fiscalUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<comprimento>;<largura>;<altura>;<material>;<anoColecao>;<premium (true/false)>.");
                    System.out.println("Criar uma nova TShirt -> addTShirt <fiscalUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<tamanho>;<padrao>.");
                    System.out.println("Criar uma nova Sapatilha -> addSapatilha <fiscalUtilizador>;<condicao>;<estado>;<nrDonos>;<descricao>;<marca>;<cod>;<precoBase>;<correcaoPreco>;<transportadora>;<tamanho>;<atacadores (true/false)>;<cor>;<lancamento (2023-12-08)>;<premium (true/false)>.");

                    System.out.println("\nFinalmente, depois de todos os artigos e utilizadores adicionados, pode criar uma nova Encomenda.");
                    System.out.println("Criar uma nova Encomenda -> addEncomenda <nrArtigos>;<codArtigo1>;<codArtigoN>;<dimensao>;<precoFinal>;<precoExpedicao>;<estado>;<dataCriada>");
                }
            }

            else if (parse_command.length == 2){
                String[] parse = ("ignore;" + parse_command[1]).split(";");
                String[] parse2 = (parse_command[1]).split(";");

                if (parse_command[0].equalsIgnoreCase("addUtilizador")) {
                    Utilizador temp = ParseNewUtilizador.parse(parse2).clone();
                    utilizadores.put(temp.getNrFiscal(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addMala")) {
                    Mala temp = ParseMala.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getFiscalUtilizador()).getVender().put(temp.getCod(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addTShirt")) {
                    TShirt temp = ParseTShirt.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getFiscalUtilizador()).getVender().put(temp.getCod(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addSapatilha")) {
                    Sapatilha temp = ParseSapatilha.parse(parse).clone();
                    marketplace.put(temp.getCod(), temp);
                    utilizadores.get(temp.getFiscalUtilizador()).getVender().put(temp.getCod(), temp);
                }
                else if (parse_command[0].equalsIgnoreCase("addEncomenda")) {
                }

                for (Artigo a : marketplace.values()) System.out.println(a.toString());
                for (Utilizador u : utilizadores.values()) System.out.println(u.toString());
            }
        }
    }
}
