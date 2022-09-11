import java.text.DecimalFormat;
import java.util.*;

class VerificadorCustom implements Comparator<Ouvinte> {

    // override ao metodo de comparar
    public int compare(Ouvinte o1, Ouvinte o2) {
        if (o1.ganhou == o2.ganhou)
            return 0;
        else if (o2.ganhou > o1.ganhou)
            return 1;
        else
            return -1;
    }
}

public class JogoDoSaco {
    static Scanner imp = new Scanner(System.in);

    static Registo chamadas = new Registo();

    static Random sorte = new Random();
    static DecimalFormat peso = new DecimalFormat("#.000");

    static Art arte = new Art();

    static Ouvinte ouv1 = new Ouvinte("Anabela", "Malhadas", "937012903");
    static Ouvinte ouv2 = new Ouvinte("Ricardo", "Trofa", "917778930");
    static Ouvinte ouv3 = new Ouvinte("Maria", "Matosinhos", "919993489");

    static Ouvinte ouv4 = new Ouvinte("Pedro", "Porto", "914464789");

    static Ouvinte vencedor;
    static double melhorPalp;


    public static void main(String[] args) {
        int op = 1;

////ATENCAO: Ponha a Anabela na lista por sua conta e risco!
//        chamadas.listaOuvintes.add(ouv1);
        chamadas.listaOuvintes.add(ouv2);
        chamadas.listaOuvintes.add(ouv3);
        chamadas.listaOuvintes.add(ouv4);

        while (op != 0) {
            try {
                arte.Ascii();
                System.out.println("-------------------------------------------");
                System.out.println("Bom dia Braganca!");
                System.out.println("-------------------------------------------");
                System.out.println("Escolha uma opcao");
                System.out.println("1 - Criar Ouvintes");
                System.out.println("2 - Editar Ouvintes");
                System.out.println("3 - Eliminar Ouvintes");
                System.out.println("4 - Verificar Ouvintes");
                System.out.println("5 - Ver Ranking");
                System.out.println("6 - Jogar");
                System.out.println("0 - Sair");
                op = imp.nextInt();
                imp.nextLine();

                switch (op) {
                    case 1 -> criarOuv();
                    case 2 -> editarOuv();
                    case 3 -> eliminarOuv();
                    case 4 -> verOuv();
                    case 5 -> verRank();
                    case 6 -> jogoSaco();
                    case 0 -> {
                    }
                }
            } catch (Exception e) {
                System.out.println("Opcao Invalida");
                imp = new Scanner(System.in);
            }
        }

    }

    /**
     * Criar um Ouvinte
     */
    private static void criarOuv() {
        String nomeOuv, locOuv, telOuv;

        System.out.println("Introduza o nome do ouvinte.");
        nomeOuv = imp.nextLine();

        System.out.println("Introduza a localidade do ouvinte.");
        locOuv = imp.nextLine();

        System.out.println("Introduza o contacto do ouvinte.");
        telOuv = imp.nextLine();

        Ouvinte ouv = new Ouvinte(nomeOuv, locOuv, telOuv);

        chamadas.listaOuvintes.add(ouv);

    }

