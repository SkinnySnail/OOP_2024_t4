package Account;
import java.util.Scanner;
import Product.*;
import ORDER.*;
import Person.*;

public class Employeerights extends Account {
    Kho KhoHang = new Kho();
    Scanner sc = new Scanner(System.in);
    DSKH cusList = new DSKH();
    ProductMenu mainSP = new ProductMenu();
    order order = new order();
    MainGioHang mainGh = new MainGioHang();
    MainTestMuahang mainMh = new MainTestMuahang();
    ListAccount listacc = new ListAccount();

    public Employeerights() {
        super();
    }

    

    public Employeerights(String password, String username, String confirm) {
        super(password, username, confirm);
    }



    public Employeerights(String password, String username, String confirm,String role) {
        super(password,username,confirm);
        this.role="EMP";
    }


    public void InforCustomers() {
        // int exit;
        int chon;
        do {
            System.out.println("-----------Info_Cus----------+");
            System.out.println("1 : Xem thong tin Customers  |");
            System.out.println("2 : xoa thong tin            |");
            System.out.println("3 : Them thong tin           |");
            System.out.println("0 : Thoat                    |");
            System.out.println("-----------------------------+");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    cusList.docFile(confirm);
                    cusList.displayTTKH();
                    break;
                // case 2:
                // cusList.Xoa();
                // break;
                // case 3:
                // cusList.Nhap();
                // break;
                case 0:

                    break;

                default:
                    break;
            }
            // System.out.println("Press : 0 to exit || 1 to continue");
            // exit = sc.nextInt();
        } while (chon != 0);
    }

    public void menuStorage() {
        KhoHang.docDataTuFile();
        KhoHang.inKho();
    }

    public void createOrder() {
        // mainGh.menuGH();
        mainMh.menuMh();
        // order.inputOrderInfo();
        // order.displayOrderInfo();
    }

    public void EmployeeManeger() {
        int exit, choose;
        do {
            System.out.println("+----------EMPLOYEE----------+");
            System.out.println("1 : Kho - Storage            |");
            System.out.println("2 : Thong tin khach hang     |");
            System.out.println("3 : Tao don hang             |");
            System.out.println("0 : Thoat                    |");
            System.out.println("+----------------------------+");
            System.out.print("Nhap lua chon : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    menuStorage();
                    break;
                case 2:
                    InforCustomers();
                    break;
                case 3:
                    createOrder();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Press : 1 to continue || 0 to exit (EMPLOYEE)");
            exit = sc.nextInt();
        } while (exit == 1);
    }

    public static void main(String[] args) {
        Employeerights empl = new Employeerights();
        empl.EmployeeManeger();
    }
}
