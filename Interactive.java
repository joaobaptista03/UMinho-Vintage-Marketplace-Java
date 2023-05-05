import java.util.Scanner;

public class Interactive {
    public static void start() {
        System.out.println("Digite \"--help\" para listar os comandos disponíveis, ou \"exit\" para terminar.");

        try (Scanner stdIN = new Scanner(System.in)) {
            while (stdIN.hasNextLine()) {
                String line = stdIN.nextLine();
                String[] parse_command = line.split(" ", 2);

                if (parse_command.length == 1) {
                    if (line.equalsIgnoreCase("exit")) return;

                    if (line.equalsIgnoreCase("save")) GestãoVintage.save();
                    
                    if (line.equalsIgnoreCase("lucrovintage")) System.out.println(GestãoVintage.getLucrovintage());

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
                        Utilizador temp = ParseNewUtilizador.parse(parse2);
                        GestãoVintage.addUtilizador(temp);
                    }
                    else if (parse_command[0].equalsIgnoreCase("addMala")) {
                        Mala temp = ParseMala.parse(parse);
                        GestãoVintage.addArtigoMarketplace(temp);
                        GestãoVintage.removeUtilizadorVender(temp.getCodUtilizador(), temp.getCod());
                    }
                    else if (parse_command[0].equalsIgnoreCase("addTShirt")) {
                        TShirt temp = ParseTShirt.parse(parse);
                        GestãoVintage.addArtigoMarketplace(temp);
                        GestãoVintage.removeUtilizadorVender(temp.getCodUtilizador(), temp.getCod());
                    }
                    else if (parse_command[0].equalsIgnoreCase("addSapatilha")) {
                        Sapatilha temp = ParseSapatilha.parse(parse);
                        GestãoVintage.addArtigoMarketplace(temp);
                        GestãoVintage.removeUtilizadorVender(temp.getCodUtilizador(), temp.getCod());
                    }
                    else if (parse_command[0].equalsIgnoreCase("addTransportadora")) {
                        Transportadora temp = ParseNewTransportadora.parse(parse2);
                        GestãoVintage.addTransportadora(temp);
                    }
                    else if (parse_command[0].equalsIgnoreCase("addEncomenda")) {
                        ParseNewEncomenda.parse(parse2).forEach((key, value) -> GestãoVintage.addEncomenda(key, value));
                    }
                    else if (parse_command[0].equalsIgnoreCase("mudarData")) {
                        GestãoVintage.mudarData(Integer.parseInt(parse_command[1]));
                        GestãoVintage.update();
                    }

                    GestãoVintage.testar();
                }
            }

            stdIN.close();
        } catch (NumberFormatException e) {
            System.out.println("Failed to input newline.");
            e.printStackTrace();
        }
    }
}

