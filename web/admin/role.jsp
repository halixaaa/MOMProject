<%-- 
    Document   : role
    Created on : Aug 1, 2019, 1:57:22 PM
    Author     : HARRY-PC
--%>

<%@page import="models.Role"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-4 text-gray-800">Role Page</h1>
    <a class="btn btn-primary btn-icon-split" data-toggle="modal" data-target="#modalInsert"><span class="icon text-white-50">
            <i class="fas fa-plus"></i>
        </span>
        <span class="text">Insert Role</span>
    </a>
    <br>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Role Data</h6>
        </div>
        <%
            List<Role> listRole = (List<Role>) session.getAttribute("listRole");
            Role role = (Role) session.getAttribute("role");
            if (session.getAttribute("listRole") == null) {
                response.sendRedirect("../RoleServlet");
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
                            if (session.getAttribute("listRole") != null) {
                                for (Role rol : listRole) {
                        %>
                        <tr>
                            <td></td>
                            <td><%=rol.getName()%></td>
                            <td><a class="btn btn-danger"  href="../RoleServlet?action=delete&id=<%=rol.getId()%>">Delete</a>
                                <a class="btn btn-primary" data-toggle="modal" data-target="#modalEdit<%=rol.getId()%>" >Update</a>
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
                <form action="../RoleServlet" method="POST">
                    <label><b>Role Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=(role != null) ? role.getName() : ""%>" />
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success" id="insert">
                </form>
            </div>
        </div>
    </div>
</div>
<!--End of Modal Insert-->

<!-- Modal Edit-->
<%if (session.getAttribute("listRole") != null) {
        for (Role r : listRole) {%>
<div class="modal fade" id="modalEdit<%= r.getId()%>" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="../RoleServlet" method="POST">
                    <label><b>ID</b></label>
                    <input class="form-control" type="text" name="id" value="<%=r.getId()%>" readonly/>
                    <br>
                    <label><b>Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=r.getName()%>" />
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
    session.removeAttribute("listRole"); 
    session.removeAttribute("role");
%>
</html>