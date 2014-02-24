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
       
        <!--script type="text/javascript" src="../table.js"></script>
        <script type="text/javascript" src="../jquery.js"></script-->
        <!--link rel="stylesheet" type="text/css" href="../table.css" media="all"-->
        <script language="javascript">

            function check_login() {
                var user = document.getElementById("userName").value;
                var pwd = document.getElementById("pwd").value;
                var msg1 = "";
                if (user == "" || user.length == 0) {
                    alert(msg1);
                    document.getElementById("userName").focus();
                    return false;
                }

                if (pwd == "" || pwd.length == 0) {
                    var msg2 = "";
                    alert(msg2);
                    document.getElementById("pwd").focus();
                    return false;
                }

                document.form1.action = "/C1/ws/sellside/savetimeperiod";
                document.form1.submit();
                return true;
            }

            $(function() {
                $('tr.parent')
                        .css("cursor", "pointer")
                        .attr("title", "Click to expand/collapse")
                        .click(function() {
                    $(this).siblings('.child-' + this.id).toggle();
                });
                $('tr[@class^=child-]').hide().children('td');
            });
            checked = false;
            function checkedAll() {

                if (checked == false) {
                    checked = true;
                } else {
                    checked = false;
                }

                for (var i = 0; i < document.getElementById('myform').elements.length; i++) {

                    document.getElementById('myform').elements[i].checked = checked;
                }
                return true;
            }

        </script>   
      
      
    </head>
    <body>
        
                
        <form  name="form3"  action="/C1/ws/test/upload/" method="POST" accept="" enctype="multipart/form-data">
 
    <p>
 
        Select a mpid : <input type="text" name="id" size="50" />
 
       </p>
       
       
       
        <p>
 
        Select a file : <input type="file" name="file" size="50" />
 
       </p>
 
      
       
 
 
       <input type="submit" value="Upload test" />
 
    </form>
        
               
        <form  name="form2"  action="/C1/ws/sellside/uploadmediaplancreative" method="POST" accept="" enctype="multipart/form-data">
 
    <p>
 
        Select a mpid : <input type="text" name="mediaplanid" size="50" value="111" />
 
       </p>
       
        <p>
 
            Select a mplid : <input type="text" name="mediaplanlineid" size="50" value="112" />
 
       </p>
       
       <p>
 
           Select a size : <input type="text" name="size" size="50" value="23x23" />
 
       </p>
       
        
 
       <p>
 
        Select a file : <input type="file" name="file" size="50" />
 
       </p>
       
       
 
 
       <input type="submit" value="Upload It" />
 
    </form>

 
       
       <form:form id="form3" name="form3"   action="/C1/ws/sellside/savetimeperiod" method="POST" enctype="" >
 <img src="https://s3-us-west-2.amazonaws.com/c1x/banners/creatives5.jpg" />
   
 
       <p>
  Id : <input  type="text" name="timeperiodid" value="0"      />
           Name : <input  type="text" name="name" value="name"      />
 
       </p>Publisher Id
       <input type="text" name="publisherid" size="50" value="345" />
       
       <p>
   
           S Date  : <input type="text" name="startDate" size="50" value="2010-10-10" />
 
       </p>
       
       <p>
  
           E Date : <input type="text" name="endDate" size="50" value="2011-10-11" /> 
 
       </p>
       
       <p>
       
           Status : <input type="text" name="status" size="50" value="Active" /> 
 
       </p>
 
 
       <input type="submit" value="Upload It" />
 
    </form:form>
       
       
       
       

    </body>
</html>
