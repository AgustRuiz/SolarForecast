<%-- 
    Document   : footer
    Created on : 14-jun-2016, 12:34:02
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>      
          
        </div>
      </div>
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!--script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script-->
    <spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />
    <script src="${bootstrapJs}"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <spring:url value="/resources/bootstrap/js/holder.min.js" var="holderJs" />
    <script src="${holderJs}"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <spring:url value="/resources/bootstrap/js/ie10-viewport-bug-workaround.js" var="ie10WorkaroundJs" />
    <script src="${ie10WorkaroundJs}"></script>
  </body>
</html>