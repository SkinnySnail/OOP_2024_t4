package Payment;
public class kiemtraso {
    public static boolean hople(String n) {
        for (int i = 0; i < n.length(); i++) {
            char a = n.charAt(i);
            if (!Character.isDigit(a)) {
                return false;
            }
        }
        return true;
    }
}
