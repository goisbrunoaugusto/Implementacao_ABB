public class No {
    private int conteudo;
    public No noEsquerda;
    public No noDireita;

    public int getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getNoEsquerda() {
        return this.noEsquerda;
    }

    public void setNoEsquerda(No noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public No getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(No noDireita) {
        this.noDireita = noDireita;
    }

    public No(int conteudo) {
        this.conteudo = conteudo;
        this.noDireita = null;
        this.noEsquerda = null;
    }

    public No() {
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo= " + conteudo +
                '}';
    }
}
