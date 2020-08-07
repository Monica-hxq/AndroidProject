/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class WeatherServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //设置响应那个内容格式
        response.setContentType("application/json;charset=utf-8");  
        
        try(PrintWriter out = response.getWriter())
        {
            WeatherInfo zzInfo = new WeatherInfo(1,"郑州","晴","bz2.png","sun.png",32.2);
            WeatherInfo shInfo = new WeatherInfo(2,"上海","阴","bz1.jpg","clouds.png",30.2);
            WeatherInfo bjInfo = new WeatherInfo(3,"北京","多云","bz2.png","cloud_sun.png",16.5);
            String city = request.getParameter("City");
            Gson gson = new Gson();
            switch(city)
            {
                case "郑州" : out.write(gson.toJson(zzInfo));
                break;
                case "上海" : out.write(gson.toJson(shInfo));
                break;
                case "北京" : out.write(gson.toJson(bjInfo));
                break;
            }
            
        }
        
    }

    // <editor- defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
