package tests;

import models.PlayerId;
import org.testng.annotations.Test;
import specs.Specifications;

import static io.restassured.RestAssured.given;

public class DeletePlayerTests extends BaseTest {

    private static final String ENDPOINT = "delete/supervisor";

    @Test
    public void deletePlayerByIdTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecNoContent204());
        Integer userToDeleteId = 2096433072;
        PlayerId playerId = new PlayerId(userToDeleteId);

        //Act
        given()
                .body(playerId)
                .when()
                .delete(ENDPOINT)
                .then().log().all();
    }

    @Test
    public void deletePlayerWithSupervisorRoleTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecForbidden403());
        Integer userToDeleteId = 1;
        PlayerId playerId = new PlayerId(userToDeleteId);

        //Act
        given()
                .body(playerId)
                .when()
                .delete(ENDPOINT)
                .then().log().all();
    }
}
