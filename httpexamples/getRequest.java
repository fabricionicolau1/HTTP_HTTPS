package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class getRequest {

//    public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    public static final String URL_GET = "http://httpbin.org/get";

    public static void main(String[] args) throws IOException, InterruptedException {
        // cliente HTTP
        HttpClient Client = HttpClient.newHttpClient();
        // criar a requisicao
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();
        // enviando uma solicitacao
        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());
        //  imprimir o conteudo recebido
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
