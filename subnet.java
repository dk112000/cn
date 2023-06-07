import java.util.Scanner;

public class subnet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the IP address: ");
        String ip = sc.nextLine();
        String[] split_ip = ip.split("\\.");
        String[] split_bip = new String[4];
        String bip = "";

        for (int i = 0; i < 4; i++) {
            split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
            bip += split_bip[i];
        }

        System.out.println("IP in binary is " + bip);
        System.out.print("Enter the number of addresses: ");
        int n = sc.nextInt();

        int bits = (int) Math.ceil(Math.log(n + 2) / Math.log(2)); // Adding 2 to account for network and broadcast addresses
        System.out.println("Number of bits required for address = " + bits);
        int mask = 32 - bits;
        System.out.println("The subnet mask is = " + mask);

        int[] fbip = new int[32];
        int[] lbip = new int[32];

        for (int i = 0; i < 32; i++) {
            fbip[i] = (int) bip.charAt(i) - 48;
            lbip[i] = (int) bip.charAt(i) - 48;
        }

        for (int i = 31; i > 31 - bits; i--) {
            fbip[i] &= 0;
            lbip[i] |= 1;
        }

        String[] fip = { "", "", "", "" };
        String[] lip = { "", "", "", "" };

        for (int i = 0; i < 32; i++) {
            fip[i / 8] += fbip[i];
            lip[i / 8] += lbip[i];
        }

        System.out.print("Subnet address is = ");
        for (int i = 0; i < 4; i++) {
            System.out.print(Integer.parseInt(fip[i], 2));
            if (i != 3)
                System.out.print(".");
        }
        System.out.println();

        System.out.print("Broadcast address is = ");
        for (int i = 0; i < 4; i++) {
            System.out.print(Integer.parseInt(lip[i], 2));
            if (i != 3)
                System.out.print(".");
        }
        System.out.println();
    }

    static String appendZeros(String s) {
        String temp = "00000000";
        return temp.substring(s.length()) + s;
    }
}
