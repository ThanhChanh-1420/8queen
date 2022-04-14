/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nienluancs;

import java.util.Scanner;
import java.awt.*;  //import older gui library for content pane
import javax.swing.*;   //import newer gui library for labels, textfields, and button
import java.awt.event.*; //import gui event action library
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JRadioButton;
/**
 *
 * @author Trinh Thanh Chanh
 */
public class quanHau {

    public int n;
    public boolean[] okRow, okCol; //kí hiệu trạng thái của hàng và cột
    public boolean[] okMinus; //kí hiệu trạng thái đã có quân hậu nào trên đường chéo trừ thứ k chưa, Ok_Minus[1..15]
    public boolean[] okPlus; //kí hiệu trạng thái đã có quân hậu nào trên đường chéo cộng thứ k chưa, Ok_Plus[1..15]
    public int[] solution; //mảng lưu lời giải
    //public static int array[][][];
    private int index=0;
    int count = 0;

    public quanHau(int _n) {
        n = _n;
        //Khai báo giá trị tối đa của các mảng okRow, okCol, okPlus, okMinus, solution
        okRow = new boolean[n + 1];
        okCol = new boolean[n + 1];
        okPlus = new boolean[2 * n];
        okMinus = new boolean[2 * n];
        solution = new int[n + 1];
    }
//Hàm in ra các lời giải
    public void PrintSolution() {
        count++;
        QuanHauForm.array = new int[300][8][8];
        //System.out.println("\nLoi giai thu " + count + ": \n");
        
        for (int i = 1; i <= n; i++) {
            int c = solution[i];
            for (int j = 1; j <= n; j++) {
                if (c == j) {
                    //      System.out.print("Q ");
                    QuanHauForm.array[index][i - 1][j - 1] = 1;
                } else {
                    //     System.out.print("* ");
                    QuanHauForm.array[index][i - 1][j - 1] = 0;
                }
                //System.out.println(array[i-1][j-1]+"\n");
            }
            // System.out.print("\n");
        }
        // System.out.print("\n");
        for (int i=0;i<n;i++){
            System.out.print(index);
            for (int j=0;j<n;j++){
                System.out.print(QuanHauForm.array[index][i][j]);
            }
            System.out.print("\n");
            
        }
    }

    public void Try(int i) {
        for (int j = 1; j <= n; j++) {
            if (!okRow[i] && !okCol[j] && !okPlus[i + j - 1] && !okMinus[i - j + n]) {
                solution[i] = j;
                okCol[j] = true;
                okPlus[i + j - 1] = true;
                okMinus[i - j + n] = true;
                if (i < n) {
                    Try(i + 1);
                } else {
                    
                    PrintSolution();
                    index++;
                }
                okRow[i] = false;
                okCol[j] = false;
                okPlus[i + j - 1] = false;
                okMinus[i - j + n] = false;
            }
        }
    }

    public void Solve() {
        Try(1);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap kich co ban co: ");
        int n = sc.nextInt();
        quanHau q = new quanHau(n);
        q.Solve();
        // System.out.println("");
        // TODO code application logic here
    }


}
