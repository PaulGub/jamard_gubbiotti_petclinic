package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetTests {

    @Test
    @Transactional
    public void testHasVisit() {
        Pet guts = new Pet();
        guts.setName("Guts");

        Visit aVisit = new Visit();
        aVisit.setDate(LocalDate.parse("2010-03-04"));
        aVisit.setDescription("An operation");

        assertEquals(0, guts.getVisits().size());
        assertTrue(guts.getVisits().isEmpty());

        List<Visit> listOfVisits = new ArrayList<>();
        listOfVisits.add(aVisit);

        guts.addVisit(aVisit);

        assertEquals(listOfVisits, guts.getVisits());
    }

    @Test
    @Transactional
    public void testHasOperation() {
        Pet guts = new Pet();
        guts.setName("Guts");

        Operation anOperation = new Operation();
        anOperation.setDate(LocalDate.parse("2010-03-04"));
        anOperation.setDescription("removal of testicles");

        assertEquals(0, guts.getOperations().size());
        assertTrue(guts.getOperations().isEmpty());

        List<Operation> listOfOperations = new ArrayList<>();
        listOfOperations.add(anOperation);

        guts.addOperation(anOperation);

        assertEquals(listOfOperations, guts.getOperations());
    }
}
