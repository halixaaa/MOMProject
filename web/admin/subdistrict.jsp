<%-- 
    Document   : subdistrict
    Created on : Aug 2, 2019, 4:03:34 PM
    Author     : HARRY-PC
--%>

<%@page import="models.District"%>
<%@page import="models.Subdistrict"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container-fluid">
    <h1 class="h3 mb-4 text-gray-800">Sub-District Page</h1>
    <a class="btn btn-primary btn-icon-split" data-toggle="modal" data-target="#modalInsert"><span class="icon text-white-50">
            <i class="fas fa-plus"></i>
        </span>
        <span class="text">Insert Sub-District</span>
    </a>
    <br>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Sub-District Data</h6>
        </div>
        <%
            List<Subdistrict> listSubdistrict = (List<Subdistrict>) session.getAttribute("listSubdistrict");
            List<District> listDistrict = (List<District>) session.getAttribute("listDistrict");
            Subdistrict subdistrict = (Subdistrict) session.getAttribute("subdistrict");
            if (session.getAttribute("listSubdistrict") == null) {
                response.sendRedirect("../SubdistrictServlet");
            }
        %>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>No</th> 
                            <th>Subdistrict</th>
                            <th>District</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>No</th>
                            <th>Subdistrict</th>
                            <th>District</th>
                            <th>Action</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            if (session.getAttribute("listSubdistrict") != null) {
                                for (Subdistrict subdist : listSubdistrict) {
                        %>
                        <tr>
                            <td></td>
                            <td><%=subdist.getName()%></td>
                            <td><%=subdist.getDistrict().getName()%></td>
                            <td><a class="btn btn-danger"  href="../SubdistrictServlet?action=delete&id=<%=subdist.getId()%>">Delete</a>
                                <a class="btn btn-primary" data-toggle="modal" data-target="#modalEdit<%=subdist.getId()%>" >Update</a>
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
                <form action="../SubdistrictServlet" method="POST">
                    <label><b>Sub-District</b></label>
                    <input class="form-control" type="text" name="name" value="<%=(subdistrict != null) ? subdistrict.getName() : ""%>" />
                    <br>
                    <label><b>District</b></label>
                    <div>
                        <select class="form-control" id="district" name="district">
                            <option value="">None</option>
                            <%
//                                if (session.getAttribute("listSubdistrict") != null) {
//                                    for (District d : listDistrict) {%>
                                    <option value="<%//=d.getId()%>"<%//=(subdistrict!=null)?(Integer.parseInt(d.getId().toString())
                                            //==Integer.parseInt(subdistrict.getDistrict().getId().toString()))?"selected":"":""%>><%//=d.getName()%></option>
                                    <%//}
                                //}
                            %>
                        </select>
                    </div>
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success" id="insert">
                </form>
            </div>
        </div>
    </div>
</div>
<!--End of Modal Insert-->

<!-- Modal Edit-->
<%//if (session.getAttribute("listDistrict") != null) {
    //for (District d : listDistrict) {%>
<div class="modal fade" id="modalEdit<%//= d.getId()%>" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="../DistrictServlet" method="POST">
                    <label><b>ID</b></label>
                    <input class="form-control" type="text" name="id" value="<%//=d.getId()%>" readonly/>
                    <br>
                    <label><b>Sub-District</b></label>
                    <input class="form-control" type="text" name="name" value="<%//=d.getName()%>" />
                    <br>
                    <label><b>District</b></label>
                    <div>
                        <select class="form-control" id="province" name="province">
                            <option value="">None</option>
                            <%//if(session.getAttribute("listDistrict") != null){
                                //for (Province p : listProvince) {%>
                                <option value="<%//=p.getId()%>"<%//=(d!=null)?(Integer.parseInt(p.getId().toString())
                                        //==Integer.parseInt(d.getProvince().getId().toString()))?"selected":"":""%>><%//=p.getName()%>
                                </option>                
                                <%//}
                            //}%>
                        </select>
                    </div>
                    <br>
                    <input  type="submit" value="Save" class="btn btn-success">
                </form>
            </div>
        </div>
    </div>
</div>
<%//}
    //}
%>
<!--End of Modal Edit-->
<%@include file="../layout/footer.jsp"%>
<%
    session.removeAttribute("listSubdistrict"); 
    session.removeAttribute("subdistrict");
%>
</html>
