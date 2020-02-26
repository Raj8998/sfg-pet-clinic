package springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {
    @RequestMapping({"","/","index","index.html"})
    public String getIndex(Model model)
    {
        model.addAttribute("welcome","Welcome to Pet Clinic Web-App");
        return "index";
    }
}
