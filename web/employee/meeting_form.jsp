<%-- 
    Document   : district
    Created on : Aug 2, 2019, 11:12:21 AM
    Author     : HARRY-PC
--%>

<%@page import="models.Meeting"%>
<%@page import="models.Employee"%>
<%@page import="models.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/headerE.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-4 text-gray-800">Meeting Form</h1>
<!--    <a class="btn btn-primary btn-icon-split" data-toggle="modal" data-target="#modalInsert"><span class="icon text-white-50">
            <i class="fas fa-plus"></i>
        </span>
        <span class="text">Insert District</span>
    </a>-->
    <br>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">District Data</h6>
        </div>
        <%
            List<Meeting> listMeeting = (List<Meeting>) session.getAttribute("listMeeting");        
        List<Customer> listCustomer = (List<Customer>) session.getAttribute("listCustomer");
        List<Employee> listEmployee = (List<Employee>) session.getAttribute("listEmployee");
        Meeting meeting = (Meeting) session.getAttribute("meeting");
        
        if(session.getAttribute("listMeeting") == null || session.getAttribute("listCustomer") == null || session.getAttribute("listEmployee") == null){
            response.sendRedirect("../MeetingFormServlet");
        }
        %>
        <div class="card-body">
               <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <br>
                       <h1>Meeting Form</h1>
                       <br>
                       <form action="../MeetingFormServlet" method="POST">
                        <label><b>Meeting</b></label>
                        <input class="form-control" type="text" name="meeting" style="width: 600px"/>
                        <br>
                        <label><b>Project</b></label>
                        <input class="form-control" type="text" name="project" style="width: 600px"/>
                        <br>
                        <label><b>Date</b></label>
                        <input class="form-control" type="date" name="date" id="date" style="width: 250px"/>
                        <br>
                        <label><b>Time</b></label>
                        <input class="form-control" type="time" name="time" style="width: 150px"/>
                        <br>
                                               
                        <label><b>Type</b></label><br>
                        <input type="radio" name="type" value="Internal" onclick="toggleTextbox('Internal')" checked> Internal &nbsp &nbsp
                        <input type="radio" name="type"  value="External" onclick="toggleTextbox('External')"> External <br>
                        <br>
                        <label><b>Customer</b></label>
                        <div>
                        <select class="form-control" id="cbCus" name="customer" disabled="disabled" required>
                            <option value="" selected>None</option> 
                         <% if(session.getAttribute("listCustomer") != null){
                            for (Customer cus : listCustomer ) {%>
                            <option value="<%=cus.getId()%>"><%=cus.getName()%></option><%}}%>
                        </select>
   
                        </select> 
                        </div>         
                        
                        <br>
                        <label><b>Manager</b></label>
                        <div>
                        <select class="form-control" id="sel1" name="manager" required>
                            <option value="">None</option> 
                         <% if(session.getAttribute("listEmployee") != null){
                            for (Employee emp : listEmployee ) {%>
                            <option value="<%=emp.getId()%>"><%=emp.getName()%></option><%}}%>
                        </select>
                        </div> 
                        
                        <br>
                        <label><b>PIC</b></label>
                        <div>
                        <select class="form-control" id="sel1" name="pic" required>
                            <option value="">None</option> 
                         <% if(session.getAttribute("listEmployee") != null){
                            for (Employee emp1 : listEmployee ) {%>
                            <option value="<%=emp1.getId()%>"><%=emp1.getName()%></option><%}}%>
                        </select>
                        </div> 
                        
                        <br>
                        <input  type="submit" value="Save" class="btn btn-success" id="insert">
                        <br>
                        <br>
                        <br>
                       </form>
  
                        
                        
                    </div>
                </div>
            </div>
        </div>
</div>

<script type="text/javascript">
function toggleTextbox(opt)
{
    if (opt == 'Internal')
        document.getElementById('cbCus').disabled = true;
    else
        document.getElementById('cbCus').disabled = false;
}
    </script>
<!--End of Modal Edit-->
<%@include file="../layout/footerE.jsp" %>
<%
    session.removeAttribute("listMeeting"); 
    session.removeAttribute("listCustomer"); 
    session.removeAttribute("listEmployee");
    session.removeAttribute("meeting");
%>
</html>
