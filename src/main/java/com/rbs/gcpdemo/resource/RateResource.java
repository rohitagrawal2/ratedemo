package com.rbs.gcpdemo.resource;

import com.rbs.gcpdemo.PersistenceHelper;
import com.rbs.gcpdemo.entity.Client;
import com.rbs.gcpdemo.entity.RateQuote;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

@Path("/rate")
@Produces("application/json")
@Consumes("application/json")
public class RateResource {

    @Inject
    PersistenceHelper helper;

    @POST
    @Transactional
    public RateQuote[] getRates(Client rateRequest) throws UnknownHostException {
        Client client = helper.getEntityManager().find(Client.class,rateRequest.getClientId());
        if(client==null){
            throw new BadRequestException("Invalid Client ID");
        }
        if(client.getSegmentId()!=rateRequest.getSegmentId()){
            throw new BadRequestException("Invalid Segment ID");
        }
        RateQuote[] rateQuotes = generateRateQuotes(client);
        return rateQuotes;
    }

    @Transactional
    private RateQuote[] generateRateQuotes(Client client) {
        RateQuote rateQuote2 = new RateQuote();
        rateQuote2.setClient(client);
        rateQuote2.setRate(getRandomDoubleBetweenRange(1.36,1.37));
        rateQuote2.setSellCurrency("USD");
        rateQuote2.setBuyCurrency("GBP");


        RateQuote rateQuote1 = new RateQuote();
        rateQuote1.setClient(client);
        rateQuote1.setRate(getRandomDoubleBetweenRange(1.16,1.17));
        rateQuote1.setSellCurrency("USD");
        rateQuote1.setBuyCurrency("EUR");

        helper.getEntityManager().persist(rateQuote1);
        return new RateQuote[]{rateQuote1};
    }

    static DecimalFormat df = new DecimalFormat("#.####");

    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return new BigDecimal(x).setScale(5, RoundingMode.HALF_EVEN).doubleValue();
    }
}
