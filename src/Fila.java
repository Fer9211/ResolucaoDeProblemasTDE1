public class Fila {
    No inicio;
    No fim;
    String id;

    public Fila(String id) {
        this.id = id;
        this.inicio = null;
        this.fim = null;
    }

    public String getId() {
        return this.id;
    }

    public void insere(int info) {
        No novo_no = new No(info, null);
        if (this.inicio == null) {
            this.inicio = novo_no;
        } else {
            this.fim.proximo = novo_no;
        }
        this.fim = novo_no;
    }

    public int remove() {
        No removido = this.inicio;
        if (inicio == null) {
            return -1;
        } else if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
        }
        return removido.informacao;
    }

    public String imprime() {
        No atual = this.inicio;
        StringBuilder retorno = new StringBuilder();
        retorno.append("Fila " + this.id + ": ");
        if (atual == null) {
            retorno.append("A lista está vazia.");
        } else {
            while (atual != null) {
                retorno.append("[" + atual.informacao + "] -> ");
                atual = atual.proximo;
            }
        }
        return retorno.toString();
    }
}