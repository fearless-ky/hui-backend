<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="/wabao/js/jquery-3.4.1.js"></script>
    <script>
      
           $(document).ready(function(){
        	   $("#iii").click(function(){
        		  
        		   var aaa = {"username":"wyj"};
        		   $.ajax({
                       url:"${pageContext.request.contextPath}/test1",
                       type:"post",
                       contentType:"application/json;charset=utf-8",//指定为json类型
					   data:JSON.stringify(aaa),
                       success:function (msg) {
                          console.log(msg.code);
                          console.log(msg.message);
                       }
                   });
        	   });
        	   
           });
        
    </script>


</head>	
<body>

<%-- <a href="${pageContext.request.contextPath}/test1" target="_blank">前往test1.jsp</a> --%>

 <input type="button" value="我是你爸爸！！"id = "iii">
 
</body>
</html>