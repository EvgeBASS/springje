package or.exc.artname.dto

import lombok.Data


@Data
class OrderPart {
    private val deliveryName: String? = null
    private val deliveryStreet: String? = null
    private val deliveryCity: String? = null
    private val deliveryState: String? = null
    private val deliveryZip: String? = null
    private val ccNumber: String? = null
    private val ccExpiration: String? = null
    private val ccCVV: String? = null
    private val parts: MutableList<Part> = arrayListOf()

    fun addPart(part: Part) {
        parts.add(part)
    }
}
