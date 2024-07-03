package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 세션 만들기
        HttpSession session = request.getSession();
        System.out.println("발급받은 sdssion id : " + session.getId());

        // session 만료하게 되면 sessionDestroyed()가 동작한다.
//        session.setMaxInactiveInterval(5);
//        session.invalidate();

        // session에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다.
        session.setAttribute("username","honggildong");
        session.setAttribute("age",20);

        // dto 의 바인딩 링스너 확인
        session.setAttribute("user",new UserDTO("honggildong",20));

        // session attribute에 동일한 키로 덮어 쓰는 경우 (수정) attributedReplaced 메소드가 동작한다.
        session.setAttribute("username","hong");

        // session attribute를 제거할 때 attributedRemoved() 가 동작한다.
        session.removeAttribute("username");

    }
}
