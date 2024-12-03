import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class paymentmodify{
    public static void suathongtin(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhSachhoadon = new ArrayList<>();
        ArrayList<String> dshoadon = new ArrayList<>();
        try (BufferedReader doc = new BufferedReader(new FileReader("incart.txt"))){
            String dong;
            ArrayList<String> hoadon = new ArrayList<>();
            while ((dong = doc.readLine()) != null){
                if (dong.trim().equals("----------------------")){
                    if (!hoadon.isEmpty()){
                        danhSachhoadon.addAll(hoadon);
                        danhSachhoadon.add("----------------------");
                        dshoadon.addAll(hoadon);
                        dshoadon.add("----------------------");
                        hoadon.clear();
                    }
                } else{
                    hoadon.add(dong);
                }
            }
            if (!hoadon.isEmpty()){
                danhSachhoadon.addAll(hoadon);
                dshoadon.addAll(hoadon);
            }
        } catch (Exception e){
            System.out.println("Loi khong doc duoc file");
            return;
        }
        
        if (danhSachhoadon.isEmpty()){
            System.out.println("Khong ton tai hoa don");
            return;
        }
        
        System.out.println("Cac hoa don : ");
        int soLuonghoadon = 0;
        int vtbatdau = 0;
        for (int i = 0; i < danhSachhoadon.size(); i++){
            if (danhSachhoadon.get(i).equals("----------------------")){
                soLuonghoadon++;
                System.out.println("Hóa đơn " + soLuonghoadon + ":");
                for (int j = vtbatdau; j < i; j++){
                    System.out.println((j - vtbatdau + 1) + ". " + danhSachhoadon.get(j));
                }
                System.out.println("----------------------");
                vtbatdau = i + 1;
            }
        }
        
        System.out.print("Chon so thu tu hoa don muon sua: ");
        int thuTu = sc.nextInt();
        sc.nextLine();
        
        if (thuTu < 1 || thuTu > soLuonghoadon){
            System.out.println("Lua chon khong hop le");
            return;
        }
        
        int vtbatdau2 = 0;
        int hdhientai = 1;
        
        for (int i = 0; i < danhSachhoadon.size(); i++){
            if (danhSachhoadon.get(i).equals("----------------------")){
                if (hdhientai == thuTu){
                    break;
                }
                vtbatdau2 = i + 1;
                hdhientai++;
            }
        }
        
        ArrayList<String> hoadonSua = new ArrayList<>();
        int vtketthuc = vtbatdau2;
        
        while (vtketthuc < danhSachhoadon.size() && !danhSachhoadon.get(vtketthuc).equals("----------------------")){
            hoadonSua.add(danhSachhoadon.get(vtketthuc));
            vtketthuc++;
        }
        
        String phuongThucTT = "";
        for (String dong : hoadonSua){
            if (dong.contains("Phuong thuc thanh toan")){
                phuongThucTT = dong.split(" : ")[1].trim();
                break;
            }
        }
        
        payment hoadonmoi;
        
        if (phuongThucTT.equals("Tien mat")){
            hoadonmoi = new cashpayment();
            hoadonmoi.setPhuongthuctt("Tien mat");
            
            String tenThuNgan = "";
            for (String dong : hoadonSua){
                if (dong.contains("Ten thu ngan")){
                    tenThuNgan = dong.split(" : ")[1].trim();
                    break;
                }
            }
            
            ((cashpayment)hoadonmoi).setTenthungan(tenThuNgan);
        } else if (phuongThucTT.equals("The ngan hang")){
            hoadonmoi = new cardpayment();
            hoadonmoi.setPhuongthuctt("The ngan hang");
            
            String soThe = "";
            String loaiThe = "";
            String tenChuThe = "";
            
            for (String dong : hoadonSua){
                if (dong.contains("So the")){
                    soThe = dong.split(" : ")[1].trim();
                } else if (dong.contains("Loai the")){
                    loaiThe = dong.split(" : ")[1].trim();
                } else if (dong.contains("Ten chu the")){
                    tenChuThe = dong.split(" : ")[1].trim();
                }
            }
            
            ((cardpayment)hoadonmoi).setSothe(soThe);
            ((cardpayment)hoadonmoi).setLoaithe(loaiThe);
            ((cardpayment)hoadonmoi).setTenchuthe(tenChuThe);
        } else{
            System.out.println("Khong the sua hoa don");
            return;
        }
        double soTienTT = 0.0;
        String trangThaiTT = "";
        
        for (String dong : hoadonSua){
            if (dong.contains("So tien thanh toan")){
                soTienTT = Double.parseDouble(dong.split(" : ")[1].trim());
            } else if (dong.contains("Trang thai thanh toan")){
                trangThaiTT = dong.split(" : ")[1].trim();
            }
        }
        
        hoadonmoi.setSotientt(soTienTT);
        hoadonmoi.setTrangthaitt(trangThaiTT);
        
        hoadonmoi.nhap();
        dshoadon.subList(vtbatdau2, vtketthuc).clear();
        String[] thaythe = hoadonmoi.toString().split("\n");
        for (int i = 0; i < thaythe.length; i++){
            dshoadon.add(vtbatdau2 + i, thaythe[i]);
        }
        
        if (hoadonmoi instanceof cashpayment){
            cashpayment cashPayment = (cashpayment) hoadonmoi;
            dshoadon.add(vtbatdau2 + thaythe.length, 
                "So tien khach tra : " + cashPayment.getSotiennhan());
            dshoadon.add(vtbatdau2 + thaythe.length + 1, 
                "So tien tra lai : " + cashPayment.getSotientl());
        } else if (hoadonmoi instanceof cardpayment){
            cardpayment cardPayment = (cardpayment) hoadonmoi;
            dshoadon.add(vtbatdau2 + thaythe.length, 
                "So tien khach tra : " + cardPayment.getsotiennhan());
            dshoadon.add(vtbatdau2 + thaythe.length + 1, 
                "So tien tra lai : " + cardPayment.getSotientl());
        }
        try (BufferedWriter ghi = new BufferedWriter(new FileWriter("incart.txt"))){
            for (int i = 0; i < dshoadon.size(); i++){
                ghi.write(dshoadon.get(i));
                ghi.newLine();
                if (dshoadon.get(i).equals("----------------------")){
                    continue;
                }
                if ((i + 1 < dshoadon.size() && dshoadon.get(i + 1).equals("----------------------"))){
                    continue;
                }
            }
            System.out.println("Da sua hoa don!");
        } catch (Exception e){
            System.out.println("Loi khong ghi duoc file");
        }
    }
}
