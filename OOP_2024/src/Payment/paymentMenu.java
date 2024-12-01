import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<payment> hoadon = new ArrayList<>();
        while (true){
            System.out.println("---------------MENU----------------");
            System.out.println("Chon phuong thuc thanh toan : ");
            System.out.println("1. Thanh toan bang tien mat");
            System.out.println("2. Thanh toan bang the ngan hang");
            System.out.println("3. Xem cac hoa don thanh toan");
            System.out.println("4. Sua doi thong tin hoa don");
            System.out.println("5. Xoa cac hoa don da duoc luu");
            System.out.println("6. Thoat");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon: ");
            int z = sc.nextInt();
            sc.nextLine();
            if (z == 1){
                cashpayment cash = new cashpayment();
                cash.nhap();
                hoadon.add(cash);
            }
            else if (z == 2){
                cardpayment card = new cardpayment();
                card.nhap();
                hoadon.add(card);
            }
            else if (z == 3){
                payment.ghifile(hoadon, true);
                System.out.println("Danh sach hoa don :");
                payment.docFile("incart.txt");
            }
            else if (z == 4){
                System.out.print("Nhap so thu tu hoa don can sua : ");
                int index = sc.nextInt() - 1;
                sc.nextLine();
                if (index >= 0 && index < hoadon.size()){
                    hoadon.get(index).nhap();
                } else{
                    System.out.println("Hoa don khong ton tai");
                }
            }
            else if (z == 5) {
                hoadon.clear();
                System.out.println("Da xoa tat ca hoa don");
            }
            else if (z == 6){
                System.out.println("Thoat");
                return;
            }
            else{
                System.out.println("Lua chon khong hop le, hay chon lai");
            }
        }
    }
}