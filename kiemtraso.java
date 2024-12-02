public class kiemtraso {
    public static boolean hople(String n) {
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
