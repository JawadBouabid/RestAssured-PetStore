package endpoints;

/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {
	
	public static String base_url = " https://petstore.swagger.io/v2";

	// user module

	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	//pet user
	
	public static String post_pet_url = base_url + "/pet";
	public static String get_pet_url = base_url + "/pet/{petId}";
	public static String put_pet_url = base_url + "/pet";
	public static String delete_pet_url = base_url + "/pet/{petId}";

}
