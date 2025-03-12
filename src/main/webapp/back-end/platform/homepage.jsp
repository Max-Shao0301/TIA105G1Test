<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.apply.model.*"%>
<%@ page import="com.member.model.*"%>
<%@ page import="com.staff.model.*"%>
<%@ page import="com.orders.model.*"%>
<%
MemberService memberSvc = new MemberService();
List<MemberVO> memberList = memberSvc.getAll();
pageContext.setAttribute("memberList", memberList);
%>
<%
ApplyService applySvc = new ApplyService();
List<ApplyVO> applyList = applySvc.getAll();
pageContext.setAttribute("applyList", applyList);
%>
<%
StaffService staffSvc = new StaffService();
List<StaffVO> staffList = staffSvc.getAll();
pageContext.setAttribute("staffList", staffList);
%>
<%
OrdersService ordersSvc = new OrdersService();
List<OrdersVO> ordersList = ordersSvc.getAll();
pageContext.setAttribute("ordersList", ordersList);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>平台管理系統</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/homepage.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/datatables/dataTables.min.css" />
</head>
<body>
	<header class="header">
		<div class="title_content_box">
			<!-- <span class="aside_bar"><i class="fa-solid fa-bars fa-lg"></i></span> -->

			<h2 class="h_title">
				<img src="${pageContext.request.contextPath}/resource/images/logo.png"
					alt="" />寵愛牠平台管理系統
			</h2>
			<span class="user_admin"><i class="fa-solid fa-user"></i> admin</span>
		</div>
	</header>
	<nav class="nav">
		<a onclick="showContent('order')">訂單管理</a> <a
			onclick="showContent('resume')">履歷審核</a> <a
			onclick="showContent('member')">會員管理</a> <a
			onclick="showContent('worker')">服務人員管理</a>
	</nav>
	
	<div id="homepage_img">
		<img
			src="${pageContext.request.contextPath}/resource/images/Homepage_cat.png"
			alt="" />
	</div>
	<div id="order" class="content">
		<h2>訂單管理</h2>
		<table id="myTable" class="display">
			<thead>
				<tr>
					<th>訂單編號</th>
					<th>訂單建立時間</th>
					<th>顧客編號</th>
					<th>服務人員編號</th>
					<th>上車地點</th>
					<th>下車地點</th>
					<th>支付方式</th>
					<th>折抵點數</th>
					<th>訂單金額</th>
					<th>訂單備註</th>
					<th>訂單狀態</th>
					<th>訂單評價</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ordersVO" items="${ordersList}">
					<tr>
						<td>${ordersVO.order_id}</td>
						<td>${ordersVO.create_time}</td>
						<td>${ordersVO.member_id}</td>
						<td>${ordersVO.staff_id}</td>
						<td>${ordersVO.geton_location}</td>
						<td>${ordersVO.getoff_location}</td>
						<td><c:if test="${ordersVO.pay_method == 0}">
							點數
						</c:if> <c:if test="${ordersVO.pay_method == 1}">
							刷卡
						</c:if> <c:if test="${ordersVO.pay_method == 2}">
							點數+刷卡
						</c:if></td>
						<td>${ordersVO.redeem_point}</td>
						<td>${ordersVO.payment}</td>
						<td>${ordersVO.notes}</td>
						<td><c:if test="${ordersVO.status == 0}">
							已取消
						</c:if> <c:if test="${ordersVO.status == 1}">
							進行中
						</c:if> <c:if test="${ordersVO.status == 2}">
							已完成
						</c:if></td>
						<td>${ordersVO.rating}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="resume" class="content">
		<h2>履歷審核</h2>
		<table id="myTable3" class="display">
			<thead>
				<tr>
					<th>履歷編號</th>
					<th>應徵者姓名</th>
					<th>應徵者電話</th>
					<th>應徵者電子信箱</th>
					<th>應徵時間</th>
					<th>審核結果</th>
					<th>審核完成時間</th>
					<th>檢視</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="applyVO" items="${applyList}">
					<tr>
						<td>${applyVO.applyId}</td>
						<td>${applyVO.name}</td>
						<td>${applyVO.phone}</td>
						<td>${applyVO.email}</td>
						<td><fmt:formatDate value="${applyVO.submissionDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						
						<td><c:if test="${applyVO.results == 0}">
							未通過
						</c:if> <c:if test="${applyVO.results == 1}">
							已通過
						</c:if> <c:if test="${applyVO.results == 2}">
							未審核
						</c:if></td>
						<td>${applyVO.reviewDate}</td>
						<td><span class="view-resume" data-name="${applyVO.name}"
							data-gender="${applyVO.gender}" data-phone="${applyVO.phone}"
							data-email="${applyVO.email}" data-plate="${applyVO.plateNumber}"
							data-introduction="${applyVO.introduction}"
							data-license="${pageContext.request.contextPath}/PhotoReader?applyId=${applyVO.applyId}">
								<i class="fa-solid fa-eye"></i>
						</span></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<!-- 履歷審核的彈窗 -->
	<div id="resumeModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<div class="left-section">
				<p>
					<strong>應徵者姓名：</strong> <span id="modal-name"></span>
				</p>
				<p>
					<strong>應徵者性別：</strong> <span id="modal-gender"></span>
				</p>
				<p>
					<strong>應徵者電話：</strong> <span id="modal-phone"></span>
				</p>
				<p>
					<strong>應徵者電子信箱：</strong> <span id="modal-email"></span>
				</p>
				<p>
					<strong>應徵者車號：</strong> <span id="modal-plate"></span>
				</p>
				<p>
					<strong>應徵者簡介：</strong> <span id="modal-introduction"></span>
				</p>
			</div>
			<div class="right-section">
				<p>
					<strong>應徵者駕照照片：</strong>
				</p>
				<img id="modal-license" src="" alt="駕照照片" />
				<!-- 按鈕區域 -->
				<form method="post"
					action="${pageContext.request.contextPath}/ApplyServlet">
					<div class="buttons">
						<input type="hidden" name="apply_id" value="">
						<input type="hidden" name="action" value="update"> 
						<input type="hidden" name="results" id="rs">
						<button type="submit" class="approve" id="approve-btn">聘用</button>
						<button type="submit" class="reject" id="reject-btn">婉拒</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="member" class="content">
		<h2>會員管理</h2>
		<table id="myTable1" class="display">
			<thead>
				<tr>
					<th>顧客編號</th>
					<th>顧客姓名</th>
					<th>電話</th>
					<th>地址</th>
					<th>點數</th>
					<th>電子信箱</th>
					<th>帳號狀態</th>
					<th>帳號註冊時間</th>
					<th>最後更新時間</th>
					<th>停權</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberVO" items="${memberList}">
					<tr>
						<td>${memberVO.member_id}</td>
						<td>${memberVO.name}</td>
						<td>${memberVO.phone}</td>
						<td>${memberVO.address}</td>
						<td>${memberVO.points}</td>
						<td>${memberVO.email}</td>
						<td><c:if test="${memberVO.status == 0}">
							已停權
						</c:if> <c:if test="${memberVO.status == 1}">
							啟用中
						</c:if></td>
						<td><fmt:formatDate value="${memberVO.registration_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${memberVO.last_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>
							<form action="${pageContext.request.contextPath}/MemberServlet" method="post">
							<input type="hidden" name="member_id" value="${memberVO.member_id}">
							<input type="hidden" name="action" value="delete"> 
							<input type="hidden" name="status" id="st">
								<button class="ban" type="submit" style="border: none; background: none; padding: 0; cursor: pointer;"> 
									<span>
										<i class="fa-solid fa-ban"
											style="color: #ff2600"></i>
									</span>
								</button>
							</form>	
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="worker" class="content">
		<h2>服務人員管理</h2>
		<table id="myTable2" class="display">
			<thead>
				<tr>
					<th>服務人員編號</th>
					<th>服務人員姓名</th>
					<th>性別</th>
					<th>電話</th>
					<th>電子信箱</th>
					<th>車號</th>
					<th>帳號狀態</th>
					<th>帳號建立時間</th>
					<th>最後更新時間</th>
					<th>停權</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="staffVO" items="${staffList}">
					<tr>
						<td>${staffVO.staff_id}</td>
						<td>${staffVO.name}</td>
						<td><c:if test="${staffVO.gender == 1}">
							男
						</c:if> <c:if test="${staffVO.gender == 2}">
							女
						</c:if></td>
						<td>${staffVO.phone}</td>
						<td>${staffVO.email}</td>
						<td>${staffVO.plate_number}</td>
						<td><c:if test="${staffVO.status == 0}">
							已停權
						</c:if> <c:if test="${staffVO.status == 1}">
							啟用中
						</c:if></td>
						<td><fmt:formatDate value="${staffVO.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${staffVO.last_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>
						<form action="${pageContext.request.contextPath}/StaffServlet" method="post">
							<input type="hidden" name="staff_id" value="${staffVO.staff_id}">
							<input type="hidden" name="action" value="delete"> 
							<input type="hidden" name="status" id="st">
								<button class="ban" type="submit" style="border: none; background: none; padding: 0; cursor: pointer;"> 
									<span>
										<i class="fa-solid fa-ban"
											style="color: #ff2600"></i>
									</span>
								</button>
							</form>	
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="${pageContext.request.contextPath}/resource/vendors/jquery/jquery-3.7.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resource/vendors/fontawesome-6.7.2/js/all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resource/vendors/datatables/dataTables.min.js"></script>
	<!-- 	<script src="${pageContext.request.contextPath}/resource/js/homepage.js"></script> -->
	<script>
		//jQuery表格套件
		let orderTable = new DataTable("#myTable");
		let memberTable = new DataTable("#myTable1");
		let employeeTable = new DataTable("#myTable2");
		let resumeTable = new DataTable("#myTable3");

		function showContent(sectionId) {
		  // 先隱藏所有內容
		  const sections = document.querySelectorAll(".content");
		  const homepage_el = document.querySelector("#homepage_img");
		  sections.forEach((section) => section.classList.remove("active"));
		  homepage_el.style.display = "none";

		  // 顯示被點擊的內容
		  document.getElementById(sectionId).classList.add("active");
		}

		$(document).ready(function () {
		  //彈窗
		  let modal = $("#resumeModal");
		  modal.hide(); // 確保一開始是隱藏的

		  // 點擊檢視按鈕時顯示彈窗
		  $(document).on("click", ".view-resume", function (e) {
		    e.stopPropagation(); // 防止事件冒泡影響其他點擊行為
			let modal = $("#resumeModal");
            
            $("#modal-name").text($(this).data("name"));
            $("#modal-gender").text($(this).data("gender") == 1 ? "男" : "女");
            $("#modal-phone").text($(this).data("phone"));
            $("#modal-email").text($(this).data("email"));
            $("#modal-plate").text($(this).data("plate"));
            $("#modal-introduction").text($(this).data("introduction"));
            $("#modal-license").attr("src", $(this).data("license"));
            
		    modal.fadeIn(); // 使用 fadeIn() 平滑顯示
		    $(".selected-row").removeClass("selected-row"); // 移除之前選中的行
		    $(this).closest("tr").addClass("selected-row"); // 標記選中的行
		  });

		  // 點擊 X 或背景關閉彈窗
		  $(document).on("click", ".close, #resumeModal", function (event) {
		    if (
		      $(event.target).is(".close") ||
		      $(event.target).is("#resumeModal")
		    ) {
		      modal.fadeOut(); // 使用 fadeOut() 平滑隱藏
		    }
		  });
		  //聘用婉拒按鈕
		  $(document).on("click", "#approve-btn, #reject-btn", function (event) {
		    let selectedRow = $(".selected-row"); // 取得被選中的履歷行
		    let applyId = selectedRow.find("td:nth-child(1)").text();
		    $("input[name='apply_id']").val(applyId); // 設置 apply_id 隱藏欄位的值
		    let statusCell = selectedRow.find("td:nth-child(6)"); // 取得審核結果欄位
		    
		    if ($(event.target).is("#approve-btn")) {
		      alert("該應徵者已被聘用");
		      $("#rs").attr("value", "1");
		      /* statusCell.text("已通過"); // 更新審核結果 */
		    } else if ($(event.target).is("#reject-btn")) {
		      alert("該應徵者已被婉拒！");
		      $("#rs").attr("value", "0");
		      /* statusCell.text("未通過"); // 更新審核結果 */
		    }
		    modal.fadeOut();
		  });

		  //停權 監聽所有表格內的停權按鈕（使用事件委派）
		  $(document).on("click", ".fa-ban", function () {
		    let row = $(this).closest("tr"); // 取得當前行
		    let statusCell = row.find("td:nth-child(7)"); // 找到帳號狀態的欄位（第7個欄位）
		    let userId = row.find("td:first").text(); // 取得用戶編號

		    if (confirm(`確定要停權用戶嗎？`)) {
// 		      statusCell.text("已停權"); // 更新帳號狀態

		      // 可以在這裡加入 AJAX 來同步更新後端
		      // $.post("/updateStatus", { userId: userId, status: "已停權" });
		    }
		  });
		});
	</script>
</body>
</html>
