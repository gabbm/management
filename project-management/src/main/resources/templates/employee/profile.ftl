<#include "/common/header.ftl">

        <h3 class="text-muted"><@spring.message "employee-title"/></h3>
      </div>
	
	<div class="row">
      <div class="col-xs-12 col-sm-12 col-md-6 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1 toppad">
        <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${employee.employee.surname}, ${employee.employee.name}</h3>
            </div>
            <div class="panel-body">
            	<div class="row">
            	   <div class=" col-md-12 col-lg-12"> 
	                  <table class="table table-user-information">
	                    <tbody>
	                      <tr>
	                        <td><@spring.message "employee-position"/></td>
	                        <td>${employee.employee.position}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "employee-salary"/></td>
	                        <td>${employee.employee.salary?string["#,##0.00 €"]}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "employee-company-cost"/></td>
	                        <td>${employee.companyCost?string["#,##0.00 €"]}</td>
	                      </tr>
	                        <tr>
	                        <td><@spring.message "employee-base-cost"/></td>
	                        <td>${employee.baseCost?string["#,##0.00 €"]}</td>
	                      </tr>
	                      <tr>
	                        <td><@spring.message "employee-objective-rate"/></td>
	                        <td>${employee.objectiveRate?string["#,##0.00 €"]}</td>
	                      </tr>	                     
	                    </tbody>
	                  </table>
	                </div>         	
            	</div>
            </div>
            <div class="panel-footer">
                <a href="/employee/${employee.employee.id}/edit" data-original-title="Edit this employee" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                <a href="/employee/${employee.employee.id}/remove" data-original-title="Remove this employee" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
            </div>
          </div>
      </div>
</div>

<#include "/common/footer.ftl">