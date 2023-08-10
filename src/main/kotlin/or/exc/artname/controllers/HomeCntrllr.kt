package or.exc.artname.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeCntrllr {
    @GetMapping("/")
    fun home() = "home"
}