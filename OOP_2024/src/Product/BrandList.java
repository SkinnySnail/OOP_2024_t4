package Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandList implements iReaderWriter {
    ArrayList<Brand> BList;
    Scanner sc = new Scanner(System.in);
    public BrandList() {
        BList = new ArrayList<>();
    }
    
    public void themVaoList(){
                Brand bra = new Brand();
                bra.nhap();
                this.BList.add(bra);
            
    }

    // các hàm xóa
    public void xoaNCC(int vitri){
        this.BList.remove(vitri);
    }

    public void xoaNCC(String maNCC){
        for (Brand bra : BList) {
            if(bra.getBrand_id().equals(maNCC)){
                this.BList.remove(bra);
            }
        }
    }

    public void clearList(){
        this.BList.clear();
        System.out.println("Da xoa thong tin trong list.");
    }

    // Các hàm in 
    public void inList(){
        System.out.println("----------------------- List -----------------------");
        for (Brand bra : BList) {
            bra.xuat();
        }
        System.out.println("----------------------------------------------------");
    }

public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataNCC.txt");
            for (Brand bra : this.BList) {
                fw.write(bra.toString()+ "\n");
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
            BufferedReader br = new BufferedReader(new FileReader("dataNCC.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String maNCC = parts[0].trim();
                String tenNCC = parts[1].trim();
                this.BList.add(new Brand(maNCC, tenNCC));
            }
            br.close();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}
