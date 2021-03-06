<%-- 
    Document   : proposals
    Created on : Oct 23, 2013, 5:57:07 PM
    Author     : logic
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 


<!DOCTYPE html>
<html>
    <title>C1X- Medal Plans</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/table.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/table.css" media="all">

<script language='JavaScript'>
 
$(function() {
	$('tr.parent')
		.css("cursor","pointer")
		.attr("title","Click to expand/collapse")
		.click(function(){
			$(this).siblings('.child-'+this.id).toggle();
		});
	$('tr[@class^=child-]').hide().children('td');
});
 
 
 
 
checked = false;
 
function checkedAll () {
 
if (checked == false){checked = true}else{checked = false}
 
for (var i = 0; i < document.getElementById('myform').elements.length; i++) {
 
document.getElementById('myform').elements[i].checked = checked;
 
}
 return true;
}
 
</script>
<style type="text/css">
body
	{
	margin: 0; /* margin and padding only necessary to cater for Mac IE5 */
	padding: 0;
	/*\*/	overflow: hidden; /* because Mac IE5 don't understand */
	}
div
	{
	margin: 0;
	padding: 0;
	}
#content
	{
	
	 
	position: absolute;
	top: 11%;
	/*\*//*right: 31%;*/
	left: 21%;   /* Exclude right and left props for Mac IE5 */
	/*margin: 0 31% 0 21%;*/
	width:79%;
	/*\*/ margin: 0; /* */
	/*height: 59%;*/
	bottom: 5%;
	overflow:auto; 
	
	}
#sidebar-left
	{
	position: absolute;
	top: 10%;
	bottom: 0;
	left: 0;
	width: 20%;
	/*overflow: auto;*/
	}
#sidebar-right
	{
	position: absolute;
	top:  0;
	right: 0;
	bottom: 0;
	overflow: auto;
	width: 30%;
	}
#header
	{
	position: absolute;
	top: 0;
	/*\*//*right: 31%;*/
	left: 0%;   /* Exclude right and left props for Mac IE5 */
	/*margin: 0 31% 0 21%;*/
	width:100%;
	/*\*/ margin: 0; /* */
	height: 10%;
	}
#footer
	{
	/*\*/ position: absolute;  /* Exclude for Mac IE5 */
	/*right: 31%;*/
	bottom: 0;
	left: 0;
	height: 5%;
	width:100%;
	margin: 0 31% 0 21%; /* Cater for Mac IE5 */
	/*\*/ margin: 0; /* Put back for all the rest */
	}
#footer h4
	{
	position: absolute;
	bottom: 0;
	width: 100%;
	margin: 0;
	padding: 0;
	}

</style>
<!--[if lt IE 7]>
<style type="text/css" media="screen">
/* let the IE expressions commence */
#sidebar-left
	{
	height: expression(document.body.clientHeight + "px");
	}
#sidebar-right
	{
	height: expression(document.body.clientHeight + "px");
	}
#content
	{
	height: expression(document.body.clientHeight - ( (document.body.clientHeight * 15 / 100) + (document.body.clientHeight * 25 / 100) + (document.body.clientHeight * 1 / 100 * 2) ) + "px");
	width: expression(document.body.clientWidth - ( (document.body.clientWidth * 20 / 100) + (document.body.clientWidth * 30 / 100) + (document.body.clientWidth * 1 / 100 * 2) ) + "px");
	}
#header
	{
	width: expression(document.body.clientWidth - ( (document.body.clientWidth * 20 / 100) + (document.body.clientWidth * 30 / 100) + (document.body.clientWidth * 1 / 100 * 2) ) + "px");
	}
#footer
	{
	width: expression(document.body.clientWidth - ( (document.body.clientWidth * 20 / 100) + (document.body.clientWidth * 30 / 100) + (document.body.clientWidth * 1 / 100 * 2) ) + "px");
	}
</style>
<![endif]-->
<style type="text/css">
/* settings for appearance alone */
body { background: #e6e7e9; font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", "DejaVu Sans", Verdana, sans-serif; }
#content { /*background: #cccccc;*/ }
#sidebar-left { background: #5a6775;border-top:#e6e7e9 solid 1px; }
#sidebar-right { background: #ffcc99; }
#header { background: #3c4c5f; }
#footer { background: #3c4c5f; }
#footer h4 { background: #ccffcc; }
/* convenience div for padding inside positioned divs */
div.paddingwrap
	{
	margin: 0;
	/*padding: 1em;*/
	}
p, h1, h2, h4, li
	{
	margin: 0;
	padding: 0;
	}
h3
	{
	margin: 1em 0 0 0;
	}
ul
	{
	margin: 0 0 0em 0em;
	padding: 0;
	}
code
	{
	display: block;
	background-color: #dddddd;
	}
 #header h1{
  margin:1% 0 0 5%;
  color:#FFF;
 }
