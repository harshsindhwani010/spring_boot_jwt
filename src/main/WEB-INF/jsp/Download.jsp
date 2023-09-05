<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Download File</title>
</head>
<body>
      <div class="container">

        <h1 class="p-3">Download File</h1>

        <form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>File Name</th>
            		 <th>Download File</th>
            		
            	</tr>

            	<c:forEach var="fileList" items="${fileLists}">
                    <tr>
                		<td>${fileList.id}</td>
                		<td>${fileList.fileName}</td>
                		<td><a href="/download/${fileList.id}">Download File</a></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

     <!--   <button type="button" class="btn btn-primary btn-block">
        	
        	<p><a href="/viewUserLoginList">Back to User List</a></p>
        </button>-->

    </div>

      <!--  <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Save Success") {
        				Command: toastr["success"]("User Login added successfully!!")
        			} else if (msg == "Delete Success") {
        				Command: toastr["success"]("User Login deleted successfully!!")
        			} else if (msg == "Delete Failure") {
        			    Command: toastr["error"]("Some error occurred, couldn't delete user Login")
        			} else if (msg == "Edit Success") {
        				Command: toastr["success"]("User Login updated successfully!!")
        			}

        			toastr.options = {
                          "closeButton": true,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": true,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "showDuration": "300",
                          "hideDuration": "1000",
                          "timeOut": "5000",
                          "extendedTimeOut": "1000",
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }
        	    }
            </script>-->
    
    
    
    
    
    
</body>
</html>
