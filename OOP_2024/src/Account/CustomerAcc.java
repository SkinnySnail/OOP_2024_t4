package Account;
import java.util.Scanner;
import Product.*;

public class CustomerAcc extends Account {
    Scanner sc = new Scanner(System.in);
    MainTestMuahang mainMh = new MainTestMuahang();
    ListAccount listacc = new ListAccount();

    public CustomerAcc() {
        super();
    }

    

    public CustomerAcc(String password, String username, String confirm) {
        super(password, username, confirm);
    }



    public CustomerAcc(String password, String username, String confirm, String role) {
        super(password,username,confirm);
        this.role="CUS";
    }
    public void createOrder() {
        // mainGh.menuGH();
        mainMh.menuMh();
        // order.inputOrderInfo();
        // order.displayOrderInfo();
    }

    public void CustomerManeger() {
        createOrder();

    }

    public static void main(String[] args) {
        CustomerAcc cus1 = new CustomerAcc();
        cus1.CustomerManeger();
    }
}


