package com.kh.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testPerson3.do")
public class TestPersonServlet3 extends HttpServlet {

    /**
     * POST 요청 처리시 doPost 오버라이드
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 요청 인코딩 처리 (POST요청시 필수)
        request.setCharacterEncoding("utf-8");

        // 2. 사용자 입력값 처리

        String name = request.getParameter("name"); // 대소문자 구분
        String color = request.getParameter("color");
        String animal = request.getParameter("animal");
        String[] foods = request.getParameterValues("food"); // 복수개의 값 처리

        System.out.println("name = " + name);
        System.out.println("color = " + color);
        System.out.println("animal = " + animal);
        System.out.println("food = " + (foods != null ? Arrays.toString(foods) : null));

        // 3. 업무 로직
        // 추천서비스
        String recommendation = "";
        switch(color) {
        case "빨강" : recommendation = "행운 아이템 : 빨간 하트"; break;
        case "파랑" : recommendation = "행운 아이템 : 파란색 핸드폰케이스"; break;
        case "노랑" : recommendation = "행운 아이템 : 노란 우산"; break;
        case "초록" : recommendation = "행운 아이템 : 초록색 텀블러"; break;
        }

        // 4. 응답메세지 작성 -> JSP위임
        // jsp에 데이터 전달 방법 : request속성 등록
        request.setAttribute("recommendation", recommendation);
        
        RequestDispatcher reqDispatcher = 
                request.getRequestDispatcher("/testPersonResult.jsp");
        // src/main/webapp/testPersonResult.jsp
        reqDispatcher.forward(request, response);
    }
}
