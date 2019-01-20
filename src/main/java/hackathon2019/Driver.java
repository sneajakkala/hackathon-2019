package hackathon2019;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Driver 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		Scanner data = new Scanner(new File("C:\\Users\\bakub\\eclipse-workspace\\quickstart\\src\\main\\java\\hackathon2019\\data"));
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<String> link = new ArrayList<String>();
		
		while(data.hasNextLine())
		{
			word.add(data.nextLine());
			link.add(data.nextLine());
		}
		/*
		String[] word = {"Again","Hello","How","I Don't Understand","I Understand","My Name Is","Nice To Meet You","No","Sorry","Thank You","Yes","You Sign Too Fast"};
		String[] link = {"https://www.youtube.com/watch?v=NjKxESlhjQo",
				"https://www.youtube.com/watch?v=Q6iAT2LRTlo",
				"https://www.youtube.com/watch?v=-HB2hTJ0VI4", 
				"https://www.youtube.com/watch?v=mqW2lO_d_5o", 
				"https://www.youtube.com/watch?v=Iq7nPVdkZfI", 
				"https://www.youtube.com/watch?v=3upGgnhsGxw", 
				"https://www.youtube.com/watch?v=V3Dxz_LrOc0",
				"https://www.youtube.com/watch?v=8YeRAygTxp0",
				"https://www.youtube.com/watch?v=jINNMaomzSk",
				"https://www.youtube.com/watch?v=6gUv59PSoHI",
				"https://www.youtube.com/watch?v=TjQMj1Dj2ec",
				"https://www.youtube.com/watch?v=jEIX1sPKeDg"};
				
		BinaryTree bst = new BinaryTree(word[0],link[0]);
		for (int x = 1; x < word.length; x++)
		{
			bst.addNode(word[x], link[x]);
		}
		*/
		BinaryTree bst = new BinaryTree(word.get(0), link.get(0));
		for (int x = 1; x < word.size(); x++)
		{
			bst.addNode(word.get(x), link.get(x));
		}
		System.out.print("Enter the word you would like in ASL: ");
		String input = scan.nextLine();
		System.out.println(bst.search(input));
	}
}
