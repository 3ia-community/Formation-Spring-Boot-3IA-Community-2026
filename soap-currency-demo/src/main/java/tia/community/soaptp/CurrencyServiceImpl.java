package tia.community.soaptp;

import jakarta.jws.WebService;

@WebService(
        endpointInterface = "tia.community.soaptp.CurrencyService",
        targetNamespace = "http://tia.community/soaptp",
        serviceName = "CurrencyService"
)
public class CurrencyServiceImpl implements CurrencyService{

    private final double TAUX = 10;

    @Override
    public double convertUsdToMad(double amount) {
        return amount*TAUX;
    }

    @Override
    public double convertMadToUsd(double amount) {
        return amount/TAUX;
    }
}
