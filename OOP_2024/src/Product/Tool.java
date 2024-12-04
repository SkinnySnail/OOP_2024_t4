package Product;

import java.util.Scanner;

import Main.KiemTra;

public class Tool extends Product {
    KiemTra kt = new KiemTra();
    Scanner sc = new Scanner(System.in);
    

    public Tool(String product_id, String product_name, int price) {
        super(product_id, product_name, price);
    }

    public Tool(String maSP, String tenSP, int donGia,int num) {
        super(maSP, tenSP, donGia,num);
        this.category = "Tool";
    }

    public Tool(String product_id, String product_name, int price, String category, int itemnum) {
        super(product_id, product_name, price, category, itemnum);
    }
    public Tool() {
        this.category = "Tool";
    }

    

    @Override
    public void nhap() {
        System.out.print("Nhap vao ma san pham: ");
        String maSP = kt.kiemtraMaSanpham();
        setProduct_id(maSP); 
        System.out.print("Nhap vao ten san pham: ");
        String tenSP = kt.nhapChuoi();
        setProduct_name(tenSP);
        System.out.print("Nhap vao gia cua san pham: ");
        int gia = kt.KiemTraNhapSoNguyen();
        setPrice(gia);
        System.out.print("Nhap vao so luong cua san pham: ");
        int sl = kt.KiemTraNhapSoTuNhien();
        setItemnum(sl);
    }


    public void xuat(){
        System.out.printf("%-25s%-25s%-21s%-26d%-13d\n", this.category , getProduct_id() , getProduct_name() , getPrice(),getItemnum());
    }

    @Override
    public String toString() {
        return category + "," + itemnum + "," + getProduct_id()
        + "," + getItemnum() + "," + getProduct_name()
        + "," + getPrice();
    }
    
    
}
