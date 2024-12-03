package Product;


import java.util.Scanner;

public class ProductMenu {
    Kho khoHang = new Kho();
    BrandList Blist = new BrandList();
    public void menuProduct() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("--------------Quan_Li_KHO------------+");
            System.out.println("1. Them vao kho.                     |");
            System.out.println("2. Xoa san pham khoi kho.            |");
            System.out.println("3. Tim kiem san pham.                |");
            System.out.println("4. Don dep kho.                      |");
            System.out.println("5. In kho.                           |");
            System.out.println("0. Thoat                             |");
            System.out.println("-------------------------------------+");
            System.out.print("Nhap lua chon : ");
            choice = sc.nextInt();
            sc.nextLine();
            khoHang.docDataTuFile();
            if (choice == 1) {
                khoHang.themVaoKho();
                khoHang.ghiDataXuongFile();
            } else if (choice == 2) {
                System.out.println("Nhap vao vi tri muon xoa: ");
                // String maSP = sc.nextLine();
                khoHang.xoaSP(sc.nextLine());
            } else if (choice == 3) {
                System.out.println("1. Tim san pham theo ma.                      |");
                System.out.println("2. Sap xep san pham theo gia tien.            |");
                System.out.println("3. Tim san pham trong khoang gia.             |");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Nhap vao ma SP muon tim: ");
                    String masp = sc.nextLine();
                    khoHang.timkiemProduct(masp);
                } else if (choice == 2) {
                    System.out.println("1. Xem san pham tu thap den cao                      |");
                    System.out.println("2. Xem san pham tu cao den thap                      |");
                    choice = sc.nextInt();
                if (choice == 1) {
                    khoHang.timkiemProductCaoDenThap();
                } else if (choice == 2) {
                    khoHang.timkiemProductThapDenCao();
                }
                } else if (choice == 3) {
                    System.out.println("Nhap gia thap nhat");
                    int min = sc.nextInt();
                    System.out.println("Nhap gia cao nhat");
                    int max = sc.nextInt();
                    khoHang.timkiemProductTheoGiaTien(min,max);
                } 

                ;
            } else if (choice == 4) {
                System.out.print("Ban co chac chan khong(true/false): ");
                Boolean confirm = sc.nextBoolean();
                if (confirm == true) {
                    khoHang.clearKho();
                }
            } else if (choice == 5) {
                System.out.println("1. In cac san pham la Tool.                   |");
                System.out.println("2. In cac san pham la Paper Product.          |");
                System.out.println("3. In toan bo kho.                            |");
                choice = sc.nextInt();
                if (choice == 1) {
                    khoHang.inTool();    
                } else if (choice == 2) {
                    khoHang.inTool();    
                } else if (choice == 3) {
                    khoHang.inKho();
                } 
            }
        } while (choice != 0);
        sc.close();    
    }

    public static void main(String[] args) {
       ProductMenu main = new ProductMenu();
        main.menuProduct();
    }
}
