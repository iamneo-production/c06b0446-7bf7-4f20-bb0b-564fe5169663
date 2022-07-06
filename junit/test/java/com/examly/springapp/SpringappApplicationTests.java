package com.examly.springapp;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Test;
import org.junit.jupiter.api.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@Transactional
    public void BE_Add_User() throws Exception {
        String newProduct = "{\"email\":\"test@gmail.com\",\"password\":\"Test@123\",\"username\":\"test123\",\"mobileNumber\":\"9876543210\",\"userRole\":\"user\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newProduct)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Add_Job() throws Exception {
        String newJob = "{\"jobId\":\"01\",\"jobDescription\":\"ABC\",\"jobLocation\":\"chennai\",\"fromDate\":\"25-11-2021\",\"toDate\":\"12-12-2021\",\"wagePerDay\":\"500\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/addJob")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newJob)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_Job() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/admin/getAlljobs")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_Job() throws Exception {
        String newJob = "{\"jobId\":\"01\",\"jobDescription\":\"ABC\",\"jobLocation\":\"chennai\",\"fromDate\":\"25-11-2021\",\"toDate\":\"12-12-2021\",\"wagePerDay\":\"500\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/editJob")
		.param("jobId","01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newJob)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
}
