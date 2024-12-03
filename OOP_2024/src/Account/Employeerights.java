package Account;
import java.util.Scanner;
import Product.*;
import ORDER.*;
import Person.*;

public class Employeerights extends Account {
    Kho KhoHang = new Kho();
    Scanner sc = new Scanner(System.in);
    customers cusList = new CustomerList();
    ProductMenu mainSP = new ProductMenu();
    order order = new order();
    cartDetailsArray billdetail = new BillDetail(order);
    MainGioHang mainGh = new MainGioHang();
    MainTestMuahang mainMh = new MainTestMuahang();
    ListAccount listacc = new ListAccount();

    public Employeerights() {
        super();
    }

    public Employeerights(String password, String username, String confirm) {

    }

    public void CreateBill() {

        billdetail.getBillDetail();
        billdetail.writeToFile();
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
                    cusList.readFile();
                    cusList.getListCustomer();
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
            System.out.println("1 : Tao hoa don              |");
            System.out.println("2 : Kho - Storage            |");
            System.out.println("3 : Thong tin khach hang     |");
            System.out.println("4 : Tao don hang             |");
            System.out.println("0 : Thoat                    |");
            System.out.println("+----------------------------+");
            System.out.print("Nhap lua chon : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    try {
                        if (listacc.isFileEmpty()) {
                            System.out.println("Don hang trong. Moi ban tao don hang truoc khi tao hoa don!");
                        } else {
                            CreateBill();
                        }
                        listacc.deleteFileghiorder();
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    menuStorage();
                    break;
                case 3:
                    InforCustomers();
                    break;
                case 4:
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
