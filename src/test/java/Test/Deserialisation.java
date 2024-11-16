package Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import Dpojo.Getcourses;
import Dpojo.webAutomation;

public class Deserialisation {

	public static void main(String[] args) {
		//get access token
		
		String [] ex= {"Selenium Webdriver Java","Cypress","Protractor"};
		
		List<String> expected = Arrays.asList(ex);
		
		
		String token = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		
		JsonPath js=new JsonPath(token);
		
		String access_token = js.getString("access_token");
		
		Getcourses js1 = given().queryParam("access_token", access_token)
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(Getcourses.class);
		
		
		
		System.out.println(js1.getLinkedIn());
		
		String courseTitle = js1.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(courseTitle);
		
		List<webAutomation> webAutomation = js1.getCourses().getWebAutomation();
		
		ArrayList<String> actual=new ArrayList<String>();
		
		for(int i=0; i<webAutomation.size(); i++) {
			String li = webAutomation.get(i).getCourseTitle();
			System.out.println(li);
			
			actual.add(li);
		}

		Assert.assertEquals(expected, actual);
	}

}
