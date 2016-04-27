package com.bank.shares.generator.data;

import com.bank.shares.generator.exceptions.BooleanPossibilityException;
import com.bank.shares.generator.exceptions.RandomNumberArgsException;
import org.springframework.stereotype.Component;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by tomasz on 4/15/16.
 */
@Component
public class DataCreator {
    private Random random = new Random();
    private List<String> names;
    private List<String> surnames;

    public DataCreator() {
        createNames();
        createSurnames();
    }

    private void createNames() {
        String[] tempNames = {"Aaron", "Abbo", "Abbon", "Abdiasz", "Abdon", "Abel", "Abelard", "Abercjusz", "Abiasz", "Abigail", "Abraham", "Absalon", "Abundancja",
                "Abundancjusz", "Achacja", "Achacjusz", "Achacy", "Achilles", "Ada", "Adalbert", "Adalberta", "Adalgunda", "Adalruna", "Alruna", "Adalryk", "Alderyk",
                "Adalwin", "Adalwina", "Adam", "Adamina", "Adamnan", "Adaukt", "Addar", "Adela", "Adelajda", "Adelard", "Adelina", "Adelinda", "Ademar", "Adolf", "Adolfa",
                "Adolfina", "Adrian", "Adriana", "Adrianna", "Aelred", "Afra", "Afrodyta", "Afrodyzja", "Afrodyzjusz", "Afrodyzy", "Afrykan", "Agapit", "Agapita", "Agapiusz",
                "Agata", "Agatangel", "Agaton", "Agatonik", "Agatonika", "Agenor", "Aggeusz", "Agis", "Agnellus", "Agnieszka", "Baalis", "Babilas", "Bachus", "Bakchus", "Balbin",
                "Balbina", "Baldomer", "Baldomera", "Baldwin", "Baldwina", "Balladyna", "Baltazar", "Barabasz", "Barbacjan", "Barbacy", "Barbat", "Barbara", "Barlaam", "Barnaba",
                "Barnim", "Baroncjusz", "Bartłomiej", "Bartłomieja", "Bartosz", "Basjan", "Basjana", "Batylda", "Bawon", "Bazyla", "Bazyli", "Bazylides", "Bazyliusz", "Ida", "Idalia",
                "Idzi", "Ifigenia", "Iga", "Ignacja", "Ignacy", "Igor", "Ildefons", "Ildefonsa", "Ilidia", "Ilidiusz", "Ilona", "Imbram", "Imelda", "Imisław", "Imisława", "Indracht",
                "Indrakt", "Inga", "Ingarda", "Ingbert", "Ingeborga", "Ingobert", "Ingolf", "Ingryda", "Innocencja", "Innocenta", "Innocenty", "Innocentyna", "Irena", "Ireneusz",
                "Kacper", "Kaja", "Kajetan", "Kajetana", "Kajmir", "Kajus", "Kalasanty", "Kalikst", "Kalista", "Kalina", "Kalinik", "Kalistrat", "Kalmir", "Kamil", "Kamila",
                "Kancjan", "Kancjanela", "Kancjusz", "Kandyd", "Kandyda", "Kanizjusz", "Kanimir", "Kanizja", "Kanmił", "Kanut", "Kanuta", "Kapitolina", "Karina", "Karol",
                "Karol", "Boromeusz", "Karola", "Karolina", "Eberhard", "Ebrulf", "Edbert", "Edburga", "Edda", "Edelburga", "Edeltruda", "Edgar", "Edmund", "Edmunda", "Edward",
                "Edwarda", "Edwin", "Edwina", "Edyta", "Efraim", "Efrem", "Egbert", "Egidia", "Egidiusz", "Egon", "Egwin", "Ekhard", "Eghard", "Ekard", "Ekspedyt", "Ekspedyta",
                "Eksuperancjusz", "Eksuperiusz", "Eleazar", "Eleonora", "Eleukadiusz", "Eleuteria", "Eleuteriusz", "Eleutery", "Dacjan", "Dacjusz", "Dadzbog", "Dadzboga",
                "Dafroza", "Dagmara", "Dagna", "Dagobert", "Dalbor", "Dalebor", "Dalebora", "Dalegor", "Dalemir", "Dalestryj", "Dalewin", "Dalwin", "Dalewuja", "Dalia",
                "Dalibor", "Dalila", "Dalimir", "Dalmacjusz", "Dalwin", "Damazy", "Damian", "Damiana", "Damroka", "Daniel", "Daniela", "Danuta", "Dargomier", "Dargorad",
                "Dargosław", "Rachela", "Racibor", "Racigniew", "Racimir", "Racisław", "Radbod", "Radegunda", "Radmir", "Radociech", "Radogost", "Radomił", "Radomiła", "Radomir",
                "Radomira", "Radosław", "Radosława", "Radowit", "Radowuj", "Radsuł", "Radzim", "Radzisław", "Radzisława", "Rafał", "Raisa", "Rajner", "Rajmund", "Ścibor", "Ścibora",
                "Śnieżka", "Świebąd", "Świebor", "Świebora", "Świeciech", "Świecław", "Świedarg", "Świegniew", "Świelub", "Świemił", "Świemir", "Świerad", "Świetlana", "Święcsława",
                "Święsława", "Świętobor", "Świętomir", "Świętomira", "Świętopełk", "Świętosław", "Świętosława", "Wacław", "Wacława", "Walbert", "Walburga", "Waldebert", "Waldemar",
                "Waldetruda", "Walenty", "Walentyn", "Walentyna", "Waleria", "Walerian", "Waleriana", "Waleriusz", "Walery", "Walter", "Waltrauda", "Walwan", "Wanda", "Wanesa",
                "Wanessa", "Warcisław", "Wawrzyniec", "Wedast", "Wenancja", "Wenancjusz", "Wenanty", "Wendelin", "Wenefryda", "Wenerand", "Werena", "Wergilia" };

        this.names = Arrays.asList(tempNames);
    }

