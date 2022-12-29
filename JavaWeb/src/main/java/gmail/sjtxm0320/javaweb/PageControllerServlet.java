package gmail.sjtxm0320.javaweb;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PageControllerServlet", value = "/PageControllerServlet")
public class PageControllerServlet extends HttpServlet {
    // 서비스에 대한 참조 변수
    private PageService pageService;

    public PageControllerServlet() {
        // 생성자에서 서비스 생성(나중에는 주입 받음)
        pageService = new PageServiceImpl();
    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
        ServletException,
        IOException {
        // 파라미터 읽기
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        // 서비스 메서드 호출
        // 파라미터의 자료형 변환은 Service에서 수행해도 된다.
        // Spring은 일반적으로 Controller에서 형 변환 수행
        int result = pageService.add(Integer.parseInt(first), Integer.parseInt(second));

        // 결과를 저장
        request.setAttribute("result", result);
        request.getSession().setAttribute("result", result);
        request.getServletContext().setAttribute("result", result);

        // 뷰 페이지 결정 후 데이터 전달
        response.sendRedirect("res.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
        ServletException,
        IOException {

    }
}
