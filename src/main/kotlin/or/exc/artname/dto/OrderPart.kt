package or.exc.artname.dto


data class OrderPart(val deliveryName: String? = null,
    var deliveryStreet: String? = null,
    var deliveryCity: String? = null,
    var deliveryState: String? = null,
    var deliveryZip: String? = null,
    var ccNumber: String? = null,
    var ccExpiration: String? = null,
    var ccCVV: String? = null,
    var parts: MutableList<Part> = arrayListOf()) {


    fun addPart(part: Part) {
        parts.add(part)
    }
}
