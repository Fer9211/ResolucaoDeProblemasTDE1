import java.util.Scanner;

public class PilhaLista {
    private Node Lista;
    public PilhaLista() {
        this.Lista = null;
    }

    //Inserir elementos
    public void inserir(int informacao) {
        Node novo = new Node();

        novo.setInformacao(informacao);

        if(Lista == null) {
            Lista = novo;
        }
        else {
            novo.setProximo(Lista);
            Lista = novo;
        }
    }

    public void imprimir(){
        Node atual = Lista;
        while(atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }

    public void remover() {
        if (Lista == null) { // pilha vazia
            System.out.println("Pilha vazia!");
        }
        else {
            Lista = Lista.getProximo();
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaLista lista = new PilhaLista();
        System.out.println("Digite os itens da lista (digite '0' para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) {
                break;
            }
            lista.inserir(item);
        }
        System.out.println("Lista Encadeada:");
        lista.imprimir();

        lista.remover();

        lista.imprimir();
    }
}

