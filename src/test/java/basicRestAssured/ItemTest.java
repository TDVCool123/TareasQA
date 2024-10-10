package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ItemTest {
    @Test
    @DisplayName("Verify Create Read Update Delete Project - Todo.ly")
    public void verifyCRUDProject(){
        JSONObject body = new JSONObject();
        body.put("Content","Testing item type");
        body.put("ProjectId",4357952);

        // create
        Response response = given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json");
        response.then()
                .statusCode(200)
                .body("Content",equalTo(body.get("Content")))
                .body("ProjectId",equalTo(body.get("ProjectId")))
                .log().all();

        int id = response.then().extract().path("Id");
        // read
        response = given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .log().all()
                .when()
                .get("https://todo.ly/api/items/"+id+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo(body.get("Content")))
                .body("ProjectId",equalTo(body.get("ProjectId")))
                .log().all();
        // update
        body.put("Content","RESTUPDATE");
        body.put("DueDate","2024/11/24");
        body.put("Priority",2);

        response = given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .put("https://todo.ly/api/items/"+id+".json");

        response.then()
                .statusCode(200)
                .body("ProjectId",equalTo(body.get("ProjectId")))
                .body("Content",equalTo("RESTUPDATE"))
                .body("DueDate",equalTo("24 Nov 12:00 AM"))
                .body("Priority",equalTo(body.get("Priority")))
                .log().all();
        // delete

        response = given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .log().all()
                .when()
                .delete("https://todo.ly/api/items/"+id+".json");
        response.then()
                .statusCode(200)
                .body("Content",equalTo("RESTUPDATE"))
                .body("ProjectId",equalTo(body.get("ProjectId")))
                .body("DueDate",equalTo("24 Nov 12:00 AM"))
                .body("Priority",equalTo(body.get("Priority")))
                .body("Deleted",equalTo(true))
                .log().all();
    }
}
