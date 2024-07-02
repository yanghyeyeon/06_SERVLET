package com.ohgiraffers.section01.forward;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    /*
    * forward할 때 전달한 request와 response의 모든 정보를 이용해 새로운 request와 response를
    * 만들고, 그 정보를 이용해 다시 http 메소드에 맞는 서블릿의 doGet 혹은 doPost를 요청하는 방식
    * 깊은 복사를 이용해 값을 그대로 복사했기 때문에 내부에 존재하는 헤더나 인스턴스는 그대로 유지하고 있다.
    * */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * forward 받은 서블릿에서도 요청 방식이 Get이면 doGet메소드를,
         * 요청 방식이 Post이면 doPost 메소드를 호출한다.
         * 보내준 서블릿에서 request에 전달 정보를 담았으모로, 해당 서블릿에서 사용하기 위해
         * request에서 다시 꺼낸다.
         * */
        String userId = (String) request.getAttribute("userId");

        // 응답에 필요한 데이터가 준비되면 동적인 웹페이지를 생성한다.
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다.</h3>\n")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println(responseText.toString());

        out.flush();
        out.close();

        /*
        * 기본적으로 변수의 기본 스코프 메소드 (= 해당 페이지) 이기 때문에 다른 페이지(=서블릿)
        * 으로 데이터를 공유 할 수 없다.
        * 하지만 forward방식은 request와 response를 포함하여 위임하므로 request 정보를
        * 저장하여, forward하면 위임받은 서블릿에서도 위임한 서블릿의 정보를 공유할 수 있다.
        * 이때, forward 받은 서블릿의 존재를 클라이언트가 알 필요가 없기때문에
        * URL이 변경되지 않는다. (결과 화면만 받으면 되기 때문)
        * => forward 방식의 특징이 요청시 서버로 전송한 데이터가 남아있는 상태로 새로고침(= 재요청)을
        * 하게되면 동일한 요청을 반복하여 데이터 베이스에 insert 하는 등의 행위가 중복될 가능성이 있다.
        * -> 다른페이지 전환 방식인 sendRedirect를 이용한다.
        * */
    }
}
