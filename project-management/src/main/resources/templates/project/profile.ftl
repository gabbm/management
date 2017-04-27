<#import "/spring.ftl" as spring/>
<#-- Use UTF-8 charset for URL escaping from now: -->
<#setting url_escaping_charset="UTF-8">
<#setting locale=.locale>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/public/images/favicon.ico">

    <title>${project.pep} - ${project.name}</title>

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
        <h3 class="text-muted"><@spring.message "project-title"/></h3>
      </div>
	
	<div class="row">
      <div class="col-xs-12 col-sm-12 col-md-6 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1 toppad">
        <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${project.pep}</h3>
            </div>
            <div class="panel-body">
            	<div class="row">
            	   <div class=" col-md-12 col-lg-12"> 
	                  <table class="table table-user-information">
	                    <tbody>
	                      <tr>
	                        <td><@spring.message "project-customer"/></td>
	                        <td>${project.customer}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-name"/></td>
	                        <td>${project.name}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-start-date"/></td>
	                        <td>${project.startDate}</td>
	                      </tr>
	                        <tr>
	                        <td><@spring.message "project-end-date"/></td>
	                        <td>${project.endDate}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-selling-margin"/></td>
	                        <td>${project.sellingMargin?string.percent}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-selling-price"/></td>
	                        <td>${project.sellingPrice?string["0,000.## €"]}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-selling-price-vat"/></td>
	                        <td>${project.sellingPriceVAT?string["0,000.## €"]}</td>
	                      </tr>
	                     
	                    </tbody>
	                  </table>
	                </div>         	
            	</div>
            </div>
            <div class="panel-footer">
            	<a href="/project/controlling?pep=${project.pep}" data-original-title="Project controlling" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-cog"></i></a>
                <span class="pull-right">
                    <a href="/project/edit?pep=${project.pep}" data-original-title="Edit this project" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                    <a href="/project/remove?pep=${project.pep}" data-original-title="Remove this project" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                </span>
            </div>
          </div>
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
