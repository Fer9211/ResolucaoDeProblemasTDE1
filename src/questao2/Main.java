package questao2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
        System.out.println("=== LISTA DE NÓS ===");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Imprimir lista.");
        System.out.println("2. Inserir novo nó com informação.");
        System.out.println("3. Remover nó da lista (FIFO).");
        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
            if (opcao == 1) {
                StringBuilder output = Fila.imprime();
                System.out.println(output);
            } else if (opcao == 2) {
                System.out.println("Digite a informação (int):");
                int info = input.nextInt();
                Fila.insere(info);
                System.out.println("Novo nó adicionado.");
                Fila.imprime();
            } else if (opcao == 3) {
                int no_removido = Fila.remove();
                System.out.println("Nó removido: " + no_removido);
            }
        }
    }
}