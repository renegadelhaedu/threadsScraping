package ThreadsRequestExample;

import java.util.ArrayList;

public class TestadorScraping {

    public static void main(String[] args) {

        ArrayList<String> listaUrls = new ArrayList<String>();
        listaUrls.add("https://www.globo.com");
        listaUrls.add("https://www.uol.com.br");
        listaUrls.add("https://www.poder360.com.br");

        String busca = "Flamengo";

        for(int i=0; i<listaUrls.size(); i++){
            new Garimpador(busca, listaUrls.get(i)).start();
        }

    }
}
