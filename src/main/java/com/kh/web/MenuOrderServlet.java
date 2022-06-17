package com.kh.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {   
	    
	    request.setCharacterEncoding("utf-8");
	    
	    String mainMenu = request.getParameter("mainMenu");
	    String sideMenu = request.getParameter("sideMenu");
	    String drinkMenu = request.getParameter("drinkMenu");
	    
	    int total = 0;
	    
	    if(mainMenu != null && sideMenu != null && drinkMenu != null){
	        switch(mainMenu){
	        case "한우버거" : total += 5000; break;
	        case "밥버거" : total += 4500; break;
	        case "치즈버거" : total += 4000; break;
	        }
	        
	        switch(sideMenu){
	        case "감자튀김" : total += 1500; break;
	        case "어니언링" : total += 1700; break;
	        }
	        
	        switch(drinkMenu){
	        case "콜라" : total += 1000; break;
	        case "사이다" : total += 1000; break;
	        case "커피" : total += 1500; break;
	        case "밀크쉐이크" : total += 2500; break;
	        }
	    }
	    request.setAttribute("total", total);
	    
	    RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/menu/menuEnd.jsp");
	    reqDispatcher.forward(request, response);
	    
	}
	    
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

}
