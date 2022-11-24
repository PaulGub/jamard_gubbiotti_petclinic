package org.springframework.samples.petclinic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Pets {

    private List<Pet> petList;

    @XmlElement(name = "pets")
    public List<Pet> getPetList() {
        if (petList == null) {
            petList = new ArrayList<>();
        }
        return petList;
    }
}
