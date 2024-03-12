package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// セッションスコープの取得
		HttpSession session = request.getSession(true);
		// セッションスコープ内のインスタンス（買い物リスト）を破棄
		session.removeAttribute("cart");
		
		out.print("<html><head>");
		out.print("<title>ログアウト画面</title><style>body{text-align:center}</style>");
		out.print("</head><body>");
		out.print("<h2>ログアウトしました</h2>");
		out.print("<input type=\"button\" value=\"商品一覧ページに戻る\" onclick=\"location.href='/Shop_Project/session'\"");
		out.print("");
		out.print("</body></html>");
	}
}
