/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nienluancs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import jdk.nashorn.internal.ir.BreakNode;

public class QuanMaForm extends javax.swing.JFrame {

    
    private MainForm main;
   
    private Timer time;
    private int n; //kich thuoc ban co
    private JPanel board[][];
    private JLabel lb[][];
    //private String kq = new  String();
    private int t = 0;
    //public static int array[][][];

    int count = 0;

    public QuanMaForm() {
        initComponents();
        n = 8;
 
        this.board = new JPanel[n][n];
        lb = new JLabel[n][n];
        int i, j;
        int x = 0, y = 0;
        int check = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                this.board[i][j] = new JPanel();
                this.lb[i][j] = new JLabel();
                this.board[i][j].setLocation(new Point(x, y));
                this.board[i][j].setSize(50, 50);
                this.board[i][j].add(lb[i][j]);
                if (check == 0) {
                    this.board[i][j].setBackground(new Color(255, 255, 255));
                } else {
                    this.board[i][j].setBackground(new Color(0, 0, 0));
                }
                check = 1 - check;
                this.board[i][j].setVisible(true);
                pn.add(this.board[i][j]);
                x += 50;
            }
            check = 1 - check;
            y += 50;
            x = 0;
        }
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Pic/icons8_knight_48px.png")));
    }
    public void setMain(MainForm a){
        this.main = a;
    }    
    
    public Timer setTime(JLabel lb[][], JPanel bw[][],int mili, int n){
        Timer t;
        t = new Timer(mili, new ActionListener() {
            private JLabel label[][] = lb;
            private int N = n;
            private JPanel pn2[][] = bw;
            private int a=0,b=0;
            private int k=0;
            private boolean kt=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                kt = false;
                label[a][b].setIcon(null);
                //pn2[a][b].setBackground(Color.green);
                this.label[a][b].setText(KnightTour.sol[a][b]+"");
                this.label[a][b].setForeground(Color.GREEN);
                
                int i,j;
                for (i=0;i<N;i++){
                    for (j=0;j<N;j++){
                        if (KnightTour.sol[i][j]==k){
                            a=i;
                            b=j;
                            k++;
                            System.out.println(k+","+a+","+b);
                            kt=true;
                            break;
                        }
                    }
                    if (kt==true){
                        break;
                    }
                }
                    
                if (k==64) {
                    label[a][b].setIcon(null);
                }
                else{
                label[a][b].setIcon(new ImageIcon(this.getClass().getResource("../Pic/icons8_knight_48px.png")));
                }
            }
        });
        return t;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn = new javax.swing.JPanel();
        txtN = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnMain = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();
        btninfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BÀI TOÁN QUÂN MÃ ĐI TUẦN");

        javax.swing.GroupLayout pnLayout = new javax.swing.GroupLayout(pn);
        pn.setLayout(pnLayout);
        pnLayout.setHorizontalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        pnLayout.setVerticalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        btnOk.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnOk.setText("Thực hiện");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setText("Lưu trữ");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnMain.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMain.setText("Trang chủ");
        btnMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMainMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Kích thước bàn cờ 8x8");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("BÀI TOÁN QUÂN MÃ ĐI TUẦN");

        btnStop.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnStop.setText("Tạm dừng");
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });

        btninfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btninfo.setText("Thông tin");
        btninfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninfoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(txtN)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(51, 51, 51))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btninfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(51, 51, 51)))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btninfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(txtN)
                        .addGap(36, 36, 36)
                        .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(btnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
        try {
            if (txtN.getText().equals("8")){
            int check=0;
            this.n = Integer.parseInt(txtN.getText());
            KnightTour.solveKT(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //this.lb[i][j].setText(KnightTour.sol[i][j]+"");
                    if (check==0){
                        this.lb[i][j].setForeground(Color.black);
                    }   else{
                        this.lb[i][j].setForeground(Color.white);
                    } 
                    check=1-check;
                    
                }
                check=1-check;
            }
            time = this.setTime(lb, this.board,1000, n);
            time.start();
            }
            else{
                String t = new String();
                t = "NHẬP KÍCH THƯỚC BÀN CỜ LÀ 8 !!!";
                JOptionPane.showConfirmDialog(rootPane, t, "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnOkMouseClicked

    private void btnMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMainMouseClicked
        this.main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMainMouseClicked
    public String getKetQua(){
        String kq = new  String();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                kq+=KnightTour.sol[i][j]+" ";
            }
            kq+="\n";
        }
        return kq;
    }
    
    public void writeToFile(String a) throws IOException{
///
                File f = new File(a);
                System.out.println(f);
                FileWriter fw = new FileWriter(f,true);
                System.out.println(fw);
                BufferedWriter bw = new BufferedWriter(fw);
                String list;
                //for(int i = 0;i<92;i++){
                    
                    list="Lời giải thứ "+":\n" + this.getKetQua();
                    try{
                        //System.out.println(bw);
                        bw.newLine();
                        bw.write(list);
                        
                        bw.flush();
                        //bw.close();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
               // }
                bw.close();
                ///
}
    
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl= "jdbc:sqlserver://LAPTOP-E3J8KANC\\SQLEXPRESS:1433;databaseName=NLCSNganh;user=sa;password=sa";
            Connection con=DriverManager.getConnection(dbUrl);
            Statement s = con.createStatement();
            Statement x = con.createStatement();
            ResultSet rs = x.executeQuery("Select max(ID) from QuanMa;");
            rs.next();
            int a = rs.getInt(1)+1;
            System.out.println(a);
            //for(int i = 0;i<92;i++)
            s.executeUpdate("Insert into QuanMa values ("+a+",'"+this.getKetQua()+"');");
            //t++;
            //con.close();
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Thực hiện lưu trữ CSDL thành công !!!");
        }catch(Exception ex){
            ex.printStackTrace();
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Thực hiện lưu trữ CSDL không thành công !!!");
        }
        try {
            JFileChooser save = new JFileChooser();
            String savePath = new String();
            int returnValue = save.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                savePath = save.getSelectedFile().getPath();
                //this.main.writeFile(savePath);
                this.writeToFile(savePath);
            }else{
                savePath = "NO";
            }
            //this.writeToFile();
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Thực hiện lưu trữ File Text thành công !!!");
        } catch (IOException ex) {
            Logger.getLogger(QuanMaForm.class.getName()).log(Level.SEVERE, null, ex);
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Thực hiện lưu trữ File Text không thành công !!!");
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopMouseClicked
        // TODO add your handling code here:
        time.stop();
        
    }//GEN-LAST:event_btnStopMouseClicked

    private void btninfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninfoMouseClicked
        // TODO add your handling code here:
        String thongtin = new String();
        thongtin = "Bài toán quân Mã đi tuần trong bàn cờ vua \n"+
                "Mã đi tuần hay hành trình của quân mã là bài toán về việc di chuyển một quân mã trên bàn cờ vua (8 x 8).\n"+
                "Quân mã được đặt ở một ô trên một bàn cờ trống nó phải di chuyển theo quy tắc của cờ vua để đi qua mỗi ô trên bàn cờ đúng một lần.";
       JDialog dialog = new JDialog();
       dialog.setAlwaysOnTop(true);
       JOptionPane.showMessageDialog(dialog, thongtin);
    }//GEN-LAST:event_btninfoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanMaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanMaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanMaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanMaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanMaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMain;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btninfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pn;
    private javax.swing.JTextField txtN;
    // End of variables declaration//GEN-END:variables
}
