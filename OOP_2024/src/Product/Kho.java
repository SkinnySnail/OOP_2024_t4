package Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kho implements iDocGhi{
    ArrayList<SanPham> khoHang;
    Scanner sc = new Scanner(System.in);
    
    public Kho() {
        khoHang = new ArrayList<>();
    }

    public void themVaoKho(){
        int lc = 0;

        do{
            System.out.println("Chon san pham muon them: ");
            System.out.println(
                    "1. Tool.\n"
                +   "2. Paper product.\n"
            );
            lc = sc.nextInt();
            if(lc == 1){
                SanPham sp = new Tool();
                sp.nhap();
                this.khoHang.add(sp);
            }else if(lc == 2){
                SanPham sw = new Paper_product();
                sw.nhap();
                this.khoHang.add(sw);
            }
        }while(lc != 0);
    }

    // các hàm xóa
    public void xoaSP(int vitri){
        this.khoHang.remove(vitri);
    }

    public void xoaSP(String maSP){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getProduct_id().equals(maSP)){
                this.khoHang.remove(sanPham);
            }
        }
    }

    public void clearKho(){
        this.khoHang.clear();
        System.out.println("Kho da duoc don dep!.");
    }

    // Các hàm in 
    public void inKho(){
        System.out.println("----------------------- Kho -----------------------");
        for (SanPham sanPham : khoHang) {
            sanPham.xuat();
        }
        System.out.println("----------------------------------------------------");
    }

    public void inPaper_product(){
        System.out.println("------------ Cac san pham la Paper product ------------");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getCategory().equals("Paper_product")){
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void inTool(){
        System.out.println("------------ Cac san pham la Tool ------------");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getCategory().equals("Tool")){
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

public void timkiemSanPham(String maOrten) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getProduct_id().equals(maOrten) || sanPham.getProduct_name().indexOf(maOrten) >= 0) {
                sanPham.xuat();
            }
        }
    }

    public void timkiemSanPhamTheoGiaTien(int min, int max) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getPrice() >= min && sanPham.getPrice() <= max) {
                sanPham.xuat();
            }
        }
    }

    public void timkiemSanPhamThapDenCao() {
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp1.getPrice(), sp2.getPrice());
            }
        });
    }

    public void timkiemSanPhamCaoDenThap() {
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp2.getPrice(), sp1.getPrice());
            }
        });
    }

    public SanPham laySPtheoMa(String maSP) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getProduct_id().equals(maSP)) {
                if (sanPham.getCategory().equals("Tool")) {
                    SanPham sp = new Tool();
                    sp = (Tool) sanPham;
                    return sp;
                } else if (sanPham.getCategory().equals("Paper_product")) {
                    SanPham sw = new Paper_product();
                    sw = (Paper_product) sanPham;
                    return sw;
                }
            }
        }
        System.out.println("San pham ko ton tai");
        return null;
    }

    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataSanPham.txt");
            for (SanPham sp : this.khoHang) {
                fw.write(sp.toString()+ "\n");
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    // Đọc dữ liệu từ file
    @Override
    public void docDataTuFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataSanPham.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String category = parts[0].trim();
                String maSP = parts[1].trim();
                String tenSP = parts[2].trim();
                int donGia = Integer.parseInt(parts[3].trim());
                if(category.equals("Tool")){
                    String us = parts[4].trim();
                    String des = parts[5].trim();
                    this.khoHang.add(new Tool(maSP, tenSP, donGia,us,des));
                }else if(category.equals("Paper_product")){
                    String pptype = parts[4].trim();
                    this.khoHang.add(new Paper_product(maSP, tenSP, donGia,pptype));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
