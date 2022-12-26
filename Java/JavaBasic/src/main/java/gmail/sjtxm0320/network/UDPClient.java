package gmail.sjtxm0320.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Send Message: ");

                String msg = sc.nextLine();

                // 보낼 곳의 IP 생성
                InetAddress addr = InetAddress.getByName("192.168.0.19");

                // 소켓 생성
                DatagramSocket ds = new DatagramSocket();

                // 보낼 패킷 생성
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, 8888);

                ds.send(dp);
                ds.close();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
