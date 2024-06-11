package practice;

import java.util.Scanner;


public class Pract {
	int[] number;
	int size;
	int[] undolist;
	int undoSize;
	int num;
	static Scanner input = new Scanner(System.in);
	
	Pract(){
		number = new int[100];
		size = 0;
		undolist = new int[100];
		undoSize = 0;
	}
	
	public void printArr() {
		System.out.print("Data: ");
		for(int i=0; i<size; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
	}
	
	public void printUndo() {
		System.out.print("Undo list (top..0): ");
		for(int i=0; i<undoSize; i++) {
			System.out.print(undolist[i] + " ");
		}
		System.out.println();
	}
	
	public void select(String select) {
		switch (select) {
		case "I":
		case "i":
			System.out.print("Insert: ");
			num = input.nextInt();
			insert(num);
			Display();
			break;
		case "U":
		case "u":
			System.out.print("Undo: ");
			num = input.nextInt();
			undo(num);
			Display();
			break;
		case "E":
		case "e":
			System.out.print("Exit.");
			break;
		default :
			System.out.print("Invalide select option, Please try again!!");
			Display();
			break;
		}
	}
	
	public void insert(int data) {
		number[size] = data;
		size += 1;
	}
	
	public void undo(int time) {
		for(int i=0; i<time; i++) {
            if (size > 0) {
                undolist[undoSize] = number[size-1];
                number[size-1] = -1;
                undoSize += 1;
                size -= 1;
            }
        }
	}
	
	public void Display() {
		System.out.println();
		System.out.println("Practice");
		System.out.println("B6602727 Tanee Thongpak");
		System.out.println("----------------------------------------");
		printArr();
		printUndo();
		System.out.println("Menu:");
		System.out.println("	I: Insert number into array.");
		System.out.println("	U: Undo the previously change.");
		System.out.println("	E: Exit.");
		System.out.print("Select: ");
		String select = input.next();
		select(select);
	}
	
	public static void main(String[] args) {
		Pract p = new Pract();
		p.Display();
	}
}
