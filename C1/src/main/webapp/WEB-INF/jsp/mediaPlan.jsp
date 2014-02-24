<%-- 
    Document   : mediaPlan1
    Created on : Nov 18, 2013, 3:34:10 PM
    Author     : logic
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>C1X- Media Plans</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" media="screen" charset="utf-8">
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/accordion.css" type="text/css" media="screen" charset="utf-8">
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.5.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.nestedAccordion.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/accordion.js" type="text/javascript" charset="utf-8"></script>
    
     		<script src="<%=request.getContextPath()%>/resources/js/jquery.tinysort.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.tinysort.charorder.js"></script>	
    <script type="text/javascript">

		$.fn.accordion.defaults.container = false; 
		$(function() {

  			$("#container").accordion({
      			obj: "div", 
      			wrapper: "div", 
      			el: ".h", 
      			head: "h4, h5", 
      			next: "div", 
      			showMethod: "slideFadeDown",
      			hideMethod: "slideFadeUp",

   			 });
 			 $("html").removeClass("js");
			 
			  				  var aAsc = [];
				function sortTable(e) {
					//alert($(e.currentTarget).index());
					var nr = $(e.currentTarget).index();
					aAsc[nr] = aAsc[nr]=='asc'?'desc':'asc';
					console.log($('div#container div#acc2.accordion > .new .level1 ul.sorter1').val('li:eq('+nr+')').text());

					$('#container>div.new').tsort('section:eq('+nr+')',{order:aAsc[nr]});
				}
				$('#header-sort > .sorter>section').click(sortTable);	

				});
	</script>	
</head>
<body>
	<div id="header">
		<div id="logo"></div>
        
        <ul class="crumbs">
				<li><a href="#" style="z-index:9;">Media Plans</a></li>
				<li><a href="#" style="z-index:8;">Insertion Orders</a></li>
				<li><a href="#" style="z-index:7;">Contracts</a></li>
				<li><a href="#" style="z-index:6;">Campaigns</a></li>
                <li><a href="#" style="z-index:5;">Reporting</a></li>
			</ul>
            	
        <div id="user"><span>danku@c1x.com</span><div class="arrow-down"></div></div>
	</div>
      
	<div id="wrapper">
		<div id="btn-group">
        <input  type="text" class="form-control custom-box" placeholder="Type to search for Media Plan or RFP"></input>
        <button type="button" class="btn btn-default btn-xs lightGreenBtn">+ New Media Plan</button>
        <button type="button" class="btn btn-default btn-xs lightGreyBtn">Delete</button>
        	<div id="btn-group-inner">Show:
            	 <button type="button" class="btn btn-default btn-xs greenBtn floatCenter">Approved</button>
                  <button type="button" class="btn btn-default btn-xs darkBtn floatCenter">Pending</button>
            </div>
         <button type="button" class="btn btn-default btn-xs lightGreyBtn floatLeft">Export CSV</button>


        </div>
        <div class="clr"></div>
		<div id="header-sort">
        	<div class="sorter">
           		 <section>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</section>
                <section>Targeting</section>
                <section>Start Date</section>
                <section>End Date</section>
                <section>Inventory</section>
                <section>Impressions</section>
                <section>Status</section>
                <section>Price</section>
                <section>Actions</section>
            </div>
        </div>
	
	 <div id="container" class="accordion">
          
             	<div class="new sorter1"> 
                <!--<li>q0s Male plan</li>-->
            
                

<%--c:if test="${!empty data}"> 
<c:forEach items="${data}" var="getData"  varStatus="i" >
    
    
    <c:out value="${getData.get(0)} == Name" />== 
    <c:out value="${getData.get(1)} == Tar " />== 
    <c:out value="${getData.get(2)} == StDt" />==
    <c:out value="${getData.get(3)} == EndDt" />==
    <c:out value="${getData.get(4)} == imp" />==
    <c:out value="${getData.get(5)} == inv" />==
    <c:out value="${getData.get(6)} == Status" />==
    <c:out value="${getData.get(7)} == PUP" />==
    </br>
    
