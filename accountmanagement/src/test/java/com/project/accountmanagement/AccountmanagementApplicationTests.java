package com.project.accountmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(MockitoJUnitRunner.class)
//@ActiveProfiles("test")
class AccountmanagementApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private CustomerRepository customerrepository;
//	
//	Gson gson = new Gson();
//    @Test
//    @DisplayName("Given Customer data should save the data to DB and return Customer data")
//    public void testcreateCustomer() throws Exception {
//    	Customer customer=new Customer();
//    	customer.setAadherNumber("567856785678");
//    	customer.setAddress("jhadyuqwdjq");
//    	customer.setCustomerName("qwerty");
////    	Date d1=new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-20");
//    	customer.setDateOfBirth(LocalDate.now());
//    	customer.setEmail("sravs@gmail.com");
//    	customer.setPanNumber("ffxbh6746m");
//    	System.out.println("-----------------------------------test-----------------------------------------");
//    	when(customerrepository.save(Mockito.any())).thenReturn(customer);  	
//    	mockMvc.perform(MockMvcRequestBuilders.post("/createcustomer").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(customer))).andExpect(status().isOk());
//    }

}
