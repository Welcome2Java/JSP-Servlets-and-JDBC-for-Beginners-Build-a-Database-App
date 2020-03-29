<!-- 
	JSP Construct
	
	Deep dive coming up in later sessions
	JSP Expressions  < %= some java expression % > small java expression
	JSP Scriptlet   < % some java code: 1 to many lines % > one can add one to many lines of java code
	JSP Declaration  < %! variable or method declaration % > define variable or method. 

	<br/> is the line that will make the next statement to go to the next line. 

 -->
 
 <!-- 
 	JSP sciplet is a JSP construct that allows you to add in more then one line of Java code. 
 	Syntax is < % //some lines of code %> 
 
 
 
  -->

<html>
	<body>

		Converting a String to upper case: <%= new String("Hello Wolrd").toUpperCase() %>
		<br/>
		25 times by 4 is : <%= 25*4 %>
		<br/>
		Is 75 less then 69? <%= 75 < 69 %>
		<br/>
		Trying out JSP Scriptlet construct
		<br/>
		<%for(int i=0; i<10; i++){
			out.println("<br/>12345");
		}%>
	</body>

</html>