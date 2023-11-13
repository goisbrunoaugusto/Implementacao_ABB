import org.w3c.dom.views.AbstractView;

public class Main {

    public static void main(String[] args) {
        No no = new No(10);
        Arvore arvore = new Arvore();
        arvore.raiz = no;
        arvore.inserir(arvore.raiz, 5);
        arvore.inserir(arvore.raiz, 15);
        arvore.inserir(arvore.raiz, 16);
        arvore.inserir(arvore.raiz, 7);
        arvore.inserir(arvore.raiz, 3);
        arvore.inserir(arvore.raiz, 14);
        arvore.inserir(arvore.raiz, 9);
        arvore.inserir(arvore.raiz, 9);

        System.out.println(arvore.pre_ordem());

        return;
    }
}
