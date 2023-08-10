package or.exc.artname

import or.exc.artname.controllers.HomeCntrllr
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(HomeCntrllr::class)
class HomeControllerTest {
    @Autowired
    private val mockMvc: MockMvc? = null
    @org.junit.jupiter.api.Test
    @Throws(Exception::class)
    fun testHomePage() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.content().string(
                        org.hamcrest.Matchers.containsString("Welcome to...")))
    }
}