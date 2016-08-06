package com.bank.shares.generator.data;

import com.bank.shares.generator.data.table.Client;
import com.bank.shares.generator.data.table.Transfer;
import com.bank.shares.generator.exceptions.BooleanPossibilityException;
import com.bank.shares.generator.exceptions.RandomNumberArgsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.bank.shares.generator.data.TransferType.*;

/**
 * Created by tomasz on 4/15/16.
 */
@Component
public class PayService {
    @Autowired
    DataCreator dataCreator;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private List<Transfer> transfers;
    private List<Client> clients;
    private int lastTransferInList = 0;


    public PayService() {
        makeEntityManager();
        this.transfers = new ArrayList<Transfer>();
        this.clients =  new ArrayList<Client>();
    }

    private void makeEntityManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void createRecordsToDB(long maxTransNumber, long clieNumber) throws ParseException, RandomNumberArgsException, BooleanPossibilityException {
        int outsideRecognition = 0;
        int outsideLoads = 0;
        int loads = 0;
        int recognition = 0;

        TransferType transferType = null;
        for (int i = 0; i < maxTransNumber; i++) {
            transferType = createTransfer();

            if (transferType == OUTSIDE_LOADS) {
                loads++;
                outsideLoads++;
            }
            if (transferType == OUTSIDE_RECOGNITION) {
                recognition++;
                outsideRecognition++;
            }
            if (transferType == RECOGNITION) {
                recognition++;
            }
            if (transferType == LOADS) {
                loads++;
            }
        }

        List<Integer> countList = createCountList(loads, outsideLoads, recognition, outsideRecognition);
        createClients(countList, clieNumber);
        saveClientsToDB();
        finishConnection();

    }

    private TransferType createTransfer() throws ParseException, RandomNumberArgsException, BooleanPossibilityException {

        Transfer transfer = new Transfer();
        transfer.setClientAccountNumber(dataCreator.getRandomNumberAsString(26));
        transfer.setDate(dataCreator.getRandomDate());

        boolean outside = dataCreator.getRandomBoolean(50.0);
        transfer.setOutside(outside);

        transfer.setOutsideAccountNumber(dataCreator.getRandomNumberAsString(26));
        String transferType = dataCreator.getRandomTransferType();

        transfer.setTransferType(transferType);
        transfer.setVerification(dataCreator.getRandomBoolean(90.0));
        transfer.setMany(dataCreator.getRandomDoubleNumber(0.0, 1000.0));

        this.transfers.add(transfer);

        return chooseTransferType(outside, transferType);
    }

    private TransferType chooseTransferType(boolean outside, String transferType) {
        TransferType transferTypeEnum = null;

        if (outside && transferType.equals("obciazenie")) {
            transferTypeEnum = OUTSIDE_RECOGNITION;
        } else if (transferType.equals("obciazenie")) {
            transferTypeEnum = RECOGNITION;
        } else if (!outside && transferType.equals("uznanie")) {
            transferTypeEnum = OUTSIDE_LOADS;
        } else if (transferType.equals("uznanie")) {
            transferTypeEnum = LOADS;
        }

        return transferTypeEnum;
    }

    private List<Integer> createCountList(int loads, int outsideLoads, int recognition, int outsideRecognition) {
        List<Integer> transferCounts = new ArrayList<Integer>();
        transferCounts.add(loads);
        transferCounts.add(outsideLoads);
        transferCounts.add(recognition);
        transferCounts.add(outsideRecognition);

        return transferCounts;
    }

    private void createClients(List<Integer> countList, long clientNumber) throws RandomNumberArgsException, BooleanPossibilityException {
        int loads = countList.get(0);
        int outsideLoads = countList.get(1);
        int recognition = countList.get(2);
        int outsideRecognition = countList.get(3);

        for (int i = 0; i < clientNumber; i++) {
            int randomOuterLoads = dataCreator.getRandomNumber(0, outsideLoads);
            int randomOuterRecognition = dataCreator.getRandomNumber(0, outsideRecognition);
            int randomLoads = randomOuterLoads + dataCreator.getRandomNumber(0, loads);
            int randomRecognition = randomOuterRecognition + dataCreator.getRandomNumber(0, recognition);


            Client client = createClient(randomLoads<loads ? randomLoads: loads,
                    randomOuterLoads<outsideLoads? randomOuterLoads: outsideLoads,
                    randomRecognition<recognition? randomRecognition: recognition,
                    randomOuterRecognition<outsideRecognition? randomOuterRecognition: outsideRecognition);

            loads = loads>=randomLoads? loads-randomLoads: 0;
            outsideLoads = outsideLoads>=randomOuterLoads? outsideLoads-randomOuterLoads: 0;
            recognition = recognition>=randomRecognition? recognition-randomRecognition: 0;
            outsideRecognition = outsideRecognition>=randomOuterRecognition? outsideRecognition-randomOuterRecognition: 0;

            this.clients.add(client);
        }
    }


    private Client createClient(int loads, int outLoads, int recognition, int outRecognition) throws RandomNumberArgsException, BooleanPossibilityException {
        Client client = new Client();
        client.setAccountState(dataCreator.getRandomDoubleNumber(0.0, 100000.0));
        client.setActive(dataCreator.getRandomBoolean(80.0));
        client.setName(dataCreator.getRandomName());
        client.setPeselNumber(dataCreator.getRandomNumberAsString(11));
        client.setSurname(dataCreator.getRandomSurname());
        client.setTotalLoads(loads);
        client.setTotalLoadsOutsides(outLoads);
        client.setTotalOutsideRecognition(recognition);
        client.setTotalRecognition(outRecognition);
        client.setTransfers(this.transfers.subList(this.lastTransferInList, this.lastTransferInList+loads+recognition));
        this.lastTransferInList += (loads + recognition);


        return client;
    }


    private void saveClientsToDB() {
        entityManager.getTransaction().begin();
        for (Client client : this.clients) {
            entityManager.persist(client);
            for (Transfer transfer :client.getTransfers()) {
                transfer.setClient(client);
                entityManager.persist(transfer);
            }
        }
        entityManager.getTransaction().commit();
    }

    private void finishConnection() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }

}
