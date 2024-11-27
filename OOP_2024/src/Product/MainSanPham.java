package Product;

import java.io.File;
import java.util.Scanner;

public class MainSanPham {
    Kho khoHang = new Kho();

    public void menuProduct() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        File f = new File("./dataSanPham.txt");
        do {
            System.out.println("--------------Quan_Li_KHO------------+");
            System.out.println("1. Them vao kho.                     |");
            System.out.println("2. Xoa san pham khoi kho.            |");
            System.out.println("3. Tim kiem san pham theo maSP.      |");
            System.out.println("4. Don dep kho.                      |");
            System.out.println("5. In toan bo kho.                   |");
            System.out.println("6. Ghi du lieu xuong file.           |");
            System.out.println("7. Doc du lieu tu file.              |");
            System.out.println("0. Thoat                             |");
            System.out.println("-------------------------------------+");
            System.out.print("Nhap lua chon : ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                khoHang.docDataTuFile();
                khoHang.themVaoKho();
                khoHang.ghiDataXuongFile();
            } else if (choice == 2) {
                System.out.println("Nhap vao vi tri muon xoa: ");
                // String maSP = sc.nextLine();
                khoHang.xoaSP(sc.nextInt());
            } else if (choice == 3) {
                System.out.println("Nhap vao maSP muon tim: ");
                khoHang.timkiemSanPham(sc.nextLine());
            } else if (choice == 4) {
                System.out.print("Ban co chac chan khong(true/false): ");
                Boolean confirm = sc.nextBoolean();
                if (confirm == true) {
                    khoHang.clearKho();
                }
            } else if (choice == 5) {
                khoHang.docDataTuFile();
                khoHang.inKho();
            } else if (choice == 6) {
                khoHang.ghiDataXuongFile();
            } else if (choice == 7) {
                khoHang.docDataTuFile();
            } 
        } while (choice != 0);
    }

    public static void main(String[] args) {
        MainSanPham main = new MainSanPham();
        main.menuProduct();
    }
}
