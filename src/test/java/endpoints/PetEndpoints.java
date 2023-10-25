package endpoints;


import static io.restassured.RestAssured.given;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.codehaus.groovy.transform.sc.StaticCompilationMetadataKeys;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Pet;

public class PetEndpoints {
	
	public static Response createNewPet(Pet payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.when().post(Routes.post_pet_url);
				return response;
	}
	
	public static Response readPet(int petId) {
		Response response = given().pathParam("petId", petId).when().get(Routes.get_pet_url);
		return response;
	}
	
	public static Response updatePet(Pet payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.when().put(Routes.put_pet_url);
		return response;
				
	}
	
	public static Response deletePet(int petId) {
		Response response = given().pathParam("petId", petId).when().delete(Routes.delete_pet_url);
		return response; 
	}
}
