/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DOAN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL
 */
public class NhapHangView extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form NhapHangView
     */
    public NhapHangView() {
        initComponents();
        String[] header = {"Mã hàng", "Size", "Màu sắc", "Hãng sản xuất", "Giá", "Loại hàng", "Số lượng"};
        model=new DefaultTableModel(header,0);
        tblNhapHang.setModel(model);
        initLoadDataToJtable();
        this.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, "Ban hay nhap ma hang truoc khi thuc hien cac thao tac Them, Xoa, Sua");
    }
    
     public void initLoadDataToJtable(){
        
        model.setRowCount(0);//xoa toan bo cac dong hien ton tai tren ban 
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";

        try  {
            Connection con = DriverManager.getConnection(connectionUrl); 
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM NhapHang";// dat cac chuoi leng vao bien SQL
            ResultSet rs = stmt.executeQuery(SQL);//goi rs truy van vao database

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                String[] row= new String[]{rs.getString("ComodityCode"),
                                           rs.getString("Size"),
                                           rs.getString("Color"),
                                           rs.getString("Manufacturer"),
                                           rs.getString("Price"),
                                           rs.getString("Comodities"),
                                           rs.getString("Quantity")
                        
                };

                model.addRow(row);
            }
            con.close();//dong cac ket noi
            rs.close();
            stmt.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMahang = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText("Quay lại màn hình chính");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnExcel.setText("Xuất phiếu");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("Mã hàng");

        txtMahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMahangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtMahang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Size", "Màu sắc", "Hãng sản xuất", "Giá", "Loại hàng", "Số lượng hàng"
            }
        ));
        tblNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhapHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhapHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtMahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMahangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMahangActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        GiaoDienChinh l = new GiaoDienChinh();
        l.setVisible(true);
        this.setVisible(false);
        l.setLocationRelativeTo(null);
             
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initLoadDataToJtable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtMahang.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma hang");
            return;
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";

        try  {
            Connection con1 = DriverManager.getConnection(connectionUrl); 
            String SQL1 = "SELECT * FROM NhapHang where ComodityCode=?";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt1 = con1.prepareStatement(SQL1);
            psmt1.setString(1, txtMahang.getText());
            ResultSet rs1 = psmt1.executeQuery();//dung rs de truy xuat lai ket qua truy van
            
            if(rs1.next()){
                JOptionPane.showMessageDialog(this, "Ma hang nay ban da dua vao bang nhap hang\n Kiem tra lai ma hang hoac chon muc Sua de Sua thong tin");
                return;
            }
            
            
            
            Connection con = DriverManager.getConnection(connectionUrl); 
            String SQL = "SELECT * FROM KhoGiayDep where ComodityCode=?";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt = con.prepareStatement(SQL);
            psmt.setString(1, txtMahang.getText());
            ResultSet rs = psmt.executeQuery();//dung rs de truy xuat lai ket qua truy van
           
            
            if(rs.next()) {
                FormNhapSL f1 = new FormNhapSL();
                f1.setVisible(true);
                f1.nhanthongtin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                f1.setLocationRelativeTo(null);
                JOptionPane.showMessageDialog(this, "Do ma hang da ton tai trong kho nen chi can nhap so luong");
            }
            else{
                FormNhapThongTin f2 = new FormNhapThongTin();
                f2.setVisible(true);
                f2.nhanthongtin(txtMahang.getText());
                f2.setLocationRelativeTo(null);

            }
            con.close();//dong cac ket noi
            rs.close();
            txtMahang.setText("");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane,"Ban co muon xoa  hay khong ?")==JOptionPane.NO_OPTION){
            return;
        }
        
         String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";

        try  {
            Connection con = DriverManager.getConnection(connectionUrl); 
            
            String SQL = "delete from NhapHang where ComodityCode=?";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt = con.prepareStatement(SQL);
            //lay du lieu tu text field roi ghi vao o tuong ung
            psmt.setString(1,txtMahang.getText());
            
            psmt.executeUpdate();//chen du lieu vao trong CSDL
            JOptionPane.showMessageDialog(this, "Da xoa thanh cong thanh cong");
            initLoadDataToJtable();
            txtMahang.setText("");
            con.close();//dong cac ket noi
            psmt.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(txtMahang.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma hang");
            return;
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";

        try { 
            //kiem tra ma hang nguoi dung nhap co ton tai trong bang nhap hang hay chua
            Connection con = DriverManager.getConnection(connectionUrl); 
            String SQL = "SELECT * FROM NhapHang where ComodityCode=?";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt = con.prepareStatement(SQL);
            psmt.setString(1, txtMahang.getText());
            ResultSet rs = psmt.executeQuery();//dung rs de truy xuat lai ket qua truy van
           
            
            if(rs.next()) {
                Connection con1 = DriverManager.getConnection(connectionUrl); 
                String SQL1 = "SELECT * FROM KhoGiayDep where ComodityCode=?";// dat cac chuoi leng vao bien SQL
                PreparedStatement psmt1 = con1.prepareStatement(SQL1);
                psmt1.setString(1, txtMahang.getText());
                ResultSet rs1 = psmt1.executeQuery();//dung rs de truy xuat lai ket qua truy van         
                
                if(rs1.next()){//neu ma hang da ton tai trong kho thi chi cho nguoi dung sua so luong hang nhap vao khong duoc sua thong tin co san cua hang
                    FormSuaSl f2 = new FormSuaSl();
                    f2.nhanthongtin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    f2.setVisible(true);
                    f2.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Do ma hang nay da ton tai trong kho nen ban chi duoc sua so luong hang nhap vao");
                }
                else{//neu ma hang khong ton tai trong kho thi cho nguoi dung sua thong tin cua hang
                    FormSuaThongTin f1 = new FormSuaThongTin();
                    f1.nhanthongtin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    f1.setVisible(true);
                    f1.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Do ma hang nay chua ton tai trong kho nen ban duoc sua cac thong tin khac cua ma");
                }
         
            }
            else{
                JOptionPane.showMessageDialog(this,"Ban chua them ma hang nay voa danh sach nhap hang");
            }
            con.close();//dong cac ket noi
            rs.close();
            txtMahang.setText("");
          
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhapHangMouseClicked
        // TODO add your handling code here:
        int Row = tblNhapHang.getSelectedRow();
        
        txtMahang.setText((String) tblNhapHang.getValueAt(Row, 0));
    }//GEN-LAST:event_tblNhapHangMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Ban da xuat phieu nhap kho hay chua ?") == JOptionPane.NO_OPTION){
            return;
        }
        
        
        
        
        //kiem tra bang nhap hang co hang hay chua
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLGiayDep;user=sa;password=123456;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;";
        try{
            
            //kiem tra ma hang nguoi dung nhap co ton tai trong bang nhap hang hay chua
            Connection con0 = DriverManager.getConnection(connectionUrl); 
            String SQL0 = "SELECT * FROM NhapHang";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt0 = con0.prepareStatement(SQL0);
            ResultSet rs0 = psmt0.executeQuery();//dung rs de truy xuat lai ket qua truy van
            
            if(!rs0.next()){
                JOptionPane.showMessageDialog(this, "Ban chua chon hang de nhap kho");
                return;
            }
            rs0.close();
            con0.close();
            psmt0.close();
        }
        catch(Exception e){
             e.printStackTrace();
        }
        
        
        //thuc hien nhap hang
        
        
        try { 
           
            Connection con = DriverManager.getConnection(connectionUrl); 
            String SQL = "SELECT * FROM NhapHang";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt = con.prepareStatement(SQL);
            ResultSet rs = psmt.executeQuery();//dung rs de truy xuat lai ket qua truy van
            
             while(rs.next()) {
                Connection con1 = DriverManager.getConnection(connectionUrl); 
                String SQL1 = "SELECT * FROM KhoGiayDep where ComodityCode=?";// dat cac chuoi leng vao bien SQL
                PreparedStatement psmt1 = con1.prepareStatement(SQL1);
                psmt1.setString(1, rs.getString(1));
         
                ResultSet rs1 = psmt1.executeQuery();//dung rs de truy xuat lai ket qua truy van         
                //kiem tra hang co torng kho hay khong
                //neu co chi cap nhat so luong hang
                //neu khong them hang moi vao kho
                if(rs1.next()){//neu ma hang da ton tai trong kho thi chi cho nguoi dung sua so luong hang nhap vao khong duoc sua thong tin co san cua hang
                    int slhang = Integer.parseInt(rs1.getString(7));//lay so luong hang trong kho ra va chuyen ve kieu nguyen
                    int slnhap = Integer.parseInt(rs.getString(7));//lay so luong hang trong bang nhap hang ra 
                    slhang = slnhap + slhang;
                    Connection con2 = DriverManager.getConnection(connectionUrl);
                    String SQL2 = "update  KhoGiayDep set Size=?,Color=?,Manufacturer=?,Price=?,Comodities=?,Quantity=? "+" where ComodityCode=?";// dat cac chuoi leng vao bien SQL
                    PreparedStatement psmt2 = con2.prepareStatement(SQL2);
                    //lay du lieu tu text field roi ghi vao o tuong ung
                    psmt2.setString(7,rs.getString(1));
                    psmt2.setString(1,rs.getString(2));
                    psmt2.setString(2,rs.getString(3));
                    psmt2.setString(3,rs.getString(4));
                    psmt2.setString(4,rs.getString(5));
                    psmt2.setString(5,rs.getString(6));
                    psmt2.setString(6,Integer.toString(slhang));

                    psmt2.executeUpdate();//chen du lieu vao trong CSDL
                

                    con2.close();//dong cac ket noi
                    psmt2.close();
                    
                }
                else{//neu ma hang khong ton tai trong kho thi cho nguoi dung sua thong tin cua hang
                    Connection con3 = DriverManager.getConnection(connectionUrl); 
                    String SQL3 = "insert into KhoGiayDep(ComodityCode,Size,Color,Manufacturer,Price,Comodities,Quantity) values(?,?,?,?,?,?,?)";// dat cac chuoi leng vao bien SQL
                    PreparedStatement psmt3 = con3.prepareStatement(SQL3);
                    //lay du lieu tu text field roi ghi vao o tuong ung
                    psmt3.setString(1,rs.getString(1));
                    psmt3.setString(2,rs.getString(2));
                    psmt3.setString(3,rs.getString(3));
                    psmt3.setString(4,rs.getString(4));
                    psmt3.setString(5,rs.getString(5));
                    psmt3.setString(6,rs.getString(6));
                    psmt3.setString(7,rs.getString(7));
                    
            
                    psmt3.executeUpdate();//chen du lieu vao trong CSDL
                    con3.close();//dong cac ket noi
                    psmt3.close();
                }
                
                rs1.close();
                con1.close();
                psmt1.close();
            }
            con.close();//dong cac ket noi
            psmt.close();
            rs.close();
            JOptionPane.showMessageDialog(this, "Da nhap hang thanh cong");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        try{
            
            //kiem tra ma hang nguoi dung nhap co ton tai trong bang nhap hang hay chua
            Connection con4 = DriverManager.getConnection(connectionUrl); 
            String SQL4 = "DELETE FROM NhapHang";// dat cac chuoi leng vao bien SQL
            PreparedStatement psmt4 = con4.prepareStatement(SQL4);
            psmt4.executeUpdate();
            con4.close();
            psmt4.close();
            initLoadDataToJtable();
        }
        catch(Exception e){
             e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try{
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("danh sach nhap kho");//tao ghi vao sheet danhsach
            XSSFRow row = null;//tao mac dinh khong dong va ko o
            Cell cell = null;
            row = sheet.createRow(3);//xuong 3 dong
            
            cell=row.createCell(0,CellType.STRING);
            cell.setCellValue("Ma hang");
            
            cell=row.createCell(1,CellType.STRING);
            cell.setCellValue("Size");
            
            cell=row.createCell(2,CellType.STRING);
            cell.setCellValue("Mau sac");
            
            cell=row.createCell(3,CellType.STRING);
            cell.setCellValue("Hang san xuat");
            
            cell=row.createCell(4,CellType.STRING);
            cell.setCellValue("Gia");
            
            cell=row.createCell(5,CellType.STRING);
            cell.setCellValue("Loai hang");
            
            cell=row.createCell(6,CellType.STRING);
            cell.setCellValue("So luong");
            
            for(int i=0;i<tblNhapHang.getRowCount();i++){
                row = sheet.createRow(4+i);
                
                cell=row.createCell(0,CellType.STRING);
                cell.setCellValue( tblNhapHang.getValueAt(i, 0).toString());
                
                cell=row.createCell(1,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 1).toString());
                
                cell=row.createCell(2,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 2).toString());
                
                cell=row.createCell(3,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 3).toString());
                
                cell=row.createCell(4,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 4).toString());
                
                cell=row.createCell(5,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 5).toString());
                
                cell=row.createCell(6,CellType.STRING);
                cell.setCellValue(tblNhapHang.getValueAt(i, 6).toString());
                
                                
            }
            //lam ten file va thu muc luu phieu
            //lay nam thang ngay
            LocalDate localDate = LocalDate.now();
            String year = Integer.toString(localDate.getYear());//lay ra nam hien tai
            String day = Integer.toString(localDate.getDayOfMonth());//lay ra ngay hien tai
            String month = Integer.toString(localDate.getMonthValue());
            //lam ten file
            String phieunhap = "E:\\phieunhap\\"+day+"_"+month+"_"+year+".xlsx";
           
            File f = new File(phieunhap);
            try{
                FileOutputStream fis = new FileOutputStream(f);
                wb.write(fis);
                fis.close();
            }
            catch (FileNotFoundException ex){
                ex.printStackTrace();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, "Da xuat phieu thanh cong");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "loi mo file");
        }
    }//GEN-LAST:event_btnExcelActionPerformed

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
            java.util.logging.Logger.getLogger(NhapHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblNhapHang;
    private javax.swing.JTextField txtMahang;
    // End of variables declaration//GEN-END:variables
}
