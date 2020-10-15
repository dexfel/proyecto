<%-- 
    Document   : index
    Created on : Oct 9, 2020, 11:38:05 PM
    Author     : Usuario
--%>

<%@page import="java.util.HashMap"%>
<%@page import="gt.edu.umg.desarrollo.proyecto.Model.PuestoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style type="text/css">
			
			* {
				margin:0px;
				padding:0px;
			}
			
			#header {
				margin:auto;
				width:500px;
				font-family:Arial, Helvetica, sans-serif;
			}
			
			ul, ol {
				list-style:none;
			}
			
			.nav > li {
				float:left;
			}
			
			.nav li a {
				background-color:#000;
				color:#fff;
				text-decoration:none;
				padding:10px 12px;
				display:block;
			}
			
			.nav li a:hover {
				background-color:#434343;
			}
			
			.nav li ul {
				display:none;
				position:absolute;
				min-width:140px;
			}
			
			.nav li:hover > ul {
				display:block;
			}
			
			.nav li ul li {
				position:relative;
			}
			
			.nav li ul li ul {
				right:-140px;
				top:0px;
			}
			
		</style>
        
        
        
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <div id="header">
			<nav> <!-- Aqui estamos iniciando la nueva etiqueta nav -->
				<ul class="nav">
                                    
                                    <%
                              PuestoDao puesto =  new PuestoDao();
                              
                              HashMap<String, String> drop = puesto.ReadPuesto();
                              
                              for (String i:drop.keySet()){
                                  out.println("<li> <a href="+drop.get("id")+">" + drop.get(i) + "</a></li>");
                                  
                                  out.println("<h1>" + drop+ drop.get(i) +"</h1>");
                      
                                  
                              }
                     %>
					
					
				</ul>
			</nav><!-- Aqui estamos cerrando la nueva etiqueta nav -->
		</div>
        
        
    </body>
</html>