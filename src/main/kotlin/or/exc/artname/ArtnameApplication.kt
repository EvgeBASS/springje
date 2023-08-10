package or.exc.artname

import or.exc.artname.dto.Particle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArtnameApplication

fun main(args: Array<String>) {
	runApplication<ArtnameApplication>(*args)
}
