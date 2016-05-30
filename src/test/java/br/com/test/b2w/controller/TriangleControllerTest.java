package br.com.test.b2w.controller;

import br.com.test.b2w.TestB2WApplicationTests;
import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import org.springframework.http.MediaType;

public class TriangleControllerTest extends TestB2WApplicationTests {

    @Test
    public void total() throws Exception {
        this.mvc.perform(post("/triangle")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"triangle\": [[6],[3,5],[9,7,1],[4,6,8,4]] }"))
                .andExpect(jsonPath("$", is(equalTo(26))));
    }
}
