package com.anushachandran1502.dungeongame;

import java.util.Scanner;

public class DungeonGame {
		private static DungeonGame dungeonGame=null;
		private Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		dungeonGame=new DungeonGame();
		dungeonGame.Question2();
		
	}

	private void Question2() {		
		System.out.println("Enter the Rows");
		int row=scanner.nextInt();
		System.out.println("Enter the column");
		int column=scanner.nextInt();
		System.out.println("Position of Adverturer row");
		int adRow=scanner.nextInt();
		System.out.println("Position of Adverturer Column");
		int adCol=scanner.nextInt();
		System.out.println("Position of Monster row");
		int mRow=scanner.nextInt();
		System.out.println("Position of Monster Column");
		int mCol=scanner.nextInt();
		System.out.println("Position of  Gold row");
		int gRow=scanner.nextInt();
		System.out.println("Position of  Gold column");
		int gCol=scanner.nextInt();
		dungeonGame.findMinSteps(row,column,adRow,adCol,mRow,mCol,gRow,gCol);
		}
		private void findMinSteps(int row, int column, int adRow, int adCol, int mRow, int mCol, int gRow, int gCol) {
			
			if((adRow>row || adCol>column) && (adRow<row || adCol<column))
			{
					System.out.println("Adventurer position is Limit Exceeded");
				}
				else if((gRow>row || gCol>column)  && (gRow<row || gCol<column))
				{
					System.out.println("Gold position is Limit Exceeded");
				}
				else if((mRow>row || mCol>column)  && (mRow<row || mCol<column))
				{
					System.out.println("Monster position is Limit Exceeded");
				}
				else
				{
					int adGreachPosition=Math.abs(adRow-gRow)+Math.abs(adCol-gCol);
					int mGreachposition=Math.abs(mRow-gRow)+Math.abs(mCol-gCol);
					if(mGreachposition<adGreachPosition)
					{
						System.out.println("No possible solution");
					}
					else
					{
						System.out.println(adGreachPosition);
					}
					
				}

	}

		
}

	
