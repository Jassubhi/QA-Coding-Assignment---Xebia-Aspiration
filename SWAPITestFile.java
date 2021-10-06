import static io.restassured.RestAssured.get;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SWAPITestFile {
private static String api = "https://swapi.dev/";
	

	//Test to verify the people endpoint.
	@Test(priority = 1)
	public static void verifyEndpoint() {
		int code = get(api).getStatusCode();
		System.out.println("Status code:" + code);
		Assert.assertEquals(200, code);
	}
	
	//Test verifying the peoples with height more than 200,their names and total count of peoples.
	@Test(priority = 2)
	public static void verifyHeightMoreThan200() {
		int count = 0;
		int peopleCount = 0;
	
		//List to capture the name of people having height more than 200.
		List<String> names = new ArrayList<String>();
		for(int j=1; j < 10; j++) {
			String page = get( api + "/api/people/?page="+j).then().extract().response().asString();
			JsonPath js = new JsonPath(page);
			int size = js.getInt("results.size()");
			//Looping through each displayed page
			for(int i = 0; i < size; i++) {
				peopleCount++;
				if(js.get("results["+i+"].height").equals("unknown")) {
					continue;
				}
				int heights = js.getInt("results["+i+"].height");
				//Capture names of people more height than 200 in a list.
				if(heights > 200) {
					count += 1;
					String name = js.getString("results["+i+"].name");
					names.add(name);
				}	
			}
		}
	
		System.out.println("Total count of people with height greater than 200 =" + count);
		
		//Verify that the total number of people where height is greater than 200.
		Assert.assertEquals(10,count);
		
		
		//Verify that the 10 individuals returned are: Darth Vader,
		//Chewbacca, Roos Tarpals, Rugor Nass, Yarael Poof, Lama Su,
		//Tuan Wu, Grievous, Tarfful, Tion Medon.
		Assert.assertEquals(names.get(0), "Darth Vader");
        Assert.assertEquals(names.get(1), "Chewbacca");
        Assert.assertEquals(names.get(2), "Roos Tarpals");
        Assert.assertEquals(names.get(3), "Rugor Nass");
        Assert.assertEquals(names.get(4), "Yarael Poof");
        Assert.assertEquals(names.get(5), "Lama Su");
        Assert.assertEquals(names.get(6), "Taun We");
        Assert.assertEquals(names.get(7), "Grievous");
        Assert.assertEquals(names.get(8), "Tarfful");
        Assert.assertEquals(names.get(9), "Tion Medon");
        
        //Verify that the total number of people checked equals the expected count.
        System.out.println("Total people count: " + peopleCount );
        Assert.assertEquals(peopleCount, 82);
	}
}
