package ThreadsRequestExample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {

    public static void procurar(String termo, String pagina) {
        String url = pagina;

        String termoProcurado = termo;

        try {
            Document documento = Jsoup.connect(url).get();

            Elements elementos = documento.getElementsContainingOwnText(termoProcurado);

            if (elementos != null && !elementos.isEmpty()) {
                System.out.println("Termo encontrado na página: " + pagina);

                for (Element elemento : elementos) {
                    System.out.println(elemento.text());
                }
                System.out.println("-------------------------------");
            } else {
                System.out.println("Termo não encontrado na página.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pegarLinks(String url){

        try {
            Document document = Jsoup.connect(url).get();

            Elements links = document.select("a[href]");

            for (Element link : links) {
                String linkHref = link.attr("href");
                System.out.println("Link: " + linkHref);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebScraper.pegarLinks("https://www.globo.com");
    }

}
