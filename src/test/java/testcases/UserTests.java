package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;

public class UserTests {
	Faker faker;
	User userpayload;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userpayload = new User();

		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testgetUserByUserName() {
		Response response = UserEndPoints.readUser(userpayload.getUsername());
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUserByUserName() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		Response response = UserEndPoints.updateUser(userpayload, userpayload.getUsername());
		response.then().log().all();
		
		assertEquals(response.statusCode(), 200);
		
		
		//checking data after update
		Response responseAfterUpdate = UserEndPoints.readUser(userpayload.getUsername());
		//assertEquals(responseAfterUpdate.statusCode(), 200);
	}
	
	@Test(priority = 4)
	public void testDeleteUserByUserName() {
		Response response = UserEndPoints.deleteUser(userpayload.getUsername());
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	

}
