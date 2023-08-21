import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = { "alex", "joao", " roberto", "luana" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    public static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean tentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            tentando = !atendeu;
            if (tentando) {
                tentativas++;
            } else {
                System.out.println("CANDIDATO CONTATADO COM SUCESSO");
            }
        } while (tentando && tentativas < 3);
        if (atendeu) {
            System.out.println("conseguimos contato o candidato" + candidato);
        } else {
            System.out.println("nao coseguimos contatar" + candidato);
        }
    }

    public static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static void imprimirSelecionados() {
        String[] candidatos = { "alex", "joao", " roberto", "luana" };
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("candidato numero " + (i + 1) + " é " + candidatos[i]);
        }
        for (String candidato : candidatos) {
            System.out.println("candidato selecionado foi " + candidato);

        }

    }

    public static void selecaoDeCandidatos() {
        String[] candidatos = { "alex", "joao", " roberto", "luana", "julio", "levi", "andre" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPrentendido();
            System.out.println("candidato: " + candidato + " solicitou este valor" + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("candidato: " + candidato + " selecionado pra vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }

    }

    public static String analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        if (salarioBase == salarioPretendido) {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
        return "AGUARDANDO O RESULTADO DEMAIS CANDIDATOS";
    }

    public static double valorPrentendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }
}
