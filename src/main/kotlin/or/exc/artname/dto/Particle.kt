package or.exc.artname.dto


data class Particle(
        val id: String? = null,
        val name: String? = null,
        val type: Type? = null,
        ) {

    enum class Type {
        HYDROGEN, OXYGEN, CARBON, NITRO
    }
}