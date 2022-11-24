package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.model.Pets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PetsController {

    private final ClinicService clinicService;

    public PetsController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/pets")
    public String showPetList(Map<String, Object> model) {
        Pets pets = getPets();
        model.put("pets", pets);
        return "pets/petList";
    }

    private Pets getPets() {
        Pets pets = new Pets();
        pets.getPetList().addAll(this.clinicService.findPets());
        return pets;
    }

    /**
     * Custom handler for displaying a pet.
     *
     * @param petId the ID of the pet to display
     * @return a ModelMap with the model attributes for the view
     */
    @GetMapping("/pets/{petId}")
    public ModelAndView showPet(@PathVariable("petId") int petId) {
        ModelAndView mav = new ModelAndView("pets/petDetails");
        mav.addObject(this.clinicService.findPetById(petId));
        return mav;
    }
}
