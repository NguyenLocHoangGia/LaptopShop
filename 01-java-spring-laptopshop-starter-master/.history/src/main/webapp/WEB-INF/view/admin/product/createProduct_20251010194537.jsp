
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Royal - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Order - Hỏi Dân IT</title>

    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />

    <!-- Đường dẫn tuyệt đối để không bị lệch -->
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />

    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const imgProduct = $("#imgProduct");
                        imgProduct.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#productPreview").attr("src", imgURL);
                            $("#productPreview").css({ "display": "block" });
                        });
                    });
                </script>

</head>

<body class="sb-nav-fixed">
    <!-- Header -->
    <jsp:include page="/WEB-INF/view/layout/header.jsp" />

    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <!-- Sidebar -->
                <jsp:include page="/WEB-INF/view/layout/sidebar.jsp" />
                
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    Hỏi Dân IT
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">
                        Manager Product
                    </h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item active">Product</li>
                    </ol>
                    <div class="row">
                      <div class="col-md-6 col-12 mx-auto">
                        <h2>Create Product</h2>
                        <form:form method="POST"
                        enctype="multipart/form-data"
                        action="/admin/product/create" modelAttribute="newProduct">
                          <div class="row">
                            <div class="mb-3 col-12 col-md-6">
                              <label class="form-label">Product name: </label>
                              <form:input type="text" class="form-control"
                              path="name"
                              />
                            </div>
                                <div class="mb-3 col-12 col-md-6">
                                <label class="form-label">Price: </label>
                                <form:input type="number" class="form-control"
                                path="price"
                                />
                              </div>
                          </div>  
                          <div class="mb-3">
                            <label class="form-label">Description details:: </label>
                            <form:textarea type="text" class="form-control"
                            path="detailDesc"/>
                          </div>
                          <div class="row">
                            <div class="mb-3 col-12 col-md-6">
                              <label class="form-label">Description short: </label>
                              <form:input type="text" class="form-control"
                              path="shortDesc"
                              />
                            </div>
                              <div class="mb-3 col-12 col-md-6">
                                <label class="form-label">Quantity: </label>
                                <form:input type="number" class="form-control"
                                path="quantity"
                                />
                              </div>
                          </div>
                          <div class="row">
                              <div class="mb-3 col-12 col-md-6">
                              <label class="form-label">Factory: </label>
                              <form:select class="form-select" path="factory">
                                <form:option value="Apple">Apple</form:option>
                                <form:option value="Acer">Acer</form:option>
                                <form:option value="HP">HP</form:option>
                                <form:option value="Lenovo">Lenovo</form:option>
                              </form:select>
                            </div>
                            <div class="mb-3 col-12 col-md-6">
                                <label class="form-label">Target: </label>
                              <form:select class="form-select" path="target">
                                <form:option value="Light">Mỏng-Nhẹ</form:option>
                                <form:option value="Gaming">Gaming</form:option>
                                <form:option value="Office">Văn Phòng</form:option>
                                <form:option value="Student">Sinh Viên</form:option>
                              </form:select>
                            </div>
                          </div>    
                          <div class="row">
                            <div class="mb-3">
                                <label for="imgProduct" class="form-label">Chọn ảnh sản phẩm</label>
                                <input class="form-control" type="file" id="imgProduct" accept=".png, .jpg, .jpeg" name="imgProduct"/>
                              </div>
                          </div>
                          
                          <div class="col-12 mb-3">
                              <img style="max-height: 250px; display: none;" alt="product preview" id="productPreview">
                          </div>

                          <div class="col-12 mb-5">
                            <button type="submit" class="btn btn-primary">Submit</button>
                          </div>        
                      </form:form>
                      </div>
                    </div>
                </div>
            </main>
            <jsp:include page="/WEB-INF/view/layout/footer.jsp" />
        </div>
  
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/chart-area-demo.js"></script>
    <script src="${pageContext.request.contextPath}/js/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
</body>

</html>
