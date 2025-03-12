$("form#loginForm").on("submit", function (event) {
  const username = $("input#username").val();
  const password = $("input#password").val();
  if (username === "admin" && password === "admin") {
    alert("登入成功");
  }else {
	alert("登入失敗")
  }
});
