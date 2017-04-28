<#include "/common/header.ftl">

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
	                        <td>${project.sellingPrice?string["#,###.00 €"]}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "project-selling-price-vat"/></td>
	                        <td>${project.sellingPriceVAT?string["#,###.00 €"]}</td>
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

<#include "/common/footer.ftl">