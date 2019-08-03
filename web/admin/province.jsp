<%-- 
    Document   : province
    Created on : Aug 2, 2019, 8:56:31 AM
    Author     : HARRY-PC
--%>

<%@page import="models.Province"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-4 text-gray-800">Province Page</h1>
    <a class="btn btn-primary btn-icon-split" data-toggle="modal" data-target="#modalInsert"><span class="icon text-white-50">
            <i class="fas fa-plus"></i>
        </span>
        <span class="text">Insert Province</span>
    </a>
    <br>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Province Data</h6>
        </div>
        <%
            List<Province> listProvince = (List<Province>) session.getAttribute("listProvince");
            Province province = (Province) session.getAttribute("province");
            if (session.getAttribute("listProvince") == null) {
                response.sendRedirect("../ProvinceServlet");
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
                            if (session.getAttribute("listProvince") != null) {
                                for (Province prov : listProvince) {
                        %>
                        <tr>
                            <td></td>
                            <td><%=prov.getName()%></td>
                            <td><a class="btn btn-danger"  href="../ProvinceServlet?action=delete&id=<%=prov.getId()%>">Delete</a>
                                <a class="btn btn-primary" data-toggle="modal" data-target="#modalEdit<%=prov.getId()%>" >Update</a>
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
                <form action="../ProvinceServlet" method="POST">
                    <label><b>Province Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=(province != null) ? province.getName() : ""%>" />
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success" id="insert">
                </form>
            </div>
        </div>
    </div>
</div>
<!--End of Modal Insert-->

<!-- Modal Edit-->
<%if (session.getAttribute("listProvince") != null) {
        for (Province p : listProvince) {%>
<div class="modal fade" id="modalEdit<%= p.getId()%>" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="../ProvinceServlet" method="POST">
                    <label><b>ID</b></label>
                    <input class="form-control" type="text" name="id" value="<%=p.getId()%>" readonly/>
                    <br>
                    <label><b>Province Name</b></label>
                    <input class="form-control" type="text" name="name" value="<%=p.getName()%>" />
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success">
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
    session.removeAttribute("llistProvince"); 
    session.removeAttribute("province");
%>
</html>