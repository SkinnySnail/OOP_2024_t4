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
            System.out.print("Nhập mã khách hàng: ");
            MaKhachHang=re.nextLine();
            System.out.print("Nhập tên khách hàng: ");
            Ten=re.nextLine();
               while (true) {
            System.out.print("Nhập ngày sinh khách hàng (yyyy-MM-dd): ");
            String inputDate = re.nextLine();
            try {
                setNgaySinh(LocalDate.parse(inputDate));
                break; // Nếu không có lỗi thì thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập theo định dạng yyyy-MM-dd.");
            }
   }
            System.out.print("Nhập email khách hàng: ");
            Email=re.nextLine();
            System.out.print("Nhập giới tính khách hàng: ");
            GioiTinh=re.nextLine();
            System.out.print("Nhập loại thành viên: ");
            LoaiThanhVien=re.nextLine();
            System.out.print("Nhập điểm tích lũy: ");
            DiemTichLuy=re.nextInt();
            re.nextLine();
        }
        System.out.println("---Nhập địa chỉ khách hàng---");
        diachi=new DiaChi();
    }

   @Override
    public void XuatTT() {
        System.out.println("Mã khách hàng: " + MaKhachHang);
        System.out.println("Tên: " + Ten);
        System.out.println("Email: " + Email);
        System.out.println("Ngày sinh: " + NgaySinh);
        System.out.println("Tuổi: " + TinhTuoi());
        System.out.println("Loại thành viên: " + LoaiThanhVien);
        System.out.println("Điểm tích lũy: " + DiemTichLuy);
        System.out.println("Địa chỉ: " + diachi.toString());
    }

}
