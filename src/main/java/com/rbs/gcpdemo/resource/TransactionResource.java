package com.rbs.gcpdemo.resource;

import com.rbs.gcpdemo.PersistenceHelper;
import com.rbs.gcpdemo.Request.TransactionRequest;
import com.rbs.gcpdemo.Request.TransactionResponse;
import com.rbs.gcpdemo.entity.Client;
import com.rbs.gcpdemo.entity.RateQuote;
import com.rbs.gcpdemo.entity.Transaction;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Path("/transaction")
@Produces("application/json")
@Consumes("application/json")
public class TransactionResource {

    @Inject
    PersistenceHelper helper;

    @POST
    @Transactional
    public TransactionResponse saveTransaction(TransactionRequest transactionRequest) throws UnknownHostException {
        Client client = helper.getEntityManager().find(Client.class,transactionRequest.getClientId());
        RateQuote rateQuote = helper.getEntityManager().find(RateQuote.class,transactionRequest.getRateQuoteId());
        if(client==null){
            throw new BadRequestException("Invalid Client ID");
        }
        if(rateQuote==null){
            throw new BadRequestException("Invalid rate quote");
        }
        Transaction transaction = new Transaction(client,rateQuote,transactionRequest.getClientTransactionId(),transactionRequest.getDealtAmount());
        helper.getEntityManager().persist(transaction);

        TransactionResponse response= createResponse(transaction);
        return response;
    }

    @GET
    public List<TransactionResponse> getTransactions() throws UnknownHostException {
        List<Transaction> transactionList = helper.getEntityManager().createQuery("SELECT e FROM Transaction e").getResultList();
        return transactionList.stream().map(t -> createResponse(t)).collect(Collectors.toList());
    }

    private TransactionResponse createResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(transaction.getTransactionId());
        transactionResponse.setClientTransactionId(transaction.getClientTransactionId());
        transactionResponse.setBuyAmount(transaction.getAmount());
        transactionResponse.setRate(transaction.getRateQuote().getRate());
        transactionResponse.setSellAmount(transaction.getAmount() * transaction.getRateQuote().getRate());
        return transactionResponse;
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return new BigDecimal(x).setScale(5, RoundingMode.HALF_EVEN).doubleValue();
    }
}
