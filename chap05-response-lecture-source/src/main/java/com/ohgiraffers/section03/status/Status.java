package com.ohgiraffers.section03.status;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/status")
public class Status extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 200, 400, 401, 404, 500

        response.sendError(200,"요청이 성공적 입니다");
        response.sendError(400,"이 응답은 잘못된 문법으로 인하여 서버가 요청을 이해할 수 없음을 의미합니다.");
        response.sendError(401,"권한이 없습니다");
        response.sendError(404,"없는 페이지 입니다. 경로를 확인해주세요");
        response.sendError(500,"서버 내부 오류입니다. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다");
    }
}
