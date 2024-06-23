import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---------------------Opções para conversão de valores:--------------------------------");
        HashMap<String, String> moeda = new HashMap<String, String>();
        moeda.put("ARS", "Peso argentino");
        moeda.put("BOB", "Boliviano boliviano");
        moeda.put("BRL", "Real brasileiro");
        moeda.put("CLP", "Peso chileno");
        moeda.put("USD", "Dolar americano");
        moeda.put("COP", "Peso colombiano");
        for (Map.Entry<String, String> entry : moeda.entrySet()) {
            System.out.println("País = " + entry.getKey() + ", moeda = " + entry.getValue());
        }
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o código do país da moeda original: ");
        var base_code = leitura.nextLine();
        System.out.println("Digite o código do país da moeda que deseja converter: ");
        var target_code = leitura.nextLine();
        System.out.println("Digite o valor para converter: ");
        var valor_converter = leitura.nextDouble();

            //https://v6.exchangerate-api.com/v6/311632e858483c296792fb00/latest/USD
            String endereco = "https://v6.exchangerate-api.com/v6/" + "311632e858483c296792fb00/pair/" + base_code + "/" + target_code + "/" + valor_converter;
            HttpClient client = HttpClient.newHttpClient(); // Requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client //Resposta
                    .send(request, HttpResponse.BodyHandlers.ofString()); //Resposta
            //System.out.println(response.body()); // Exibir a resposta */
            Gson gson = new Gson();
            String json = response.body();
            //System.out.println(json);
            Valor valor = gson.fromJson(json, Valor.class);
            //System.out.println(valor);
            System.out.println("Valor convertido de " + valor.base_code + " " + "para " + valor.target_code + " " + valor.conversion_result);
        }
    }


