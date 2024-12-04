import java.util.Scanner;

public class DiaChi {
    public String SoDuong;
    public String TenDuong;
    public String Quan;
    public String ThanhPho;

    // Constructor
    public DiaChi() {}

    public DiaChi(String soduong, String tenduong, String quan, String thanhpho) {
        SoDuong = soduong;
        TenDuong = tenduong;
        Quan = quan;
        ThanhPho = thanhpho;
    }
    
     public String getSoDuong() {
        return SoDuong;
    }

    public void setSoDuong(String soduong) {
    SoDuong = soduong;
    }
    
     public String getTenDuong() {
        return TenDuong;
    }

    public void setTenDuong(String tenduong) {
    TenDuong = tenduong;
    }
    
     public String getQuan() {
        return Quan;
    }

    public void setQuan(String quan) {
    Quan = quan;
    }
    
     public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhpho) {
    ThanhPho = thanhpho;
    }
    

    
    public void nhapdiachi(){
        try (Scanner re = new Scanner(System.in)) {
            System.out.print("Nhập số đường: ");
            SoDuong=re.nextLine();
            System.out.print("Nhập tên đường: ");
            TenDuong=re.nextLine();
            System.out.print("Nhập quận: ");
            Quan=re.nextLine();
            System.out.print("Nhập tên thành phố: ");
            ThanhPho=re.nextLine();
        }
    }

    // Override toString
    @Override
    public String toString() {
        return SoDuong + ", " + TenDuong + ", " + Quan + ", " + ThanhPho;
    }
}