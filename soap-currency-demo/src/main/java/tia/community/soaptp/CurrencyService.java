package tia.community.soaptp;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface CurrencyService {

    @WebMethod
    double convertUsdToMad(double amount);

    @WebMethod
    double convertMadToUsd(double amount);
}
