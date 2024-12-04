package Product;
import ORDER.*;
import Payment.*;

import java.util.ArrayList;
import java.util.Scanner;

import Main.KiemTra;

public class MainTestMuahang {
    static order order = new order();
    static paymentMenu paymenu = new paymentMenu();

    static int choice, lc;
    static Kho khoHang = new Kho();
    static KiemTra kt = new KiemTra();
    static DanhSachGioHang dsGH = new DanhSachGioHang();
    static bildetailList detailList = new bildetailList();
    static Scanner sc = new Scanner(System.in);

    static GioHang gioHang = new GioHang();

    public void menuMh() {
        layData();

        System.out.println("Kinh chao quy khach den voi cua hang van phong pham.");
        System.out.println("Chon phim bat ki de tiep tuc.");
        sc.nextLine();
        do {
            hienThiMenu();

            checkChoice();

            sc.nextLine();
            if (choice == 1) {
                choice1();
            } else if (choice == 2) {
                choice2();
            } else if (choice == 3) {
                int sl;
                do {
                    gioHang.themVaoGion();
                    System.out.print("Ban co muon mua tiep? An so 1 de tiep tuc/Nhap so khac bat ki de ngung: ");
                    // initialize to a default value
                    sl = sc.nextInt();
                } while (sl == 1);

            } else if (choice == 4) {
                gioHang.inGioHang();

            } else if (choice == 5) {
                choice5();
            } else if (choice == 6) {
                if (gioHang.KtraGH() == true) {
                    System.out.println("Gio hang dang trong vui long them truoc thi thanh toan !!!");
                } else {
                    gioHang.ghiTenSPvaDonGiaVaoFile();
                    double tonggia = 0;
                    ArrayList<orderItem> orderItems = gioHang.convertToOrderItems();
                    for (orderItem item : orderItems) {
                        order.addProduct(item);
                        tonggia += item.totalValueProduct();
                    }
                    order.inputOrder();
                    order.printOrder();
                    System.out.println("Total Value Product: " + tonggia);
                    paymenu.paymentmenu();
                    detailList.writeFile();
                    order.giamSoLuongSanPham();
                    gioHang.xoaTatCa();
                    khoHang.CapNhatsl();
                }
            }

        } while (choice != 0);
    }

    public static void main(String[] args) {
        MainTestMuahang mainMh = new MainTestMuahang();
        mainMh.menuMh();
    }

    public static void layData() {

        dsGH.docDataTuFile();

        khoHang.docDataTuFile();

    }

    public static void luuData() {

        dsGH.ghiDataXuongFile();
    }

    public static void hienThiMenu() {

        System.out.println("=====================Don Hang=======================");
        System.out.println(
                "1. Xem san pham trong cua shop.\n"
                        + "2. Tim kiem san pham.\n"
                        + "3. Tien hanh mua hang.\n"
                        + "4. Xem gio hang.\n"
                        + "5. Chinh sua gio hang.\n"
                        + "6. Thanh toan.\n"
                        + "0. Roi cua hang.");
        System.out.println("====================================================");
    }

    public static void checkChoice() {
        try {
            System.out.print("Moi nhap lua chon: ");
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Xin hay nhap vao mot so nguyen.\n");
            choice = -1;
        }
    }

    public static void checkLC() {
        try {
            lc = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Xin hay nhap vao mot so nguyen.\n");
            lc = -1;
        }
    }

    public static void choice1() {
        do {
            // System.out.println("Shop gom co 3 mat hang 'Paper' 'Pen' 'Supply' .");
            System.out.println("----------------------------------------------------");
            System.out.println(
                            "1. Xem cac mat hang la 'Tool'.\n"
                            + "2. Xem cac mat hang la 'Paper Product'.\n"
                            + "3. Xem tat ca cac mat hang co trong shop.\n"
                            + "0. Quay lai menu.");
            System.out.println("----------------------------------------------------");
            System.out.print("Moi nhap lua chon: ");

            checkLC();

            System.out.println();
            switch (lc) {
                case 1:
                    khoHang.inTool();
                    break;
                case 2:
                    khoHang.inPaper_product();
                    break;
                case 3:
                    khoHang.inKho();
                    break;
            }

        } while (lc != 0);
    }

    public static void choice2() {
        do {
            System.out.println("--------------------- TIM KIEM ---------------------");
            System.out.println(
                            "1. Tim kiem san pham theo maSP hoac tenSP.\n"
                            + "2. Tim kiem san pham theo khoang donGia (min, max).\n"
                            + "3. Tim kiem san pham co donGia tu thap den cao.\n"
                            + "4. Tim kiem san pham co donGia tu cao den thap.\n"
                            + "0. Quay lai menu.\n");
            System.out.println("----------------------------------------------------");
            System.out.print("Nhap vao lua chon: ");

            checkLC();
            switch (lc) {
                case 1:

                    System.out.println("Nhap vao ma san pham muon tim kiem.");
                    String sp = kt.kiemtraMaSanpham();
                    khoHang.timkiemProduct(sp);
                    break;

                case 2:

                    System.out.println("Nhap vao donGia min, max (VD: 1000000 3000000)");
                    int min, max;
                    min = kt.KiemTraNhapSoNguyen();
                    max = kt.KiemTraNhapSoNguyen();
                    khoHang.timkiemProductTheoGiaTien(min, max);
                    break;

                case 3:

                    khoHang.timkiemProductThapDenCao();
                    
                    break;

                case 4:

                    khoHang.timkiemProductCaoDenThap();
                    
                    break;
            }

        } while (lc != 0);
    }

    public static void choice5() {
        do {

            System.out.println("-----------------------------------------------------");
            System.out.println(
                    "1. Xoa san pham trong gio theo maSP.\n"
                            + "2. Xoa san pham trong gio theo vi tri trong gio.\n"
                            + "3. Xoa toan bo gio hang.\n"
                            + "0. Quay lai Menu.");

            System.out.println("-----------------------------------------------------");
            System.out.println("Moi ban nhap lua chon: ");
            checkLC();
            switch (lc) {
                case 1:
                    System.out.print("Nhap vao maSP: ");
                    String maSP = kt.kiemtraMaSanpham();
                    gioHang.xoaKhoiGioHang(maSP);
                    break;

                case 2:
                    if (gioHang.gioHangSize() > 0) {
                        System.out.println("Nhap vao vi tri san pham: ");
                        int viTri;
                        try {
                            viTri = kt.KiemTraNhapSoTuNhien();
                        } catch (Exception e) {
                            System.out.println("Vi tri khong hop le.Vui long nhap lai !");
                            sc.nextLine();
                            viTri = -1;
                        }
                        gioHang.xoaKhoiGioHang(viTri);
                    } else {
                        System.out.println("Gio hang hien tai cua ban dang trong.");
                    }
                    break;

                case 3:
                    gioHang.xoaTatCa();
                    System.out.println("Toan bo gio hang da duoc xoa!");
                    break;
            }
        } while (lc != 0);
    }

}

