package com.anushachandran1502.dungeongame;

import java.util.Scanner;

public class DungeonGame {
		private static DungeonGame dungeonGame=null;
		private Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		dungeonGame=new DungeonGame();
		dungeonGame.Question1();
		
	}

	private void Question1() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Rows");
		int row=scanner.nextInt();
		System.out.println("Enter the column");
		int column=scanner.nextInt();
		char[][] playGround=new char[row][column];
		System.out.println("Position of Adverturer row");
		int adRow=scanner.nextInt();
		System.out.println("Position of Adverturer Column");
		int adCol=scanner.nextInt();
		System.out.println("Position of  Gold row");
		int gRow=scanner.nextInt();
		System.out.println("Position of  Gold column");
		int gCol=scanner.nextInt();
		int minSteps=0;
		 minSteps=dungeonGame.findMinSteps(row,column,adRow,adCol,gRow,gCol,minSteps);
		 System.out.println("Minimum Steps : "+minSteps);
	}

	private int findMinSteps(int row, int column, int adRow, int adCol, int gRow, int gCol,int minSteps) {
		if((adRow>row || adCol>column) && (adRow<row || adCol<column))
		{
			System.out.println("Adventurer position is Limit Exceeded");
		}
		else if((gRow>row || gCol>column)  && (gRow<row || gCol<column))
		{
			System.out.println("Gold position is Limit Exceeded");
		}
		else
		{
			return Math.abs(adRow-gRow)+Math.abs(adCol-gCol);
		}
		return 0;
	}

		
}

