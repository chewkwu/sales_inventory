/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.GodwinApp;

/**
 *
 * @author Uchenna
 */


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TransactionDB {
    
    
  private long id;
  private String phone;
  private String itemsPurchased;
  private int amount;
  private Date date;
  private int sumPaid;
  private int debt;
  
  public long getId()
  {
    return this.id;
  }
  
  public void setId(long id)
  {
    this.id = id;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  
  public String getItemsPurchased()
  {
    return this.itemsPurchased;
  }
  
  public void setItemsPurchased(String itemsPurchased)
  {
    this.itemsPurchased = itemsPurchased;
  }
  
  public int getAmount()
  {
    return this.amount;
  }
  
  public void setAmount(int amount)
  {
    this.amount = amount;
  }
  
  public Date getDate()
  {
    return this.date;
  }
  
  public void setDate(Date date)
  {
    this.date = date;
  }
  
  public int getSumPaid()
  {
    return this.sumPaid;
  }
  
  public void setSumPaid(int sumPaid)
  {
    this.sumPaid = sumPaid;
  }
  
  public int getDebt()
  {
    return this.debt;
  }
  
  public void setDebt(int debt)
  {
    this.debt = debt;
  }
  
  public long registerPurchase(String phoneNo, String purchasedItems, int amount, int amtPaid, Date pchDate, int debt)
    throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    int genKey = 0;
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
      String sql = "INSERT INTO transactions (CustomerPhone,ItemsPurchased,PurchaseAmount,AmountPaid,PurchaseDate,Debt) VALUES(?,?,?,?,?,?)";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, phoneNo);
      pst.setString(2, purchasedItems);
      pst.setInt(3, amount);
      pst.setInt(4, amtPaid);
      pst.setDate(5, pchDate);
      pst.setInt(6, debt);
      pst.executeUpdate();
      ResultSet rs = pst.getGeneratedKeys();
      rs.next();
      genKey = rs.getInt(1);
      conn.close();
    }
    catch (SQLException e)
    {
      return 0L;
    }
    return genKey;
  }
  
  public boolean updateDebt(int payment, long id)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT AmountPaid, Debt FROM transactions WHERE TransactionID = ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setLong(1, id);
    ResultSet rst = ps2.executeQuery();
    rst.next();
    int oldPaid = rst.getInt("AmountPaid");
    int oldDebt = rst.getInt("Debt");
    int newPaid = oldPaid + payment;
    int newdebt = oldDebt - payment;
    String upd1 = "UPDATE transactions SET AmountPaid = ?, Debt = ? WHERE TransactionID = ?";
    PreparedStatement ps = conn.prepareStatement(upd1);
    ps.setInt(1, newPaid);
    ps.setInt(2, newdebt);
    ps.setLong(3, id);
    try
    {
      ps.executeUpdate();
      ps.close();
      conn.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  public TransactionDB viewPartPruchase(long id)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT * FROM transactions WHERE TransactionID = ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setLong(1, id);
    ResultSet rst = ps2.executeQuery();
    TransactionDB one = new TransactionDB();
     rst.next();
    one.setId(rst.getLong("TransactionID"));
    one.setPhone(rst.getString("CustomerPhone"));
    one.setItemsPurchased(rst.getString("ItemsPurchased"));
    one.setAmount(rst.getInt("PurchaseAmount"));
    one.setSumPaid(rst.getInt("AmountPaid"));
    one.setDate(rst.getDate("PurchaseDate"));
    one.setDebt(rst.getInt("Debt"));
    
    return one;
  }
  
  public List<TransactionDB> viewCustomerPurchase(String phone)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<TransactionDB> temi = new ArrayList();
    
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT * FROM transactions WHERE CustomerPhone = ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setString(1, phone);
    ResultSet rst = ps2.executeQuery();
    while (rst.next())
    {
      TransactionDB one = new TransactionDB();
      one.setId(rst.getLong("TransactionID"));
      one.setPhone("CustomerPhone");
      one.setItemsPurchased("ItemsPurchased");
      one.setAmount(rst.getInt("PurchaseAmount"));
      one.setSumPaid(rst.getInt("AmountPaid"));
      one.setDate(rst.getDate("PurchaseDate"));
      one.setDebt(rst.getInt("Debt"));
      temi.add(one);
    }
    return temi;
  }
  
  public List<TransactionDB> viewAllPurchases()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<TransactionDB> temi = new ArrayList();
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT * FROM transactions";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ResultSet rst = ps2.executeQuery();
    while (rst.next())
    {
        TransactionDB one = new TransactionDB();
      one.setId(rst.getLong("TransactionID"));
      one.setPhone(rst.getString("CustomerPhone"));
      one.setItemsPurchased(rst.getString("ItemsPurchased"));
      one.setAmount(rst.getInt("PurchaseAmount"));
      one.setSumPaid(rst.getInt("AmountPaid"));
      one.setDate(rst.getDate("PurchaseDate"));
      one.setDebt(rst.getInt("Debt"));
      temi.add(one);
    }
    return temi;
  }
  
  public List<TransactionDB> viewFromDate(Date date)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<TransactionDB> temi = new ArrayList();
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT * FROM transactions WHERE PurchaseDate >= ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setDate(1, date);
    ResultSet rst = ps2.executeQuery();
    TransactionDB one = new TransactionDB();
    while (rst.next())
    {
      one.setId(rst.getLong("TransactionID"));
      one.setPhone("CustomerPhone");
      one.setItemsPurchased("ItemsPurchased");
      one.setAmount(rst.getInt("PurchaseAmount"));
      one.setSumPaid(rst.getInt("AmountPaid"));
      one.setDate(rst.getDate("PurchaseDate"));
      one.setDebt(rst.getInt("Debt"));
      temi.add(one);
    }
    return temi;
  }
  
  public int debtFromTime(Date date)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT Debt FROM transactions WHERE PurchaseDate >= ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setDate(1, date);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("Debt");
      sum += mua;
    }
    return sum;
  }
  
  public int customerDebt(String phone)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT Debt FROM transactions WHERE CustomerPhone = ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setString(1, phone);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("Debt");
     sum += mua;
    }
    return sum;
  }
  
  public int allDebt()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT Debt FROM transactions";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("Debt");
      sum += mua;
    }
    return sum;
  }
  
  public int revenueFromDate(Date date)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT AmountPaid FROM transactions WHERE PurchaseDate >= ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setDate(1, date);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("AmountPaid");
      sum += mua;
    }
    return sum;
  }
  
  public int allRevenue()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT AmountPaid FROM transactions";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("AmountPaid");
      sum += mua;
    }
   
    return sum;
  }
  
  public int allSales()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT PurchaseAmount FROM transactions";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
     int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("PurchaseAmount");
      sum += mua;
    }
    return sum;
  }
  
  public int salesFromTime(Date date)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd = "SELECT PurchaseAmount FROM transactions WHERE PurchaseDate >= ?";
    PreparedStatement ps2 = conn.prepareStatement(upd);
    ps2.setDate(1, date);
    ResultSet rst = ps2.executeQuery();
    List<Integer> emi = new ArrayList();
    int sum = 0;
    while (rst.next())
    {
      int mua = rst.getInt("PurchaseAmount");
      sum += mua;
    }
    return sum;
  }
    
}
