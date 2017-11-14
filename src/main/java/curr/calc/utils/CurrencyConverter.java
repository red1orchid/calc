package curr.calc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Collections;

/**
 * Created by Marina on 13.11.17.
 */
public class CurrencyConverter {
    public static double convertBtcUsd(double btc) {
        double btcBcc = getBccBtc();
        double bccUsd = getBccUsd();

        return (btc/btcBcc)*bccUsd;
    }

    public static double convertRubUsd(double rub) {
        double btcRub = getBtcRub();

        return convertBtcUsd(rub/btcRub);
    }

    public static double convertUsdBtc(double usd) {
        double btcBcc = getBccBtc();
        double bccUsd = getBccUsd();

        return (usd/bccUsd)*btcBcc;
    }

    public static double convertUsdRub(double usd) {
        double btcRub = getBtcRub();

        return convertUsdBtc(usd)*btcRub;
    }

    private static double getBtcRub() {
        try {
            String url = "https://api.livecoin.net/exchange/ticker";
            String response = HttpRequestsSender.sendGetRequest(url, Collections.singletonMap("currencyPair", "BTC/RUR"), null).getBody();

            ObjectNode node = new ObjectMapper().readValue(response, ObjectNode.class);
            return node.get("last").asDouble();
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain BTC/RUR course");
        }
    }

    private static double getBccBtc() {
        try {
            String url = "https://bitconnect.co/api/info/BTC_BCC";
            String response = HttpRequestsSender.sendGetRequest(url, null, null).getBody();

            ObjectNode node = new ObjectMapper().readValue(response, ObjectNode.class);
            return node.get("markets").get(0).get("last_price").asDouble();
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain BCC/BTC course");
        }
    }

    private static double getBccUsd() {
        try {
            String url = "https://api.coinmarketcap.com/v1/ticker/bitconnect";
            String response = HttpRequestsSender.sendGetRequest(url, Collections.singletonMap("convert", "USD"), null).getBody();

            ArrayNode node = new ObjectMapper().readValue(response, ArrayNode.class);
            return node.get(0).get("price_usd").asDouble();
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain BCC/USD course");
        }
    }
}
