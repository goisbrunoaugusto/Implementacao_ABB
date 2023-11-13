public class No {
    public int conteudo;
    public int altura;
    public int qtdNosEsquerda;
    public int qtdNosDireita;
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

    public int getQtdNosDireita() {
        return qtdNosDireita;
    }

    public void setQtdNosDireita(int quantidade) {
        this.qtdNosDireita = quantidade;
    }

    public int getQtdNosEsquerda() {
        return this.qtdNosEsquerda;
    }

    public void setQtdNosEsquerda(int quantidade) {
        this.qtdNosEsquerda = quantidade;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public No(int conteudo) {
        this.conteudo = conteudo;
        this.noDireita = null;
        this.noEsquerda = null;
        this.altura = 1;
        this.qtdNosDireita = 0;
        this.qtdNosEsquerda = 0;
    }

    public No() {
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo = " + conteudo +
                '}';
    }
}
