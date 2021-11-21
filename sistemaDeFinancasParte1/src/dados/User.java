package dados;

public class User {
    private String login;
    private String senha;

    public User(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public User(){
        this.login = null;
        this.senha = null;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean setNovoLogin(String oldLogin, String newLogin) {
        if(oldLogin.equals(login)){
            login = newLogin;
            return true;
        }else{
            return false;
        }
    }

    public boolean setNovaSenha(String oldSenha, String newSenha) {
        if(oldSenha.equals(senha)){
            senha = newSenha;
            return true;
        }else{
            return false;
        }
    }

}
