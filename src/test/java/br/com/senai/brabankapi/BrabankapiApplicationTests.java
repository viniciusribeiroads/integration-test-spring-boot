package br.com.senai.brabankapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrabankapiApplication.class)
@TestPropertySource(locations = "classpath:test.properties" )
public class BrabankapiApplicationTests {

	@Test
	void contextLoads() {
	}

}
