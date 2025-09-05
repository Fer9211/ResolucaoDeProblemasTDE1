package questao2;

public class Fila {
    static No inicio;
    static No fim;

    static void insere(int info) {
        No novo_no = new No(info, null);
        if (inicio == null) {
            inicio = novo_no;
        } else {
            fim.proximo = novo_no;
        }
        fim = novo_no;
    }

    static int remove() {
        No removido = inicio;
        if (inicio == null && fim == null) {
            return -1;
        } else if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
        }
        return removido.informacao;
    }

    static StringBuilder imprime() {
        No atual = inicio;
        StringBuilder retorno = new StringBuilder();
        if (atual == null) {
            retorno.append("A lista está vazia.");
        } else {
            while (atual != null) {
                retorno.append("[" + atual.informacao + "] -> ");
                atual = atual.proximo;
            }
        }
        return retorno;
    }
}