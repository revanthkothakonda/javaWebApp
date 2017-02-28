/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
    {
       Connection con=null;
       Statement st=null;
       PreparedStatement pstmt=null;
       ResultSet rs;
       
       PrintWriter out=response.getWriter();
       String retrieve="select * from employ";
       //String insert="insert into employ values(3,'srinivas'),(4,'ambika')";
       
       //inserting by PreparedStatement
       int id=5;
       String name="kothakonda";
       String insert="insert into employ values(?,?)";
       try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
            st=con.createStatement();
            rs=st.executeQuery(retrieve);
            
             //for inserting using statementQuery
            pstmt = con.prepareStatement(insert);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            int add=pstmt.executeUpdate();
            out.println(add+" inserted values"+" "+id+" "+ name);
            //ArrayList adddata=new ArrayList();
                
            //String data="";
           //while(rs.next())
             //   {
               //     data=rs.getString("empid")+" : "+rs.getString("empname");
                 //   out.println(data);
                //}
                       } 
        catch (Exception ex) {
            Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}