package Product;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import Main.KiemTra;


public class GioHang {
    public ArrayList<Product> gioHang;
    private String maGH;
    private Kho kho = new Kho();
    private KiemTra kt = new KiemTra();
    Scanner sc = new Scanner(System.in);

    public GioHang() {
        this.gioHang = new ArrayList<>();
        this.maGH = "GH";
        this.kho.docDataTuFile();
    }

    public ArrayList<Product> getDanhSachSP() {
        return gioHang;
    }

    public String getMaGH() {
        return this.maGH;
    }

    public void setMaGH(int sizeDSGio) {
        this.maGH = "GH" + sizeDSGio;
    }

    public void setDanhSachSP(ArrayList<Product> gioHang) {
        this.gioHang = gioHang;
    }

    public void themVaoGio(String maSP) {
        while (true) {
            for (Product sanPham : kho.khoHang) {
                if (maSP.matches(sanPham.getProduct_id())) {
                    this.gioHang.add(kho.laySPtheoMa(maSP));
                    return;
                }
            }
        }
    }

    public void themVaoGion() {
        while (true) {
            System.out.print("Nhap vao ma san pham: ");
            String maSP = sc.nextLine();
            for(Product sanPham : gioHang){
                if (maSP.matches(sanPham.getProduct_id())) {
                    if(kho.laySPtheoMa(maSP).getItemnum() == 0){
                    System.out.println("San pham da het hang!! ");
                    return;
                    }
                    System.out.print("Nhap vao so luong san pham: ");
                    sanPham.itemnum = sanPham.getItemnum() + kt.KiemTraNhapSoTuNhien();
                    return;
                }
            }
            for (Product sanPham : kho.khoHang) {
                if (maSP.matches(sanPham.getProduct_id())) {
                    if(kho.laySPtheoMa(maSP).getItemnum() == 0){
                    System.out.println("San pham da het hang!! ");
                    return;
                    }
                    System.out.print("Nhap vao so luong san pham: ");
                    sanPham.itemnum = kt.KiemTraNhapSoTuNhien();;
                    this.gioHang.add(kho.laySPtheoMa(maSP));
                    return;
                }
                
            }
            System.out.println("Ma san pham khong ton tai");
        }
    }

    public void ghiTenSPvaDonGiaVaoFile() {
        try {
            FileWriter writer = new FileWriter("danhsachspdadat.txt");
            String line1 =(String.format("%-24s%-24s%-24s\n","Ten SP","Don gia","So Luong"));
            writer.write(line1);
            for (Product sanPham : this.gioHang) {
                String line = (String.format("%-24s%-24s%-24d\n",sanPham.getProduct_name()+"|",sanPham.getPrice()+"|",sanPham.getItemnum()));
                writer.write(line);

            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi thông tin vào file.");
            e.printStackTrace();
        }
    }

    public void inTenSPvaDonGia() {

        for (Product sanPham : this.gioHang) {
            sanPham.xuat();
        }
    }

    public void xoaKhoiGioHang(int vitri) {
        if (vitri >= 0 && vitri < gioHang.size()) {
            this.gioHang.remove(vitri);
        } else {
            System.out.println("Vi tri ban nhap vao la so am hoac vi tri lon hon so luong trong gio hang.");
        }
    }

    public void xoaKhoiGioHang(String maSP) {
        for (Product sanPham : gioHang) {
            if (sanPham.getProduct_id().equals(maSP)) {
                this.gioHang.remove(sanPham);
                System.out.println("Da xoa san pham co ma | " + maSP + " | trong gio.");
                return;
            }
        }
    }

    public void xoaTatCa() {
        this.gioHang.clear();
    }

    public int tinhTien() {
        int tong = 0;
        for (Product sanPham : gioHang) {
            tong += sanPham.getPrice() * sanPham.getItemnum();
        }
        return tong;
    }

    public int gioHangSize() {
        int count = 0;
        for (Product sanPham : gioHang) {
            count++;
        }
        return count;
    }

    public String layAllMaSP() {
        String allMaSP = "";
        for (Product sanPham : gioHang) {
            allMaSP += ", " + sanPham.getProduct_id();
        }
        return allMaSP;
    }

    public void inGioHang() {
        System.out.println("===================== GIO HANG =====================");
        if (this.gioHang.isEmpty()) {
            System.out.println("Gio hang dang trong!");
            return;
        }
        System.out.printf("%-12s%-20s%-12s%-25s%-12s\n","|LSP|","|maSP|","|tenSP|","|donGia|","|So Luong|");

        for (Product sanPham : this.gioHang) {
            sanPham.xuat();

        }
        System.out.println("====================================================");
    }

    public boolean KtraGH() {
        if (this.gioHang.isEmpty()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gioHang == null) ? 0 : gioHang.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GioHang other = (GioHang) obj;
        if (gioHang == null) {
            if (other.gioHang != null)
                return false;
        } else if (!gioHang.equals(other.gioHang))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.maGH + this.layAllMaSP() + "\n";
    }
}
