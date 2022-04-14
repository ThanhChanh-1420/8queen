package nienluancs;

import java.util.Scanner;

class KnightTour {
   // static int N = 8;
    //Mảng lưu trữ vị trí của từng bước đi, mảng kết quả
    public static int sol[][] = new int[8][8];
    //Hàm kiểm tra nút sol[i][j] có thuộc bàn cờ 8x8 hay không
    static boolean isSafe(int N,int x, int y, int sol[][])
    {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }
    //Hàm in lời giải của thuật toán
    static void printSolution(int N, int sol[][])
    {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    //Hàm kiểm tra bước đi của quân Mã có hợp lệ hay không và in ra từng bước đi
    static boolean solveKT(int N)
    {
    //    int sol[][] = new int[N][N]; //N=8
 
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
 
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
        sol[1][0] = 0;
 
        if (!solveKTUtil(N,0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        }
        else
            printSolution(N,sol);
 
        return true;
    }
    //Hàm đệ qui gọi lại hàm solveKT
    static boolean solveKTUtil(int N, int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[])
    {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
        //Thử tất cả các bước đi tại các tọa độ x, y
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(N, next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(N, next_x, next_y, movei + 1,
                                sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y]
                        = -1; // backtracking
            }
        }
 
        return false;
    }
 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vào kich thuoc N= ");
        int N = sc.nextInt();
        solveKT(N);
        
    }
}