package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションスコープの生成(初回)、取得(2回目以降)
		// 引数を「false」にすると、初回実行時の場合セッションスコープを生成しない
		HttpSession session = request.getSession(true);

		// セッションスコープからcart(買い物かごに入れているアイテムのリスト)を取得(初回はnullが返ってくる)
		ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("cart");

		if (itemList == null) {
			itemList = new ArrayList<String>(); //初回アクセス時のみ
		} else {
			request.setCharacterEncoding("UTF-8");
			String item = request.getParameter("item");
			itemList.add(item);
		}
		
	// セッションスコープに買い物リストを格納
		session.setAttribute("cart", itemList);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>商品一覧画面</title>");
		out.println("<style>body{text-align:center}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ポケモンショッピングネットへようこそ</h1>");
		out.println("<h2>購入する商品を選択してください</h2>");;
		out.println("<table border=\"1\" style=\"margin:auto\">");
		out.println("<tr><th>商品画像</th><th>商品名</th><th>価格</ht></tr>");
		out.println("<tr><th><img src=\"./image/monsterball.png\" width=\"100\"></th><th>モンスターボール</th><th>200円</th></tr>");
		out.println("<tr><th><img src=\"./image/superball.png\" width=\"100\"></th><th>スーパーボール</th><th>600円</th></tr>");
		out.println("<tr><th><img src=\"./image/hyperball.png\" width=\"100\"></th><th>ハイパーボール</th><th>1200円</th></tr>");
		out.println("</table><br><br>");
		out.println("<form action=\"/Shop_Project/session\" method=\"post\">");
		out.println("<select name=\"item\" size=\"1\">");
		out.println("<option value=\"モンスターボール\">モンスターボール</option> ");
		out.println("<option value=\"スーパーボール\">スーパーボール</option>");
		out.println("<option value=\"ハイパーボール\">ハイパーボール</option>");
		out.println("</select>");
		out.println("<input type=\"submit\" value=\"追加\">");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
