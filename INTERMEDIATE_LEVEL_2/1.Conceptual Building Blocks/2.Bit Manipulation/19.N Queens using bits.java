import java.io.*;
import java.util.*;
/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
     Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
               Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation 
               and not test you.
               
Input : 4
Output :  
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

*/
public class Main {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
      
      
// cols : represent the bits that we are going to block, for the particular column 
// ndiag: Blocking in the normal diagonal 
// rdiag :Blocking in the  reverse diagonal
 if(row == board.length){
     System.out.println(asf + ".");
     return ; 
 }

  for(int col = 0 ; col < board.length ; col++ ){
      if (
          
          ((cols & (1 << col)) == 0) &&  
           ((ndiag & (1 << (row + col))) == 0) &&
           ((rdiag  & (1 << (row - col + board.length -1)))== 0) 
      )
      {
          
          board [row][col] = true ; // putting the queen
          cols ^= (1<< col) ;
          ndiag ^= (1 << (row + col)) ;
          rdiag ^= (1 << (row - col + board.length -1)) ; 
          solution(board,row+1,cols,ndiag,rdiag,asf + row + "-" + col + ", ");
          // backtrack
           
          cols ^= (1<< col) ;
          ndiag ^= (1 << (row + col)) ;
          rdiag ^= (1 << (row - col + board.length -1)) ; 
          board [row][col] = false ;
      }
  }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}