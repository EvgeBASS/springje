package or.exc.artname.utils

import or.exc.artname.dto.Particle
import or.exc.artname.dto.Particle.Type
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component


@Component
class IngredientByIdConverter : Converter<String, Particle?> {
	private val particleMap: MutableMap<String, Particle> = HashMap()

	init {
		particleMap["PLMT"] = Particle("PLMT", "PolyM", Type.CARBON)
		particleMap["PSTC"] = Particle("PSTC", "PositiveTech", Type.HYDROGEN)
		particleMap["PHAR"] = Particle("PHAR", "PhosAgro", Type.NITRO)
		particleMap["TGK"] = Particle("TGK", "TGK", Type.OXYGEN)
		particleMap["DVMP"] = Particle("DVMP", "DVMP", Type.NITRO)
		particleMap["GZPR"] = Particle("GZPR", "GazP", Type.CARBON)
		particleMap["PLS"] = Particle("PLS", "Polus", Type.CARBON)
		particleMap["MENR"] = Particle("MENR", "MosEnergo", Type.OXYGEN)
		particleMap["ALRS"] = Particle("ALRS", "Alrosa", Type.CARBON)
		particleMap["FNTC"] = Particle("FNTC", "FinTech", Type.HYDROGEN)
	}

	override fun convert(id: String): Particle? {
		return particleMap[id]
	}
}