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

    }

    public void atribuir_filhos() {

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
            imprime_hifen(raiz, 0);
        else
            imprime_parenteses(raiz);
    }

    private void imprime_hifen(No no, int nivel) {
            if (no == null) {
                return;
            }
    
            // Calcular o número de hifens com base no nível
            int numHifens = nivel * 4;
            String linha = " ".repeat(numHifens) + no.conteudo + "-------------";
    
            // Imprimir a linha
            System.out.println(linha);
    
            // Chama recursivamente para os filhos esquerdo e direito
            imprime_hifen(no.noEsquerda, nivel + 1);
            imprime_hifen(no.noDireita, nivel + 1);
        }
    

    private void imprime_parenteses(No no) {
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

    /* 
    public No removerNo(No raiz, int conteudo) {
        if(raiz == null) {
            return raiz;
        }
        else if(conteudo < raiz.getConteudo()) {
            raiz.noEsquerda = removerNo(raiz.noEsquerda, conteudo);
        }
        else if(conteudo > raiz.getConteudo()) {
            raiz.noDireita = removerNo(raiz.noDireita, conteudo);
        }
        else {
            if(raiz.noEsquerda == null && raiz.noDireita == null) {
                raiz = null;
            }
            else if(raiz.noEsquerda == null) {
                No temp = raiz;
                raiz = raiz.noDireita;
                temp = null;
            }
            else if(raiz.noDireita == null) {
                No temp = raiz;
                raiz = raiz.noEsquerda;
                temp = null;
            }
            else {
                //tem q implementar a funçao findMin pra achar o menor nó do lado direito ou o maior do lado esquerdo
                No temp = findMin(raiz.noDireita);
                raiz.setConteudo(temp.getConteudo());
                raiz.noDireita = removerNo(raiz.noDireita, temp.getConteudo());
            }

        }
        return raiz;
    }
*/
}
