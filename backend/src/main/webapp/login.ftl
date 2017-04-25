<#include "base.ftl">

<#macro navbar>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/admin/"><i class="fa fa-fort-awesome" aria-hidden="true"></i> IWG Admin Panel</a>
        </div>
    </div>
</div>
</#macro>

<#macro side_menu></#macro>

<#macro page_body>
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
    <form name="f" action="/login" method="post" class="form-signin" style="margin-left: 0; max-width: 400px;">
        <h1 form-signin-heading>Security Login to IWG</h1>
        <h3 form-signin-heading>Please sign in</h3>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <p class="required"><label for="id_username">Username:</label>
                <input
                  class="form-control"
                  id="id_username"
                  name="username"
                  type="text"
                  placeholder="Enter your username"
                />
            </p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_password">Password:</label>
                <input
                        class="form-control"
                        id="id_password"
                        name="password"
                        type="password"
                        placeholder="Enter your password"
                />
            </p>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
      <#if error.isPresent()>
          <p>The username or password you have entered is invalid, try again.</p>
      </#if>
    </form>
</#macro>

<@display_page/>
