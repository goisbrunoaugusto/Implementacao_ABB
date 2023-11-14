import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import org.w3c.dom.views.AbstractView;

public class Main  {

    public static void main(String[] args) throws IOException {

        ArrayList<String> arvoreInicial = lerArquivo("C:\\Users\\Giovanna\\Desktop\\quarto-semestre\\EDB2\\implementacao_ABB\\src\\elementos");
        ArrayList<String> comandos = lerArquivo("src\\comandos");
        ArrayList<Integer> arvoreInteiros = new ArrayList<>();
        Arvore arvore = new Arvore(arvoreInteiros.get(1));
        
        for(String i : arvoreInicial){
            arvoreInteiros.add(Integer.parseInt(i));
        }
        for(String j : comandos) {
            String[] separado = j.split(" ");
            String comando = separado[0];
            String argumento = "";
            
            try {
                argumento = separado[1];
            } catch (Exception e) {}
            
            argumentoComando(comando, argumento, arvore);
            }

            return;
        }
        public static ArrayList<String> lerArquivo(String nome_do_arquivo) throws IOException{

        File file = new File(nome_do_arquivo);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        ArrayList<String> array_string = new ArrayList<>();
        
        while((linha = br.readLine()) != null){
            array_string.add(linha);
        }

        br.close();
        fr.close();

        return array_string;
        }

    	public static void argumentoComando(String comando, String argumento, Arvore arvore) {
        switch (comando) {
            case "INSIRA":
                arvore.inserir(Integer.parseInt(argumento));
                break;
            case "REMOVA":
                arvore.remover(arvore.raiz, Integer.parseInt(argumento));
                break;
            case "BUSCAR":
                arvore.buscar(Integer.parseInt(argumento));
                break;
            case "ENESIMO":
                System.out.println(arvore.enesimoElemento(Integer.parseInt(argumento)));
                break;
            case "POSICAO":
            	System.out.println(arvore.posicao(Integer.parseInt(argumento)));
                break;
            case "MEDIANA":
            	System.out.println(arvore.mediana());
                break;
            case "MEDIA":
            	System.out.println(arvore.media(Integer.parseInt(argumento)));
                break;
            case "CHEIA":
            	if(arvore.ehCheia()){}
                break;
            case "COMPLETA":
            	if(arvore.ehCompleta()){}
                break;
            case "PREORDEM":
            	System.out.println(arvore.pre_ordem());
                break;
            case "IMPRIMA":
                arvore.imprimeArvore(Integer.parseInt(argumento));
                break;
        
            default:
                break;
        }
    }
}
