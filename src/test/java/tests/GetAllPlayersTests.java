package tests;

import specs.Specifications;
import models.PlayerData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllPlayersTests extends BaseTest {

    private static final String ENDPOINT = "get/all";

    @Test
    public void getAllUsersTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecOK200());

        //Act
        List<PlayerData> users = given()
                .when()
                .get(ENDPOINT)
                .then().log().all()
                .extract().body().jsonPath().getList( "players", PlayerData.class);

        //Assert
        Assert.assertFalse(users.isEmpty());
    }
}
