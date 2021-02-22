<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="dao.DaoImp.ProductImp" %>
<%@ page import="Model.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SBahia - Login</title>
</head>
<body>

   <div class="container">
        <div class="row">
            <div class="col-12">

                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="d-flex flex-grow-1">
                        <span class="w-100 d-lg-none d-block"><!-- hidden spacer to center brand on mobile --></span>
                        <a class="navbar-brand d-none d-lg-inline-block" id="logotext" href="#">
                            SBahia
                        </a>
                        <a class="navbar-brand-two mx-auto d-lg-none d-inline-block" href="#">
                            <img src="//placehold.it/40?text=LOGO" alt="logo">
                        </a>
                        <div class="w-100 text-right">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavbar">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                        </div>
                    </div>
                    <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar">
                        <ul class="navbar-nav ml-auto flex-nowrap">
                            <li class="nav-item">
                                <a href="/SBahia/" class="nav-link m-2 menu-item nav-active">Accuiel</a>
                            </li>
                            <li class="nav-item">
                                <a href="/SBahia/produit.jsp" class="nav-link m-2 menu-item">Produits</a>
                            </li>
                                                        <li class="nav-item">
                                <a href="/SBahia/admin.jsp" class="nav-link m-2 menu-item">Admin Panel</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <!--                                    ICI                     -->

                <section class="container-fluid">
                    <section class="row justify-content-center">
                      <section class="col-md-10 col-xl-5 col-lg-6 col-sm-10 mx-auto text-center form">
                        <form class="form-container" action="/SBahia/addproduct" method="post">
                          <div class="form-group">

                            <p>Add Product</p>
                            
                            <input type="text" class="form-control" name="name" placeholder="Name">
                          </div>
                          <div class="form-group">
                            <input type="text" class="form-control" name="description" placeholder="Description">
                          </div>
                      		<div class="form-group">
                            <input type="text" class="form-control" name="quantite" placeholder="Quantité">
                          </div>
                      	<div class="form-group">
                            <input type="text" class="form-control" name="price" placeholder="Price">
                          </div>
                          <div class="form-group">
                            <input type="text" class="form-control" name="image" placeholder="Image">
                          </div>
                          <button type="submit" name="login" class="btn btn-primary btn-block">Add Product</button>
                        </form>
                      </section>
                    </section>
                  </section>

                   <!--                  END            ICI                      -->
            </div>

            
        </div>

    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>