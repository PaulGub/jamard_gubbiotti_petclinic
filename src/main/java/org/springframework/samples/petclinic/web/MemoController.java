package org.springframework.samples.petclinic.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Memo;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/vets/{vetId}")
public class MemoController {
    private static final String VIEWS_MEMOS_CREATE_OR_UPDATE_FORM =
        "memos/createOrUpdateMemoForm";
    private final ClinicService clinicService;

    @Autowired
    public MemoController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("vet")
    public Vet findVet(@PathVariable("vetId") int vetId) {
        return this.clinicService.findVetById(vetId);
    }

    @InitBinder("vet")
    public void initVetBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("memo")
    public void initMemoBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new MemoValidator());
    }

    @GetMapping(value = "/memos/new.html")
    public String initCreationForm(Vet vet, ModelMap model) {
        Memo memo= new Memo();
        vet.addMemo(memo);
        model.put("memo", memo);
        return VIEWS_MEMOS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/memos/new.html")
    public String processCreationForm(Vet vet, @Valid Memo memo, BindingResult
        result, ModelMap model) {

        if (result.hasErrors()) {

            model.put("memo", memo);
            return VIEWS_MEMOS_CREATE_OR_UPDATE_FORM;
        } else {

            vet.addMemo(memo);
            this.clinicService.saveMemo(memo);
            return "redirect:/vets/{vetId}";
        }
    }
}
