<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../themes/common/taglibs.jsp"%>

<head>
    <title>Danh sách sản phẩm </title>
    <meta name="menu" content="productMenu"/>
    <script src="<c:url value='../../themes/admin/global_assets/js/plugins/forms/validation/validate.min.js'/>"></script>
    <link href="<c:url value='../../themes/admin/assets/css/custom_style.css'/>" rel="stylesheet" type="text/css">
</head>

<div class="content">

        <div class="card">
            <div class="card-header header-elements-inline">
                <div class="header-elements">
                    <div class="list-icons">
                            <a href="<c:url value='/product/form'/>" class="btn btn-sm btn-primary" title="<fmt:message key="button.add"/>"><i class="icon-plus22"></i><fmt:message key="button.add"/></a>
                    </div>
                </div>
            </div>
            <div class="card-body">Danh sách sản phẩm</div>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr class="table-success">
                        <th>id</th>
                        <th>name</th>
                        <th>price</th>
                        <th>status</th>
                        <th class="text-center" style="width:120px;"><i class="icon-menu-open2"></i></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty products}">
                        <tr><td colspan="3" class="text-center text-none-data"><fmt:message key="not.data"/></td></tr>
                    </c:if>
                    <c:forEach var="e" items="${products}" >
                         <tr>
                            <td>${e.id}</td>
                            <td>${e.name}</td>
                            <td>${e.price}</td>
                             <td>${e.salary}</td>
                             <td class=" text-center">
                                 <div class="list-icons">
                                     <div class="dropdown">
                                         <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7 mr-3 icon-2x"></i></a>
                                         <div class="dropdown-menu dropdown-menu-right">
                                             <a href="/product/form?id=${e.id}" class="dropdown-item"><i class="icon-pencil7" style="color:blue">Chi tiết</i></a>
                                             <a href="/product/delete/${e.id}" class="dropdown-item"><i class="icon-trash" style="color:blue"> Xóa sản phẩm</i></a>
                                         </div>
                                     </div>
                                 </div>
                             </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