li{
	padding:10px 0px 10px 10px;		
	margin-left:0px;
	list-style:none;
	color:#e6e7e9;
	font-size:12px;
 }
 li a{
	color:#e6e7e9;
	text-decoration:none; 
	 }
	 li input{
	width:80%;	 
	color:#3c4c5f;	 
	border-radius:3px;
	border:none;
	height:20px;
	background-color:#d1d2d4;
		 }
.paddingwrap .search,.newmedia,.delete{
	float:left;
	padding:20px;
	}
	
	.search input{
		width:250px;
		color:#3c4c5f;	 
	border-radius:3px;
	border:none;
	height:20px;
	 
		}
	.newmedia button{
		 
		color:#ffffff;	 
	border-radius:3px;
	border:none;
	height:20px;
	 background-color:#2cbdbc;
		}	
		.delete button,.export button{
		 
		color:#ffffff;	 
	border-radius:3px;
	border:none;
	height:20px;
	background-color:#d1d2d4;
		}	
		div .export{
	 
	 float:right;padding:20px;
			}
			div .data,table{
	width:99%	;
	float:left;
				}
table th {
    background-color:#333333;
	color:#CCC;
	font-size:10px; 
	font-weight:100;
}
table tr td table th {
    background-color:#ccc;
	color:#333;
	font-weight:bold;
	}