    /**
     * Editar um Ouvinte
     */
    private static void editarOuv() {

        int escolha;
        String editando = "";

        for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {
            System.out.println("\n==================================================");
            System.out.printf("%so  Ouvinte: \n%s", i + 1, chamadas.listaOuvintes.get(i));
        }


        System.out.println("\n\nQual e o ouvinte que quer editar?");
        escolha = imp.nextInt() - 1;
        imp.nextLine();


        if (escolha >= 0 && escolha < chamadas.listaOuvintes.size()) {
            while (!editando.equals("sair")) {
                System.out.println("\nO que quer editar? Escreva(Nome/Local/NumTele) ou 'Sair' para terminar.");
                editando = imp.nextLine().toLowerCase();

                if (!editando.equals("nome") && !editando.equals("local") &&
                        !editando.equals("numtele") && !editando.equals("sair")) {
                    System.out.println("\n****************************************************");
                    System.out.println("Escolha Invalida tente novamente");
                    System.out.println("****************************************************\n");
                } else {
                    switch (editando) {
                        case "nome" -> {
                            String nom;
                            System.out.println("Introduza o novo nome.");
                            nom = imp.nextLine();
                            chamadas.listaOuvintes.get(escolha).setNome(nom);
                            System.out.println("\n**************************************************");
                            System.out.println("Nome Alterado com Sucesso!");
                            System.out.println("****************************************************\n");
                        }
                        case "local" -> {
                            String loc;
                            System.out.println("Introduza a nova localidade.");
                            loc = imp.nextLine();
                            chamadas.listaOuvintes.get(escolha).setLocalidade(loc);
                            System.out.println("\n**************************************************");
                            System.out.println("Localidade Alterada com Sucesso!");
                            System.out.println("****************************************************\n");
                        }
                        case "numtele" -> {
                            String tele;
                            System.out.println("Introduza o novo contacto.");
                            tele = imp.nextLine();
                            chamadas.listaOuvintes.get(escolha).setNumTel(tele);
                            System.out.println("\n**************************************************");
                            System.out.println("Numero Alterado com Sucesso!");
                            System.out.println("****************************************************\n");

                        }
                        case "sair" -> {
                            System.out.println("\n============================================================");
                            System.out.printf("Estado:\n %s", chamadas.listaOuvintes.get(escolha));
                            System.out.println("============================================================\n");
                        }
                    }
                }
            }
        } else {
            System.out.println("Esse ouvinte nao existe.. Voltando para o menu..");
        }

    }

    /**
     * Eliminar um ou mais ouvintes
     */
    private static void eliminarOuv() {
        int escolha;

        System.out.println("Pretende eliminar 1 ouvinte ou a lista completa?");
        System.out.println("-----------------------------------------------------");
        System.out.println("1 - Ouvinte particular");
        System.out.println("2 - Lista completa de ouvintes");
        System.out.println("0 - Voltar para o menu");
        escolha = imp.nextInt();
        imp.nextLine();

        switch (escolha) {
            case 1 -> {
                int op;
                for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {
                    System.out.println("\n==================================================");
                    System.out.printf("%so  Ouvinte: \n%s", i + 1, chamadas.listaOuvintes.get(i));
                }

                System.out.println("\n\nQual e o ouvinte que quer apagar?");
                op = imp.nextInt() - 1;
                imp.nextLine();

                if (op >= 0 && op < chamadas.listaOuvintes.size()) {
                    String conf;

                    System.out.println("Tem a certeza? Escreva 'Sim' para confirmar.");
                    conf = imp.nextLine().toLowerCase();

                    if (conf.equals("sim")) {
                        chamadas.listaOuvintes.remove(op);
                        System.out.println("\n**************************************************");
                        System.out.println("Ouvinte removido com Sucesso!");
                        System.out.println("****************************************************\n");
                    } else {
                        System.out.println("Voltando para o menu...");
                    }
                } else {
                    System.out.println("Esse ouvinte nao existe.. Voltando para o menu...");
                }

            }
            case 2 -> {
                String conf;

                System.out.println("Tem a certeza? Confirme com 'Sim'.");
                conf = imp.nextLine().toLowerCase();

                if (conf.equals("sim")) {
                    chamadas.setListaOuvintes(new ArrayList<>());
                    System.out.println("\n**************************************************");
                    System.out.println("Lista apagada com sucesso!");
                    System.out.println("****************************************************\n");
                } else {
                    System.out.println("Voltando para o menu..");
                }

            }
            case 0 -> {
            }
        }


    }

    /**
     * Imprimir uma lista de ouvintes
     */
    private static void verOuv() {
        for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {
            System.out.println("\n==================================================");
            System.out.printf("%so  Ouvinte: \n%s", i + 1, chamadas.listaOuvintes.get(i));
        }
    }

    /**
     * Ordena e imprime a lista de ouvintes conforme o rank.
     */
    private static void verRank() {
        Collections.sort(chamadas.listaOuvintes, new VerificadorCustom());

        for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {

            System.out.println("===================================================");
            System.out.printf("%so Lugar \n", i + 1);
            System.out.println(chamadas.listaOuvintes.get(i));
            System.out.printf("Jogou: %s jogos               Ganhou: %s \n",
                    chamadas.listaOuvintes.get(i).getJogos(), chamadas.listaOuvintes.get(i).getGanhou());
            System.out.println("===================================================");

        }
    }

