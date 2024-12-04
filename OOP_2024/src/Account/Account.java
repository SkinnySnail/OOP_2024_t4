package Account;
import java.util.Scanner;

public class Account {
    public String password;
    public String username;
    public String confirm;
    public String role;
    Scanner sc = new Scanner(System.in);

    public Account() {
        password = "";
        username = "";
        confirm = "";
    }

    public Account(String password, String username, String confirm) {
        this.password = password;
        this.username = username;
        this.confirm = confirm;
    }

    

    public Account(String password, String username, String confirm, String role) {
        this.password = password;
        this.username = username;
        this.confirm = confirm;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setPassword() {
        password = sc.nextLine();
    }

    public void setUsername() {
        username = sc.nextLine();
    }

    public void setConfirm() {
        confirm = sc.nextLine();
    }

    public static void main(String[] args) {

    }
}
