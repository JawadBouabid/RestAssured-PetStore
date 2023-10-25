package testcases;

import static org.testng.Assert.assertEquals;

import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.PetEndpoints;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.Pet;
import payload.PetCategory;
import payload.PetTag;

public class PetTests {
	Faker faker;
	Pet petPayload;
	PetCategory category;
	PetTag tag1;
	PetTag tag2;
	
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		petPayload = new Pet();
		category = new PetCategory();
		tag1 = new PetTag();
		tag2 = new PetTag();
		
		
		category.setId(faker.number().hashCode());
		category.setName(RandomStringUtils.randomAlphabetic(4));
		tag1.setId(faker.number().hashCode());
		tag1.setName(RandomStringUtils.randomAlphabetic(4));
		tag2.setId(faker.number().hashCode());
		tag2.setName(RandomStringUtils.randomAlphabetic(4));
		
		
		
		petPayload.setId(faker.number().hashCode());
		petPayload.setCategory(category);
		petPayload.setName(faker.animal().name());
		petPayload.setUrls(Arrays.asList(RandomStringUtils.randomAlphabetic(5)));
		petPayload.setTags(Arrays.asList(tag1, tag2));
		
	}
	
	@Test(priority = 1)
	public void postPetTest() {
		Response response = PetEndpoints.createNewPet(petPayload);
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 2)
	public void getPetTest() {
		Response response = PetEndpoints.readPet(petPayload.getId());
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 3)
	public void updatePetTest() {
		petPayload.setName(faker.animal().name());
		
		Response response = PetEndpoints.updatePet(petPayload);
		response.then().log().all();
		System.out.println(response.statusCode());
		assertEquals(response.statusCode(), 200);
		//check the status code after updating the pet name
		Response responseAfterUpdate  = PetEndpoints.readPet(petPayload.getId());
		responseAfterUpdate.then().log().all();
		assertEquals(responseAfterUpdate.statusCode(), 200);
		
	}
	
	@Test(priority = 4)
	public void deletePetTest() {
		Response response = PetEndpoints.deletePet(petPayload.getId());
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
}
