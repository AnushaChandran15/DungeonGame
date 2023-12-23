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
						System.out.println("Maximum "+adGreachPosition);
						dungeonGame.pathPrint(adRow,adCol,mRow,mCol,gRow,gCol,true);
					}
					
				}
	}

		private void pathPrint(int adRow, int adCol, int mRow, int mCol, int gRow, int gCol,boolean possible) {
			//System.out.println("in");
			List<List<Integer>> pathList=new ArrayList<List<Integer>>();
			int sx=adRow,sy=adCol,ex=gRow,ey=gCol;
			if(sx<ex)
			{
			while(possible)
			{
				ArrayList<Integer> path=new ArrayList<Integer>();
				path.add(sx);
				path.add(sy);
				if(!pathList.contains(path))
				{
					pathList.add(path);
				}
				if(sy==ey)
				{
					break;
				}
				if(sy<ey)
				{
					sy++;
				}
				if(sy>ey)
				{
					sy--;
				}
			}
			while(possible)
			{
				ArrayList<Integer> path=new ArrayList<Integer>();
				path.add(sx);
				path.add(sy);
				if(!pathList.contains(path))
				{
					pathList.add(path);
				}
				if(sx==ex)
				{
					break;
				}
				if(sx<ex)
				{
					sx++;
				}
				if(sx>ex)
				{
					sx--;
				}
			}
			System.out.println(pathList);
		}
			else
			{
				while(possible)
				{
					ArrayList<Integer> path=new ArrayList<Integer>();
					path.add(sx);
					path.add(sy);
					if(!pathList.contains(path))
					{
						pathList.add(path);
					}
					if(sx==ex)
					{
						break;
					}
					if(sx<ex)
					{
						sx++;
					}
					if(sx>ex)
					{
						sx--;
					}
				}
				while(possible)
				{
					ArrayList<Integer> path=new ArrayList<Integer>();
					path.add(sx);
					path.add(sy);
					if(!pathList.contains(path))
					{
						pathList.add(path);
					}
					if(sy==ey)
					{
						break;
					}
					if(sy<ey)
					{
						sy++;
					}
					if(sy>ey)
					{
						sy--;
					}
				}
System.out.println(pathList);	
			}
		
		}	
}

	
