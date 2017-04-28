<#include "/common/header.ftl">

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
		<a class="btn btn-primary" href="/project/add"><@spring.message "projects-add-button"/></a>
	</div>
</div>

<#include "/common/footer.ftl">