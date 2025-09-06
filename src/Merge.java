public class Merge {
            int[] filaMerge;
            int tamanho;
            Node pilhaMerge;
        public Merge () {
            this.filaMerge = null;
            this.pilhaMerge = null;
            this.tamanho = 0;
        }
        public void fazerMergeVetor(FilaVetor filaA, FilaVetor filaB) {

            int[] dadosA = filaA.getDados();
            int[] dadosB = filaB.getDados();
            int topoA = filaA.getTopo();
            int topoB = filaB.getTopo();

            tamanho = topoA + topoB;

            filaMerge = new int[topoA + topoB + 2];

            int contA = 0;
            int contB = 0;
            int contMerge = 0;

            while (contA <= topoA && contB <= topoB) {
                if (dadosA[contA] <= dadosB[contB]) {
                    filaMerge[contMerge++] = dadosA[contA++];
                } else {
                    filaMerge[contMerge++] = dadosB[contB++];
                }
            }
            while (contA <= topoA){
                filaMerge[contMerge] = dadosA[contA];
                contMerge++;
                contA++;
            }
            while (contB <= topoB){
                filaMerge[contMerge] = dadosB[contB];
                contMerge++;
                contB++;
            }
            this.tamanho = contMerge;
        }
        public void imprimirMerge(){
            for (int i = 0; i < this.tamanho; i++) {
                System.out.print(this.filaMerge[i] + " ");
            }
        }
    }
