//package com.prj.ms.product;
//
//import io.restassured.matcher.ResponseAwareMatcher;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
//import org.springframework.context.annotation.Import;
//import org.testcontainers.containers.MySQLContainer;
//import io.restassured.RestAssured;
//import org.testcontainers.shaded.org.hamcrest.Matchers;
//
//@Import(TestcontainersConfiguration.class)
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//class ProductServiceApplicationTests {
//
//	@ServiceConnection
//	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");
//
//	//using this since we'll be using a random port
//	@LocalServerPort
//	private Integer port;
//
//	@BeforeEach
//	void setup(){
//		RestAssured.baseURI = "http://localhost";
//		RestAssured.port = port;
//	}
//
//	static {
//		mySQLContainer.start();
//	}
//
//	@Test
//	void shouldCreateProduct()  {
//		String requestBody = """
//				{
//				    "name": "laptop",
//				    "description": "A Lenovo Laptop",
//				    "price": "65000"
//				}
//				""";
//
//		RestAssured.given()
//				.contentType("/application/json")
//				.body(requestBody).when()
//				.post("/api/add").then()
//				.statusCode(201)
//				.body("id", (ResponseAwareMatcher<Response>) Matchers.notNullValue())
//				.body("name", (ResponseAwareMatcher<Response>) Matchers.equalTo("laptop"))
//				.body("description", (ResponseAwareMatcher<Response>) Matchers.equalTo("A Lenovo Laptop"))
//				.body("price", (ResponseAwareMatcher<Response>) Matchers.equalTo(65000));
//	}
//
//}
