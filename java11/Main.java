package Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner re = new Scanner(System.in);
        DSNV dsnv = new DSNV(); // Khởi tạo danh sách nhân viên
        DSKH dskh = new DSKH(); // Khởi tạo danh sách khách hàng

        while (true) {
            try {
                System.out.println("\n--- MENU CHUONG TRINH ---");
                System.out.println("1. Quan ly nhan vien");
                System.out.println("2. Quan ly khach hang");
                System.out.println("3. Thoat");
                System.out.print("Nhap lua chon cua ban: ");
                int choice = re.nextInt();
                re.nextLine(); // Xóa bộ đệm

                switch (choice) {
                    case 1:
                        menuNhanVien(dsnv, re);
                        break;

                    case 2:
                        menuKhachHang(dskh, re);
                        break;

                    case 3:
                        System.out.println("Thoat chuong trinh.");
                        re.close();
                        System.exit(0);

                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon lai.");
                }
            } catch (Exception e) {
                System.out.println("Dau vao khong hop le! Vui long nhap lai.");
                re.nextLine(); // Xóa bộ đệm sau lỗi
            }
        }
    }

    private static void menuNhanVien(DSNV dsnv, Scanner re) {
        while (true) {
            try {
                System.out.println("\n--- MENU QUAN LY NHAN VIEN ---");
                System.out.println("1. Them nhan vienn");
                System.out.println("2. Hien thi danh sach nhan vien");
                System.out.println("3. Doc du lieu tu file");
                System.out.println("4. Ghi du lieu vao file");
                System.out.println("5. Quay lai menu chinh");
                System.out.print("Nhap lua chon cua ban: ");
                int choice = re.nextInt();
                re.nextLine(); // Xóa bộ đệm

                switch (choice) {
                    case 1 -> {
                        NhanVien nv = new NhanVien();
                        System.out.println("--- Nhap thong tin nhan vien ---");
                        nv.NhapTT();
                        dsnv.themNhanVien(nv);
                        System.out.println("Them nhan vien thanh cong!");
                    }

                    case 2 -> {
                        System.out.println("--- Danh sach nhan vien ---");
                        dsnv.displayTTNV();
                    }

                    case 3 -> {
                        System.out.print("Nhap duong dan file de doc: ");
                        String readFilePathNV = re.nextLine();
                        dsnv.docFile(readFilePathNV);
                        System.out.println("Doc du lieu tu file thanh cong!");
                    }

                    case 4 -> {
                        System.out.print("Nhap duong dan file de ghi: ");
                        String writeFilePathNV = re.nextLine();
                        dsnv.ghiFile(writeFilePathNV);
                        System.out.println("Ghi du lieu vao file thanh cong!");
                    }

                    case 5 -> {
                        return;
                    }

                    default -> System.out.println("Lua chon khong hop le! Vui long chon lai.");
                }
            } catch (Exception e) {
                System.out.println("Dau vao khong hop le! Vui long nhap lai.");
                re.nextLine(); // Xóa bộ đệm sau lỗi
            }
        }
    }

    private static void menuKhachHang(DSKH dskh, Scanner re) {
        while (true) {
            try {
                System.out.println("\n--- MENU QUAN LY KHACH HANG ---");
                System.out.println("1. Them khac hang");
                System.out.println("2. Hien thi danh sach khach hang");
                System.out.println("3. Doc du lieu tu file");
                System.out.println("4. Ghi du lieu vao file");
                System.out.println("5. Quay lai menu chinh");
                System.out.print("Nhap lua chon cua ban: ");
                int choice = re.nextInt();
                re.nextLine(); // Xóa bộ đệm

                switch (choice) {
                    case 1 -> {
                        KhachHang kh = new KhachHang();
                        System.out.println("--- Nhap thong tin khach hang ---");
                        kh.NhapTT();
                        dskh.themKhachHang(kh);
                        System.out.println("Them khach hang thanh cong!");
                    }

                    case 2 -> {
                        System.out.println("--- Danh sach khach hang ---");
                        dskh.displayTTKH();
                    }

                    case 3 -> {
                        System.out.print("Nhap duong dan file de doc: ");
                        String readFilePathKH = re.nextLine();
                        dskh.docFile(readFilePathKH);
                        System.out.println("Doc du lieu tu file thanh cong!");
                    }

                    case 4 -> {
                        System.out.print("Nhap duong dan file de ghi: ");
                        String writeFilePathKH = re.nextLine();
                        dskh.ghiFile(writeFilePathKH);
                        System.out.println("Ghi du lieu vao file thanh cong!");
                    }

                    case 5 -> {
                        return;
                    }

                    default -> System.out.println("Lua chon khong hop le! Vui long chon lai.");
                }
            } catch (Exception e) {
                System.out.println("Dau vao khong hop le! Vui long nhap lai.");
                re.nextLine(); // Xóa bộ đệm sau lỗi
            }
        }
    }
}
