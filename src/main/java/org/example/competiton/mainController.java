package org.example.competiton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/api")
public class mainController {
    @GetMapping("view")
    public String View(){
        return "view";

    }
}
