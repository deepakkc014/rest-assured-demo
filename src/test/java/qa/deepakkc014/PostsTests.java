package qa.deepakkc014;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Posts API Tests")
public class PostsTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @Description("Verify GET /posts returns list of posts")
    public void testGetAllPosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].id", equalTo(1))
                .body("[0].userId", notNullValue())
                .body("[0].title", notNullValue())
                .body("[0].body", notNullValue())
                .body("", hasSize(greaterThan(0)));
    }

    @Test
    @Description("Verify GET /posts/{id} returns specific post")
    public void testGetPostById() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("userId", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue());
    }

    @Test
    @Description("Verify GET /posts/{id} with invalid ID returns 404")
    public void testGetPostInvalidId() {
        given()
                .pathParam("id", 999)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    @Description("Verify POST /posts creates a new post")
    public void testCreatePost() {
        String requestBody = "{\"userId\": 1, \"title\": \"test title\", \"body\": \"test body\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("userId", equalTo(1))
                .body("title", equalTo("test title"))
                .body("body", equalTo("test body"));
    }

    @Test
    @Description("Verify PUT /posts/{id} updates a post")
    public void testUpdatePost() {
        String requestBody = "{\"id\": 1, \"userId\": 1, \"title\": \"updated title\", \"body\": \"updated body\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", 1)
                .when()
                .put("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("updated title"))
                .body("body", equalTo("updated body"));
    }

    @Test
    @Description("Verify DELETE /posts/{id} deletes a post")
    public void testDeletePost() {
        given()
                .pathParam("id", 1)
                .when()
                .delete("/posts/{id}")
                .then()
                .statusCode(200);
    }
}
