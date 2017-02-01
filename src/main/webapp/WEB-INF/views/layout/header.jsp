 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!-- Navigation -->
 <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
     <div class="container">
         <!-- Brand and toggle get grouped for better mobile display -->
         <div class="navbar-header page-scroll">
             <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                 <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
             </button>
             <a class="navbar-brand" href="#page-top">Start Bootstrap</a>
         </div>
		
		<!-- Auth instance -->
		  <sec:authorize access="isAuthenticated()">
              <c:set var="authenticated" value="${true}"/>   						
		  </sec:authorize>
         <!-- Collect the nav links, forms, and other content for toggling -->
         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
             <ul class="nav navbar-nav navbar-right">
                 <li class="hidden">
                     <a href="#page-top"></a>
                 </li>
                 <li class="page-scroll">
                 	<c:if test="${authenticated}">
                     	<a href="/app/admin/panel">ADMINISTRADOR</a>
                     </c:if>
                 	<c:if test="${!authenticated}">
                     	<a href="#portfolio">Portfolio</a>
                     </c:if>
                 </li>
                 <li class="page-scroll">
                 	<c:if test="${!authenticated}">
                     	<a href="#about">About</a>
                    </c:if> 
                 </li>
                 <li class="page-scroll">
                     <c:if test="${!authenticated}">
                     	<a href="#contact">Contact</a>
                     </c:if>	
                 </li>
                 <li class="page-scroll">                   
					 <c:if test="${authenticated}">
						<a href="<c:url value="/logout"/>">Logout</a>
					</c:if>
					
					<c:if test="${!authenticated}">
						<a href="/app/login">Login</a>
					</c:if>
                 </li>
             </ul>
         </div>
         <!-- /.navbar-collapse -->
     </div>
     <!-- /.container-fluid -->
 </nav>

 <!-- Header -->
 <header>
     <div class="container">
         <div class="row">
             <div class="col-lg-12">
                 <img class="img-responsive" src="<c:url value="/resources/theme1/images/profile.png" />" alt="">
                 <div class="intro-text">
                     <span class="name">Start Bootstrap</span>
                     <hr class="star-light">
                     <span class="skills">Web Developer - Graphic Artist - User Experience Designer</span>
                 </div>
             </div>
         </div>
     </div>
 </header>