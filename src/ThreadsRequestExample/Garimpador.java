package ThreadsRequestExample;

public class Garimpador extends Thread{

    String url;
    String termo;

    public Garimpador( String termoBusca, String caminho){
        this.url = caminho;
        this.termo = termoBusca;
    }

    public void run(){

        WebScraper.procurar(this.termo, this.url);
    }
}
