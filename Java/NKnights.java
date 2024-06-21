import java.util.Scanner;

public class NKnights {
    static boolean issafe(boolean[][] board,int r ,int c){
        if(isValid(board,r-2,c-1)) {
            if(board[r-2][c-1])
                return false;
        }
        if(isValid(board,r-1,c-2)) {
            if (board[r - 1][c - 2])
                return false;
        }
        if(isValid(board,r-2,c+1)) {
            if(board[r-2][c+1])
                return false;
        }
        if(isValid(board,r-1,c+2)) {
            if(board[r-1][c+2])
                return false;
        }
        return true;
    }
    static boolean isValid(boolean[][] board,int row,int col){
        if(row>=0 && row<board.length && col>=0 && col< board.length){
            return true;
        }
        return false;
    }
    static void night(boolean[][] board,int row,int col,int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return;
        }
        if(row==board.length-1 && col== board.length){
            return ;
        }
        if(col==board.length){
            night(board,row+1,0,knights);
            return;
        }

        if(issafe(board,row,col)){
            board[row][col]=true;
            night(board,row,col+1,knights-1);
            board[row][col]=false;
        }
        night(board,row,col+1,knights);
    }
    static void display(boolean[][] board){
        for (boolean[] row:board){
            for (boolean element:row){
                if(element)
                    System.out.print("K"+" ");
                else
                    System.out.print("O"+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int noOfKnights=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        night(board,0,0,noOfKnights);

    }
}
