package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Operation;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/pets/{petId}")
public class OperationController {
    private static final String VIEWS_OPERATIONS_CREATE_OR_UPDATE_FORM =
        "operations/createOrUpdateOperationForm";

    private final ClinicService clinicService;

    @Autowired
    public OperationController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("pet")
    public Pet findPet(@PathVariable("petId") int petId) {
        return this.clinicService.findPetById(petId);
    }

    @InitBinder("pet")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("operation")
    public void initOperationBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new OperationValidator());
    }

    @GetMapping("/operation")
    public ModelAndView showVetsOperationList(@PathVariable("petId") int petId) {
        ModelAndView mav = new ModelAndView("operations/vetsOperationList");
        mav.addObject(this.clinicService.findPetById(petId));
        Vets vets = getVets();
        mav.addObject("vets", vets);
        return mav;
    }

    private Vets getVets() {
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        return vets;
    }

    @GetMapping(value = "/operation/{vetId}/new.html")
    public String initCreationForm(@PathVariable("vetId") int vetId, Pet pet, ModelMap modelMap) {
        Operation operation = new Operation();
        Vet vet = this.clinicService.findVetById(vetId);
        vet.addOperation(operation);
        pet.addOperation(operation);
        modelMap.put("operation", operation);
        return VIEWS_OPERATIONS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/operation/{vetId}/new.html")
    public String processCreationForm(@PathVariable("vetId") int vetId, Pet pet, @Valid Operation operation, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.put("operation", operation);
            return VIEWS_OPERATIONS_CREATE_OR_UPDATE_FORM;
        } else {
            Vet vet = this.clinicService.findVetById(vetId);
            vet.addOperation(operation);
            pet.addOperation(operation);
            this.clinicService.saveOperation(operation);
            return "redirect:/pets/{petId}";
        }
    }
}
