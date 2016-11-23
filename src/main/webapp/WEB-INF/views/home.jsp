<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/tHeader.jsp"%>

<h2>${result}</h2>
<%@include file="include/tFooter.jsp"%> --%>



        <table border='3'> 

            <tr>
                <th> 수 </th>
                <th> 약수 </th>
                <th> 갯수 </th>
            </tr>
                
            <script type="text/javascript">
                
                   var i, j, count;
                   var size = 100;
                   for(i=1; i<=size; i++){
                       count = 0;
                       document.write("<tr><td>" + i + "</td><td>");
                       for(j=1; j<i; j++){
                            if(i%j == 0){
                                count++:
                                document.write(j + " ");
                            }
                        }
                        document.write("</td><td>" + count + "</td></tr>");
                    }

                </script>


        </table>
