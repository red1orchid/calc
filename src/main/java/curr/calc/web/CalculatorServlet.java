package curr.calc.web;

import curr.calc.utils.CurrencyConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/calc")
/*TODO: ajax only*/
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String convertType = req.getParameter("convertType");
        String input = req.getParameter("input");
        String inputCurrency = req.getParameter("inputCurrency");
        String output = req.getParameter("output");

        if (!inputCurrency.isEmpty()) {
            if (convertType.equals("toUsd") && !input.isEmpty()) {
                double result = 0;
                if (inputCurrency.equals("RUB")) {
                    result = CurrencyConverter.convertRubUsd(Double.valueOf(input));
                } else if (inputCurrency.equals("BTC")) {
                    result = CurrencyConverter.convertBtcUsd(Double.valueOf(input));
                }
                req.setAttribute("input", input);
                req.setAttribute("output", new DecimalFormat("#.##").format(result));
            } else if (convertType.equals("fromUsd") && !output.isEmpty()){
                double result = 0;
                if (inputCurrency.equals("RUB")) {
                    result = CurrencyConverter.convertUsdRub(Double.valueOf(output));
                    result = Math.ceil(result);
                } else if (inputCurrency.equals("BTC")) {
                    result = CurrencyConverter.convertUsdBtc(Double.valueOf(output));
                }
                req.setAttribute("input", result);
                req.setAttribute("output", output);
            }

            req.setAttribute("inputCurrency", inputCurrency);
        }

        req.getRequestDispatcher("jsp/calc.jsp").forward(req, resp);
    }
}
