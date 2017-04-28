<#include "/common/header.ftl">

	<h3 class="text-muted"><@spring.message "employees-title"/></h3>
</div>

<div class="row marketing">
  	<div class="col-lg-6">
      	<#list employees as employee>
	  		<#if ((employee?index + 1) < employees?size)> 
	      		<h4><a href="/employee/profile/${employee.id}">${employee.surname}, ${employee.name}</a></h4>
	          	<p>${employee.position}</p>     			
	  		</#if>
	    </#list>
	</div>
	<div class="col-lg-6">
	  	<#list employees as employee>
	  		<#if ((employee?index + 1) >= employees?size)> 
	      		<h4><a href="/employee/profile/${employee.id}">${employee.surname}, ${employee.name}</a></h4>
	          	<p>${employee.position}</p>     			
	  		</#if>
	    </#list>
	</div>
</div>

<div class="row marketing">
	<div class="btn-group">
		<a class="btn btn-primary" href="/employee/add"><@spring.message "employees-add-button"/></a>
	</div>
</div>

<#include "/common/footer.ftl">