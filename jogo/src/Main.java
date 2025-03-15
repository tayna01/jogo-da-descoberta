import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Jogo da Descoberta!");
        Scanner scanner = new Scanner(System.in);

        String palavras[] = {"computador"," mouse", "monitor"};
        Random random = new Random();
        String palavraSelecionada = palavras[random.nextInt(palavras.length)];

        String palavraEmbaralhada = embaralhar(palavraSelecionada);

        System.out.println("Qual a palavra " + palavraEmbaralhada + "?");
        int tentativas = 0;
        Boolean acertou = false;
        //Fazer um while scanner paraler a entrada do usuário

        while(!acertou){
            System.out.println("Informe a palavra, 'dica' para receber uma dica ou '0' para desistir");

            String entrada = scanner.nextLine();

            if(entrada.equals("0")){
                System.out.println("Você é fraco, desistiu com " + tentativas + " tentativas.");
                break;
            }

            if (entrada.equals("dica")) {
                System.out.println("A primeira letra é '" + palavraSelecionada.charAt(0) + "' e a última é '" + palavraSelecionada.charAt(palavraSelecionada.length() - 1) + "' .");
                continue;  // Corrigido para continuar o loop após mostrar a dica
            }

            if(entrada.equals(palavraSelecionada)){
                tentativas++;
                System.out.println("Você acertou com " + tentativas + " tentativas");
            }
            else{
                tentativas++;
            }
        }
    }

    private static String embaralhar(String palavra){
        char[] palavraArray =  palavra.toCharArray();
        Random random = new Random();
        for(int x=0; x < palavraArray.length; x++) {
            int indiceAleatorio = random.nextInt(palavraArray.length - 1);

            char temp = palavraArray[x];
            palavraArray[x] = palavraArray[indiceAleatorio];
            palavraArray[indiceAleatorio] = temp;
        }

        return new String(palavraArray);
    }
}