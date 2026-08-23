package tia.community.soaptp;

import jakarta.xml.ws.Endpoint;

public class ServerMain {
    public static void main(String[] args) {

        Endpoint.publish(
                "http://localhost:8081/demo-app",
                new CurrencyServiceImpl()
        );

        System.out.println("WSDL: http://localhost:8081/demo-app?wsdl");

    }
}
