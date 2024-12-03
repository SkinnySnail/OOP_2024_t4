package Main;
import java.util.Scanner;

public class KiemTra {
    Scanner input = new Scanner(System.in);

    public String NhapTen() {
        String ten;
        while (true) {
            ten = input.nextLine();
            if (ten.matches("^[A-Z][a-z]*([\s]*[A-Z][a-z]*)*")) {
                return ten;
            } else {
                System.out.println("Ten nhap vao khong hop le vi du:Nguyen Van A. Nhap lai:");
            }
        }
    }

    public String kiemtraNhapsdt() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            if (dauvao.matches("^[0]\\d{9}")) {
                return dauvao;

            } else {
                System.out.println("Nhap sai vui long nhap lai  sdt co 10 so!!!");
            }
        }
    }

    public String nhapEmail() {
        String dauvao;
        while (true) {

            dauvao = input.nextLine();

            // Kiểm tra xem chuỗi nhập vào có đúng định dạng email hay không
            if (kiemTraEmail(dauvao)) {
                return dauvao;
            } else {
                System.out.println("Dia chi email khong hop le! Nhap lai.");
            }
        }
    }

    public boolean kiemTraEmail(String email) {
        // Biểu thức chính quy để kiểm tra địa chỉ email
        String regex = "^[a-zA-Z0-9_+&*-]*@[a-zA-Z0-9-]+.[a-zA-Z]{3}";
        return email.matches(regex);
    }

    public String nhapNgay() {
        String ngaySinh;
        while (true) {

            ngaySinh = input.nextLine();

            // Kiểm tra xem chuỗi nhập vào có đúng định dạng ngày sinh hay không
            if (kiemTraNgaySinh(ngaySinh)) {
                return ngaySinh;
            } else {
                System.out.println("ngay khong hop le! Nhap lai.");
            }
        }
    }

    public boolean kiemTraNgaySinh(String ngaySinh) {
        // Biểu thức chính quy để kiểm tra định dạng ngày sinh d/m/y
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(19|20)([0-9]*{2})";
        return ngaySinh.matches(regex);
    }

    public String ktNhapGioiTinh() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            dauvao.toLowerCase();
            if (dauvao.matches("nam") || dauvao.matches("nu") || dauvao.matches("Khac")) {
                return dauvao;

            } else {
                System.out.println("Nhap khong hop le! Nhap lai: ");

            }
        }
    }

    public String nhapChuoi() {
        String chuoi;
        while (true) {

            chuoi = input.nextLine();

            if (kiemTraChuoi(chuoi)) {
                return chuoi;
            } else {
                System.out.println("Nhap khong hop le.Nhap lai");
            }
        }
    }

    public boolean kiemTraChuoi(String chuoi) {
        String regex = "^[a-zA-Z0-9_\s]+$";
        return chuoi.matches(regex);
    }

    public String kiemtraMakhachhang() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            dauvao = dauvao.toUpperCase();
            if (dauvao.matches("^CUS[0-9]{3}$")) {
                return dauvao;

            } else {
                System.out.println("Nhap khong chinh xac. Vi du: CUS0001");
            }
            System.out.print("Nhap lai: ");

        }
    }

    public int KiemTraNhapSoNguyen() {
        int DauVao;
        while (true) {
            try {
                DauVao = Integer.parseInt(input.nextLine());
                return DauVao;
            } catch (NumberFormatException exception) {
                System.out.print("Sai kieu du lieu ! Nhap lai: ");
            }
        }
    }

    public int KiemTraNhapSoTuNhien() {
        int DauVao;
        while (true) {
            DauVao = KiemTraNhapSoNguyen();
            if (DauVao >= 0) {
                return DauVao;
            } else {
                System.out.print("Vui long nhap so tu nhien ! Nhap lai: ");
            }
        }
    }

    public String kiemtraManhanvien() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            dauvao = dauvao.toUpperCase();
            if (dauvao.matches("^EMP[0-9]{3}$")) {
                return dauvao;

            } else {
                System.out.println("Nhap khong chinh xac. Vi du: EMP001");
            }
            System.out.print("Nhap lai: ");
        }
    }

    public String kiemtraMaSanpham() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            dauvao = dauvao.toUpperCase();
            if (dauvao.matches("^SP[0-9]{3}$")) {
                return dauvao;

            } else {
                System.out.println("Nhap khong chinh xac. Vi du: SPxxx");
            }
            System.out.print("Nhap lai: ");
        }
    }

    public double nhapDoubleDuong() {
        double soDouble;
        while (true) {

            try {
                soDouble = Double.parseDouble(input.nextLine());

                if (soDouble > 0) {
                    return soDouble;
                } else {
                    System.out.println("khong phai so duong! Nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("khong phai kieu double! Nhap lai.");
            }
        }
    }

    public boolean ktraSpace(String input) {
        return input.indexOf(' ') != -1;
    }

    public String kiemtraTenTK() {
        String dauvao;
        while (true) {
            dauvao = input.nextLine();
            dauvao = dauvao.toUpperCase();
            if (dauvao.matches("^EMP[0-9]{3}$")) {
                return dauvao;

            } else {
                System.out.println("Nhap khong chinh xac. Vi du: EMPxxx");
            }
            System.out.print("Nhap lai: ");
        }
    }
}

