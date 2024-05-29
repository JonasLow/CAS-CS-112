public class StringTest {
    public static void main(String[] args) {
        String s1 = "Boston";
        String s2 = "University";
        
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.substring(3, 6));

        System.out.println(s2.substring(0, 3));
        System.out.println(s2.toUpperCase().substring(0,3));
        System.out.println(s2.substring(3, 4));
        System.out.println(s1.toUpperCase().substring(2, 6) + s2.toUpperCase().substring(4, 5));

        System.out.println(replaceStart("abc", "xxxxxxx"));
        System.out.println(replaceStart("hello", "bye"));
    }


    public static String replaceStart(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        if (s1Len > s2Len) {
            return s1;
        } else {
            return s1 + s2.substring(s1Len,s2Len);
        }
    }
}
