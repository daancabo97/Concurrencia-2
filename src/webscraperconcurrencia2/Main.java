package webscraperconcurrencia2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //Download webs
        List<String> links = new ArrayList<>();
        links.add("https://campus.open-bootcamp.com/login");
        links.add("https://www.deepl.com/en/translator");
        links.add("https://mylearn.oracle.com/ou/component/-/108432/166286");
        links.add("https://www.coursera.org/learn/introduccion-java/supplement/qapEG/bienvenida-al-curso");
        links.add("https://www.discoduroderoer.es/trabajo-eventos/");
        links.add("https://www.discoduroderoer.es/category/ejercicio/");
        links.add("https://jobs.periferiaitgroup.com/connect");

        for (String link : links) {
            String result = getWebContent(link);
            System.out.println(result);
        }
    }

    private static String getWebContent(String link) {
        System.out.println("INIT");
        System.out.println(link);
        try {

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();

            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
            System.out.println("END");

            // -->
            
            List<String> array = new ArrayList<>();
            array.add("<html>");
            array.add("<head>");
            array.add("<title> openbootcamp </title>");
            array.stream().forEach(line -> System.out.println(line));

            // -->
            return lines.collect(Collectors.joining());
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";

    }


}

/* Las clases de BufferedReader y InputStreamReader permiten leer archivos, procesar flujos de informacion
   que se van descargando */
