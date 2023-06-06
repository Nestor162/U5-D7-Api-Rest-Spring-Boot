package nestorcicardini.D7;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class D7ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetInfoIta() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info/ita"))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	void shouldGetInfoEng() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info/eng"))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	void shouldGetMainPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info"))
				.andExpect(status().is2xxSuccessful());
	}

}
