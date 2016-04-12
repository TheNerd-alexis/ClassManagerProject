package svn;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpTest {
	public static void main(String[] args) {
		Thread receiver = new Thread(new udpReceiverThread());
		receiver.start();
		Thread sender = new Thread(new udpSenderThread(receiver));
		sender.start();

	}
}

class udpSenderThread implements Runnable {
	Scanner input = new Scanner(System.in);
	Thread receiver;

	public udpSenderThread(Thread receiver) {
		this.receiver = receiver;
	}

	@Override
	public void run() {
		try {
			InetAddress destIP = InetAddress.getByName("70.12.109.255");
			InetAddress myIP = InetAddress.getLocalHost();
			DatagramSocket socket = new DatagramSocket();
			String msg;
			byte[] buf;
			while (true) {
				msg = input.nextLine();
				if (receiver.getState() == Thread.State.TERMINATED) {
					System.out.println("receiver 끊어짐");
					break;
				}
				buf = msg.getBytes("UTF-8");
				DatagramPacket packet = new DatagramPacket(buf, buf.length, destIP, 5000);
				socket.send(packet);
				if (msg.equals("quit")){
					packet.setAddress(InetAddress.getLocalHost());
					System.out.println("내 receiver에 quit 입력");
					socket.send(packet);
					break;
				}
			}
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class udpReceiverThread implements Runnable {

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			byte[] buf;
			String msg;

			while (true) {
				buf = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				msg = new String(buf, "UTF-8").trim();
				System.out.println(packet.getAddress() + ">" + msg);
				if (msg.equals("quit"))
					break;

				// DatagramPacket packet = new DatagramPacket(buf,buf.length);
			}
			System.out.println("Receiver 종료");

			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
