package tobyspring.tobyhellospring.exrate;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import tobyspring.tobyhellospring.payment.ExRateProvider;

@Component
public class WebApiExRatePaymentProvider implements ExRateProvider {

  @Override
  public BigDecimal getExRate(String currency) throws IOException {
    URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String response = reader.lines().collect(Collectors.joining());
    reader.close();

    ObjectMapper mapper = new ObjectMapper();
    ExRateData data = mapper.readValue(response, ExRateData.class);
    BigDecimal exRate = data.rates().get("KRW");

    System.out.println("WebApiExRatePaymentProvider.getExRate : " + exRate);
    return exRate;
  }
}
