package or.exc.artname

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestArtnameApplication

fun main(args: Array<String>) {
	fromApplication<ArtnameApplication>().with(TestArtnameApplication::class).run(*args)
}
