 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*"%>
<%-- 
    jsp 작성 내용은 servlet으로 변환되어 서비스된다.
    jsp를 수정한 경우, tomcat을 재시동할 필요가 없다.
    클라이언트 호출시 변경된 내용이 자동변환/컴파일 처리된다.
 --%>
<%
// Scriptlet
System.out.println("Hello JSP!");
System.out.println(12345);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basic</title>
<style>
table {
    border : 1px solid #000;
    border-collapse : collapse;
    margin : 10px 0;
}
th, td{
    border : 1px solid #000;
    margin : 10px 0;
}
</style>
<script>
window.onload = () => {
    let sum = 0;
    for(let i = 1; i <= 100; i++)
		sum += i;
    
    document.querySelector("#client-sum").innerHTML = sum;
    
	document.querySelector("#client-millis").innerHTML = Date.now();
}
</script>
</head>
<body>
    <%
    int sum = 0;
    for (int i = 1; i <= 100; i++)
        sum += i;
    %>
    <h1>JSP Basic</h1>
    <%-- jsp 주석  : servlet변환시 처리되지 않는다.--%>
    <!-- html 주석 : client까지 전달된다. -->
    <h2>1부터 100까지의 합은?</h2>
    <ul>
        <li>Server : <span class="sum"><%=sum%></span></li>
        <li>Client : <span class="sum" id="client-sum"></span></li>

    </ul>

    <h2>Server | Client 시각 출력</h2>
    <ul>
        <%-- <li>Server : <span class="millis"><%= System.currentTimeMillis() %></span></li> --%>
        <li>Server : <span class="millis"> <%
 out.print(System.currentTimeMillis());
 %>
        </span></li>
        <li>Client : <span class="millis" id="client-millis"></span></li>
    </ul>

    <h2>분기</h2>
    <%
    String lang = request.getParameter("lang");
    System.out.println("lang = " + lang);

    if ("en".equals(lang)) {
    %>
    <p>Hello~</p>
    <%
    } else if ("ko".equals(lang)) {
    %>
    <p>안녕하세요~</p>
    <%
    }
    %>

    <%
    if (lang != null) {
        switch (lang) {
        case "en":
    %>
    <p>Bye bye</p>
    <%
    break;
    case "ko":
    %>
    <p>잘가요~</p>
    <%
    break;
    }
    }
    %>

    <h2>반복처리</h2>
    <ul>
    <%
    List<String> names = Arrays.asList("홍길동", "신사임당", "이순신");
    for (String name : names) {
    %>
    <li><%=name%></li>
    <%
    }
    %>
    </ul>

    <h2>@실습문제 - 주문</h2>
    <!-- 
    <table>
    	<tbody>
    		<tr>
    			<th>주문번호</th>
    			<td></td>
    		</tr>
            <tr>
                <th>상품명</th>
                <td></td>
            </tr>
            <tr>
    			<th>옵션1</th>
    			<td></td>
    		</tr>
    	</tbody>
    </table> 
    -->
    <%
    int no = Integer.parseInt(request.getParameter("no"));
    String prod = request.getParameter("prod");
    String[] options = request.getParameterValues("option");
%>
     <table>
         <tbody>
             <tr>
                 <th>주문번호</th>
                 <td><%= no %></td>
             </tr>
             <tr>
                 <th>상품명</th>
                 <td><%= prod %></td>
             </tr>
<% 
    if(options != null){
        for(int i = 0; i < options.length; i++){        
%>
             <tr>
                 <th>옵션<%= i + 1 %></th>
                 <td><%= options[i] %></td>
             </tr>
<% 
        }
    } 
%>    
         </tbody>
     </table>
    





</body>
</html>