package models;

public class PlayerUpdateRequest extends BasePlayer{

    private String login;
    private String password;
    private String role;

    public PlayerUpdateRequest(String login, String password, String screenName, String gender, Integer age, String role){
        super(screenName, gender, age);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