    private void createSurnames() {
        String[] tempSurnames = {"Abramuk", "Acker", "Adamczak", "Adamkiewicz", "Adamowicz", "Adamska", "Adamski", "Agaciński", "Albrecht", "Albrecht", "Aleksandru",
                "Amer", "Andrysiak", "Andrzejak", "Andrzejewski", "Andrzejewski", "Angielczyk", "Antczak", "Antoniak", "Antoniewski", "Antoszewski", "Anyżewski",
                "Arasimowicz", "Arcichowski", "Arlitewicz", "Babiarz", "Bajerlein", "Bakuła", "Baliński", "Banaś", "Banatkiewicz", "Baranowski", "Barbaś", "Barcichowski",
                "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowski", "Bartlewicz", "Bartlewicz", "Bartlewski", "Bartlewski",
                "Bartnicki", "Bartoszak", "Bartoszewski", "Baszyński", "Baszyński", "Batko", "Baum", "Bączkowski", "Bączkowski", "Becker", "Benert", "Benetkiewicz",
                "Berdychowski", "Kaczmarek", "Kaczmarek", "Kaczor", "Kadzinowski", "Kalkowski", "Kałmuczak", "Kałudziński", "Kałużyński", "Kamińska", "Kamyczek", "Kanabus",
                "Kania", "Kaniewski", "Kardasz", "Karlewicz", "Karlik", "Karpiński", "Kaseja", "Kasperski", "Kaspruk", "Kasprzak", "Kaszubkiewicz" };

        this.surnames = Arrays.asList(tempSurnames);
    }

    public double getRandomDoubleNumber(double min, double max) throws RandomNumberArgsException {
        if (min<0.0 || max> Double.MAX_VALUE || min > max)
            throw new RandomNumberArgsException(min,max);

        return max != 0.0 ? min + (max - min) * random.nextDouble() : 0;
    }

    public int getRandomNumber(int min, int max) throws RandomNumberArgsException {
        if (min< 0 || max> Integer.MAX_VALUE || min > max)
            throw new RandomNumberArgsException(min,max);

        return max != 0 ? min + random.nextInt(max-min) : 0;
    }

    public boolean getRandomBoolean(double truPossibility) throws BooleanPossibilityException, RandomNumberArgsException {
        if (truPossibility < 0.0 || truPossibility > 100.0)
            throw new BooleanPossibilityException();

        double chance = getRandomDoubleNumber(0.0, 100.0);
        boolean result = chance <= truPossibility ? true : false;

        return result;
    }


    public Timestamp getRandomDate() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = dateFormat.parse("2016-06-20");
        long maxDateMs = date.getTime();
        date = dateFormat.parse("2013-06-20");
        long minDateMs = date.getTime();

        long randomDateMs = minDateMs + (long)(random.nextDouble()*(maxDateMs - minDateMs));

        return new Timestamp(randomDateMs);
    }

    public String getRandomNumberAsString(int digitNumber) {
        String accountNumber = "";


        for (int i = 0; i<digitNumber; i++)
        accountNumber += random.nextInt(10);

        return accountNumber;
    }

    public String getRandomTransferType() {
        int i = random.nextInt(2);

        return i == 0 ? "obciazenie" : "uznanie";
    }

    public String getRandomName() {
        return names.get(random.nextInt(names.size()));
    }

    public String getRandomSurname() {
        return surnames.get(random.nextInt(surnames.size()));
    }


}
