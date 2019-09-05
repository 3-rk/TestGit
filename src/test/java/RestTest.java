
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.sql.Timestamp;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class RestTest {

    public String createTimeStamp() {
        // create time stamp
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp( time );
        System.out.println( "Current Time Stamp: " + ts );

        String s = ts.toString();
        String t = s.replaceAll( "-", "" ).replace( ".", "" ).replace( " ", "" );
        String timeStmp = t.replaceAll( ":", "" ).trim();
        System.out.println( timeStmp );
        // return timestamp created
        return timeStmp;
    }

    @Test
    public void createEmployee1() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        String ts = createTimeStamp();
        String empName = "EMP" + ts;


        String requestBody = "{\n" +
                "  \"name\": \"" + empName + "\",\n" +
                "  \"salary\": \"5000\",\n" +
                "  \"age\": \"20\"\n" +
                "}";


        Response response = null;


        try {
            response = RestAssured.given()
                    .contentType( ContentType.JSON )
                    .body( requestBody )
                    .post( "/create" );
//            then().assertThat().body("name",response.jsonPath().get( "name" ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonPath jpo = response.jsonPath();

        //validation using jason response
        System.out.println( "Response :" + response.asString() );
        System.out.println( "Status Code :" + response.getStatusCode() );
        System.out.println( "Does Reponse contains name? :" + response.asString().contains( empName ) );

//validation using json path
        System.out.println( "name " + jpo.get( "name" ) );
        System.out.println( "sal " + jpo.get( "salary" ) );
        System.out.println( "age " + jpo.get( "age" ) );

        assertEquals( 200, response.getStatusCode() );
    }


    // @Test
//    public void createEmployee() {
//
//        // create time stamp
//        Date date= new Date();
//        long time = date.getTime();
//        Timestamp ts = new Timestamp(time);
//        System.out.println("Current Time Stamp: " + ts);
//
//        String s = ts.toString();
//        String t= s.replaceAll( "-","" ).replace( ".","" ).replace(" ","");
//        String timeStmp = t.replaceAll( ":","" ).trim();
//        System.out.println(timeStmp);
//
//
//        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
//
//        String requestBody = "{\n" +
//                "  \"name\": \"Emp"+timeStmp+"\",\n" +
//                "  \"salary\": \"5000\",\n" +
//                "  \"age\": \"20\"\n" +
//                "}";
//
//
//        Response response = null;
//        JsonPath jpo = response.jsonPath();
//
//        try {
//            response =  RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .body(requestBody)
//                    .post("/create");
//
//                   // response.then().body("name",Matchers.equalToIgnoringCase( "Emp"+timeStmp));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Response :" + response.asString());
//        System.out.println("Status Code :" + response.getStatusCode());
//        System.out.println("Does Reponse contains Emp name : "+ response.asString().contains("Emp"+timeStmp));
//
//        System.out.println("name "+jpo.get("name"));
//        System.out.println("sal "+jpo.get("salary"));
//        System.out.println("age "+jpo.get("age"));
//
//        assertEquals(200, response.getStatusCode());
//
//
//    }

//    @Test
//    public void GetWeatherDetails() {
//
//      //  RestAssured.baseURI = "http://restapi.demoqa.com";
//        //given().urlEncodingEnabled(true)
//          //      .param("cityName", "Hyderabad")
//
//            //    .header("Accept", ContentType.JSON.getAcceptHeader())
//              //  .post("/utilities/weather/city")
//                //.then()
//                //.extract();
////        Response r = given();
////        String resp = r.getBody().asString();
////        System.out.println(resp);
//
//        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//        String cityName = "Hyderabad";
//
//         Response r = (Response) given()
//                .contentType("application/json")
//                .pathParam( "city", cityName ).
//         when().
//               post("/{city}").then().
//        statusCode( 200 );
//
//                    String resp = r.getBody().asString();
//                    System.out.println(resp);
//
//                          //  assertThat().
//
//                            //body( "city",equalToIgnoringCase( "Hyderabad" ) );
//
//
//
//
////        String myJson = "{\"name\":\"Jimi Hendrix\"}";
////        RestAssured.baseURI  = "http://127.0.0.1:5984/restassured";
////
////        Response r = given()
////                .contentType("application/json").
////                        body("{\"name\":\"Jimi Hendrix\"}").
////                        when().
////                        post("");
////
////        String body = r.getBody().asString();
////        System.out.println(body);
//
//
////        int statusCode = response.getStatusCode();
////        Assert.assertEquals(statusCode, "201");
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//        // Specify the base URL to the RESTful web service
////        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
////
////        RequestSpecification httpRequest = given();
//////
////        Response response = httpRequest.request( Method.GET, "/Hyderabad" );
//////
////        int statusCode = response.getStatusCode();
////        String responseBody = response.getBody().asString();
////        System.out.println( "Response Body is =>  " + responseBody );
//
////            RestAssured.baseURI = "http://restapi.demoqa.com";
////            String cityName = "Hyderabad";
////
////              given().
////                pathParam( "city", cityName ).
////                when().
////                get( baseURI+"/utilities/weather/city/{city}" ).
////                then().
////                      assertThat().
////                body("City",equalTo("Hyderabad"));
//
////        String season = "2017";
////        int numberOfRaces = 20;
////
////        given().
////                pathParam("raceSeason",season).
////                when().
////                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
////                then().
////                assertThat().
////                body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
////
////
//
////                    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
////            RequestSpecification httpRequest = RestAssured.given();
////            Response response = httpRequest.get("/Hyderabad");
////
////            // First get the JsonPath object instance from the Response interface
////            JsonPath jsonPathEvaluator = response.jsonPath();
////
////            // Let us print the city variable to see what we got
////            System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
////
////            // Print the temperature node
////            System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
////
////            // Print the humidity node
////            System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
////
////            // Print weather description
////            System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
////
////            // Print Wind Speed
////            System.out.println("City wind speed received from Response " + jsonPathEvaluator.get("WindSpeed"));
////
////            // Print Wind Direction Degree
////            System.out.println("City wind direction received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
//
//

    //}
}