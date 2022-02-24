package dados;

public class User {
    private int id;
    private String login;
    private String senha;

    public User(int id, String login, String senha){
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public User(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

}
