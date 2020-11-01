/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.GodwinApp;

import com.biz.GodwinApp.GoodsDB;
import com.biz.GodwinApp.TransactionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Uchenna
 */
public class RegPurch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String itemspurch ;
    int purchamt;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Purchase</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String[] items = request.getParameterValues("init");  
            itemspurch = Arrays.toString(items);
            for(String item : items)
            if(item != null){
                GoodsDB upd = new GoodsDB();
                upd.updateStock(Integer.parseInt(request.getParameter("figure" + item)),request.getParameter("init"+item));
            purchamt += Integer.parseInt(request.getParameter("price"+item));
            }
            
        Calendar currenttime = Calendar.getInstance();
          Date date = new Date((currenttime.getTime()).getTime());
          int debt = purchamt - Integer.parseInt(request.getParameter("amtpaid")); 
         
          TransactionDB purch = new TransactionDB();
           long status = purch.registerPurchase(request.getParameter("custPhone"), 
           itemspurch,purchamt,Integer.parseInt(request.getParameter("amtpaid")), 
           date, debt);
           if (status != 0){
          
                TransactionDB purch2 = new TransactionDB();
                purch2.setId(status);
                purch2.setPhone(request.getParameter("custPhone"));
                purch2.setItemsPurchased(itemspurch);
                purch2.setAmount(purchamt);
                purch2.setSumPaid(Integer.parseInt(request.getParameter("amtpaid")));
                purch2.setDate(date);
                purch2.setDebt(debt);
                request.setAttribute("purchase",purch2);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/regPurchSucc.jsp");
                rd.forward(request, response);
           } else {
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/regPurchFail.jsp");
               rd.forward(request, response);
               //out.println(e.getMessage());
           }
           // }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegPurch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
