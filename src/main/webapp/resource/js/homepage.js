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
  $(document).on("click", ".fa-eye", function (e) {
    e.stopPropagation(); // 防止事件冒泡影響其他點擊行為
    modal.fadeIn(); // 使用 fadeIn() 平滑顯示
    $(".selected-row").removeClass("selected-row"); // 移除之前選中的行
    $(this).closest("tr").addClass("selected-row"); // 標記選中的行
  });

  // 點擊 X 或背景關閉彈窗
  $(document).on("click", ".close, #resumeModal", function (event) {
    if ($(event.target).is(".close") || $(event.target).is("#resumeModal")) {
      modal.fadeOut(); // 使用 fadeOut() 平滑隱藏
    }
  });
  //聘用婉拒按鈕
  $(document).on("click", "#approve-btn, #reject-btn", function (event) {
    let selectedRow = $(".selected-row"); // 取得被選中的履歷行
    let statusCell = selectedRow.find("td:nth-child(6)"); // 取得審核結果欄位

    if ($(event.target).is("#approve-btn")) {
      alert("該應徵者已被聘用");
      statusCell.text("已通過"); // 更新審核結果
    } else if ($(event.target).is("#reject-btn")) {
      alert("該應徵者已被婉拒！");
      statusCell.text("未通過"); // 更新審核結果
    }
    modal.fadeOut();
  });

  //停權 監聽所有表格內的停權按鈕（使用事件委派）
  $(document).on("click", ".fa-ban", function () {
    let row = $(this).closest("tr"); // 取得當前行
    let statusCell = row.find("td:nth-child(7)"); // 找到帳號狀態的欄位（第7個欄位）
    let userId = row.find("td:first").text(); // 取得用戶編號

    if (confirm(`確定要停權用戶 ${userId} 嗎？`)) {
      statusCell.text("已停權"); // 更新帳號狀態

      // 可以在這裡加入 AJAX 來同步更新後端
      // $.post("/updateStatus", { userId: userId, status: "已停權" });
    }
  });
});
