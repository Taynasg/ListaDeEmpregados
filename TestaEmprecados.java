import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TestaEmprecados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RepositorioDeDados repositorioDeDados = new RepositorioDeDados();
        TestaEmprecados testaEmprecados = new TestaEmprecados();

        System.out.println("===========================================");
        System.out.println("         LISTA DE EMPREGADOS            ");
        System.out.println("===========================================");

        System.out.println("Preencha os dados solicitados");

        System.out.println();


        for (int i = 1; i < 4; i++) {
            Empregado empregado = new Empregado();
            System.out.println("Dados do(a) " + i + " empregado(a)");
            System.out.println();
            testaEmprecados.cadastrarNovosEmpregados(empregado, scanner, repositorioDeDados);
        }

        Collections.sort(repositorioDeDados.mostrarlistaDeEmpregados(), Comparator.comparing(Empregado::getSalario).reversed());
        System.out.println(repositorioDeDados.mostrarlistaDeEmpregados());


        int opcao;
        do {

            System.out.println("Você gostaria de remover um(a) empregado(a) da lista?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    testaEmprecados.excluirEmpregado(repositorioDeDados, scanner);
                    System.out.println(repositorioDeDados.mostrarlistaDeEmpregados());
                    break;

                case 2:
                    System.out.println("Processo encerrado com sucesso!");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor tente novamente!");

            }

        } while (opcao <= 0 || opcao > 2);
    }

    private void cadastrarNovosEmpregados(Empregado empregado, Scanner scanner, RepositorioDeDados repositorioDeDados) {

        System.out.println("Qual o nome do empregado(a)? ");
        String nomeDoEmpregado = scanner.nextLine();

        System.out.println("Qual o CPF do empregado(a)? ");
        String cpfDoEmpregado = scanner.next();

        System.out.println("Qual o salario do empregado(a)? ");
        double salarioDoEmpregado = scanner.nextDouble();

        scanner.nextLine();
        empregado.setNome(nomeDoEmpregado);
        empregado.setCpf(cpfDoEmpregado);
        empregado.setSalario(salarioDoEmpregado);

        repositorioDeDados.cadastrarNovosEmpregados(empregado);
    }

    public void excluirEmpregado(RepositorioDeDados repositorioDeDados, Scanner scanner) {

        System.out.println("Digite o CPF do empregado(a) que deseja ");
        String cpfDoEmpregado = scanner.next();
        boolean excluiuEmpregado = repositorioDeDados.excluirEmpregado(cpfDoEmpregado);
        if (excluiuEmpregado) {
            System.out.println("Funcionário excluido com sucesso!");
        } else {
            System.out.println("CPF não encontrado!");
        }
    }
}
