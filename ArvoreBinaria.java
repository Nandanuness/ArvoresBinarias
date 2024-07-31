public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) { // se não houver nenhum nó
            this.raiz = novoNo; // primeiro nó raiz
        } else { // já existe nó, percorre a árvore para encontrar a posição de inserção
            No atual = this.raiz; // começa do nó raiz
            No pai = null; // inicia pai como null
            boolean esquerda = false; // inicia esquerda como false
            while (atual != null) { // percorre até encontrar um nó vazio
                if (novoNo.getValor() < atual.getValor()) { // se novono é menor que atual, segue a esq
                    pai = atual;
                    atual = atual.getEsq(); // move para esquerda
                    esquerda = true;
                } else { // novo nó maior que atual, segue para a direita
                    pai = atual;
                    atual = atual.getDir(); // move para a direita
                    esquerda = false;
                }
            }
            if (esquerda) { // esquerda true
                pai.setEsq(novoNo); // add novo nó como filho esquerdo do pai
            } else { // esquerda false
                pai.setDir(novoNo); // add novo nó como filho direito do pai
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

     void remover(int valor) {
        raiz = remover(raiz, valor); // atualiza raiz, se removida ou não
    }

    private No remover(No no, int valor) { // recebe nó e valor a ser removido
        if (no == null) {
            return null;
        }

        if (valor < no.getValor()) { // se valor menor que o valor do nó atual, está a esquerda
            no.setEsq(remover(no.getEsq(), valor)); // chamada recursiva a esq, atual recebe filho a esq
        } else if (valor > no.getValor()) { // se valor maior que o valor do nó atual, está a direita
            no.setDir(remover(no.getDir(), valor)); // chamada recursiva a dir, atual recebe filho a dir
        } else { // se valor é igual ao nó atual (encontrou o nó a ser removido)
            if (no.getEsq() == null && no.getDir() == null) { // verifica se o nó tem filhos (folha)
                return null; // retorna o nó null, removendo-o
            }

            if (no.getEsq() == null) { //se o nó a ser removido tem apenas um filho direito
                return no.getDir(); // retorna o filho direito para substiruir o nó
            } else if (no.getDir() == null) { // se o nó a ser removido tem apenas um filho esquerdo
                return no.getEsq(); // retorna o filho esquerdo para substiruir o nó
            }

            No menorNo = encontrarMenorNo(no.getDir()); // encontra o nó de menor valor a direita do atual
            no.setValor(menorNo.getValor()); // altera o valor do atual pelo valor do sucessor encontrado
            no.setDir(remover(no.getDir(), menorNo.getValor())); // remove o nó que era sucessor
        }

        return no; // retorna o nó atual após a remoção, atualiza pai para o nó removido
    }

    private No encontrarMenorNo(No no) { // encontra menor nó apartir do nó fornecido (atual)
        while (no.getEsq() != null) { // enquanto tiver no esquerdo
            no = no.getEsq(); // move para o filho esqerdo
        }
        return no; // retorna o no mais a esquerda, que tem o menor valor
    }
}
