package tia.community.soaptp;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientMain {
    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");

        URL wsdl = new URL("http://localhost:8081/demo-app?wsdl");

        QName qName = new QName(
                "http://tia.community/soaptp",
                "CurrencyService"
        );

        Service service = Service.create(wsdl, qName);

        CurrencyService currencyService = service.getPort(CurrencyService.class);

        double resultConvert10UsdToMad = currencyService.convertUsdToMad(10);
        System.out.println("10$ = "+resultConvert10UsdToMad+"dh");

        double resultConvert100MadToUsd = currencyService.convertMadToUsd(100);
        System.out.println("100dh = "+resultConvert100MadToUsd+"$");

    }
}
