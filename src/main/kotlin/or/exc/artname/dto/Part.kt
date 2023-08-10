package or.exc.artname.dto

import lombok.Data

@Data
class Taco {
    private val name: String? = null
    private val ingredients: List<Particle>? = null
}