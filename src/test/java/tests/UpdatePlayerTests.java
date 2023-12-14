package tests;

import models.PlayerUpdateRequest;
import models.UpdatedUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import specs.Specifications;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class UpdatePlayerTests extends BaseTest {

    private static final String ENDPOINT = "update/";

    @Test
    public void updatePlayerTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecOK200());
        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 1000;
        int id = 288624726;
        String editor = "supervisor/";
        String login = "login" + randomNumber;
        String password = "pass" + randomNumber;
        String name = "Name" + randomNumber;
        String gender = "male";
        int age = 20;
        String role = "user";
        PlayerUpdateRequest playerUpdReq = new PlayerUpdateRequest(login, password, name, gender, age, role);

        //Act
        UpdatedUser updatedUser = given()
                .body(playerUpdReq)
                .when()
                .patch(ENDPOINT + editor + id)
                .then().log().all()
                .extract().as(UpdatedUser.class);

        //Assert
        Assert.assertEquals(updatedUser.getLogin(), login);
        Assert.assertEquals(updatedUser.getScreenName(), name);
        Assert.assertEquals(updatedUser.getGender(), gender);
        Assert.assertEquals(updatedUser.getAge(), age);
        Assert.assertEquals(updatedUser.getRole(), role);
    }

    @Test
    public void updatePlayerWithWrongDataTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecForbidden403());
        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 1000;
        int id = 288624726;
        String editor = "supervisor/";
        String login = "login" + randomNumber;
        String password = "pass" + randomNumber;
        String name = "Name" + randomNumber;
        String gender = "helicopter";
        int age = 15;
        String role = "supervisor";
        PlayerUpdateRequest playerUpdReq = new PlayerUpdateRequest(login, password, name, gender, age, role);

        //Act
        given()
                .body(playerUpdReq)
                .when()
                .patch(ENDPOINT + editor + id)
                .then().log().all();
    }
}
