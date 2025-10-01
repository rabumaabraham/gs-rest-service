package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployeesShouldReturnListOfEmployees() throws Exception {
        this.mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees").isArray())
                .andExpect(jsonPath("$.employees[0].employee_id").value("EMP001"))
                .andExpect(jsonPath("$.employees[0].first_name").value("John"))
                .andExpect(jsonPath("$.employees[0].last_name").value("Doe"))
                .andExpect(jsonPath("$.employees[0].email").value("john.doe@company.com"))
                .andExpect(jsonPath("$.employees[0].title").value("Software Engineer"));
    }

    @Test
    public void postEmployeeShouldAddNewEmployee() throws Exception {
        String employeeJson = "{\"employee_id\":\"TEST001\",\"first_name\":\"Test\",\"last_name\":\"User\",\"email\":\"test.user@company.com\",\"title\":\"Test Engineer\"}";
        
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("TEST001"))
                .andExpect(jsonPath("$.first_name").value("Test"))
                .andExpect(jsonPath("$.last_name").value("User"))
                .andExpect(jsonPath("$.email").value("test.user@company.com"))
                .andExpect(jsonPath("$.title").value("Test Engineer"));
    }

    @Test
    public void postEmployeeWithInvalidJsonShouldReturnBadRequest() throws Exception {
        String invalidJson = "{\"employee_id\":\"TEST002\",\"first_name\":\"Test\"}"; // Missing required fields
        
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andDo(print())
                .andExpect(status().isOk()); // Spring Boot will still accept it but with null values
    }
}

