<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.w3c.dom.NodeList" %>
<%! %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

</head>
<body>
 <h3>Successfully fetched the following news from feed.</h3>
 <div align="right" class="ui-widget">
  <label for="tags">Search </label>
  <input id="tags">
</div>
         
         <% 
         NodeList titles=(NodeList)request.getAttribute("TITLES");
         NodeList links=(NodeList)request.getAttribute("LINKS");
		  out.println("Movies page");
         NodeList descriptions=(NodeList)request.getAttribute("DESCRIPTIONS");
         out.println("<input type='hidden' id='length' value='"+titles.getLength()+"'");
           for (int i = 1; i < titles.getLength(); i++) 
           {
           %>
          <br><b>Title:<%=titles.item(i).getTextContent() %></b>
		  <br> Link: <a href="<%= links.item(i).getTextContent()%>" > <%= titles.item(i).getTextContent()%> </a> 
		  <% if (descriptions.item(i) != null){ %>
		        <br/>Description:<%= descriptions.item(i).getTextContent()%> <%} %>   
		        
		        
		  <%
		  
		  out.println("<input type='hidden' id='titles_"+i+"' value='"+titles.item(i).getTextContent()+"'>");
           }%>
		     
		<script>
		$(document).ready(function(){
			var length = $('#length').val();
			 console.log(length);
			 var availableTags=new Array();
			 var i;
			 var tag = new Array();
			  for (i=1;i<length;i++) 
				  {
				//  console.log('#titles_'+i);
				  availableTags[i]=$('#titles_'+i).val();
				tag.push(availableTags[i]);
				
				  }
			 console.log(tag);
			 $( "#tags" ).autocomplete({
					      source: tag
					    });
		});
		</script>
	/*	<script>
	//	  $(function() {
	//		  alert("hello");
			 
		
			 
			/* var availabaleTags=new Array();
			 var length = $('#length').val();
			 console.log(length);
			  for (int i = 1; i < length; i++) 
				  {
				  availableTags[i]=$('#titles_'+i).val();
				  alert(availableTags[[i]);
				  }
				  
			/*    var availableTags = [
			      "ActionScript",
			      "AppleScript",
			      "Asp",
			      "BASIC",
			      "C",
			      "C++",
			      "Clojure",
			      "COBOL",
			      "ColdFusion",
			      "Erlang",
			      "Fortran",
			      "Groovy",
			      "Haskell",
			      "Java",
			      "JavaScript",
			      "Lisp",
			      "Perl",
			      "PHP",
			      "Python",
			      "Ruby",
			      "Scala",
			      "Scheme"
			    ];*/
		//	    $( "#tags" ).autocomplete({
	 //		      source: availableTags
	//		    });
		//	  });
			  </script>      
</body>
</html>