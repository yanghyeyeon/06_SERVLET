package com.ohgiraffers.section01.exception;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showerrorpage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // getAttributeNames : request 객체가 가지고 있는 속성의 이름을 모두 가져온다.
        Enumeration<String> attrNames = request.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        // Attribute에는 키벨류 쌍으로 벨류가 Object 타입으로 저장된다.
        String forwardRequestUri = (String) request.getAttribute("jakarta.servlet.forward.request_uri");
        String contextPath = (String) request.getAttribute("jakarta.servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("jakarta.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String massage = (String) request.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
        String requestURI = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        // 시작점에 관한 내용
        System.out.println("forwardRequestUri = " + forwardRequestUri);
        // 객체의 위치
        System.out.println("contextPath = " + contextPath);
        // 현재 request를 넘겨받을 서블릿의 위치
        System.out.println("servletPath = " + servletPath);
        // 매핑된 경로
        System.out.println("mapping = " + mapping);
        // 매핑된 서블릿의 이름
        System.out.println("mapping.getServletName() = " + mapping.getServletName());
        // 매핑경로의 값
        System.out.println("mapping.getMatchValue() = " + mapping.getMatchValue());
        // 매핑 패턴
        System.out.println("mapping.getPattern() = " + mapping.getPattern());
        // 매핑된 URL이 일치하는지 (EXACT : 정확히 일치함)
        System.out.println("mapping.getMappingMatch() = " + mapping.getMappingMatch());
        // 상태코드
        System.out.println("statusCode = " + statusCode);
        // 전달된 메시지
        System.out.println("massage = " + massage);
        // 전달한 서블릿 이름
        System.out.println("servletName = " + servletName);
        // 에러가 발생한 URI 경로
        System.out.println("requestURI = " + requestURI);

        StringBuilder errorPage = new StringBuilder();

        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(massage)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(errorPage.toString());

        out.flush();
        out.close();

    }


}
