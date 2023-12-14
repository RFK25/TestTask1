package models;

public class BasePlayer {

    private String screenName;
    private String gender;
    private Integer age;

    public BasePlayer(String screenName, String gender, Integer age){
        this.screenName = screenName;
        this.gender = gender;
        this.age = age;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }
}
