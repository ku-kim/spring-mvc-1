package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");// application/json 에 utf-8 의미없음 (규약상 utf-8 포함)

        HelloData helloData = new HelloData();
        helloData.setUsername("lee");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData);
//        response.getWriter().write(result); // 이 방식으로 하면 utf-8 추가안해줘도 자동으로 해당 시스템에 맞는 charset 추가해버림
        response.getOutputStream().print(result); // charset 자동 추가 안하고 싶을 때 getOutputStream()으로 해주면 됨됨
    }
}

