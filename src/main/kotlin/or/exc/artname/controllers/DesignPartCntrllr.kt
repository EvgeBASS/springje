package or.exc.artname.controllers

import lombok.extern.slf4j.Slf4j
import or.exc.artname.dto.Particle
import or.exc.artname.dto.Particle.*
import or.exc.artname.dto.Taco
import or.exc.artname.dto.TacoOrder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
class DesignTacoController {
    @ModelAttribute
    fun addIngredientsToModel(model: Model) {
        val ingredients = listOf(
                Particle("FLTO", "PolyM", Type.CARBON),
                Particle("COTO", "Corn Tortilla", Type.HYDROGEN),
                Particle("GRBF", "PhosAgro", Type.NITRO),
                Particle("CARN", "Carnitas", Type.OXYGEN),
                Particle("TMTO", "Diced Tomatoes", Type.NITRO),
                Particle("LETC", "Lettuce", Type.HYDROGEN),
                Particle("CHED", "Polus", Type.CARBON),
                Particle("JACK", "Monterrey Jack", Type.OXYGEN),
                Particle("SLSA", "Salsa", Type.OXYGEN),
                Particle("SRCR", "Sour Cream", Type.OXYGEN)
        )
        val types = Type.values()
        for (type in types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type))
        }
    }

    @ModelAttribute(name = "tacoOrder")
    fun order(): TacoOrder {
        return TacoOrder()
    }

    @ModelAttribute(name = "taco")
    fun taco(): Taco {
        return Taco()
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
}