table tr  { 
	
	font-size:10px; 
	height:25px;
}
 	table tr td:first-child { color:#126BAF;font-weight:bold;}
	.current{
	background-color:#3c4c5f; 
	/* background-image:url("sortable.gif");
	background-position:center right;background-repeat:no-repeat;*/
		}
.arrow-left {
	width: 0; 
	height: 0; 
	border-top: 10px solid transparent;
	border-bottom: 10px solid transparent; 
	float:right;
	margin-right:0px;
	border-right:10px solid white; 
}
.arrow-down {
	width: 0; 
	height: 0; 
	border-left: 5px solid transparent;
	border-right: 5px solid transparent; 
	float:right;
	margin-left:5px;
	margin-top:3px;
	border-top:5px solid white; 
}

.breadcrumb{
	position:absolute;
background-color:#CCC;
color:#18325D;
width:80%;
left:20%;
/*float:right;*/
height:30px;	
bottom:0px;
padding:5px 10px 0px 20px;
	}
.chkbox{
 background-color:#333333;padding: 0px 0px 0px 0px;	
	}
	
	
	
/*table.detail, table.detail td, table.detail th {
	border-collapse:collapse;
	border:1px solid black;
}*/
 tr.parenttr {
	 background-color:#999;
	font-weight:bold;
}

</style>
</head>
<body>
<div id="content">
<div class="paddingwrap">
 
 <div class="search"> <input type="text" name="" id="" value="Type to search for Media Plans or RFP"  /></div>
<!-- <div  class="newmedia"> <button type="button" name="" id="" > + New media Plan</button> </div>
<div  class="delete"> <button type="button" name="" id="" > Delete</button> </div>-->
<div  class="export"> <button type="button" name="" id="" > Export CSV</button> </div>
<div class="data">
 <form id="myform">
     
     
     
     
<table align="center"  rules="rows"><thead>
<tr><th   nowrap="nowrap" align="left" class="table-sortable:default table-sortable">Media Plan</th>
<th align="left"  class="table-sortable:date table-sortable">Start Date </th>
<th align="left" class="table-sortable:date table-sortable">End Date</th>
<th align="left" class="table-sortable:numeric table-sortable">Placements Selected</th>
<th align="left" class="table-sortable:numeric table-sortable">Impressions Proposed</th> 
<th align="left" class="table-sortable:default table-sortable">Impressions Approved</th>
<th align="left" class="table-sortable:default table-sortable table-sorted-desc">Actions</th>
</tr></thead>
<tbody>
    
  
  
    <c:if test="${!empty data}">  
    <c:forEach items="${data}" var="reqpro">    
   <%--
        <c:out value="${reqpro.name}" />
    <c:out value="${reqpro.startDate}" />
    <c:out value="${reqpro.endDate}" />    
    <c:out value="${reqpro.mediaplanlineList.size()}" />  
    <c:out value="${reqpro.mediaplanlineList.inventoryApproved}" />
  <c:out value="${reqpro.mediaplanlineList.inventoryApproved}" />
  <c:out value="Edit" />
   --%>
    
</tr>


<tr class="parent" id="r1"><td>50s Female Plan</td>
<td nowrap="nowrap">December 1st, 2014</td>
<td nowrap="nowrap">December 31st, 2014</td>
<td align="center">3</td>
<td align="center">4,000,000</td>
<td align="center">3,000,00</td>
<td nowrap="nowrap">Edit</td>

</tr>
<tr class="child-r1" style="display: table-row;">
<td colspan="7">

<table width="100%" align="center"   rules="rows"> 
<tr ><th   nowrap="nowrap" align="left"  >Publisher Name</th>
<th align="left"   >Category</th>
<th align="left"  >Placement</th>
<th align="left"  >Creative type</th>
<th align="left"  >Status</th> 
<th align="left"  >Impressions Proposed</th>
<th align="left"  >Impressions approved</th>
<th align="left"  >Actions</th>
</tr> 
<tbody  class="table-nosort">
<tr><td>egmartech</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">Center fold,in sidebar</td>
<td align="center">leader board 720 x 90</td>
<td align="center">RFP Approved</td><td align="center">1,000,000</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>

</tr>

<tr><td>&nbsp;</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">image gallery pages Center fold</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">pending</td><td align="center">0</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>
<tr ><td>Ultimate Motor Cycling</td>
<td nowrap="nowrap">-</td>
<td align="center">Center Placement</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">RFP Approved</td><td align="center">2,000,000</td><td align="center">2,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>

</tbody></table>

</td>
</tr>
</c:forEach>
</c:if>
  

    
    

    

    
<tr class="parent" id="r1"><td>50s Female Plan</td>
<td nowrap="nowrasp">December 1st, 2014</td>
<td nowrap="nowrap">December 31st, 2014</td>
<td align="center">3</td>
<td align="center">4,000,000</td>
<td align="center">3,000,00</td>
<td nowrap="nowrap">Edit</td>

</tr>
<tr class="child-r1" style="display: table-row;">
<td colspan="7">

<table width="100%" align="center"   rules="rows"> 
<tr ><th   nowrap="nowrap" align="left"  >Publisher Name</th>
<th align="left"   >Category</th>
<th align="left"  >Placement</th>
<th align="left"  >Creative type</th>
<th align="left"  >Status</th> 
<th align="left"  >Impressions Proposed</th>
<th align="left"  >Impressions approved</th>
<th align="left"  >Actions</th>
</tr> 
<tbody  class="table-nosort">
<tr><td>egmartech</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">Center fold,in sidebar</td>
<td align="center">leader board 720 x 90</td>
<td align="center">RFP Approved</td><td align="center">1,000,000</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>

</tr>

<tr><td>&nbsp;</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">image gallery pages Center fold</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">pending</td><td align="center">0</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>
<tr ><td>Ultimate Motor Cycling</td>
<td nowrap="nowrap">-</td>
<td align="center">Center Placement</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">RFP Approved</td><td align="center">2,000,000</td><td align="center">2,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>

</tbody></table>



</td>

</tr>
<tr class="parent" id="r2" >
<td >Winter Fasion</td>
<td> </td><td> </td>
<td align="center">2</td><td align="center">2,000,000</td><td align="center">2,000,000</td>
<td align="center">Edit</td>
</tr>

<tr class="child-r2" style="display: table-row;">
<td colspan="7">

<table width="100%" align="center"   rules="rows"> 
<tr ><th   nowrap="nowrap" align="left"  >Publisher Name</th>
<th align="left">Category</th>
<th align="left">Placement</th>
<th align="left">Creative type</th>
<th align="left">Status</th> 
<th align="left">Impressions Proposed</th>
<th align="left">Impressions approved</th>
<th align="left">Actions</th>
</tr> 
<tbody class="table-nosort">
<tr><td>egmartech</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">Center fold,in sidebar</td>
<td align="center">leader board 720 x 90</td>
<td align="center">RFP Approved</td><td align="center">1,000,000</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>

</tr>

<tr><td>&nbsp;</td>
<td nowrap="nowrap">egmcartech Main</td>
<td align="center">image gallery pages Center fold</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">pending</td><td align="center">0</td><td align="center">1,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>
<tr ><td>Ultimate Motor Cycling</td>
<td nowrap="nowrap">-</td>
<td align="center">Center Placement</td>
<td align="center">Medium rectangle 300 x 250</td>
<td align="center">RFP Approved</td><td align="center">2,000,000</td><td align="center">2,000,000</td>
<td nowrap="nowrap">Place Insertion Order | Contact</td>
</tr>

</tbody></table>



</td>


</tr> 

 </tbody>


 
 
</table></form></div>
<!--<h2>END CONTENT</h2>-->
</div><!-- close div.paddingwrap -->
</div><!-- close div#content -->
<div id="sidebar-left">
<div class="paddingwrap">
<ul><li><input type="text" name="" id="" value="Type Keyword to search" /></li><li>Overview</li><li>
<ul>
    
  <c:url var="mediaLink" value="/mediaURL" />    
<li ><a href="${mediaLink}">Media Plans</a></li>

<c:url var="RequestLink" value="/requestproposals" />
<li class="current"><a href="${RequestLink}">Request For Proposals</a><span class="arrow-left"></span></li>
<li><a href="#">Insertion Orders</a></li>
 
<li><a href="#">Contracts</a></li>
<li><a href="#">Campaigns</a></li>
</ul></li></ul>
 
</div><!-- close div.paddingwrap -->
</div><!-- close div#sidebar-left -->
 
<div id="header">
<h1>C1X</h1>
<span style="float:right;position:absolute;top:5px; right:150px;color:white;font-size:10px;">danku@c1x.com<span class="arrow-down"></span></span>
<div class="breadcrumb">Media Plans</div>
 </div><!-- close div#header -->
<div id="footer">
 
</div><!-- close div#footer -->

</html>
