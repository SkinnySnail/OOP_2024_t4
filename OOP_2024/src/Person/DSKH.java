package Person;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DSKH {
    private final List<KhachHang> khachHang;

    // Constructor
    public DSKH() {
        khachHang = new ArrayList<>();
    }

    // Thêm khách hàng vào danh sách
    public void themKhachHang(KhachHang khachhang) {
        khachHang.add(khachhang);
    }

    // Hiển thị thông tin khách hàng từ danh sách
    public void displayTTKH() {
        if (khachHang.isEmpty()) {
            System.out.println("Danh sach khach hang trong.");
        } else {
            for (KhachHang khachhang : khachHang) {
                khachhang.XuatTT();
                System.out.println("----------------------------");
            }
        }
    }

    // Tạo dữ liệu mẫu nếu danh sách trống
    public void createSampleData() {
        if (khachHang.isEmpty()) {
            DiaChi diachi = new DiaChi("123", "Le Loi", "Quan 1", "TP.HCM");
            khachHang.add(new KhachHang("Nguyen Van A", LocalDate.of(1990, 1, 15), "a@gmail.com", "Nam", diachi,
                    "KH001", "VIP", 1000));
            khachHang.add(new KhachHang("Tran Thi B", LocalDate.of(1995, 5, 20), "b@gmail.com", "Nu", diachi,
                    "KH002", "Thuong", 500));
        }
    }

    // Đọc dữ liệu khách hàng từ file
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("danhsachKH.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                DiaChi diachi = new DiaChi(data[4], data[5], data[6], data[7]);
                KhachHang khachhang = new KhachHang(data[0], LocalDate.parse(data[1]), data[2], data[3], diachi,
                        data[8], data[9], Integer.parseInt(data[10]));
                khachHang.add(khachhang);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Ghi thông tin khách hàng vào file
    public void ghiFile(){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("danhsachKH.txt"))) {
            for (KhachHang khachhang : khachHang) {
                DiaChi diachi = khachhang.getDiaChi();
                bw.write(String.join(",",
                        khachhang.getTen(),
                        khachhang.getNgaySinh().toString(),
                        khachhang.getEmail(),
                        khachhang.getGioiTinh(),
                        diachi.getSoDuong(),
                        diachi.getTenDuong(),
                        diachi.getQuan(),
                        diachi.getThanhPho(),
                        khachhang.getMaKhachHang(),
                        khachhang.getLoaiThanhVien(),
                        String.valueOf(khachhang.getDiemTichLuy())));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Lấy danh sách khách hàng
    public List<KhachHang> getDSKH() {
        return khachHang;
    }
}