    /**
     * Inicia um jogo do saco!
     */
    private static void jogoSaco() {

        double saco = sorte.nextDouble(4.600, 4.750);

        Boolean anabela = true;

        double palpite;

        Collections.shuffle(chamadas.listaOuvintes);

        for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {

            System.out.println("A ligar....");
            System.out.println("Bom dia! Estou a falar com?");
            System.out.printf("%s.\n", chamadas.listaOuvintes.get(i).getNome());
            System.out.printf("Ora muito bom dia %s! E de onde???\n", chamadas.listaOuvintes.get(i).getNome());
            System.out.printf("De %s\n", chamadas.listaOuvintes.get(i).getLocalidade());
            System.out.println("""
                                        
                    Ora bem vamos la entao!
                    A nossa margem para hoje e entre 4.600 e 4.750 kg...
                    Quanto pesa o saco???
                    """);

////////////Anabela a jogar
            if (chamadas.listaOuvintes.get(i).equals(ouv1)) {
                while (anabela) {
                    System.out.println("Anabela: 2 quilos e 130!");
                    System.out.println("Locutor: Voce e terrivel...");
                    System.out.println("Locutor: Anabela... O saco pesa mais de 4 quilos e MEIO!");
                    System.out.println("Anabela: AH SFASDFLASJLDFJASLKDJFA");
                    System.out.println("Locutor: O que??");
                    System.out.println("Anabela: 3 quilos 120!");
                    System.out.println("Locutor: gosto tanto de a ouvir, Anabela...");
                    System.out.println("Locutor: O saco pesa mais de 4 quilos e meio, como e que pode ser 3, 120 Anabela??");
                    System.out.println("Locutor: Tem de ser mais de QUATRO E MEIO mulher!");
                    System.out.println("Anabela: 3 quilos e 10!");
                    System.out.println("Locutor: Entao isso e mais de 4 e meio??");
                    System.out.println("Anabela: Nao...");
                    System.out.println("Anabela: 3 quilos..");
                    System.out.println("Locutor: hahaha anabela! voce e um ponto..");
                    System.out.println("Locutor: Mais de 4 mais pa frente!");
                    System.out.println("Anabela: mais de 3 ou de 2 entao?");
                    System.out.println("Locutor: DIGA 4 QUILOS E 500!");
                }
            }

            palpite = sorte.nextDouble(4.600, 4.750);

            chamadas.listaOuvintes.get(i).setPalpite(palpite);

            System.out.printf("%s.\n\n", peso.format(palpite));
        }

        System.out.println("Vamos ver quem acertou ou chegou mais perto!");


        // inicializar vencedor de modo a primeira
        // que adivinhar o valor mais perto do peso do saco
        // (no caso de terem o mesmo palpite)
        // seja a vencedora.
        melhorPalp = chamadas.listaOuvintes.get(0).getPalpite();
        vencedor = chamadas.listaOuvintes.get(0);
        //

        for (int i = 0; i < chamadas.listaOuvintes.size(); i++) {
            double dist = Math.abs(saco - melhorPalp);
            chamadas.listaOuvintes.get(i).setJogos(chamadas.listaOuvintes.get(i).getJogos() + 1);

            if (melhorPalp == saco) {
                vencedor = chamadas.listaOuvintes.get(i);
                return;
            }

            if (Math.abs(saco - chamadas.listaOuvintes.get(i).getPalpite()) < dist) {
                melhorPalp = chamadas.listaOuvintes.get(i).getPalpite();
                vencedor = chamadas.listaOuvintes.get(i);
            }


        }

        vencedor.setGanhou(vencedor.getGanhou() + 1);
        System.out.println("PARABENS!");
        System.out.printf("O vencedor desta semana e: %s\n", vencedor.getNome());
        System.out.printf("O peso do saco era %s, e o palpite foi %s\n", peso.format(saco), peso.format(vencedor.getPalpite()));

    }


}



