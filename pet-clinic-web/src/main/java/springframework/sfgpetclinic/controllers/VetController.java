package springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.sfgpetclinic.services.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","index","index.html"})
    String getList(Model model)
    {
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
