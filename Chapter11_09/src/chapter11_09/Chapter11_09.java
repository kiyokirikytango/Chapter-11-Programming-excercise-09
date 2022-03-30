/*
Chapter 11 Programming excercise 09
Riky Hernandez
10/11/21
Description: Ptogram that fills in 0 and 1 in a Matrix,finds the rows/Col with the most 1s
         _..._
      .'     '.      _
     /    .-""-\   _/ \
   .-|   /:.   |  |   |
   |  \  |:.   /.-'-./
   | .-'-;:__.'    =/
   .'=  *=|NASA _.='
  /   _.  |    ;
 ;-.-'|    \   |
/   | \    _\  _\
\__/'._;.  ==' ==\
         \    \   |
         /    /   /
         /-._/-._/
         \   `\  \
          `-._/._/
*/
package chapter11_09;
import java.util.Scanner;
import java.util.ArrayList;

public class Chapter11_09 {

  public static int[][] getMatrix(Scanner input) {
    System.out.print("Enter the array size n: ");
    int size = input.nextInt();                               //makin the size of the array accordin to user inputt
    int[][] matrix = new int[size][size];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = (int)(Math.random() * 2);                        // between 0 and 1
      }
    }
    return matrix;
  }
  
  public static void displayMatrix(int[][] matrix) {                    // matrix box format
    for (int i = 0; i < matrix.length; i++) {                               //ex; https://stackoverflow.com/questions/5061912/printing-out-a-2d-array-in-matrix-format    
      for (int j = 0; j < matrix[i].length; j++) {              
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
   
   public static void displayList(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {                             //print out all the elements of a List
      System.out.print(list.get(i));                                         //ex:https://stackoverflow.com/questions/10168066/how-to-print-out-all-the-elements-of-a-list-in-java/24109978      
      if (i == list.size() - 1) 
      { break; }
      System.out.print(", ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] matrix = getMatrix(input);
    displayMatrix(matrix);

    ArrayList<Integer> rows = new ArrayList<>();
    ArrayList<Integer> cols = new ArrayList<>();

    int maxRow = 0;
    int count;
                                                                             // check rows for max 1
    for (int i = 0; i < matrix.length; i++) {
      count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count > maxRow) { maxRow = count; }
    }

    int maxCol = 0;
                                                                                        // check columns for max 1
    for (int j = 0; j < matrix[0].length; j++) {
      count = 0;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count > maxCol) { maxCol = count; }
    }

                                                                             // checks if more than 1 row or column has max 1
                                                                    // find all rows with max 1
    for (int i = 0; i < matrix.length; i++) {
      count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count == maxRow) { rows.add(i); }
    }

                                                                                    // find all columns with max 1
    for (int j = 0; j < matrix[0].length; j++) {
      count = 0;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count == maxCol) { cols.add(j); }
    }

    System.out.print("The largest row index: ");
    displayList(rows);

    System.out.print("The largest column index: ");
    displayList(cols);
  }
}
