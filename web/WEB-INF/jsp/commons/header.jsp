<%-- 
    Document   : header
    Created on : 14-jun-2016, 12:33:55
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <spring:url value="/resources/favicon.png" var="favicon" />
    <link rel="icon" href="${favicon}">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core and others CSS -->
    <spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet">
    <spring:url value="/resources/css/myStyle.css" var="myStyleCss" />
    <link href="${myStyleCss}" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <spring:url value="/resources/bootstrap/css/ie10-viewport-bug-workaround.css" var="ie10WorkaroundCss" />
    <link href="${ie10WorkaroundCss}" rel="stylesheet">

    <!-- Custom styles for this template -->
    <spring:url value="/resources/bootstrap/css/dashboard.css" var="dashboardCss" />
    <link href="${dashboardCss}" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          