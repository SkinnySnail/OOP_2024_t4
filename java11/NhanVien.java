import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class NhanVien extends Person {
    private String MaNhanVien;
    private String ChucVu;
    private float Luong;
    private LocalDate startDate;

    // Constructor
    public NhanVien() {
        super();
        MaNhanVien="";
        ChucVu="";
        Luong=0;
        startDate = LocalDate.of(2000, 1, 1);
    }

    public NhanVien(String ten, LocalDate ngaysinh, String email, String gioitinh, DiaChi diachi,
                    String manhanvien, String chucvu,float luong, LocalDate startDate) {
        super(ten, ngaysinh, email, gioitinh, diachi);
        MaNhanVien=manhanvien;
        ChucVu=chucvu;
        Luong=luong;
        this.startDate = startDate;
    }

    // Getters và Setters
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanvien(String manhanvien) {
        MaNhanVien = manhanvien;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucvu) {
        ChucVu=chucvu;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(float luong) {
        Luong=luong;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Tính số năm làm việc
    public int TinhNamLamViec() {
        return Period.between(this.startDate, LocalDate.now()).getYears();
    }

    // Override nhập và xuất thông tin
    @Override
    public void NhapTT() {
        try (Scanner re = new Scanner(System.in)) {
            System.out.print("Nhập mã nhân viên: ");
            MaNhanVien = re.nextLine();
            System.out.print("Nhập tên nhân viên: ");
            setTen(re.nextLine());
               
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
            System.out.print("Nhập email: ");
            setEmail(re.nextLine());
            System.out.print("Nhập giới tính: ");
            setGioiTinh(re.nextLine());
            System.out.print("Nhập chức vụ: ");
            ChucVu = re.nextLine();
            System.out.print("Nhập lương: ");
            Luong = re.nextFloat();
            re.nextLine(); // Consume the newline character
            System.out.print("Nhập ngày bắt đầu làm việc (yyyy-mm-dd): ");
            startDate = LocalDate.parse(re.nextLine());
        }
        System.out.println("---Nhập địa chỉ nhân viên---");
        diachi = new DiaChi();
    }


    @Override
    public void XuatTT() {
        System.out.println("Mã nhân viên: " + MaNhanVien);
        System.out.println("Tên nhân viên: " + Ten);
        System.out.println("Ngày sinh: " + NgaySinh);
        System.out.println("Email: "+ Email);
        System.out.println("Giới tính: "+ GioiTinh);
        System.out.println("Chức vụ: " + ChucVu);
        System.out.println("Số năm làm việc: " + TinhNamLamViec());
        System.out.println("Lương: " + Luong);
        System.out.println("Địa chỉ: " + diachi.toString());
    }
}