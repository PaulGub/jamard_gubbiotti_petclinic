package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VetTests {

    @Test
    @Transactional
    public void testHasMemo() {
        Vet johnDoe = new Vet();
        johnDoe.setFirstName("John");
        johnDoe.setLastName("Doe");

        Memo aMemo = new Memo();
        aMemo.setDate(LocalDate.parse("2010-03-04"));
        aMemo.setDescription("Visit with Guts");

        assertEquals(0, johnDoe.getNrOfMemos());
        assertTrue(johnDoe.getMemos().isEmpty());

        List<Memo> listOfMemos = new ArrayList<>();
        listOfMemos.add(aMemo);

        johnDoe.addMemo(aMemo);

        assertEquals(listOfMemos, johnDoe.getMemos());
    }

    @Test
    @Transactional
    public void testHasOperation() {
        Vet johnDoe = new Vet();
        johnDoe.setFirstName("John");
        johnDoe.setLastName("Doe");

        Operation anOperation = new Operation();
        anOperation.setDate(LocalDate.parse("2010-03-04"));
        anOperation.setDescription("removal of testicles");

        assertEquals(0, johnDoe.getNrOfOperations());
        assertTrue(johnDoe.getOperations().isEmpty());

        List<Operation> listOfOperations = new ArrayList<>();
        listOfOperations.add(anOperation);

        johnDoe.addOperation(anOperation);

        assertEquals(listOfOperations, johnDoe.getOperations());
    }
}
