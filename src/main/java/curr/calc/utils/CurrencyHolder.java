package curr.calc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.http.ResponseEntity;

/**
 * Created by Marina on 13.11.17.
 */
public class CurrencyHolder {
    public static double getBtcRub() {
        try {
            String url = "https://api.livecoin.net/exchange/ticker?currencyPair=BTC/RUR";
            String response = HttpRequestsSender.sendGetRequest(url, null, null).getBody();

            ObjectNode node = new ObjectMapper().readValue(response, ObjectNode.class);
            if (node.has("last")) {
                return node.get("last").asDouble();
            } else {
                throw new RuntimeException("Failed to obtain BTC/RUR course");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain BTC/RUR course");
        }
    }
}
