package com.kloia.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class Tasks {
    @BeforeClass
    public void beforeclass() {
        RestAssured.baseURI = ("https://petstore.swagger.io/v2");
    }
    Long createdPetId;

    @Test
    public void Task1Post() {
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "\"category\": {\n" +
                        "\"id\": 0,\n" +
                        "\"name\": \"Pets\"\n" +
                        "},\n" +
                        "\"name\": \"Scout\",\n" +
                        "\"photoUrls\": [\n" +
                        "\"scout.png\"\n" +
                        "],\n" +
                        "\"tags\": [\n" +
                        "{\n" +
                        "\"id\": 0,\n" +
                        "\"name\": \"pet-dog\"\n" +
                        "}\n" +
                        "],\n" +
                        "\"status\": \"available\"\n" +
                        "}")
                .when().post("/pet");
        response.prettyPrint();
        //validation
        //verify status code is 200
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertNotNull(response.path("id"), "Response has an id");
        Assert.assertEquals(response.path("name"), "Scout");
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));

        createdPetId = response.path("id");

    }

    @Test
    public void Task2Get() {

        long id = createdPetId;
        given().accept(ContentType.JSON)
                .and().pathParam("id",id )
                .when().get(baseURI + "/pet/{id}")
                .then().statusCode(200)
                .and().header("Date",notNullValue())
                .and().assertThat().contentType(equalTo("application/json"))
                .and().assertThat().body("id",equalTo(id),
                "name", equalTo("Scout"),
                "category.id", equalTo(0),
                "category.name", equalTo("Pets"),
                "photoUrls[0]",equalTo("scout.png"),
                "tags.id[0]",equalTo(0),"tags.name[0]",equalTo("pet-dog"),
                "status",equalTo("available"));
    }

    @Test
    public void Task3Delete() {
        Long idToDelete =createdPetId;

        given().pathParam("id", idToDelete)
                .when().delete(baseURI + "/pet/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType(equalTo("application/json"))
                .and().assertThat()
                .body("message",equalTo(String.valueOf(idToDelete)),
                "type",equalTo("unknown"));

        //verify part
        given().pathParam("id",idToDelete)
                .when().delete(baseURI + "/pet/{id}")
                .then().assertThat().statusCode(404);
    }


}
