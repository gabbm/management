<#import "/spring.ftl" as spring/>
<#-- Use UTF-8 charset for URL escaping from now: -->
<#setting url_escaping_charset="UTF-8">

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/public/images/favicon.ico">

    <title><@spring.message "projects-title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="/public/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/public/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/public/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/public/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/public/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="/">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
          </ul>
        </nav>
        <h3 class="text-muted"><@spring.message "projects-title"/></h3>
      </div>

      <div class="row marketing">
      	<div class="col-lg-6">
	      	<#list projects as project>
	      		<#if ((project?index + 1) < projects?size)> 
		      		<h4><a href="/project/profile?pep=${project.pep}">${project.pep}</a></h4>
		          	<p>${project.name}</p>     			
	      		</#if>
		    </#list>
		</div>
		<div class="col-lg-6">
	      	<#list projects as project>
	      		<#if ((project?index + 1) >= projects?size)> 
		      		<h4><a href="/project/profile?pep=${project.pep}">${project.pep}</a></h4>
		          	<p>${project.name}</p>     			
	      		</#if>
		    </#list>
		</div>
      </div>

      <div class="row marketing">
		<div class="btn-group">
		  <a class="btn btn-primary" href="/project/add">Add project</a>
		</div>
      </div>

      <footer class="footer">
        <p>&copy; 2016 GabTools</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/public/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>