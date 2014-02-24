<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <title>C1</title> 
        <script type="text/javascript" src="../table.js"></script>
        <script type="text/javascript" src="../jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../table.css" media="all">
    
    </head>
    <body>

        <div id="content">

            <div class="paddingwrap"> 
                <div class="data">


                    <form:form id="form1" name="form1" method="POST" action="">
                        <table width="80%" align="center" rules="none" cellpadding="30" cellspacing="30"> 
                            <tr > 
                                <th colspan='3' align="center" width="100%" ><spring:message code="label.loginform"/></th>
                            </tr><tr>
                                <th align="center" nowrap="nowrap"><spring:message code="label.username"/></th>
                                <th align="center"  ><input type="text" name="userName" id="userName" value="" /></th>

                            </tr>
                            <tr> 
                                <th align="center" nowrap="nowrap"><spring:message code="label.pwd"/></th>
                                <th align="center"  ><input type="password" name="pwd" id="pwd" value="" /></th>

                            </tr> <tr> 
                                <th align="center" nowrap="nowrap"  ><input type="button" id="login" name="login" value="<spring:message code="label.button" />" onclick="return check_login();" /></th>
                                <th align="center"  ><input type="button" id="login" name="login" value="<spring:message code="label.clear" />" /></th>

                            </tr>   
                        </table> </form:form></div>
                </div><!-- close div.paddingwrap -->
            </div><!-- close div#content -->
            <div id="sidebar-left">
                <div class="paddingwrap"> 

                </div><!-- close div.paddingwrap -->
            </div><!-- close div#sidebar-left -->

            <div id="header">

                <h1>C1</h1>

                <div class="breadcrumb"><spring:message code="label.loginhere"/>
                <div id="i18N"><span>
                        <a href="?lang=en">en</a> 
                        |        
                        <a href="?lang=fr">fr</a>    
                        |        
                        <a href="?lang=jp">jp</a>
                    </span>    
                </div>   
            </div>
        </div><!-- close div#header -->
        <div id="footer"> 
        </div><!-- close div#footer -->

    </body>
</html>
