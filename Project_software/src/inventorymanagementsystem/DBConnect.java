/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Sazzad sazib
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public DBConnect() {
        try{
         Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse370project","root","root");
        st = con.createStatement();
        
            
        }catch(Exception e) {
            System.out.println("ERROR : "+ e);
        }
       
        
        
    }
    public String getDataQuery01() {
        String str="No DATA TO DISPLAY";   
        try{
                String query="Select productName from product where productStock<1";
                rs=st.executeQuery(query);
                 str="DATABASE Output FOR product whose stock <0  is : \n \n";
                 
                while(rs.next()) {
                    String products = rs.getString("productName");
                    str=str+" \n" +products+", ";
                }
                
                
            }catch(Exception e) {
                System.out.println(e);
            }
     //       System.out.println(str);
            return str;
        }
    
    public String adminLoginAccess(String username,String password) {
        String ret="null";
        try{
            
                String query="Select * from adminlogin";
                rs=st.executeQuery(query);
                
                while(rs.next()) {
                    String us = rs.getString("admin_name");
                    String pw=rs.getString("admin_password");
                    String type=rs.getString("admin_type");
                    if(username.equals(us) && password.equals(pw) && type.equals("admin")) {
                      ret="admin";
                     break;
                    }else if(username.equals(us) && password.equals(pw) && type.equals("salesman")) {
                      ret="salesman";
                        break;
                    }
                }
                
                
            }catch(Exception e) {
                System.out.println(e);
            }
        
        return ret;
    }
    
     public void getData() {
            try{
                String query="Select * from customer";
                rs=st.executeQuery(query);
                System.out.println("DATABASE INPUT FOR Customer");
                while(rs.next()) {
                 String customerID=rs.getString("customerId");
                 String customerNamE=rs.getString("customerName");
                 String customerHouseNO=rs.getString("customerHouseNo");
                 String customerRoadNO=rs.getString("customerRoadNo");
                 String customerCity=rs.getString("customerCity");
                 String customerLocation=rs.getString("customerLocation");
                 String customerPhone=rs.getString("customerPhone");
                 String customerEmail=rs.getString("customerEmail");
                 
                 System.out.println(""+ customerID + " "+ customerNamE + " "+ customerHouseNO + " "+ customerRoadNO + " "+ customerCity + " "+ customerLocation + " ");
                 
                }
                
                
            }catch(Exception e) {
                System.out.println(e);
            }
        }
     
     public void add_customer(String Cid,String cn,String chn,String crn, String cc, String cl,String cp,String ce) {
         try {
             
             String query="INSERT INTO `cse370project`.`customer` (`customerId`, `customerName`, `customerHouseNo`, `customerRoadNo`, `customerCity`, `customerLocation`, `customerPhone`, `customerEmail`) VALUES ( '"+Cid+"', '"+cn+"', '"+chn+"', '"+crn+"', '"+cc+"', '"+cl+"', '"+cp+"', '"+ce+"');";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
     }
     
     public void add_orderlist (String orID,String cid,String od,String opt, double tap) {
         try {
             
             String query="INSERT INTO `cse370project`.`orderlist` (`orderId`, `customerId`, `orderDate`, `orderPayementType`, `totalAmountPayement`) VALUES ('"+orID+"', '"+cid+"', '"+od+"', '"+opt+"', "+tap+");";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
     }
     public void add_orderProducts (String orID,String pid,double tp, double top) {
         try {
             
             String query="INSERT INTO `cse370project`.`orderproduct` (`orderId`, `productId`, `quantity`, `totalPrice`) VALUES ('"+orID+"', '"+pid+"', "+tp+","+top+");";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
     }
     
     public void add_Products (String pn,String pid,double ps, double pp) {
         try {
             
             String query="INSERT INTO `cse370project`.`product` (`productId`, `productName`, `productStock`, `productPrice`) VALUES ('"+pn+"', '"+pid+"', "+ps+", "+pp+");";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
     }
   public void add_supplier (String sid,String sn,String bn,String acn,String shn,String srn,String sc,String sl,String sp,String se) {
         try {
             
             String query1="INSERT INTO `cse370project`.`supplier` (`supplierId`, `supplierName`) VALUES ('"+sid+"', '"+sn+"');";
             String query2="INSERT INTO `cse370project`.`supplierbankaccountinfo` (`supplierId`, `bank`, `accountNo`) VALUES ('"+sid+"', '"+bn+"', '"+acn+"');";
             String query3="INSERT INTO `cse370project`.`suppliercontactinfo` (`supplierId`, `supplierHouseNo`, `supplierRoadNo`, `supplierCity`, `supplierLocation`, `supplierPhone`, `supplierEmail`) VALUES ('"+sid+"', '"+shn+"', '"+srn+"', '"+sc+"', '"+sl+"', '"+sp+"', '"+se+"');";
             System.out.println(query1);
               st.executeUpdate(query1);
               st.executeUpdate(query2);
               st.executeUpdate(query3);
              
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Insert was Not Successfull");
         }
     }
   
    public void edit(String tbl,String att,String val,String key ) {
        //"Customer", "OrderList","OrderProduct", "Product","Supplier"
        try{
         String id="";
         if(tbl.equals("Customer")){
             id="customerId";
         }else if(tbl.equals("OrderList")) {
             id="orderid";             
         }else if(tbl.equals("OrderProduct")) {
             id="orderid";             
         }else if(tbl.equals("Product")) {
             id="productId";             
         }else if(tbl.equals("Supplier")) {
             id="supplierid";             
         }
         String query="UPDATE `cse370project`.`"+tbl+"` SET `"+att+"` = '"+val+"' WHERE `"+tbl+"`.`"+id+"` = '"+key+"';";
         System.out.println(query);
         st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Edit in database was successfull");
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e+"EDIT FAILED May be You are trying to change something which cannot be change!!");
     }
     }
     
     
     
     public void delete(String tbl,String key) {
         try{
         String id="";
         if(tbl.equals("Customer")){
             id="customerId";
         }else if(tbl.equals("OrderList")) {
             id="orderid";             
         }else if(tbl.equals("OrderProduct")) {
             id="orderid";             
         }else if(tbl.equals("Product")) {
             id="productId";             
         }else if(tbl.equals("Supplier")) {
             id="supplierid";             
         }
          String query="DELETE FROM `"+tbl+"` WHERE `"+id+"`='"+key+"';";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "DELETE was SUCCESSFULL");
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, e+"DELETE WAS NOT SUCCESSFULL");
         }
     }
     
    
     
     public void getTotalCust(){
         try{
             String str = "select count(*) as Total_Number_of_Customers from Customer";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
     
       public void getTotalSuuplier(){
         try{
             String str = "Select count(*) as Total_Number_of_Suppliers from Supplier";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
       
        public void getMostExpensiveProduct(){
         try{
             String str = "Select productId, productName,max(productPrice) as max_price from product";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
         public void getCheapestProduct(){
         try{
             String str = "Select productId, productName,min(productPrice) as min_price from product";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
         
        public void getCustomerInfo(){
         try{
             String str = "Select * from customer";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
    public void getAdminInfo(){
         try{
             String str = "Select * from adminlogin";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
    
        public void getProductInfo(){
         try{
             String str = "Select * from product";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
      public void getSupplierInfo(){
         try{
             String str = "Select * from supplier";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
      
         public void getOutOfStock(){
         try{
             String str = "Select productId, productName from product where productStock<1";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
         
     public String [] Combo(String field, String col){
         try{
             String sql = "select * from " + col + "";
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             ArrayList<String> str = new ArrayList();
             while(rs.next()){
                 String name = rs.getString(field);
                 str.add(name);
             }
             int n = str.size();
             String arr[] = new String[n];
             for(int i = 0; i<n; i++) arr[i] = str.get(i);
             return arr;
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
         }
         return null;
     }
     
        public void getSpecificProdInfo(String id){
         try{
             String str = "Select * from product where productId = " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
     public void getSpecificCustInfo(String id){
         try{
             String str = "Select * from customer where customerId = " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
     
         public void getSpecificSupplierInfo(String id){
         try{
             String str = "Select * from supplier where supplierId = " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
        public void getSpecificProdQty(String id){
         try{
             String str = "Select productStock as Quantity_Left_In_Stock from product where productId = " + id;
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
        
         public void getSpecificCustPayType(String id){
         try{
             String str = "Select orderDate, orderPayementType, totalAmountPayement from orderlist where customerId = " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
         
    public void getSpecificSuppDate(String id){
         try{
             String str = "Select distinct(supplyDate) from supplyproduct where supplierId = " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
    
    public void getSpecificSuppProd(String id){
         try{
             String str = "select distinct(product.productId), product.productName from supplyproduct inner join product on supplyproduct.productId = product.productId where supplyproduct.supplierId =  " + id + "";
             rs = st.executeQuery(str);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Vector column = new Vector(c);
             for(int i = 1; i <= c; i++){
                 column.add(rsmt.getColumnName(i));
             }
             Vector data = new Vector();
             Vector row = new Vector();
             while(rs.next()){
                row = new Vector(c);
                for(int i = 1; i <= c; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
             }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            //frame.setSize(frame.getContentPane().getPreferredSize());
         }
         catch(Exception e){
           JOptionPane.showMessageDialog(null, "Query was Not Successfull");  
        }
     }
    public void createADmin(int sl,String adN,char adp[],String adTyp) {
        try {
             String pw="";
             for(int i=0; i<adp.length; i++) {
                 pw=pw+adp[i];
            
             }
             String query="INSERT INTO `cse370project`.`adminlogin` (`sL_admin`, `admin_name`, `admin_password`, `admin_type`) VALUES ('"+sl+"', '"+adN+"', '"+pw+"', '"+adTyp+"');";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
    }
    
    
    public void editAdmin(int sl,char pwd[]) {
        try {
             String pw="";
             for(int i=0; i<pwd.length; i++) {
                 pw=pw+pwd[i];
            
             }
             String query="UPDATE `cse370project`.`adminlogin` SET `admin_password` = '"+pw+"' WHERE `adminlogin`.`sL_admin` = "+sl+";";
             System.out.println(query);
             st.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Inserted Successfully");
         }catch(Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Query insert was Not Successfull");
         }
    }
}
