package or.exc.artname.controllers

import or.exc.artname.dto.OrderPart
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.bind.support.SessionStatus

@Controller
@RequestMapping("/orders")
@SessionAttributes("orderPart")
class OrderCntrllr {
	private val log = LoggerFactory.getLogger(this.javaClass)
	@GetMapping("/current")
	fun orderForm(): String {
		return "orderForm"
	}

	@PostMapping
	fun processOrder(order: OrderPart?,
					 sessionStatus: SessionStatus): String? {
		log.info("Order submitted: {}", order)
		sessionStatus.setComplete()
		return "redirect:/"
	}
}