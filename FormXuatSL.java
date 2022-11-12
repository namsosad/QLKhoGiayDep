/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DOAN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FormXuatSL extends javax.swing.JFrame {
    private String Mahang,Size,Mausac,Gia,Loaihang;
    private String Hangsanxuat,Sl;
    /**
     * Creates new form FormXuatSL
     */
    public FormXuatSL() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSl = new javax.swing.JTextField();
        btnExport = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Số lượng hàng:");

        txtSl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExport)
                        .addGap(53, 53, 53)
                        .addComponent(btnBack))
                    .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport)
                    .addComponent(btnBack))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        if(txtSl.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Khong duoc de trong ");
            return;
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";
        try{
            int  sl = Integer.parseInt(txtSl.getText());
            
            if(sl<=0 ){
                JOptionPane.showMessageDialog(this, "So luong phai lon hon 0");
                return;
            }
            
            try  {
                    //kiem tra so luong hang so du hay khong
                    Connection con1 = DriverManager.getConnection(connectionUrl); 
                    String SQL1 = "SELECT * FROM KhoGiayDep where ComodityCode=?";// dat cac chuoi leng vao bien SQL
                    PreparedStatement psmt1 = con1.prepareStatement(SQL1);
                    psmt1.setString(1, Mahang);
                    ResultSet rs = psmt1.executeQuery();//dung rs de truy xuat lai ket qua truy van
                
               
                    if(rs.next()){
                        //doi ve kieu nguyen de so sanh
                        int slxuat=Integer.parseInt(txtSl.getText());
                        int slkho=Integer.parseInt(rs.getString(7));
                        if(slxuat>slkho){
                            JOptionPane.showMessageDialog(this, "So luong ton kho khong du, chi con lai: "+rs.getString(7));
                            return;
                        }
                
                    }
                    //them vao bang xuat hang
            
                    Connection con = DriverManager.getConnection(connectionUrl); 
                    String SQL = "insert into XuatHang (ComodityCode,Size,Color,Manufacturer,Price,Comodities,Quantity) values(?,?,?,?,?,?,?)";// dat cac chuoi leng vao bien SQL
                    PreparedStatement psmt = con.prepareStatement(SQL);
                    //lay du lieu tu text field roi ghi vao o tuong ung
                    psmt.setString(1,Mahang);
                    psmt.setString(2,Size);
                    psmt.setString(3,Mausac);
                    psmt.setString(4,Hangsanxuat);
                    psmt.setString(5,Gia);
                    psmt.setString(6,Loaihang);
                    psmt.setString(7,txtSl.getText());

                    psmt.executeUpdate();//chen du lieu vao trong CSDL
                    JOptionPane.showMessageDialog(this, "Da them thanh cong va nhan nut Refresh de cap nhat bang nhap hang");

                    this.setVisible(false);
                   // NhapHangView nh = new NhapHangView();
                   // nh.initLoadDataToJtable();


                    con.close();//dong cac ket noi
                    psmt.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }


        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "So luong hang phai la so nguyen");
        }
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    public void nhanthongtin(String Mahang,String Size,String Mausac,String Hangsanxuat,String Gia,String Loaihang){
        this.Mahang=Mahang;
        this.Size=Size;
        this.Mausac=Mausac;
        this.Hangsanxuat=Hangsanxuat;
        this.Gia=Gia;
        this.Loaihang=Loaihang;
    }
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
            java.util.logging.Logger.getLogger(FormNhapSL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNhapSL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNhapSL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNhapSL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormXuatSL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtSl;
    // End of variables declaration//GEN-END:variables
}
