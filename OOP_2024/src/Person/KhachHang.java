package Person;
import java.time.LocalDate;
import java.util.Scanner;

public class KhachHang extends Person {
    public String MaKhachHang;
    public String LoaiThanhVien;
    public int DiemTichLuy;

    // Constructor
    public KhachHang(){
        super();
        MaKhachHang="";
        LoaiThanhVien="";
        DiemTichLuy=0;
    }

    public KhachHang(String ten, LocalDate ngaysinh, String email, String gioitinh, DiaChi diachi, 
                    String makhachhang, String loaithanhvien, int diemtichluy) {
        super(ten, ngaysinh, email, gioitinh, diachi);
        MaKhachHang = makhachhang;
        LoaiThanhVien = loaithanhvien;
        DiemTichLuy = diemtichluy;
    }

    // Getters và Setters
    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String makhachang) {
    MaKhachHang = makhachang;
    }

    public String getLoaiThanhVien() {
        return LoaiThanhVien;
    }

    public void setLoaiThanVien(String loaithanhvien) {
        LoaiThanhVien = loaithanhvien;
    }

    public int getDiemTichLuy() {
        return DiemTichLuy;
    }

    public void setDiemTichLuy(int diemtichluy) {
        DiemTichLuy = diemtichluy;
    }

    // Tăng điểm tích lũy
    public void tangDiemTichLuy(int diem) {
        DiemTichLuy += diem;
    }

    // Override nhập và xuất thông tin
    @Override
    public void NhapTT() {
        try (Scanner re = new Scanner(System.in)) {
            System.out.print("Nhap ma khach hang: ");
            MaKhachHang=re.nextLine();
            System.out.print("Nhap ten khach hang: ");
            Ten=re.nextLine();
               while (true) {
            System.out.print("Nhap ngay sinh khach hang (yyyy-MM-dd): ");
            String inputDate = re.nextLine();
            try {
                setNgaySinh(LocalDate.parse(inputDate));
                break; // Nếu không có lỗi thì thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le! Vui long nhap theo dinh dang yyyy-MM-dd.");
                }
            }
            while (true) {
            System.out.print("Nhap email khach hang: ");
            Email = re.nextLine();
            if (Email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                 break; // Định dạng đúng, thoát vòng lặp
            } else {
                System.out.println("Email khong hop le! Vui long nhap lai.");
                }
            }
            System.out.print("Nhap gioi tinh khach hang: ");
            GioiTinh=re.nextLine();
            System.out.print("Nhap loai thanh vien: ");
            LoaiThanhVien=re.nextLine();
            System.out.print("Nhap diem tich luy: ");
            DiemTichLuy=re.nextInt();
            re.nextLine();
        }
        System.out.println("---Nhap dia chi khach hang---");
        diachi=new DiaChi();
    }

   @Override
    public void XuatTT() {
        System.out.println("Ma khach hang: " + MaKhachHang);
        System.out.println("Ten: " + Ten);
        System.out.println("Email: " + Email);
        System.out.println("Ngay sinh: " + NgaySinh);
        System.out.println("Tuoi: " + TinhTuoi());
        System.out.println("Loai thanh vien: " + LoaiThanhVien);
        System.out.println("Diem tich luy: " + DiemTichLuy);
        System.out.println("Dia chi: " + diachi.toString());
    }

}
