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
    public Arvore(int conteudo) {
        No no = new No(conteudo);
        this.raiz = no;
    }

    public boolean buscar(int conteudo) {
        if(buscar(raiz, conteudo) != null) {
            System.out.println("Chave encontrada!");
            return true;
        }
        System.out.println("Chave não encontrada!");
        return false;

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
        if(this.raiz == null) {
            No aux = new No(conteudo);
            this.raiz = aux;
            System.out.println(conteudo + " adicionado!");
            return raiz;
        }
        if (raiz == null) {
            No aux = new No(conteudo);
            raiz = aux;
            System.out.println(conteudo + " adicionado!");
            return raiz;
        }
        if (conteudo < raiz.conteudo) {
            raiz.noEsquerda = inserir(raiz.noEsquerda, conteudo);
        }
        else if(conteudo > raiz.conteudo) {
            raiz.noDireita = inserir(raiz.noDireita, conteudo);
        }
        else {
            System.out.println(conteudo + " já está na árvore, não pode ser inserido!");
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
        no.qtdNosEsquerda = conta_filhos_esquerda(no);
        no.qtdNosDireita = conta_filhos_direita(no);
    }
    
    public int conta_filhos_esquerda(No no) {
        if(no == null || no.noEsquerda == null)
            return 0;

        int filhos = 0;
        No aux;
        Stack<No> pilha = new Stack<>();
        pilha.add(no.noEsquerda);

        while(!pilha.empty()) {
            aux = pilha.pop();
            filhos++;
            
            if(aux.noEsquerda != null)
                pilha.add(aux.noEsquerda);
            if(aux.noDireita != null)
                pilha.add(aux.noDireita);
        }

        return filhos;
    }

    public int conta_filhos_direita(No no) {
        if(no == null || no.noDireita == null)
            return 0;

        int filhos = 0;
        No aux;
        Stack<No> pilha = new Stack<>();
        pilha.add(no.noDireita);

        while(!pilha.empty()) {
            aux = pilha.pop();
            filhos++;
            
            if(aux.noEsquerda != null)
                pilha.add(aux.noEsquerda);
            if(aux.noDireita != null)
                pilha.add(aux.noDireita);
        }

        return filhos;
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
    
    public double media(int x) {
        No aux = buscar(raiz, x);

        Queue<No> fila = new LinkedList<>();
        double quantidade = aux.qtdNosDireita + aux.qtdNosEsquerda + 1;
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
            imprime_hifen(raiz, 1);
        else
            imprime_parenteses(raiz, true);
    }

    public void imprime_hifen(No no, int nivel) {
        if (no != null) {
            for(int i = 0; i < nivel - 1; i++) {
                System.out.print("     ");
            }
            
            System.out.print(no.conteudo);
            for(int j=0; j < 11 - nivel; j++) {
                System.out.print("-----");
            }
            System.out.println("");
            imprime_hifen(no.noEsquerda, nivel + 1);
            imprime_hifen(no.noDireita, nivel + 1);
        }
    }

    public void imprime_parenteses(No no, boolean flag) {
        if (no != null) {
            System.out.print("(" + no.conteudo);
            imprime_parenteses(no.noEsquerda, false);
            imprime_parenteses(no.noDireita, false);
            if(flag)
                System.out.println(")");
            else
                System.out.print(")");
        }
    }

    public boolean ehCheia() {
        if(raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1 == Math.pow(2, raiz.altura) - 1) {
            System.out.println("A árvore é cheia!");
            return true;
        }
        System.out.println("A árvore não é cheia!");
        return false;
    }

    public boolean ehCompleta() {
        if(((Math.pow(2, raiz.altura - 1)) <= (raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1)) 
        && ((raiz.qtdNosDireita + raiz.qtdNosEsquerda + 1) <= (Math.pow(2, raiz.altura) - 1))) {
            System.out.println("A árvore é completa!");
            return true;
        }
        System.out.println("A árvore não é completa!");
        return false;
    }

    public No minimo_esquerda(No no) {
        while(no.noEsquerda != null) 
            no = no.noEsquerda;
        return no;
    }
    
    public No remover(No raiz, int conteudo) {
        if(raiz == null) {
            System.out.println(conteudo + " não está na árvore, não pode ser removido!");
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
                System.out.println(conteudo + " removido!");
            }
        }
        atribuir_altura();
        atribuir_filhos();
        return raiz;
    }

    public int mediana() {
        if(raiz == null) {
            System.out.println("Árvore vazia!");
            return -1;
        }
        int total_nos = 1 + raiz.qtdNosDireita + raiz.qtdNosEsquerda;
        int pos_mediana = total_nos/2 + 1;
        int aux = total_nos/2;
        if(total_nos % 2 == 1)
            return enesimoElemento(pos_mediana);
        if(enesimoElemento(pos_mediana) > enesimoElemento(aux))
            pos_mediana = aux;
        return enesimoElemento(pos_mediana);
    }

    public int enesimoElemento(int n) {
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
                if(posicao == n)
                    break;
                aux = aux.noDireita;
            }
        }
        return aux.conteudo;
    }
}
