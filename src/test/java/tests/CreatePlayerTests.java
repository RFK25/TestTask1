package tests;

import models.FullPlayerData;
import org.testng.Assert;
import org.testng.annotations.Test;
import specs.Specifications;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreatePlayerTests extends BaseTest {

    private static final String ENDPOINT = "create/";

    @Test
    public void createPlayerTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecOK200());
        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 1000;
        String editor = "supervisor/";
        String login = "login" + randomNumber;
        String password = "pass" + randomNumber;
        String name = "Name" + randomNumber;
        String gender = "male";
        int age = 20;
        String role = "user";

        //Act
        FullPlayerData createdUser = given()
                .param("age", age)
                .param("gender", gender)
                .param("login", login)
                .param("password", password)
                .param("role", role)
                .param("screenName", name)
                .when()
                .get(ENDPOINT + editor)
                .then().log().all()
                .extract().as(FullPlayerData.class);

        //Assert
        Assert.assertEquals(login, createdUser.getLogin());
        Assert.assertEquals(createdUser.getScreenName(), name);
        Assert.assertEquals(createdUser.getGender(), gender);
        Assert.assertEquals(createdUser.getPassword(), password);
        Assert.assertEquals(createdUser.getAge(), age);
        Assert.assertEquals(createdUser.getRole(), role);
    }

    @Test
    public void createPlayerWithWrongGenderTest(){
        //Arrange
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.responseSpecForbidden403());
        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 1000;
        String editor = "supervisor/";
        String login = "login" + randomNumber;
        String password = "pass" + randomNumber;
        String name = "Name" + randomNumber;
        String gender = "helicopter";
        int age = 20;
        String role = "user";

        //Act
        given()
                .param("age", age)
                .param("gender", gender)
                .param("login", login)
                .param("password", password)
                .param("role", role)
                .param("screenName", name)
                .when()
                .get(ENDPOINT + editor)
                .then().log().all();
    }
}
