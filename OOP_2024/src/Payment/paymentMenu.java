package Payment;

import java.util.ArrayList;
import java.util.Scanner;

public class paymentMenu {
public static void main(String[] args) {
        ArrayList<payment> hoadon = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int z;
        while (true) {
            System.out.println("---------------MENU----------------");
            System.out.println("Chon phuong thuc thanh toan:");
            System.out.println("1.Thanh toan bang tien mat");
            System.out.println("2.Thanh toan bang the ngan hang");
            System.out.println("3.Xem cac hoa don thanh toan");
            System.out.println("4.Xoa cac hoa don da duoc luu");
            System.out.println("5.Thoat");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon : ");
            z = sc.nextInt();
            sc.nextLine();
            if (z == 1) {
                cashPayment tienmat = new cashPayment();
                tienmat.setPhuongthuctt("Tien mat");
                tienmat.nhap();
                hoadon.add(tienmat);
                payment.ghifile(hoadon, true);
                payment.docFile("incart.txt");
                System.out.println("Thanh toan bang tien mat da duoc them");
            } else if (z == 2) {
                creditCardPayment thenh = new creditCardPayment();
                thenh.setPhuongthuctt("The ngan hang");
                thenh.nhap();
                hoadon.add(thenh);
                payment.ghifile(hoadon, true);
                payment.docFile("incart.txt");
                System.out.println("Thanh toan bang the da duoc them");
            } else if (z == 3) {
                System.out.println("Danh sach hoa don : ");
                for (int i = 0; i < hoadon.size(); i++) {
                    payment pay = hoadon.get(i);
                    System.out.println(pay.toString());
                }
            } else if (z == 4) {
                hoadon.clear();
                payment.ghifile(hoadon, false);
                System.out.println("Da xoa tat ca hoa don");
            } else if (z == 5) {
                System.out.println("Thoat");
                break;
            } else {
                System.out.println("Lua chon khong hop le, hay chon lai");
            }
        }
    }
}
