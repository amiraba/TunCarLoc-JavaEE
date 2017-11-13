<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" media="all"/>
        <title><spring:message code="index.title" /></title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    </head>

    <body onload="Carousel()" bgcolor="#FFFFFF">

        <!-- Navigation -->
        <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
                <li class="sidebar-brand">
                    <a href="#top"  onclick = $("#menu-close").click(); ><spring:message code="index.liste.title" /></a>
                </li>
                <li>
                    <a href="affichage.htm" onclick = $("#menu-close").click(); ><spring:message code="index.liste.catalog" /></a>
                </li>
                <li>
                    <a href="#about" onclick = $("#menu-close").click(); ><spring:message code="index.liste.about" /></a>
                </li>
                <li>            </li>
                <li>
                    <a href="#Carousel" onclick = $("#menu-close").click(); ><spring:message code="index.liste.gallery" /></a>
                </li>
                <li>
                    <a href="#contact" onclick = $("#menu-close").click(); >Contact</a>
                </li>
            </ul>
        </nav>

        <!-- Header -->
        <header id="top" class="header" >
            <div class="welcoming" style="font-weight: bolder;" >
                <c:if test="${!empty sessionScope.login}">
                    <span class="welcomeText">    
                        <span style="color: #005555;"> </span> <span style="color: #4DA29A;"> <c:out  value="${sessionScope.login}"/> </span>

                    </span> <br/>           
                </c:if>
                    <a href="?lang=en" style="color: #c0a16b">en</a> | <a href="?lang=fr" style="color: #c0a16b">fr</a> <br/>
                <c:if test="${!empty sessionScope.login}">
                    <span class="welcomeText">    
                        <span> <a id="deco" href="/AuthentifTest/logOut.htm" style=" color: #4DA29A; font-size: small; font-weight: bolder;"><spring:message code="testCnx.logOut" /></a> </span>
                </c:if>

            </div><br/><br/>
            <script>
                    
            </script>
            <nav id="sidebar"  >
                <c:if test="${empty sessionScope.login}">     
                    <a  class=" menu ahovered moveable" href="${pageContext.request.contextPath}/inscrip.htm"><spring:message code="affichage.aInscriptionClient" /></a> <br/><br/>
                    <a class="moveable menu ahovered" href="${pageContext.request.contextPath}/authentif.htm"><spring:message code="affichage.aSeConnecter" /></a><br/>
                </c:if>
            </nav>
            
            <div class="text-vertical-center" style="width:1500px;"  >
                <table >
                    <tr>
                        <td>
                            <h1 style="color: #00686b; "><spring:message code="index.subtitle.mot1" /></h1><br>
                        </td>
                        <td rowspan="2">
                            <div style="float: right; width: 15%; height: 14%; vertical-align: top; opacity: 0.8;">
                                <img src="${pageContext.request.contextPath}/images/logo.png" alt="TunCarLoc"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h1 style="color: #c0a16b; "><spring:message code="index.subtitle.mot2" /></h1><br>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <h1 style="color: #00686b; "><spring:message code="index.subtitle.mot3" /></h1>
                        </td>
                    </tr>

                    <br>
                </table>
            </div>
        </header>

        <!-- About -->
        <section id="about" class="about">
            <div class="container">
                <div class="row" >
                    <div class="col-lg-12 text-center " style="color: #c0a16b; font-family: fantasy;">
                        <br/> <br/> <br/>
                        <h2><spring:message code="index.about.paragraph.ph1"/><br/>
                            <spring:message code="index.about.paragraph.ph2"/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                            <spring:message code="index.about.paragraph.ph3"/><BR/>
                            <spring:message code="index.about.paragraph.ph4"/> <br/>
                            <spring:message code="index.about.paragraph.ph5"/><br/>
                            <spring:message code="index.about.paragraph.ph6"/><br/><br/>
                            <br/><br/><br/>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>


        <!-- Portfolio -->

        <div id="Carousel" style="position:relative">
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>



        <!-- Map -->
        <section  class="map">
            <iframe width="100%" height="100%" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>
            <br />
            <small>
                <a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a>
            </small>
            </iframe>
        </section>
        <!-- Footer -->
        <footer>
            <div id="contact" class="container">
                <div >
                    <div class="col-lg-10 col-lg-offset-1 text-center">
                        <h4>
                            <spring:message code="index.contact.type"/><br/>
                            <strong>
                                TCL - TunCarLoc
                            </strong>
                        </h4>
                        <p> <spring:message code="index.contact.address"/><br>
                            <spring:message code="index.contact.city"/><br/>
                            <spring:message code="index.contact.country"/>
                        </p>
                        <ul class="list-unstyled">
                            <li><i class="fa fa-phone fa-fw"></i> +216 71 423 896</li>
                            <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:name@example.com">CarLocation@gmail.com</a>
                            </li>
                        </ul>
                        <br>
                        <ul class="list-inline">
                            <li>
                                <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
                            </li>
                        </ul>
                        <hr class="small">
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script>
                        // Closes the sidebar menu
                        $("#menu-close").click(function (e) {
                            e.preventDefault();
                            $("#sidebar-wrapper").toggleClass("active");
                        });

                        // Opens the sidebar menu
                        $("#menu-toggle").click(function (e) {
                            e.preventDefault();
                            $("#sidebar-wrapper").toggleClass("active");
                        });

                        // Scrolls to the selected menu item on the page
                        $(function () {
                            $('a[href*=#]:not([href=#])').click(function () {
                                if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                                    var target = $(this.hash);
                                    target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                                    if (target.length) {
                                        $('html,body').animate({
                                            scrollTop: target.offset().top
                                        }, 1000);
                                        return false;
                                    }
                                }
                            });
                        });
        </script>
        <script type="text/javascript">
            //http://www.dynamicdrive.com
            //Traduction http://www.outils-web.com

            //Taille des images, elle doivent avoir toutes les mêmes dimensions
            var Car_Image_Width = 700;
            var Car_Image_Height = 550;
            var Car_Border = true;		// true ou false
            var Car_Border_Color = "white";
            var Car_Speed = 1.5;
            var Car_Direction = true;		// true or false
            var Car_NoOfSides = 8;		// nb de faces 4,6,8 ou 12

            /* Liste des images et des liens associés 
             le nb d'images à déclarer doit être la moitié du nombre de faces
             ici 8 faces donc 4 images
             */
            Car_Image_Sources = new Array(
                    "images/familiale.png", "http://www.dynamicdrive.com",
                    "images/sport.png", "http://www.javascriptkit.com",
                    "images/cabriolet.png", "", //exemple sans lien
                    "images/utilitaire.png", "http://www.codingforums.com" //pas de virgule a la derniere
                    );

