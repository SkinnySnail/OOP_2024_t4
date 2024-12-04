package Account;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListAccount implements Iterable<Account> {
    private ArrayList<Account> accounts;
    private int n;
    Scanner sc = new Scanner(System.in);

    public ListAccount() {
        accounts = new ArrayList<>();
        n = 0;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        n++;
    }

    // Thêm phương thức kiểm tra xem một tài khoản có tồn tại trong danh sách không
    public boolean containsAccount(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void readAccount(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("ListAccount.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String username = parts[1];
                String password = parts[0];
                String role = parts[2];
                if(role.equals("CUS")){
                    CustomerAcc cus1 = new CustomerAcc(username, password, "",role);
                    addAccount(cus1);
                }else if(role.equals("EMP")){
                    Employeerights emp1 = new Employeerights(username, password, "",role);
                    addAccount(emp1);
                }

            }
            br.close();
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

    public void printAcc() {
        System.out.println("==============DANH SACH TAI KHOAN=============");
        for (Account account : accounts) {
            System.out.print("Tai khoan la : " + account.username);
            System.out.print(" -- Mau khau la : " + account.password + "\n");
        }
    }

    public void deleteAccount(String username) throws IOException {
        Iterator<Account> iterator = accounts.iterator();

        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUsername().equals(username)) {
                iterator.remove();
                break; // Break once the account is found and removed
            }
        }

        writeAccount();
        System.out.println("Đã xóa tài khoản thành công.");
    }

    public void writeAccount() throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListAccount.txt", false))) {
            for (Account account : accounts) {
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
            }
        }
    }

    public void deleteFileghiorder() throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ghiorder.txt"))) {
            writer.write("");
        }
    }

    public boolean isFileEmpty() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("ghiorder.txt"))) {
            // Đọc một dòng từ file, nếu không có dòng nào thì file là rỗng
            return reader.readLine() == null;
        }
    }

    public boolean TKandMK(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true; // Match found
            }
        }
        return false; // No match found
    }

    @Override
    public Iterator<Account> iterator() {
        return accounts.iterator();
    }

    public static void main(String[] args) {
        ListAccount listAccount = new ListAccount();

        try {
            listAccount.readAccount();
            // listAccount.readAccount();
            listAccount.printAcc();

            // listAccount.printAcc();

            // listAccount.deleteAccount("usernameToDelete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}