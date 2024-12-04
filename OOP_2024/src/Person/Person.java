package Person;
import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    public String Ten;
    public LocalDate NgaySinh;
    public String Email;
    public String GioiTinh;
    public DiaChi diachi;

    // Constructor
    public Person() {}

    public Person(String ten, LocalDate ngaysinh, String email, String gioitinh, DiaChi diachi) {
        Ten=ten;
        NgaySinh=ngaysinh;
        Email = email;
        GioiTinh = gioitinh;
        this.diachi = diachi;
    }

    // Getters và Setters
    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten=ten;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaysinh) {
        NgaySinh=ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioitinh) {
        GioiTinh=gioitinh;
    }

    public DiaChi getDiaChi() {
        return diachi;
    }

    public void setDiaChi(DiaChi diachi) {
        this.diachi = diachi;
    }

    // Tính tuổi
    public int TinhTuoi() {
        return Period.between(this.NgaySinh, LocalDate.now()).getYears();
    }

    // Hàm trừu tượng nhập và xuất thông tin
    public abstract void NhapTT();

    public abstract void XuatTT();
}