package com.anushachandran1502.dungeongame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGame {
		private static DungeonGame dungeonGame=null;
		private Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		dungeonGame=new DungeonGame();
		dungeonGame.Question5();
		
	}

	private void Question5() {		
		System.out.println("Enter the Rows");
		int row=scanner.nextInt();
		System.out.println("Enter the column");
		int column=scanner.nextInt();
		int[][] rooms=new int[row][column];
		System.out.println("Position of Adverturer row");
		int adRow=scanner.nextInt();
		System.out.println("Position of Adverturer Column");
		int adCol=scanner.nextInt();
		System.out.println("Position of Gold row");
		int gRow=scanner.nextInt();
		System.out.println("Position of Gold Column");
		int gCol=scanner.nextInt();
		System.out.println("Position of Monsster row");
		int mRow=scanner.nextInt();
		System.out.println("Position of Monster Column");
		int mCol=scanner.nextInt();
		
		System.out.println("Enter the number of pits");
		int nPits=scanner.nextInt();
		for (int i = 0; i < nPits; i++) {
			System.out.println("Enter the Position of pit" + (i + 1));
			int pitRow = scanner.nextInt();
			int pitCol = scanner.nextInt();
			if (pitRow > row || pitRow <= 0 || pitCol > column || pitCol <= 0)
				System.out.println("Pits are not in the limit");
			else
				rooms[pitRow - 1][pitCol - 1] = 1;
		}
		if (row <= 0 || column <= 0)
			System.out.println("Invalid only positive values Row and column");
		else if (adRow > row || adCol > column || adRow <= 0 || adCol <= 0) {
			System.out.println("Adventure position is limit exceeded");
		} else if (mRow > row || mCol > column || mRow <= 0 || mCol <= 0) {
			System.out.println("Mon position is limit exceeded");
		}
		else
		{
		
			int adventurePath = Math.abs(adRow - gRow) + Math.abs(adCol - gCol);
				int monsterPath = Math.abs(mRow-1 - gRow) + Math.abs(mCol -1- gCol);
			dungeonGame.findMonPath(row - 1, column - 1, adRow - 1, adCol - 1, gRow - 1, gCol - 1, rooms,monsterPath);
		}
	}
		private void findMonPath(int row, int column, int adRow, int adCol, int gRow, int gCol, int[][] rooms,int mPath ) {
			if ((adRow + 1 < rooms.length && rooms[adRow + 1][adCol] == 1) && (adRow - 1 >= 0 && rooms[adRow - 1][adCol] == 1)
					&& (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] == 1)
					&& (adCol - 1 >= 0 && rooms[adRow][adCol - 1] == 1))
			{
				List<List<Integer>> list = new ArrayList<>();
					leftToRight(rooms, adRow, adCol, gRow, gCol, list);
					if(list.size()<mPath)
						System.out.println("Minimum Number of Steps " + (list.size() - 1));
					else
						System.out.println("No Possible solution");
					
			}
				else
				{
					List<List<Integer>> list = new ArrayList<>();
						leftToRight(rooms, adRow, adCol, gRow, gCol, list);

					rightToLeft(rooms, adRow, adCol, gRow, gCol, list);
					if(list.size()<mPath)
						System.out.println("Minimum Number of Steps " + (list.size() - 1));
					else
						System.out.println("No Possible solution");
					
				}
				
		}
		
		private void rightToLeft(int[][] rooms, int adRow, int adCol, int gRow, int gCol, List<List<Integer>> list) {
			List<Integer> li;
			while (adRow < rooms.length) {
				li = new ArrayList<>();
				li.add(adRow + 1);
				li.add(adCol + 1);
				if (!list.contains(li))
					list.add(li);
				if (adRow == gCol)
					break;
				if (adRow < gCol) {
					if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if(adRow-1>=0&&rooms[adRow-1][adCol]!=1)
						adRow--;
				}
				if (gCol < adRow) {
					if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if(adRow+1<rooms.length&&rooms[adRow+1][adCol]!=1)
						adRow++;
				}
			}
			while (adCol < rooms[0].length) {
				li = new ArrayList<>();
				li.add(adRow + 1);
				li.add(adCol + 1);
				if (!list.contains(li))
					list.add(li);
				if (adCol == gRow)
					break;
				if (adCol < gRow) {
					if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if(adCol-1>=0&&rooms[adRow][adCol-1]!=0)
						adCol--;
				}

				if (gRow < adCol) {
					if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if(adCol+1<rooms[0].length&&rooms[adRow][adCol+1]!=1)
						adCol++;
				}
			}

					}

		private void leftToRight(int[][] rooms, int adRow, int adCol, int gRow, int gCol, List<List<Integer>> list) {
			List<Integer> li;
			while (adCol < rooms[0].length) {
				li = new ArrayList<>();
				li.add(adRow + 1);
				li.add(adCol + 1);
				if (!list.contains(li))
					list.add(li);
				if (adCol == gCol)
					break;
				else if (adCol < gCol) {
					if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
				}

				else {
					if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
				}
			}
			while (adRow < rooms.length) {
				li = new ArrayList<>();
				li.add(adRow + 1);
				li.add(adCol + 1);
				if (!list.contains(li))
					list.add(li);
				if (adRow == gRow)
					break;
				else if (adRow < gRow) {
					if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
					else if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 0)
						adRow--;
				} else {
					if (adRow - 1 >= 0 && rooms[adRow - 1][adCol] != 1)
						adRow--;
					else if (adCol + 1 < rooms[0].length && rooms[adRow][adCol + 1] != 1)
						adCol++;
					else if (adCol - 1 >= 0 && rooms[adRow][adCol - 1] != 1)
						adCol--;
					else if (adRow + 1 < rooms.length && rooms[adRow + 1][adCol] != 1)
						adRow++;
				}
			}
		}	
}

	
