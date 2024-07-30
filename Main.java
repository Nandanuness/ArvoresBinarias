import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) { // Ajuste o loop para 6 opções
            System.out.println("\nMenu:");
            System.out.println("1. Inserir valor");
            System.out.println("2. Remover valor");
            System.out.println("3. Exibir árvore em ordem");
            System.out.println("4. Exibir árvore em pré-ordem");
            System.out.println("5. Exibir árvore em pós-ordem");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.remover(valorRemover);
                    break;

                case 3:
                    System.out.println("Árvore em ordem:");
                    arvore.emOrdem(arvore.getRaiz());
                    break;

                case 4:
                    System.out.println("Árvore em pré-ordem:");
                    arvore.preOrdem(arvore.getRaiz());
                    break;

                case 5:
                    System.out.println("Árvore em pós-ordem:");
                    arvore.posOrdem(arvore.getRaiz());
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
