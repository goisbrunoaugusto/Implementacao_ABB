public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public No adicionarNo(No raiz, int conteudo){
        if (raiz == null){
            raiz = new No(conteudo);
            return raiz;
        }
        if (conteudo < raiz.getConteudo()) {
            raiz.noEsquerda = adicionarNo(raiz.getNoEsquerda(), conteudo);
        }else if(conteudo > raiz.getConteudo()){
            raiz.noDireita = adicionarNo(raiz.getNoDireita(), conteudo);
        }else{
            System.out.println("Não é permitido valor duplicado");
            return raiz;
        }
        return raiz;
    }

    public No buscarNo (No raiz, int conteudo){
        if(raiz == null ){
            return raiz;
        }
        if(raiz.getConteudo() == conteudo){
            return raiz;
        }else if(conteudo < raiz.getConteudo()){
            return buscarNo(raiz.noEsquerda, conteudo);
        }
        return buscarNo(raiz.noDireita, conteudo);
    }

    public No removerNo(No raiz, int conteudo){
        if(raiz == null){
            return raiz;
        }else if(conteudo < raiz.getConteudo()){
            raiz.noEsquerda = removerNo(raiz.noEsquerda, conteudo);
        }else if(conteudo > raiz.getConteudo()){
            raiz.noDireita = removerNo(raiz.noDireita, conteudo);
        }else {
            if(raiz.noEsquerda == null && raiz.noDireita == null){
                raiz = null;
            }else if(raiz.noEsquerda == null){
                No temp = raiz;
                raiz = raiz.noDireita;
                temp = null;
            }else if(raiz.noDireita == null) {
                No temp = raiz;
                raiz = raiz.noEsquerda;
                temp = null;
            }else{
                //tem q implementar a funçao findMin pra achar o menor nó do lado direito ou o maior do lado esquerdo
                No temp = findMin(raiz.noDireita);
                raiz.setConteudo(temp.getConteudo());
                raiz.noDireita = removerNo(raiz.noDireita, temp.getConteudo());
            }

        }
        return raiz;
    }
}
