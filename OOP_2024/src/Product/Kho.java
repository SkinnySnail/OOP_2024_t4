package Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Main.KiemTra;

public class Kho implements iReaderWriter{
    public ArrayList<Product> khoHang;
    Scanner sc = new Scanner(System.in);
    KiemTra kt = new KiemTra();
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
                +   "3. Them so luong Tool.\n"
                +   "4. Them so luong cho Paper product.\n"
            );
            lc = kt.KiemTraNhapSoTuNhien();
            if(lc == 1){
                Product sp = new Tool();
                sp.nhap();
                this.khoHang.add(sp);
            break;
            }else if(lc == 2){
                Product sw = new Paper_product();
                sw.nhap();
                this.khoHang.add(sw);
            }else if(lc == 3){
                Product spp = new Tool();
                spp.nhap();
                for (Product Product : khoHang) {
                    if(Product.getProduct_id().equals(spp.getProduct_id())){
                        Product.itemnum = Product.itemnum + spp.itemnum;
                        break;
                    }
                }
            }else if(lc == 4){
                Product spx = new Paper_product();
                spx.nhap();
                for (Product Product : khoHang) {
                    if(Product.getProduct_id().equals(spx.getProduct_id())){
                        Product.itemnum = Product.itemnum + spx.itemnum;
                        break;
                    }
                }
            }
        }while(lc != 0);
    }

    // các hàm xóa
    

    public void xoaSP(String maSP){
        for (Product Product : khoHang) {
            if(Product.getProduct_id().equals(maSP)){
                this.khoHang.remove(Product);
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
        for (Product Product : khoHang) {
            Product.xuat();
        }
        System.out.println("----------------------------------------------------");
    }

    public void inPaper_product(){
        System.out.println("------------ Cac san pham la Paper product ------------");
        for (Product Product : khoHang) {
            if(Product.getCategory().equals("Paper_product")){
                Product.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void inTool(){
        System.out.println("------------ Cac san pham la Tool ------------");
        for (Product Product : khoHang) {
            if(Product.getCategory().equals("Tool")){
                Product.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

public void timkiemProduct(String masp) {
        for (Product Product : khoHang) {
            if (Product.getProduct_id().equals(masp)) {
                Product.xuat();
                break;
            }
            else{
                System.out.println("San pham ko ton tai");
            }
        }
    }

    public void timkiemProductTheoGiaTien(int min, int max) {
        for (Product Product : khoHang) {
            if (Product.getPrice() >= min && Product.getPrice() <= max) {
                Product.xuat();
            }
        }
    }

    public void timkiemProductThapDenCao() {
        Collections.sort(this.khoHang, new Comparator<Product>() {
            @Override
            public int compare(Product sp1, Product sp2) {
                return Integer.compare(sp1.getPrice(), sp2.getPrice());
            }
        });
    }

    public void timkiemProductCaoDenThap() {
        Collections.sort(this.khoHang, new Comparator<Product>() {
            @Override
            public int compare(Product sp1, Product sp2) {
                return Integer.compare(sp2.getPrice(), sp1.getPrice());
            }
        });
    }

    public Product laySPtheoMa(String maSP) {
        for (Product Product : khoHang) {
            if (Product.getProduct_id().equals(maSP)) {
                if (Product.getCategory().equals("Tool")) {
                    Product sp = new Tool();
                    sp = (Tool) Product;
                    return sp;
                } else if (Product.getCategory().equals("Paper_product")) {
                    Product sw = new Paper_product();
                    sw = (Paper_product) Product;
                    return sw;
                }
            }
        }
        System.out.println("San pham ko ton tai");
        return null;
    }

    public void CapNhatsl(){
        int Soluong;
        String tenSP;
        try {
            BufferedReader br = new BufferedReader(new FileReader("danhsachspdadat.txt"));
            String line;
            while ((line = br.readLine()) != null) {
        
                String[] parts = line.split(",");
                    tenSP = parts[0].trim();
                    Soluong = Integer.parseInt(parts[2].trim()); 
                
                for(Product sp : khoHang){
                    if(tenSP.equalsIgnoreCase(sp.getProduct_name())){
                        sp.itemnum = sp.getItemnum() - Soluong;
                        return;

                    }

                }
                br.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.ghiDataXuongFile();
    }

    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataProduct.txt");
            for (Product sp : this.khoHang) {
                fw.write(sp.toString()+ "\n");
            }
            fw.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    // Đọc dữ liệu từ file
    @Override
    public void docDataTuFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataProduct.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String category = parts[0].trim();
                String maSP = parts[1].trim();
                String tenSP = parts[2].trim();
                int donGia = Integer.parseInt(parts[3].trim());
                int num = Integer.parseInt(parts[4].trim());
                if(category.equals("Tool")){
                    this.khoHang.add(new Tool(maSP, tenSP, donGia,num));
                }else if(category.equals("Paper_product")){
                    String pptype = parts[5].trim();
                    this.khoHang.add(new Paper_product(maSP, tenSP, donGia,num,pptype));
                }
            }
            br.close();
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
}
