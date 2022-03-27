<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../themes/common/taglibs.jsp"%>

<head>
    <title>Thêm mới  / Chỉnh sửa thông tin sản phẩm </title>
    <!-- Map -->
</head>

<!-- Content area -->
<div class="content">
    <form:form id="productForm" modelAttribute="product" action="/product/save" method="post" role="form">
        <form:hidden path="id"/>
        <!-- Basic layout-->
        <div class="card">
            <div class="card-body">
                <p class="mb-4">
                    Thêm mới / chỉnh sửa thông tin sản phẩm
                </p>
                <fieldset class="mb-3">
                    <legend class="text-uppercase font-size-sm font-weight-bold">
                        <fmt:message key="template.legend" />
                    </legend>
                    <div class="card">
                        <div class="card-body">

                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <div class="form-group">
                                        <label>Tên sản phẩm <span class="help-block"></span></label>
                                        <input type="text" id="nameInput" value="${product.name}" name="name"  class="form-control " required="required" />
                                        <div><span id="msgForName" style="color: red"></span></div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <div class="form-group">
                                        <label>Giá sản phẩm  <span class="help-block"></span></label>
                                        <input type="number" id="salaryInput" value="${product.price}" name="price"   class="form-control " required="required"	maxlength="1000000000000000" />
                                        <div><span id="msgForProduct" style="color: red"></span>	</div>
                                    </div>
                                </div>
                            </div>
                            <br />
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <a href="<c:url value="/products"/>" id="back" class="btn btn-light"> <i class="icon-point-left mr-2"> </i> <fmt:message key="button.back" /></a>
                        <button type="button" id="submitButton" class="btn btn-primary ml-3">Lưu<i class="icon-pencil5 ml-2"></i></button>
                    </div>
                </fieldset>
            </div>
        </div>
        <!-- /basic layout -->
    </form:form>
</div>
<!-- /content area -->