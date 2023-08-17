package or.exc.artname.controllers

import lombok.extern.slf4j.Slf4j
import or.exc.artname.dto.OrderPart
import or.exc.artname.dto.Part
import or.exc.artname.dto.Particle
import or.exc.artname.dto.Particle.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.*
import java.util.logging.Logger
import java.util.stream.Collectors


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("orderPart")
class DesignPartCntrllr {
    private val log = LoggerFactory.getLogger(this.javaClass)
    @ModelAttribute
    fun addParticleToModel(model: Model) {
        val particles = listOf(
                Particle("PLMT", "PolyM", Type.CARBON),
                Particle("PSTC", "PositiveTech", Type.HYDROGEN),
                Particle("PHAR", "PhosAgro", Type.NITRO),
                Particle("TGK", "TGK", Type.OXYGEN),
                Particle("DVMP", "DVMP", Type.NITRO),
                Particle("GZPR", "GazP", Type.CARBON),
                Particle("PLS", "Polus", Type.CARBON),
                Particle("MENR", "MosEnergo", Type.OXYGEN),
                Particle("ALRS", "Alrosa", Type.CARBON),
                Particle("FNTC", "FinTech", Type.HYDROGEN),
        )
        val types = Type.values()
        for (type in types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(particles, type))
        }
    }

    @ModelAttribute(name = "orderPart")
    fun order(): OrderPart {
        return OrderPart()
    }

    @ModelAttribute(name = "part")
    fun part(): Part {
        return Part()
    }

    @GetMapping
    fun showDesignForm(): String {
        return "design"
    }

    private fun filterByType(
            ingredients: List<Particle>, type: Type): Iterable<Particle> {
        return ingredients.stream()
                .filter{ x: Particle -> x.type==type }
                .collect(Collectors.toList())
    }

    @PostMapping
    fun processTaco(part: Part,
                    @ModelAttribute orderPart: OrderPart): String? {
        orderPart.addPart(part)

        log.info("Processing Part: {}", part)
        return "redirect:/orders/current"
    }
}
