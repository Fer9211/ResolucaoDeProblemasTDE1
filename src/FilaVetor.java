package questao3;
import Node.Node;
import java.util.Scanner;

public class FilaVetor {
    private int[] dados;
    private int frente;
    private int topo;
    private int capacidade;

    public FilaVetor(int capacidade) {
        this.dados = new int[capacidade];
        this.capacidade = capacidade;
        this.frente = 0;
        this.topo = -1;
    }
    public void insere(int valor){
        if(cheia()){
            System.out.println("questao2.Fila cheia");
        }
        else{
            topo++;
            dados[topo] = valor;
        }
    }
    public void remover() {
        if (vazio()) {
            System.out.println("questao2.Fila vazia");
        } else {
            System.out.println("Dado removido: " + dados[frente]);
            frente++; // avança para o próximo elemento
            if (frente > topo) { // fila ficou vazia
                frente = 0;
                topo = -1;
            }
        }
    }

    public void imprimir(){
        if(vazio()){
            System.out.println("questao2.Fila vazia");
        }
        else{
            for (int i = frente; i <= topo; i++) {
                System.out.print(dados[i] + " ");
            }
            System.out.println();
        }
    }
    public boolean vazio(){
        if(topo == -1){
            return true;
        }
        return false;
    }
    public boolean cheia() {
        return topo == capacidade - 1;
    }
    public int getTopo(){
        return topo;
    }
    public int[] getDados(){
        return dados;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaVetor filaA = new FilaVetor(10);
        System.out.println("Digite os itens da fila A (digite '0' para parar):");
        int itemA;
        while (!filaA.cheia()) {
            itemA = scanner.nextInt();
            if (itemA == 0) {
                break;
            }
            filaA.insere(itemA);
        }
        System.out.println("questao2.Fila A:");
        filaA.imprimir();

        FilaVetor filaB = new FilaVetor(10);
        System.out.println("Digite os itens da fila B (digite '0' para parar):");
        int itemB;
        while (!filaB.cheia()) {
            itemB = scanner.nextInt();
            if (itemB == 0) {
                break;
            }
            filaB.insere(itemB);
        }
        System.out.println("questao2.Fila B:");
        filaB.imprimir();

        Merge merge = new Merge();

        merge.fazerMergeVetor(filaA, filaB);

        System.out.println("questao2.Fila depois do merge: ");
        merge.imprimirMerge();
    }

}

