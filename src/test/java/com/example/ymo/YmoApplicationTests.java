package com.example.ymo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class YmoApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCompetence() throws Exception {
        mvc.perform(get("/competence"))
                .andExpect(status().isOk());

    }
    @Test
    public void getFakultativ() throws Exception {
        mvc.perform(get("/fakultativ"))
                .andExpect(status().isOk());

    }
    @Test
    public void getCreatorStudyProgramm() throws Exception {
        mvc.perform(get("/creator_study_programm"))
                .andExpect(status().isOk());

    }
    @Test
    public void getPractice() throws Exception {
        mvc.perform(get("/practice"))
                .andExpect(status().isOk());

    }
    @Test
    public void getPlan() throws Exception {
        mvc.perform(get("/plan"))
                .andExpect(status().isOk());

    }
    @Test
    public void getSpeciality() throws Exception {
        mvc.perform(get("/speciality"))
                .andExpect(status().isOk());

    }

}
