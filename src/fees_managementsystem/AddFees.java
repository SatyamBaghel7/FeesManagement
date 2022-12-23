/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_managementsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author satya
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public AddFees() throws SQLException {
        initComponents();
        displayCshFirst();
        fillComboBox();
        
        int recieptNum=recieptNumber();
        txtReciept.setText(Integer.toString(recieptNum));
    }
    public void displayCshFirst()
    {
        
        
        lblBranch.setVisible(false);
        comboBranch.setVisible(false);
        lblSemester.setVisible(false);
        txtSemester.setVisible(false);
        
    }
    public boolean Validation()
    {
         if(txtReciept.getText().equals("")|| txtReciept.getText().matches("[0-9]+")==false)
        {
            ErrorReciept1.setText("Enter Reciept No. in Number");
            return false;
            
        }
        if(txtRecieverName.getText().equals(""))
        {
          RecieverNameError1.setText("Enter Recievers Name");
          return false;
        }
        if(txtReciept.getText().equals("")|| txtReciept.getText().matches("[0-9]+")==false)
        {
            ErrorReciept1.setText("Enter Reciept No. in Number");
            return false;
            
        }
        if(dateChooser.getDate()==null)
        {
            ErrorDate.setText("Enter Date");
        }
        if(txtAmount.getText().equals("")|| txtAmount.getText().matches("[0-9]+")==false)
        {
            ErrorAmount1.setText("Enter Amount in Numbers");
            return false;
        }
        
       
      
        if(comboCourse.getSelectedItem().toString().equalsIgnoreCase("others"))
        {
            if(txtSemester.getText().equals(""))
            {
                ErrorSemester.setText("Enter Semester No. in number");
            }
        }                
        return true;
        
    }
    public void clearValidation()
    {
        ErrorAmount1.setText("");
        ErrorReciept1.setText("");
        ErrorSemester.setText("");
        
        RecieverNameError1.setText("");
    }
   public void fillComboBox() throws SQLException
   {
        String url="jdbc:mysql://localhost:3306/database";
        String uname="root";
        String pwd="root";
        
        Connection con=DriverManager.getConnection(url,uname,pwd);
        
        PreparedStatement pst=con.prepareStatement("select cName from course");
        ResultSet rs= pst.executeQuery();
        while(rs.next())
        {
            comboCourse.addItem(rs.getString("cName"));
        }
        
        
   }
   public int recieptNumber() throws SQLException
   {
        int reciept=0;
         String url="jdbc:mysql://localhost:3306/database";
        String uname="root";
        String pwd="root";
        
        Connection con=DriverManager.getConnection(url,uname,pwd);
        
        PreparedStatement pst=con.prepareStatement("select max(recieptNo) from feesdetail");
        ResultSet rs= pst.executeQuery();
        if(rs.next())
        {
            reciept=rs.getInt(1);
        }
       
        return reciept+1;
       
   }
    public String insertData() throws SQLException
    {
        String status="";
        
        int recieptnumber=Integer.parseInt(txtReciept.getText());
        String Stud=txtRecieverName.getText();
        String paymentMode=comboPayment.getSelectedItem().toString();
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
       String date=dateFormat.format(dateChooser.getDate());
        
        
       
        
        String course=comboCourse.getSelectedItem().toString();
        int totalAmount=Integer.parseInt(txtTotalAmount.getText());
        
       int Amount=Integer.parseInt(txtAmount.getText());
       String totalWords=txtTotal.getText();
       String Remark=txtRemark.getText();
       String branchName=comboBranch.getSelectedItem().toString();
       String Semester=txtSemester.getText();
        
        
    
        
         String url="jdbc:mysql://localhost:3306/database";
        String uname="root";
        String pwd="root";
        
        Connection con=DriverManager.getConnection(url,uname,pwd);
        
       
        String query="insert into feesdetail(recieptNo, StudentName, payment_mode,courses, totalAmount, date, amount, totalinwords, remark,semester,branch) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, recieptnumber);
        pst.setString(2, Stud);
        pst.setString(3, paymentMode);
        pst.setString(4, course);
        pst.setInt(5, totalAmount);
        pst.setString(6, date);
        pst.setInt(7, Amount);
        pst.setString(8, totalWords);
        pst.setString(9, Remark);
        pst.setString(10, Semester);
        pst.setString(11, branchName);
        
       int rowCount= pst.executeUpdate();
       if(rowCount==1)
       {
           status="success";
       }
       else
       {
           status="failed";
       }
        
     return status;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParent = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtReciept = new javax.swing.JTextField();
        txtSemester = new javax.swing.JTextField();
        comboBranch = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        lblSemester = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox<>();
        panelChild = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtRecieverName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        RecieverNameError1 = new javax.swing.JLabel();
        ErrorAmount1 = new javax.swing.JLabel();
        ErrorDate = new javax.swing.JLabel();
        ErrorSemester = new javax.swing.JLabel();
        ErrorReciept1 = new javax.swing.JLabel();
        comboPayment = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelParent.setBackground(new java.awt.Color(255, 255, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Reciept No. : ACC");
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 170, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Mode Of Payment :");
        panelParent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 180, 60));

        lblBranch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblBranch.setText("Branch :");
        panelParent.add(lblBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 80, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Date:");
        panelParent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 50, 50));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Course:");
        panelParent.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 80, 60));

        txtReciept.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelParent.add(txtReciept, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 270, 40));

        txtSemester.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelParent.add(txtSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 360, 270, 40));

        comboBranch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bca", "Engineering", "BCCA", "Other" }));
        panelParent.add(comboBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, 270, 40));
        panelParent.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, 270, 40));

        lblSemester.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSemester.setText("Semester :");
        panelParent.add(lblSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, 110, 50));

        comboCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });
        panelParent.add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 200, 270, 40));

        panelChild.setBackground(new java.awt.Color(255, 255, 255));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("SR NO.");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 150, 50));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 450, 230, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 1220, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel17.setText("Remark :");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 180, 50));

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelChild.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 650, 40));

        txtRecieverName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelChild.add(txtRecieverName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 380, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel18.setText("Total In Words :");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 150, 50));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 1220, 10));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 440, 10));

        txtTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAmountActionPerformed(evt);
            }
        });
        panelChild.add(txtTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 370, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setText("Recieved From ");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 150, 50));

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        panelChild.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 370, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Amount");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 110, 50));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel21.setText("Reciever Signature");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 180, 50));

        txtRemark.setColumns(20);
        txtRemark.setRows(5);
        jScrollPane1.setViewportView(txtRemark);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 450, 110));

        rSMaterialButtonCircle1.setText("Print");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panelChild.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 170, 80));

        RecieverNameError1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RecieverNameError1.setForeground(new java.awt.Color(255, 0, 51));
        panelChild.add(RecieverNameError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 380, 30));

        ErrorAmount1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ErrorAmount1.setForeground(new java.awt.Color(255, 0, 51));
        panelChild.add(ErrorAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 380, 30));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1500, 600));

        ErrorDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ErrorDate.setForeground(new java.awt.Color(255, 0, 51));
        panelParent.add(ErrorDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 290, 30));

        ErrorSemester.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ErrorSemester.setForeground(new java.awt.Color(255, 0, 51));
        panelParent.add(ErrorSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 270, 30));

        ErrorReciept1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ErrorReciept1.setForeground(new java.awt.Color(255, 0, 51));
        panelParent.add(ErrorReciept1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 380, 30));

        comboPayment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Cheque", "Upi" }));
        panelParent.add(comboPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 250, 40));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 1500, 1030));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\satya\\OneDrive\\Desktop\\Satyam\\Advance Java\\Fees_ManagementSystem\\my icons\\edit2.png")); // NOI18N
        jLabel1.setText("Edit Courses");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 300, 70));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\satya\\OneDrive\\Desktop\\Satyam\\Advance Java\\Fees_ManagementSystem\\my icons\\home.png")); // NOI18N
        jLabel3.setText("Home");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 70));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 300, 70));

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\satya\\OneDrive\\Desktop\\Satyam\\Advance Java\\Fees_ManagementSystem\\my icons\\search2.png")); // NOI18N
        jLabel4.setText("Search Record");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 60));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 300, 70));

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\satya\\OneDrive\\Desktop\\Satyam\\Advance Java\\Fees_ManagementSystem\\my icons\\view all record.png")); // NOI18N
        jLabel6.setText("View All Record");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 70));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 300, 70));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\satya\\OneDrive\\Desktop\\Satyam\\Advance Java\\Fees_ManagementSystem\\my icons\\left-arrow.png")); // NOI18N
        jLabel7.setText("Back");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 70));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 300, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 1030));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
      Integer amt= Integer.parseInt(txtAmount.getText());
       txtTotalAmount.setText(amt.toString());
       
     txtTotal.setText(NumberToWordsConverter.convert(amt)+"only"); 
       
       
       
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAmountActionPerformed

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
       if(comboCourse.getSelectedIndex()==5)
       {
           lblBranch.setVisible(true);
           comboBranch.setVisible(true);
           lblSemester.setVisible(true);
           txtSemester.setVisible(true);
       }
       else
       {
          lblBranch.setVisible(false);
           comboBranch.setVisible(false);
           lblSemester.setVisible(false);
           txtSemester.setVisible(false);  
       }
    }//GEN-LAST:event_comboCourseActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
         clearValidation();
        if(Validation()==true)
        {
             try {
                 String result=insertData();
                 if(result.equalsIgnoreCase("success"))
                 {
                     JOptionPane.showMessageDialog(this, "Success");
                     printReciept a=new printReciept();
                     a.setVisible(true);
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(AddFees.class.getName()).log(Level.SEVERE, null, ex);
             }
            
      }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        try {
            UpdateCourse a=new UpdateCourse();
            a.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddFees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        Color clr=new Color(0,0,204);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        Color clr=new Color(102,102,255);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        Color clr=new Color(0,0,204);
        jPanel5.setBackground(clr);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        Color clr=new Color(102,102,255);
        jPanel5.setBackground(clr);
    }//GEN-LAST:event_jPanel5MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered

    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        try {
            SearchRecord a=new SearchRecord();
            a.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddFees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        Color clr=new Color(0,0,204);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        Color clr=new Color(102,102,255);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        Color clr=new Color(0,0,204);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        Color clr=new Color(102,102,255);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        dispose();
        HomePage a=new HomePage();
        a.setVisible(true);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        Color clr=new Color(0,0,204);
        jPanel9.setBackground(clr);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        Color clr=new Color(102,102,255);
        jPanel9.setBackground(clr);
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        try {
            ViewReport a=new ViewReport();
            a.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AddFees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel8MouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddFees().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddFees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorAmount1;
    private javax.swing.JLabel ErrorDate;
    private javax.swing.JLabel ErrorReciept1;
    private javax.swing.JLabel ErrorSemester;
    private javax.swing.JLabel RecieverNameError1;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> comboPayment;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelParent;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtReciept;
    private javax.swing.JTextField txtRecieverName;
    private javax.swing.JTextArea txtRemark;
    private javax.swing.JTextField txtSemester;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
