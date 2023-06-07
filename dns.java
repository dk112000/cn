import java.net.InetAddress;

class dns {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Enter java dns (add/url)");
            return;
        }

        String input = args[0];
        InetAddress[] address = InetAddress.getAllByName(args[0]);

        if (Character.isDigit(input.charAt(0))) {
            // IP address provided
            System.out.println("URL: "+ address[0].getHostName());
        } else {
            // URL provided
            System.out.println("IP: "+ address[0].getHostAddress());
        }
    }
}

