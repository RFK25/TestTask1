package models;

public class FullPlayerData extends BasePlayer {

    private Integer id;
    private String login;
    private String password;
    private String role;

    public FullPlayerData(Integer id, String login, String password, String screenName, String gender, Integer age, String role){
        super(screenName, gender, age);
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
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
