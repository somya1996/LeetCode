package Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Chocolate_Distribution_Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int chocolatePacket[] = new int[n];
		for(int i=0; i<chocolatePacket.length; i++){
			chocolatePacket[i] = sc.nextInt();
		}

		int student = sc.nextInt();
		int minimum_difference_in_packet = chocolate(chocolatePacket , student);
		System.out.println(minimum_difference_in_packet);
	}
	public static int chocolate(int[] packet , int student){
		Arrays.sort(packet);
		int diff = 0;
		for(int i=0; i<packet.length - student; i++){
			diff = Math.min(packet[i] - packet[i+student] , diff);
		}
		return diff;
	}

}
