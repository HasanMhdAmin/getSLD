package hostname;

/**
 * Created by Hasan Mhd Amin
 **/

public class Test {

    public static void main(String[] args) {

        String[] urls = new String[]{
                "https://www.example.com/watch?v=TEST",
                "https://en.example.org/wiki/Software",
                "http://one.two.three.four.example.com",
                "one.two.three.four.example.com",
                "https://www.example.co.uk",
                "example.com/",
                "http://example.com",
        };

        for (String url : urls) {
            try {
                String host = Hostname.getHostname(url);
                System.out.println("host: " + host);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
