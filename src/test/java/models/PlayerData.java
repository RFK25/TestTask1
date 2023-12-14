package models;

import tests.BaseTest;

public class PlayerData extends BasePlayer {

    private Integer id;

    public PlayerData(Integer id, String screenName, String gender, Integer age){
        super(screenName, gender, age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
