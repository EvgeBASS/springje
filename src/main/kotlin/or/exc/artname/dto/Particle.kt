package or.exc.artname.dto

import lombok.AllArgsConstructor
import lombok.Data

@Data
class Particle(id: String, name: String, typ: Type) {
    private val id: String? = null
    private val name: String? = null
    private val type: Type? = null

    enum class Type {
        HYDROGEN, OXYGEN, CARBON, NITRO
    }
}