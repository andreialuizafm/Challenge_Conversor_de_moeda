import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Valor {
    public String base_code;
    public double conversion_rate;
    public String target_code;
    public double conversion_result;
    //public String currency_code;

    public Valor(String base_code,String target_code,double conversion_rate) throws IOException, InterruptedException {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }
    HttpClient client = HttpClient.newHttpClient(); // Requisição
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/codes"
            ))
            .build();
    HttpResponse<String> response = client //Resposta
            .send(request, HttpResponse.BodyHandlers.ofString()); //Resposta

    @Override
    public String toString() {
        return "Valor{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", target_code='" + target_code + '\'' +
                ", conversion_result=" + conversion_result +
                '}';
    }
}

/*[ARS,Peso argentino]

"BOB","Boliviano boliviano"

BRL - Real brasileiro

CLP - Peso chileno

COP - Peso colombiano

USD - Dólar americano*/
