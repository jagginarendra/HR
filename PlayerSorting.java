package com.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
		
	String name;
	int score;
	
	public Player(String name , int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player>{

	@Override
	public int compare(Player p1, Player p2) {
		if(p1.score == p2.score){
			return (p1.name.compareTo(p2.name));
		}
		return -1 * (p1.score - p2.score);
	}
	
}

public class PlayerSorting {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
	}

}
