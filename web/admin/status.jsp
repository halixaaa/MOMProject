<%-- 
    Document   : status
    Created on : Aug 1, 2019, 4:37:05 PM
    Author     : HARRY-PC
--%>

<%@page import="models.Status"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-4 text-gray-800">Status Page</h1>
    <a class="btn btn-primary btn-icon-split" data-toggle="modal" data-target="#modalInsert"><span class="icon text-white-50">
            <i class="fas fa-plus"></i>
        </span>
        <span class="text">Insert Status</span>
    </a>
    <br>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Status Data</h6>
        </div>
        <%
            List<Status> listStatus = (List<Status>) session.getAttribute("listStatus");
            Status status = (Status) session.getAttribute("status");
            if(session.getAttribute("listStatus") == null){
                response.sendRedirect("../StatusServlet");
            }
        %>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>No</th> 
                            <th>Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Action</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            if (session.getAttribute("listStatus") != null) {
                                for (Status stat : listStatus) {
                        %>
                        <tr>
                            <td></td>
                            <td><%=stat.getName()%></td>
                            <td><a class="btn btn-danger"  href="../StatusServlet?action=delete&id=<%=stat.getId()%>">Delete</a>
                                <a class="btn btn-primary" data-toggle="modal" data-target="#modalEdit<%=stat.getId()%>" >Update</a>
                            </td>
                        </tr>
                        <%}
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Modal Insert-->
<div class="modal fade" id="modalInsert" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="../StatusServlet" method="POST">
                    <label><b>Status Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=(status != null) ? status.getName() : ""%>" />
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success" id="insert">
                </form>
            </div>
        </div>
    </div>
</div>
<!--End of Modal Insert-->

<!-- Modal Edit-->
<%if (session.getAttribute("listStatus") != null) {
        for (Status s: listStatus) {%>
<div class="modal fade" id="modalEdit<%=s.getId()%>" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="../StatusServletEdit" method="POST">
                    <label><b>ID</b></label>
                    <input class="form-control" type="text" name="id" value="<%=s.getId()%>" readonly/>
                    <br>
                    <label><b>Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=s.getName()%>" />
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success" id="insert">
                </form>
            </div>
        </div>
    </div>
</div>
<%}
    }
%>
<!--End of Modal Edit-->
<%@include file="../layout/footer.jsp" %>
<%
    session.removeAttribute("listStatus"); 
    session.removeAttribute("status");
%>
</html>