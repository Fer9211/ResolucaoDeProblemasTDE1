import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, Fila> gerenciadorDeFilas = new HashMap<>();
    public static void main(String[] args) {
        Fila nova_fila_1 = new Fila("1");
        Fila nova_fila_2 = new Fila("2");
        gerenciadorDeFilas.put(nova_fila_1.getId(), nova_fila_1);
        gerenciadorDeFilas.put(nova_fila_2.getId(), nova_fila_2);
        nova_fila_1.insere(1);
        nova_fila_1.insere(3);
        nova_fila_1.insere(5);
        nova_fila_1.insere(7);
        nova_fila_2.insere(2);
        nova_fila_2.insere(4);
        nova_fila_2.insere(6);
        nova_fila_2.insere(8);
        nova_fila_2.insere(9);

        while (true) {
        System.out.println("=== LISTA DE NÓS ===");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Criar uma lista.");
        System.out.println("2. Imprimir lista.");
        System.out.println("3. Inserir novo nó com informação.");
        System.out.println("4. Remover nó da lista (FIFO).");
            System.out.println("5. Fazer merge de duas listas");
        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
            if (opcao == 1) {
                System.out.println("Digite o id único da sua nova fila:");
                input.nextLine();
                String id_da_fila_nova = input.nextLine();

                Fila nova_fila = new Fila(id_da_fila_nova);
                gerenciadorDeFilas.put(nova_fila.getId(), nova_fila);
                System.out.println("Fila '" + id_da_fila_nova + "' criada com sucesso!");
            } else if (opcao == 2) {
                // Passo 1: Perguntar o ID
                System.out.println("Digite o id da fila para imprimir:");
                input.nextLine(); // <-- Limpador do Scanner
                String id_para_imprimir = input.nextLine();

                // Passo 2: Buscar a Fila no Mapa
                Fila filaParaImprimir = gerenciadorDeFilas.get(id_para_imprimir);

                // É ESSENCIAL verificar se a fila foi encontrada!
                if (filaParaImprimir != null) {
                    // Passo 3: Chamar o método NO OBJETO ENCONTRADO
                    System.out.println(filaParaImprimir.imprime());
                } else {
                    System.out.println("ERRO: Fila com ID '" + id_para_imprimir + "' não encontrada.");
                }
            } else if (opcao == 3) {
                // Passo 1: Perguntar o ID
                System.out.println("Digite o id da fila onde quer inserir:");
                input.nextLine(); // <-- Limpador do Scanner
                String id_para_inserir = input.nextLine();

                // Passo 2: Buscar a Fila no Mapa
                Fila filaParaInserir = gerenciadorDeFilas.get(id_para_inserir);

                if (filaParaInserir != null) {
                    System.out.println("Digite a informação (int):");
                    int info = input.nextInt();

                    // Passo 3: Chamar o método NO OBJETO ENCONTRADO
                    filaParaInserir.insere(info);

                    System.out.println("Novo nó adicionado na fila '" + id_para_inserir + "'.");
                    System.out.println(filaParaInserir.imprime()); // Imprime a fila modificada
                } else {
                    System.out.println("ERRO: Fila com ID '" + id_para_inserir + "' não encontrada.");
                }
            } else if (opcao == 4) {
                // Passo 1: Perguntar o ID
                System.out.println("Digite o id da fila de onde quer remover:");
                input.nextLine(); // <-- Limpador do Scanner
                String id_para_remover = input.nextLine();

                // Passo 2: Buscar a Fila no Mapa
                Fila filaParaRemover = gerenciadorDeFilas.get(id_para_remover);

                if (filaParaRemover != null) {
                    // Passo 3: Chamar o método NO OBJETO ENCONTRADO
                    int no_removido = filaParaRemover.remove();

                    if (no_removido != -1) {
                        System.out.println("Nó removido da fila '" + id_para_remover + "': " + no_removido);
                        System.out.println("Estado atual: " + filaParaRemover.imprime());
                    } else {
                        System.out.println("A fila '" + id_para_remover + "' já está vazia.");
                    }
                } else {
                    System.out.println("ERRO: Fila com ID '" + id_para_remover + "' não encontrada.");
                }
            } else if (opcao == 5) {
//                Passo1 > perguntat qual o id da primeira lista do merge
                System.out.println("Digite o ID da primeira lista para merge");
                input.nextLine();
                String id_primeira_lista_para_merge = input.nextLine();
                Fila primeira_fila_do_merge = gerenciadorDeFilas.get(id_primeira_lista_para_merge);
                System.out.println("Digite o ID da segunda lista para merge");
                String id_segunda_lista_para_merge = input.nextLine();
                Fila segunda_fila_do_merge = gerenciadorDeFilas.get(id_segunda_lista_para_merge);
                System.out.println("Filas escolhidas:");
                System.out.println("Primeira fila:");
                System.out.println(primeira_fila_do_merge.imprime());
                System.out.println("Segunda fila:");
                System.out.println(segunda_fila_do_merge.imprime());
                System.out.println("Realizando merge nas listas...");
                mergeOrdenado(primeira_fila_do_merge, segunda_fila_do_merge);
                System.out.println(segunda_fila_do_merge.imprime());

            }
        }
    }
    public static void mergeOrdenado(Fila fila1, Fila fila2) {
        if (fila1 == null && fila2 == null) return;
        if (fila1 == null) return;
        if (fila2 == null) return;

        No p1 = fila1.inicio;
        No p2 = fila2.inicio;

        No dummy = new No(0, null);
        No atual = dummy;

        while (p1 != null && p2 != null) {
            if (p1.informacao <= p2.informacao) {
                atual.proximo = p1;
                p1 = p1.proximo;
            } else {
                atual.proximo = p2;
                p2 = p2.proximo;
            }
            atual = atual.proximo;
        }

        if (p1 != null) {
            atual.proximo = p1;
        } else if (p2 != null) {
            atual.proximo = p2;
        }

        fila2.inicio = dummy.proximo;
        fila1.inicio = null;
    }



}