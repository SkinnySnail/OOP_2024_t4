package Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DanhSachGioHang implements iReaderWriter{ 
    private ArrayList<GioHang> dsGioHang;

    public DanhSachGioHang(){
        this.dsGioHang = new ArrayList<>();
    }

    public void xoaGH(int vitri) {
    	this.dsGioHang.remove(vitri);
    }
    public void themVaoDanhSachGH(GioHang gioHang){
        gioHang.setMaGH(laySize());
        this.dsGioHang.add(gioHang);
    }
    public void inDanhSachGioHang(){
        try {
            for (GioHang gioHang : dsGioHang) {
                gioHang.inGioHang();
            }
        } catch (Exception e) {
        }
    }
    public int laySize(){
        return this.dsGioHang.size();
    }

    public GioHang layGHtheoMa(String maGH){
        for (GioHang gioHang : dsGioHang) {
            if(gioHang.getMaGH().equals(maGH)){
            	gioHang.inGioHang();
            	return gioHang;
            }
        }
        return null;
    }

    @Override
    public void ghiDataXuongFile() {
        try {
            FileWriter fw = new FileWriter("dataGioHang.txt");
            for (GioHang gioHang : dsGioHang) {
                fw.write(gioHang.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @Override
    public void docDataTuFile(){ 
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataGioHang.txt"));
            String line;
            while((line = br.readLine()) != null){
                GioHang gioHangTemp = new GioHang();
                gioHangTemp.setMaGH(this.laySize());
                String[] parts = line.split(",");
                boolean firstElement = true;
                for (String string : parts) {
                    if(firstElement){
                        firstElement = false;
                        continue;
                    }
                    gioHangTemp.themVaoGio(string.trim());
                }
                this.dsGioHang.add(gioHangTemp);
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