//ne rien modifier ci-dessous
            CW_I = new Array(Car_NoOfSides / 2 + 1);
            C_ClcW = new Array(Car_NoOfSides / 2);
            C_Coef = new Array(
                    3 * Math.PI / 2, 0, 3 * Math.PI / 2, 11 * Math.PI / 6, Math.PI / 6, 3 * Math.PI / 2, 7 * Math.PI / 4, 0,
                    Math.PI / 4, 3 * Math.PI / 2, 5 * Math.PI / 3, 11 * Math.PI / 6, 0, Math.PI / 6, Math.PI / 3);
            var C_CoefOf = Car_NoOfSides == 4 ? 0 : Car_NoOfSides == 6 ? 2 : Car_NoOfSides == 8 ? 5 : 9;
            C_Pre_Img = new Array(Car_Image_Sources.length);
            var C_Angle = Car_Direction ? Math.PI / (Car_NoOfSides / 2) : 0, C_CrImg = Car_NoOfSides, C_MaxW, C_TotalW,
                    C_Stppd = false, i, C_LeftOffset, C_HalfNo = Car_NoOfSides / 2;

            function Carousel() {
                if (document.getElementById) {
                    for (i = 0; i < Car_Image_Sources.length; i += 2) {
                        C_Pre_Img[i] = new Image();
                        C_Pre_Img[i].src = Car_Image_Sources[i]
                    }
                    C_MaxW = Car_Image_Width / Math.sin(Math.PI / Car_NoOfSides) + C_HalfNo + 1;
                    Car_Div = document.getElementById("Carousel");
                    for (i = 0; i < C_HalfNo; i++) {
                        CW_I[i] = document.createElement("img");
                        Car_Div.appendChild(CW_I[i]);
                        CW_I[i].style.position = "absolute";
                        CW_I[i].style.top = 0 + "px";
                        CW_I[i].style.height = Car_Image_Height + "px";
                        if (Car_Border) {
                            CW_I[i].style.borderStyle = "solid";
                            CW_I[i].style.borderWidth = 1 + "px";
                            CW_I[i].style.borderColor = Car_Border_Color
                        }
                        CW_I[i].src = Car_Image_Sources[2 * i];
                        CW_I[i].lnk = Car_Image_Sources[2 * i + 1];
                        CW_I[i].onclick = C_LdLnk;
                    }
                    CarImages()
                }
            }

            function CarImages() {
                if (!C_Stppd) {
                    C_TotalW = 0;
                    for (i = 0; i < C_HalfNo; i++) {
                        C_ClcW[i] = Math.round(Math.cos(Math.abs(C_Coef[C_CoefOf + i] + C_Angle)) * Car_Image_Width);
                        C_TotalW += C_ClcW[i]
                    }
                    C_LeftOffset = (C_MaxW - C_TotalW) / 2;
                    for (i = 0; i < C_HalfNo; i++) {
                        CW_I[i].style.left = C_LeftOffset + "px";
                        CW_I[i].style.width = C_ClcW[i] + "px";
                        C_LeftOffset += C_ClcW[i]
                    }
                    C_Angle += Car_Speed / 720 * Math.PI * (Car_Direction ? -1 : 1);
                    if ((Car_Direction && C_Angle <= 0) || (!Car_Direction && C_Angle >= Math.PI / C_HalfNo)) {
                        if (C_CrImg == Car_Image_Sources.length)
                            C_CrImg = 0;
                        if (Car_Direction) {
                            CW_I[C_HalfNo] = CW_I[0];
                            for (i = 0; i < C_HalfNo; i++)
                                CW_I[i] = CW_I[i + 1];
                            CW_I[C_HalfNo - 1].src = Car_Image_Sources[C_CrImg];
                            CW_I[C_HalfNo - 1].lnk = Car_Image_Sources[C_CrImg + 1]
                        }
                        else {
                            for (i = C_HalfNo; i > 0; i--)
                                CW_I[i] = CW_I[i - 1];
                            CW_I[0] = CW_I[C_HalfNo];
                            CW_I[0].src = Car_Image_Sources[C_CrImg];
                            CW_I[0].lnk = Car_Image_Sources[C_CrImg + 1]
                        }
                        C_Angle = Car_Direction ? Math.PI / C_HalfNo : 0;
                        C_CrImg += 2
                    }
                }
                setTimeout("CarImages()", 50)
            }

            function C_LdLnk() {
                if (this.lnk)
                    window.location.href = this.lnk
            }
        </script>
    </body>

</html>
