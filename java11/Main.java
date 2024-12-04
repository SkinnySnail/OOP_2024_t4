
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner re = new Scanner(System.in);
        DSNV dsnv = new DSNV(); // Khởi tạo danh sách nhân viên
        DSKH dskh = new DSKH(); // Khởi tạo danh sách khách hàng

        while (true) {
            System.out.println("\n--- MENU CHƯƠNG TRÌNH ---");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
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
                    System.out.println("Thoát chương trình.");
                    re.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // Menu quản lý nhân viên
    private static void menuNhanVien(DSNV dsnv,Scanner re) {
        while (true) {
            System.out.println("\n--- MENU QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Ghi dữ liệu vào file");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = re.nextInt();
            re.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1 -> {
                    NhanVien nv = new NhanVien();
                    System.out.println("--- Nhập thông tin nhân viên ---");
                    nv.NhapTT();
                    dsnv.themNhanVien(nv);
                    System.out.println("Thêm nhân viên thành công!");
                }

                case 2 -> {
                    System.out.println("--- Danh sách nhân viên ---");
                    dsnv.displayTTNV();
                }

                case 3 -> {
                    System.out.print("Nhập đường dẫn file để đọc: ");
                    String readFilePathNV = re.nextLine();
                    dsnv.docFile(readFilePathNV);
                    System.out.println("Đọc dữ liệu từ file thành công!");
                }

                case 4 -> {
                    System.out.print("Nhập đường dẫn file để ghi: ");
                    String writeFilePathNV = re.nextLine();
                    dsnv.ghiFile(writeFilePathNV);
                    System.out.println("Ghi dữ liệu vào file thành công!");
                }

                case 5 -> {
                    return;
                }

                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // Menu quản lý khách hàng
    private static void menuKhachHang(DSKH dskh,Scanner re) {
        while (true) {
            System.out.println("\n--- MENU QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Ghi dữ liệu vào file");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = re.nextInt();
            re.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1 -> {
                    KhachHang kh = new KhachHang();
                    System.out.println("--- Nhập thông tin khách hàng ---");
                    kh.NhapTT();
                    dskh.themKhachHang(kh);
                    System.out.println("Thêm khách hàng thành công!");
                }

                case 2 -> {
                    System.out.println("--- Danh sách khách hàng ---");
                    dskh.displayTTKH();
                }

                case 3 -> {
                    System.out.print("Nhập đường dẫn file để đọc: ");
                    String readFilePathKH = re.nextLine();
                    dskh.docFile(readFilePathKH);
                    System.out.println("Đọc dữ liệu từ file thành công!");
                }

                case 4 -> {
                    System.out.print("Nhập đường dẫn file để ghi: ");
                    String writeFilePathKH = re.nextLine();
                    dskh.ghiFile(writeFilePathKH);
                    System.out.println("Ghi dữ liệu vào file thành công!");
                }

                case 5 -> {
                    return;
                }

                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
