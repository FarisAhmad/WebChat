package br.com.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("127.0.0.1", 12345);
		System.out.println("Client has connected with the server !");

		Scanner scan = new Scanner(System.in);
		PrintStream out = new PrintStream(client.getOutputStream());

		while (scan.hasNextLine()) {
			out.println(scan.nextLine());
		}
		
		out.close();
		scan.close();
		client.close();
	}
}
