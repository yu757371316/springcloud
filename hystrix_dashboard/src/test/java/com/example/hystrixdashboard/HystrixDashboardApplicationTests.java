package com.example.hystrixdashboard;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@ContextConfiguration(locations = {"classpath:application.properties"})
public class HystrixDashboardApplicationTests {

	@Test
	public void contextLoads() {
	}

}
