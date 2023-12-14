package tests;

import specs.Specifications;
import models.PlayerId;
import models.FullPlayerData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPlayerByPlayerIdTests extends BaseTest {

    @Test
    public void getPlayerByIdTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecOK200());
        Integer trueId = 1;
        String role = "supervisor";
        PlayerId playerId = new PlayerId(trueId);

        //Act
        FullPlayerData fullPlayerData = given()
                .body(playerId)
                .when()
                .post("get")
                .then().log().all()
                .extract().as(FullPlayerData.class);

        //Assert
        Assert.assertNotNull(fullPlayerData.getRole(), "The player's role should not Null");
        Assert.assertEquals(role, fullPlayerData.getRole(), "Wrong player");
    }

    @Test
    public void getPlayerByWrongIdTest(){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecError404());
        Integer falseId = 999;
        PlayerId playerId = new PlayerId(falseId);

        given()
                .body(playerId)
                .when()
                .post("get");
    }
}
