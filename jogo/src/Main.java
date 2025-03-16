import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao Jogo da Descoberta!");

        String[] palavras = {"computador", "mouse", "monitor", "mousepad", "teclado", "impressora",
                "programação", "engenharia", "desenvolvedor", "software", "hardware",
                "inteligência", "dados", "rede", "memória"};

        boolean jogarNovamente = true;

        while (jogarNovamente) {
            String palavraSelecionada = palavras[random.nextInt(palavras.length)];
            String palavraEmbaralhada = embaralhar(palavraSelecionada);

            System.out.println("\nQual é a palavra: " + palavraEmbaralhada + "?");
            int tentativas = 0;
            boolean acertou = false;

            while (!acertou) {
                System.out.println("Informe a palavra, 'dica' para receber uma dica ou '0' para desistir:");
                String entrada = scanner.nextLine().trim();

                if (entrada.equals("0")) {
                    System.out.println("Você desistiu após " + tentativas + " tentativas.");
                    break;
                }

                if (entrada.equalsIgnoreCase("dica")) {
                    System.out.println("Dica: A primeira letra é '" + palavraSelecionada.charAt(0) +
                            "' e a última é '" + palavraSelecionada.charAt(palavraSelecionada.length() - 1) + "'.");
                    continue;
                }

                tentativas++;

                if (entrada.equalsIgnoreCase(palavraSelecionada)) {
                    System.out.println("Parabéns! Você acertou com " + tentativas + " tentativas.");
                    acertou = true;
                } else {
                    System.out.println("Errado! Tente novamente.");
                }
            }

            System.out.println("\nDeseja jogar novamente? (s/n)");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (!resposta.equals("s")) {
                jogarNovamente = false;
            }
        }

        System.out.println("Obrigado por jogar! Até a próxima.");
        scanner.close();
    }

    private static String embaralhar(String palavra) {
        char[] palavraArray = palavra.toCharArray();
        Random random = new Random();

        for (int i = 0; i < palavraArray.length; i++) {
            int indiceAleatorio = random.nextInt(palavraArray.length);
            char temp = palavraArray[i];
            palavraArray[i] = palavraArray[indiceAleatorio];
            palavraArray[indiceAleatorio] = temp;
        }

        return new String(palavraArray);
    }
}
