package Main;
import java.util.Scanner;
import Account.*;


public class Trangchu  {
    Employeerights emp = new Employeerights();
    CustomerAcc cus = new CustomerAcc();
    ListAccount list = new ListAccount();
    Scanner sc = new Scanner(System.in);
    String taikhoan;
    String matkhau;

    public void Menu() {
        System.out.println("                          =================================================");
        System.out.println("                          CHAO MUNG DEN VOI CUA HANG BAN DO VAN PHONG PHAM");
        System.out.println("                          =================================================");
        System.out.println();
        System.out.println("---------------Dang nhap de chuyen huong den trang tuong ung------------------");
        System.out.println();
        boolean isValidLogin = false;

        while (!isValidLogin) {
            System.out.print("Ten tai khoan: ");
            taikhoan = sc.nextLine();
            System.out.println();
            System.out.print("Mat khau: ");
            matkhau = sc.nextLine();
            list.readAccount();
            if (taikhoan.matches("^EMP[0-9]{3}$")  && list.TKandMK(taikhoan, matkhau)) {
                emp.EmployeeManeger();
                isValidLogin = true;
                }
       else if (taikhoan.matches("^CUS[0-9]{3}$")  && list.TKandMK(taikhoan, matkhau)) {
            cus.CustomerManeger();
            isValidLogin = true;
            }
            else {
                System.out.println();
                System.out.println("Ten tai khoan hoac mat khau khong hop le. Vui long nhap lai !");
                System.out.println();
            }
        }
    }

    public void readFile() {
        try {
            list.readAccount();
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Trangchu trangchu = new Trangchu();
        trangchu.readFile();
        trangchu.Menu();
    }
}
