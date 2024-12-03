package Payment;
import java.util.ArrayList;
import java.util.Scanner;
public class paymentMenu {
    public void paymentmenu() {
        Scanner sc = new Scanner(System.in);
        int z;
        while (true){
            System.out.println("---------------MENU----------------");
            System.out.println("Chon chuc nang : ");
            System.out.println("1.Thanh toan bang tien mat");
            System.out.println("2.Thanh toan bang the");
            System.out.println("3.Xem cac thanh toan da thuc hien");
            System.out.println("4.Xoa cac thanh toan da luu");
            System.out.println("5.Sua thong tin hoa don da luu");
            System.out.println("6.Thoat");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon : ");
            z = sc.nextInt();
            sc.nextLine();
            if(z==1){
                cashpayment tienmat = new cashpayment();
                tienmat.setPhuongthuctt("Tien mat");
                tienmat.nhap();
                ArrayList<payment> hoadonTam = new ArrayList<>();
                hoadonTam.add(tienmat);
                payment.ghifile(hoadonTam, true);
                System.out.println("Thanh toan da duoc them");
            } 
            else if(z==2){
                cardpayment thenh = new cardpayment();
                thenh.setPhuongthuctt("The ngan hang");
                thenh.nhap();
                ArrayList<payment> hoadonTam = new ArrayList<>();
                hoadonTam.add(thenh);
                payment.ghifile(hoadonTam,true);
                System.out.println("Thanh toan da duoc them");
            } 
            else if (z==3){
                System.out.println("Danh sach cac thanh toan da thuc hien : ");
                payment.docFile("incart.txt");
            } 
            else if (z==4){
                payment.ghifile(new ArrayList<>(),false);
                System.out.println("Da xoa tat ca thanh toan");
            } 
            else if(z==5){
                paymentmodify.suathongtin();
            }
            else if(z==6){
                System.out.println("Thoat");
                break;
            } 
            else{
                System.out.println("Lua chon khong hop le, hay chon lai");
            }
        }
    }
}
