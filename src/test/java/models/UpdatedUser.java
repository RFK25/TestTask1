package models;

public class UpdatedUser extends BasePlayer {

    private Integer id;
    private String login;
    private String role;

    public UpdatedUser(Integer id, String login, String screenName, String gender, Integer age, String role){
        super(screenName, gender, age);
        this.id = id;
        this.login = login;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }
}
