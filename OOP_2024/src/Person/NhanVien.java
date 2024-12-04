package Person;
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
            System.out.print("Nhap ma nhan vien: ");
            MaNhanVien = re.nextLine();
            System.out.print("Nhap ten nhan vien: ");
            setTen(re.nextLine());
               
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

            System.out.print("Nhap gioi tinh: ");
            setGioiTinh(re.nextLine());
            System.out.print("Nhap chuc vu: ");
            ChucVu = re.nextLine();
            System.out.print("Nhap luong(USD): ");
            Luong = re.nextFloat();
            re.nextLine(); // Consume the newline character
            while (true) {
                System.out.print("Nhap ngay bat dau lam viec (yyyy-mm-dd): ");
                String inputDate = re.nextLine();
                try {
                    setStartDate(LocalDate.parse(inputDate));
                    break; // Nếu không có lỗi thì thoát khỏi vòng lặp
                } catch (Exception e) {
                    System.out.println("Ngay bat dau lam viec khong hop le! Vui long nhap theo dinh dang yyyy-MM-dd.");
                    }
                }
        }
        System.out.println("---Nhap dia chi nhan vien---");
        diachi = new DiaChi();
    }


    @Override
    public void XuatTT() {
        System.out.println("Ma nhan vien: " + MaNhanVien);
        System.out.println("Ten nhan vien: " + Ten);
        System.out.println("Ngay sinh: " + NgaySinh);
        System.out.println("Email: "+ Email);
        System.out.println("Gioi tinh: "+ GioiTinh);
        System.out.println("Chuc vu: " + ChucVu);
        System.out.println("So nam lam viec: " + TinhNamLamViec());
        System.out.println("Luong: " + Luong);
        System.out.println("Dia chi: " + diachi.toString());
    }
}