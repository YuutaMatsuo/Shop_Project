<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map,java.util.HashMap" %>
<%
	HashMap<String,Integer> itemMap = (HashMap) session.getAttribute("cart");
	Map<String,Integer> priceMap = new HashMap<>();
	priceMap.put("モンスターボール", 200);
	priceMap.put("スーパーボール", 600);
	priceMap.put("ハイパーボール", 1200);
	
	int totalPrice = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
<style>
	body{
	text-align:center
	}
</style>
</head>
<body>
	<h2>購入商品一覧</h2>
	<h3>以下の内容で発送致しました。</h3>
	<%	for(Map.Entry<String, Integer> entry : itemMap.entrySet()) { %>
	<% 		if(entry.getKey() != null) { %>
	<%			totalPrice += priceMap.get(entry.getKey()) * entry.getValue(); %>
	<%= 		entry.getKey() + ": " + entry.getValue() + "個 " + (priceMap.get(entry.getKey()) * entry.getValue() + "円") %><br>					
	<% 		} %>
	<%	} %>
	<%= "合計額：" + totalPrice + "円" %><br>
<br>
<%-- ボタンタグ --%>
<input type="button" value="続けて買い物をする" onclick="location.href='/Shop_Project/session'">
<input type="button" value="買い物を終了する" onclick="location.href='/Shop_Project/logout'">
</body>
</html>