</c:forEach>
</c:if--%>
    
    

                
                <div class="trigger accordion-header level1"> 
               		<div id="level2-Strip"><div class="plus"></div></div>
                    <div id="plan"><span>Media Plan</span>50s contenet</div>
               		<div id="stack">
                    <section>gargeting gargeting</section>
                    <section>oart Date</section>
                    <section>21/3/2012</section>
                    <section>fnventory</section>
                    <section>mpressions</section>
                    <section>hStatus</section>
                    <section>rrice</section>
                    <section>ections</section></div>
                 </div>
                  <div class="outer" style="display: none; ">
                   	<div class="inner level1">                    			
                            <div class="new sorter1">
               				 <!--<section>7 Male plan</section>-->
                           <div class="trigger accordion-header level2"> 
                                <div id="level3-Strip"><div class="plus"></div></div>
                                <div id="plan"><span>publisher</span>wahoo</div>
                               <div id="stack"> <section>uzargeting</section>
                                <section>fart Date</section>
                                <section>25/3/2012</section>
                                <section>hnventory</section>
                                <section>vmpressions</section>
                                <section>btatus</section>
                                <section>nrice</section>
                                <section>zctions</section> </div>
                           </div>
                           <div class="outer" style="display: none; ">
                                <div class="inner level2">
                                					<div class="new sorter1">
                                                         <!--<section>7 Male plan</section>-->
                                                       <div class="trigger accordion-header level3"> 
                                                            <div id="level4-Strip"><div class="plus"></div></div>
                                                            <div id="plan"><span>placement</span>wahoo finanace</div>
                                                            <section>wzargeting</section>
                                                            <section>fart Date</section>
                                                            <section>25/3/2012</section>
                                                            <section>hnventory</section>
                                                            <section>vmpressions</section>
                                                            <section>btatus</section>
                                                            <section>nrice</section>
                                                            <section>zctions</section> 
                                                       </div>
                                                       <div class="outer" style="display: none; ">
                                                            <div class="inner level3">
                                                            				<div class="new sorter1">
                                                                                 <!--<section>7 Male plan</section>-->
                                                                               <div class="trigger accordion-header level4"> 
                                                                                    <div id="level4-Strip"><div class="plus"></div></div>
                                                                                    <div id="plan"><span>placement</span>Ad Unit</div>
                                                                                    <section>wzargeting</section>
                                                                                    <section>fart Date</section>
                                                                                    <section>25/3/2012</section>
                                                                                    <section>hnventory</section>
                                                                                    <section>vmpressions</section>
                                                                                    <section>btatus</section>
                                                                                    <section>nrice</section>
                                                                                    <section>zctions</section> 
                                                                               </div>
                                                                               <div class="outer" style="display: none; ">
                                                                                    <div class="inner level4">
                                                                                    				   
                                                                                                       <div class="level5"> 
                                                                                                           
                                                                                                           
                                                                                                            <section>wzargeting</section>
                                                                                                            <section>fart Date</section>
                                                                                                            <section>25/3/2012</section>
                                                                                                            <section>hnventory</section>
                                                                                                            <section>vmpressions</section>
                                                                                                            <section>btatus</section>
                                                                                                            <section>nrice</section>
                                                                                                            <section>zctions</section> 
                                                                                                       </div>
                                                                                                       
                                                                                                   
                                                                                    </div>
                                                                                 </div>
                                                                            </div>
                                                            </div>
                                                         </div>
                                                    </div>
                                                    <div class="new sorter1">
                                                         <!--<section>7 Male plan</section>-->
                                                       <div class="trigger accordion-header level3"> 
                                                            <div id="level4-Strip"><div class="plus"></div></div>
                                                             <div id="plan"><span>placement</span>wahoo finance news</div>
                                                            <section>wzargeting</section>
                                                            <section>fart Date</section>
                                                            <section>25/3/2012</section>
                                                            <section>hnventory</section>
                                                            <section>vmpressions</section>
                                                            <section>btatus</section>
                                                            <section>nrice</section>
                                                            <section>zctions</section> 
                                                       </div>
                                                       <div class="outer" style="display: none; ">
                                                            <div class="inner level3">
                                                            
                                                            </div>
                                                         </div>
                                                    </div>
                                                    <div class="new sorter1">
                                                         <!--<section>7 Male plan</section>-->
                                                       <div class="trigger accordion-header level3"> 
                                                            <div id="level4-Strip"><div class="plus"></div></div>
                                                            <div id="plan"><span>placement</span>wahoo finance news</div>
                                                            <section>wzargeting</section>
                                                            <section>fart Date</section>
                                                            <section>25/3/2012</section>
                                                            <section>hnventory</section>
                                                            <section>vmpressions</section>
                                                            <section>btatus</section>
                                                            <section>nrice</section>
                                                            <section>zctions</section> 
                                                       </div>
                                                       <div class="outer" style="display: none; ">
                                                            <div class="inner level3">
                                                            
                                                            </div>
                                                         </div>
                                                    </div>
                                </div>
                             </div>
                        </div>
                        
                        <div class="new sorter1">
               				 <!--<section>7 Male plan</section>-->
                           <div class="trigger accordion-header level2"> 
                                <div id="level3-Strip"><div class="plus"></div></div>
                                <div id="plan"><span>publisher</span>finance news</div>
                                <section>wzargeting</section>
                                <section>fart Date</section>
                                <section>25/3/2012</section>
                                <section>hnventory</section>
                                <section>vmpressions</section>
                                <section>btatus</section>
                                <section>nrice</section>
                                <section>zctions</section> 
                           </div>
                           <div class="outer" style="display: none; ">
                                <div class="inner level1">
                                
                                </div>
                             </div>
                        </div>
                    </div>
                 </div>
            </div>
          
             
             
             	<div class="new sorter1">
                <!--<li>30s Male plan</li>-->
               <div class="trigger accordion-header level1"> 
              		 <div id="level2-Strip"><div class="plus"></div></div>
                    <div id="plan"><span>Media Plan</span>10 finance news</div>
               		<div id="stack"><section>dargeting</section>
                    <section>tart Date</section>
                    <section>1/3/2012</section>
                    <section>ynventory</section>
                    <section>wmpressions</section>
                    <section>ftatus</section>
                    <section>krice</section>
                    <section>pctions</section> </div>
               </div>
               <div class="outer" style="display: none; ">
                   	<div class="inner level1"></div>
                 </div>
            </div>
            
             
            
             	<div class="new sorter1">
                <!--<section>7 Male plan</section>-->
               <div class="trigger accordion-header level1"> 
               		<div id="level2-Strip"><div class="plus"></div></div>
                    <div id="plan"><span>Media Plan</span>80 finance news</div>
                   <div id="stack"> <section>ezargeting</section>
                    <section>fart Date</section>
                    <section>25/3/2012</section>
                    <section>hnventory</section>
                    <section>vmpressions</section>
                    <section>btatus</section>
                    <section>nrice</section>
                    <section>zctions</section> </div>
               </div>
               <div class="outer" style="display: none; ">
                   	<div class="inner level1">
                    		
                        
                        
                    </div>
                 </div>
            </div>
           

             	 <div class="new sorter1">
               <!-- <section>50s Male plan</section>-->
               <div class="trigger accordion-header level1"> 
               			<div id="level2-Strip"><div class="plus"></div></div>
                        <div id="plan"><span>Media Plan</span>300finance news</div>
                       <div id="stack"> <section>zargeting</section>
                        <section>tart Date</section>
                        <section>1/3/2012</section>
                        <section>dnventory</section>
                        <section>Impressions</section>
                        <section>Status</section>
                        <section>grice</section>
                        <section>Actions</section> </div>
              </div>
              <div class="outer" style="display: none; ">
                   	<div class="inner level1"></div>
                 </div>
            </div>
         

	</div>
 
</body>
</html>	
