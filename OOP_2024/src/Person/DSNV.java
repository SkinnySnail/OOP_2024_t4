package Person;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DSNV
{
    private final List<NhanVien> nhanVien;

    // Constructor
    public DSNV() {
        nhanVien = new ArrayList<>();
    }

    // Thêm nhân viên vào danh sách
    public void themNhanVien(NhanVien nhanvien) {
        nhanVien.add(nhanvien);
    }

    // Hiển thị thông tin nhân viên từ danh sách
    public void displayTTNV() {
        if (nhanVien.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
        } else {
            for (NhanVien nhanvien : nhanVien) {
                nhanvien.XuatTT();
                System.out.println("----------------------------");
            }
        }
    }

    // Tạo dữ liệu mẫu nếu danh sách trống
    public void createSampleData() {
        if (nhanVien.isEmpty()) {
            DiaChi diachi = new DiaChi("456", "Nguyen Hue", "Quan 3", "TP.HCM");
            nhanVien.add(new NhanVien("Le Van C", LocalDate.of(1985, 3, 10), "c@gmail.com", "Nam", diachi,
                    "NV001", "Quan ly", 15000000, LocalDate.of(2015, 6, 1)));
            nhanVien.add(new NhanVien("Hoang Thi D", LocalDate.of(1992, 7, 25), "d@gmail.com", "Nu", diachi,
                    "NV002", "Nhan vien", 10000000, LocalDate.of(2020, 8, 15)));
        }
    }

    // Đọc dữ liệu nhân viên từ file
    public void docFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                DiaChi diachi = new DiaChi(data[4], data[5], data[6], data[7]);
                NhanVien nhanvien = new NhanVien(data[0], LocalDate.parse(data[1]), data[2], data[3], diachi, data[8], data[9], Float.parseFloat(data[10]), LocalDate.parse(data[11]));
                nhanVien.add(nhanvien);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Ghi thông tin nhân viên vào file
    public void ghiFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (NhanVien nhanvien : nhanVien) {
                DiaChi diachi = nhanvien.getDiaChi();
                bw.write(String.join(",",
                        nhanvien.getTen(),
                        nhanvien.getNgaySinh().toString(),
                        nhanvien.getEmail(),
                        nhanvien.getGioiTinh(),
                        diachi.getSoDuong(),
                        diachi.getTenDuong(),
                        diachi.getQuan(),
                        diachi.getThanhPho(),
                        nhanvien.getMaNhanVien(),
                        nhanvien.getChucVu(),
                        String.valueOf(nhanvien.getLuong()),
                        nhanvien.getStartDate().toString()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Lấy danh sách nhân viên
    public List<NhanVien> getDSNV() {
        return nhanVien;
    }
}
