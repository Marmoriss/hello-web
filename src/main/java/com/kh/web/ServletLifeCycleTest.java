package com.kh.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 *
 * - GenericServlet : Servlet인터페이스를 구현
 *     - HttpServlet
 *         - ServletLifeCycle
 * 
 * - 사용자 요청이 접수되면 HttpServlet의 service메소드가 호출되고,
 * 그 안에서 전송방식에 따라 doGet, doPost 호출 처리
 * 
 * - Servlet은 tomcat(WAS/Web Container)에 의해 Singletone패턴으로 관리된다.
 *  (프로그램 운영 중에 단 하나의 객체만 만들어서 운영)
 * - 사용자 요청당 하나의 쓰레드가 생성되어 처리(응답성 향상)
 * 
 * - Servlet LifeCycle
 *  1. 생성자 호출
 *  2. init 호출
 *  
 *  3. service - doGet/doPost
 *  
 *  4. destroy 호출
 * 
 * @WebServlet web.xml에 url-pattern과 servlet클래스 바인딩하는 것과 동일한 작업
 * 
 */

@WebServlet("/servlet/lifeCycle.do")
public class ServletLifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLifeCycleTest() {
        System.out.println("[ServletLifeCycleTest 생성자 호출]");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	    System.out.println("[init 호출]");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	    System.out.println("[destroy 호출]");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("[Get /servlet/lifeCycle.do 호출!]");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
