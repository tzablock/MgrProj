package com.bank.shares.generator.data;

import com.bank.shares.generator.SpringConfig;
import com.bank.shares.generator.exceptions.RandomNumberArgsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tomasz on 4/17/16.
 */
@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DataCreatorTest {

    @Autowired
    DataCreator dataCreator;

    @Test
    public void testGetRandomDoubleNumber() throws Exception {
        assertEquals(dataCreator.getRandomDoubleNumber(0,0),0,0);
        assertEquals(dataCreator.getRandomDoubleNumber(10,10),10,0);
        assertTrue(dataCreator.getRandomDoubleNumber(3,10)<10);
        assertTrue(dataCreator.getRandomDoubleNumber(3,10)>3);
    }

    @Test
    public void testGetRandomNumber() throws RandomNumberArgsException {
        assertTrue(dataCreator.getRandomNumber(2,30) <= 30);
        assertTrue(dataCreator.getRandomNumber(2,30) >= 2);
    }


    @Test
    public void testGetRandomBoolean() throws Exception {
        assertTrue(dataCreator.getRandomBoolean(100.0));
        assertFalse(dataCreator.getRandomBoolean(0.0));
    }

    @Test
    public void testGetRandomDate() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = dateFormat.parse("2016-06-20");
        long maxDateMs = date.getTime();
        date = dateFormat.parse("2013-06-20");
        long minDateMs = date.getTime();

        assertTrue(dataCreator.getRandomDate().getTime()<maxDateMs);
        assertTrue(dataCreator.getRandomDate().getTime()>minDateMs);
    }

    @Test
    public void testGetRandomNumberAsString() throws Exception {
        String randomNumberAsString = dataCreator.getRandomNumberAsString(5);

        assertEquals(randomNumberAsString.length(),5);
        assertTrue(Long.parseLong(randomNumberAsString)<=99999);

    }

    @Test
    public void testGetRandomTransferType() throws Exception {
        assertTrue(dataCreator.getRandomTransferType().equals("obciazenie") || dataCreator.getRandomTransferType().equals("uznanie"));
    }

    @Test
    public void testGetRandomName() throws Exception {
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

        List<String> names = Arrays.asList(tempNames);

        assertTrue(names.contains(dataCreator.getRandomName()));
    }

    @Test
    public void testGetRandomSurname() throws Exception {
        String[] tempSurnames = {"Abramuk", "Acker", "Adamczak", "Adamkiewicz", "Adamowicz", "Adamska", "Adamski", "Agaciński", "Albrecht", "Albrecht", "Aleksandru",
                "Amer", "Andrysiak", "Andrzejak", "Andrzejewski", "Andrzejewski", "Angielczyk", "Antczak", "Antoniak", "Antoniewski", "Antoszewski", "Anyżewski",
                "Arasimowicz", "Arcichowski", "Arlitewicz", "Babiarz", "Bajerlein", "Bakuła", "Baliński", "Banaś", "Banatkiewicz", "Baranowski", "Barbaś", "Barcichowski",
                "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowiak", "Bartkowski", "Bartlewicz", "Bartlewicz", "Bartlewski", "Bartlewski",
                "Bartnicki", "Bartoszak", "Bartoszewski", "Baszyński", "Baszyński", "Batko", "Baum", "Bączkowski", "Bączkowski", "Becker", "Benert", "Benetkiewicz",
                "Berdychowski", "Kaczmarek", "Kaczmarek", "Kaczor", "Kadzinowski", "Kalkowski", "Kałmuczak", "Kałudziński", "Kałużyński", "Kamińska", "Kamyczek", "Kanabus",
                "Kania", "Kaniewski", "Kardasz", "Karlewicz", "Karlik", "Karpiński", "Kaseja", "Kasperski", "Kaspruk", "Kasprzak", "Kaszubkiewicz" };
        List<String> surnames = Arrays.asList(tempSurnames);

        assertTrue(surnames.contains(dataCreator.getRandomSurname()));
    }
}