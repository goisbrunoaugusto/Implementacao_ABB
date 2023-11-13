import org.w3c.dom.views.AbstractView;

public class Main {

    public static void main(String[] args) {
        No no = new No(10);
        Arvore arvore = new Arvore();
        arvore.raiz = no;
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(16);
        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(14);
        arvore.inserir(9);
        arvore.inserir(23);
        arvore.inserir(21);


        //System.out.println(arvore.pre_ordem());
        //System.out.println(arvore.raiz.altura);

        arvore.remover(arvore.raiz, 9);

        // if(arvore.ehCheia())
        System.out.println(arvore.pre_ordem());

        System.out.println(arvore.raiz.qtdNosEsquerda);
        return;
    }
}
