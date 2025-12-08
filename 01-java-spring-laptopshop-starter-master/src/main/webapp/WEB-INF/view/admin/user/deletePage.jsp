
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
                        <li class="breadcrumb-item active">User</li>
                    </ol>
                    <div class="row">
                      <div class="col-md-6 col-12 mx-auto">
                        <h2>Update User</h2>
                        <div class="alert alert-danger" role="alert">
                          Do you want delete user has id = ${id} ?
                        </div>
                        <form:form method="POST" action="/admin/user/delete/" modelAttribute="currentUser">
                          <div class="mb-3" style="display: none;">
                              <label class="form-label">Id: </label>
                              <form:input type="text" class="form-control"
                              path="id"
                              />
                            </div>
                        <button type="submit" class="btn btn-warning">Submit</button>
                        <a href="/admin/user" class="btn btn-success">
                                Back
                        </a>
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
