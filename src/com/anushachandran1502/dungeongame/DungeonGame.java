package com.anushachandran1502.dungeongame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGame {
		private static DungeonGame dungeonGame=null;
		private Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		dungeonGame=new DungeonGame();
		dungeonGame.Question3();
		
	}

	private void Question3() {		
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
		System.out.println("Position of tigger  row");
		int tRow=scanner.nextInt();
		System.out.println("Position of tigger Column");
		int tCol=scanner.nextInt();
		System.out.println("Position of  Gold row");
		int gRow=scanner.nextInt();
		System.out.println("Position of  Gold column");
		int gCol=scanner.nextInt();
		dungeonGame.findMinSteps(row,column,adRow,adCol,mRow,mCol,tRow,tCol,gRow,gCol);
		}
		private void findMinSteps(int row, int column, int adRow, int adCol, int mRow, int mCol,int tRow,int tCol, int gRow, int gCol) {
			
			if (adRow>row || adCol>column)
			{
					System.out.println("Adventurer position is Limit Exceeded");
				}
				else if(gRow>row || gCol>column)
				{
					System.out.println("Gold position is Limit Exceeded");
				}
				else if(mRow>row || mCol>column)
				{
					System.out.println("Monster position is Limit Exceeded");
				}
				else
				{
					int adGreachPosition=Math.abs(adRow-gRow)+Math.abs(adCol-gCol);
					int mGreachposition=Math.abs(mRow-gRow)+Math.abs(mCol-gCol);
					if(mGreachposition<adGreachPosition)
					{
						//System.out.println("No possible solution");
						if(tRow>row || tCol>column)
						{
								System.out.println("Tigger position is Limit Exceeded");
						}
						else
						{
							int adTGreachPosition=Math.abs(adRow-tRow)+Math.abs(adCol-tCol);
							int tGreachPosition=Math.abs(tRow-gRow)+Math.abs(tCol-gCol);
							System.out.println("Mininum number of Steps :"+(adTGreachPosition+tGreachPosition));
		
						}
						
					}
					else
					{
					
						System.out.println("Mininum number of Steps :"+adGreachPosition);
					}
					
				}
		}	
}

	
