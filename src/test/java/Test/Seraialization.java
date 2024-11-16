package Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Spojo.Add;
import Spojo.location;

public class Seraialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Add a=new Add();
		a.setAccuracy(50);
		a.setAddress("29, side layout, cohen 09");
		a.setLanguage("French-IN");
		a.setName("Frontline house");
		a.setPhone_number("(+91) 983 893 3937");
		a.setWebsite("http://google.com");
	//////////////////////////////////////////////////////////	
		List<String>b=new ArrayList<String>();
		b.add("shoe park");
		b.add("shop");
		
		a.setTypes(b);
	/////////////////////////////////////////////////////////////
		location l=new location();
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		a.setLocation(l);
		
		
		
		
		
		//RestAssured.basePath="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").body(a)
		
		.when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		
		

	}

}
