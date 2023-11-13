import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Arvore {
    public No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public No buscar(No raiz, int conteudo) {
        if(raiz == null) {
            return raiz;
        }
        if(raiz.conteudo == conteudo) {
            return raiz;
        }
        else if(conteudo < raiz.conteudo) {
            return buscar(raiz.noEsquerda, conteudo);
        }
        return buscar(raiz.noDireita, conteudo);
    }

    public void inserir(int conteudo) {
        inserir(raiz, conteudo);
        atribuir_filhos();
        atribuir_altura();
    }

    public No inserir(No raiz, int conteudo) {
        if (raiz == null) {
            raiz = new No(conteudo);
            return raiz;
        }
        if (conteudo < raiz.conteudo) {
            raiz.noEsquerda = inserir(raiz.noEsquerda, conteudo);
        }
        else if(conteudo > raiz.conteudo) {
            raiz.noDireita = inserir(raiz.noDireita, conteudo);
        }
        return raiz;
    }

    public void atribuir_altura() {
        pos_ordem_altura(raiz);
    }

    public void pos_ordem_altura(No no) {
        if(no.noEsquerda != null)
            pos_ordem_altura(no.noEsquerda);
        if(no.noDireita != null) 
            pos_ordem_altura(no.noDireita);
        altera_altura(no);
    }

    public void altera_altura(No no) {
        int altura1;
        int altura2;
        if(no.noEsquerda == null)
            altura1 = 0;
        else
            altura1 = no.noEsquerda.altura;
        if(no.noDireita == null)
            altura2 = 0;
        else
            altura2 = no.noDireita.altura;
        if(altura1 > altura2)
            no.altura = altura1 + 1;
        else
            no.altura = altura2 + 1;
    }

    public void atribuir_filhos() {
        pos_ordem_filhos(raiz);
    }

    public void pos_ordem_filhos(No no) {
        if(no.noEsquerda != null)
            pos_ordem_filhos(no.noEsquerda);
        if(no.noDireita != null) 
            pos_ordem_filhos(no.noDireita);
        altera_filhos_esquerda(no);
        altera_filhos_direita(no);
    }

    public int altera_filhos_esquerda(No no) {
        if(no != null && no.noEsquerda != null && no.noDireita != null) {
            return 1 + altera_filhos_esquerda(no.noEsquerda) + altera_filhos_esquerda(no.noDireita);
        }
        return 0;



        // if(no == null || (no.noDireita == null && no.noEsquerda == null))
        //     return 0;
        // else 
        //     no.qtdNosEsquerda = 1 + altera_filhos_esquerda(no.noEsquerda) + altera_filhos_esquerda(no.noDireita);
        // return no.qtdNosEsquerda;
    }

    public void altera_filhos_direita(No no) {
    //     if(no != null) {
    //         no.qtdNosDireita = altera_filhos_direita(no.noEsquerda) + altera_filhos_direita(no.noDireita);
    //     }
    //     return no.qtdNosDireita;
    }
    
    public String pre_ordem() {
        String resultado = "";
        Stack<No> pilha = new Stack<>();
        pilha.add(this.raiz);
        No aux;

        while(!pilha.empty()) {
            aux = pilha.pop();

            if(aux == this.raiz) {
                resultado = resultado + aux.conteudo;
            }
            else
                resultado = resultado + " - " + aux.conteudo;

            if(aux.noDireita != null)
                pilha.add(aux.noDireita);
            if(aux.noEsquerda != null)
                pilha.add(aux.noEsquerda);
        }

        return resultado;
    }
    
    public int enesimoElemento(int n) {
        int posicao = 0;
        Queue<No> fila = new LinkedList<>();
        No aux;
        int resultado = 0;

        fila.add(raiz);

        while(!fila.isEmpty()) {
            aux = fila.poll();
            posicao++;

            if(posicao == n)
                resultado = aux.conteudo;

            if(aux.noEsquerda != null)
                fila.add(aux.noEsquerda);
            if(aux.noDireita != null)
                fila.add(aux.noDireita);
        }

        return resultado;
    }

    public double media(int x) {
        No aux = buscar(raiz, x);

        Queue<No> fila = new LinkedList<>();
        double quantidade = 8;
        double soma = 0;

        if(aux != null) {
            fila.add(aux);
        
            while(!fila.isEmpty()) {
                aux = fila.poll();
                soma += aux.conteudo;

                if(aux.noEsquerda != null)
                    fila.add(aux.noEsquerda);
                if(aux.noDireita != null)
                    fila.add(aux.noDireita);
            }
        }
        return soma/quantidade;
    }

    public int posicao(int x) {
        if(buscar(raiz, x) == null)
            return -1;

        Stack<No> pilha = new Stack<>();
        No aux = raiz;
        int posicao = 0;

        while(!pilha.isEmpty() || aux != null) {
            if(aux != null) {
                pilha.push(aux);
                aux = aux.noEsquerda;
            }
            else {
                aux = pilha.pop();
                posicao++;
                if(aux.conteudo == x)
                    break;
                aux = aux.noDireita;
            }
        }

        return posicao;
    }

    public void imprimeArvore(int s) {
        if(s == 1)
            imprime_hifen(raiz);
        else
            imprime_parenteses(raiz);
    }

    public void imprime_hifen(No no) {
            if (no == null) {
                return;
            }
    
            // Calcular o número de hifens com base no nível
            int numHifens = no.altura * 4;
            String linha = " ".repeat(numHifens) + no.conteudo + "-------------";
    
            // Imprimir a linha
            System.out.println(linha);
    
            // Chama recursivamente para os filhos esquerdo e direito
            imprime_hifen(no.noEsquerda);
            imprime_hifen(no.noDireita);
        }

    public void imprime_parenteses(No no) {
        if (no != null) {
            System.out.print("(" + no.conteudo);
            imprime_parenteses(no.noEsquerda);
            imprime_parenteses(no.noDireita);
            System.out.print(")");
        }
    }

    public boolean ehCheia() {
        return raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1 == Math.pow(2, raiz.altura + 1) - 1;
    }

    public boolean ehCompleta() {
        return (Math.pow(2, raiz.altura - 1) <= raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1) && 
        (raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1 >= Math.pow(2, raiz.altura) - 1);
    }

    public No minimo_esquerda(No no) {
        while(no.noEsquerda != null) 
            no = no.noEsquerda;
        return no;
    }
    
    public No remover(No raiz, int conteudo) {
        if(raiz == null) {
            return raiz;
        }
        else if(conteudo < raiz.conteudo) {
            raiz.noEsquerda = remover(raiz.noEsquerda, conteudo);
        }
        else if(conteudo > raiz.conteudo) {
            raiz.noDireita = remover(raiz.noDireita, conteudo);
        }
        else {
            if(raiz.noEsquerda == null && raiz.noDireita == null) {
                raiz = null;
            }
            else if(raiz.noEsquerda == null) {
                raiz = raiz.noDireita;
            }
            else if(raiz.noDireita == null) {
                raiz = raiz.noEsquerda;
            }
            else {
                No temp = minimo_esquerda(raiz.noDireita);
                raiz.conteudo = temp.conteudo;
                raiz.noDireita = remover(raiz.noDireita, temp.conteudo);
            }
        }
        atribuir_altura();
        atribuir_filhos();
        return raiz;
    }
}
