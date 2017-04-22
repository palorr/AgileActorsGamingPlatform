<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li class="active"><a href="/admin/users/">Users</a></li>
    <li><a href="/admin/games/">Games</a></li>
</ul>
</#macro>

<#macro page_body>
<h2>User Form</h2>
<form action="/admin/create_user" name="userForm" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-group" >
        <p class="required"> <label for="id_name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" maxlength="20" placeholder="Enter name"/> </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_surname">Surname:</label>
            <input type="text" class="form-control" name="surname" id="surname" placeholder="Enter surname"/> </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_username">Username:</label>
            <input type="text" class="form-control" name="username" id="username" placeholder="Enter username"/> </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_password">Password:</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Enter password"/> </p>
    </div>
    <div class="form-group">
            <p class="required"><label for="id_password">Repeat Password:</label>
                <input type="password" class="form-control" name="passwordRepeated" id="passwordRepeated" placeholder="Enter password again"/> </p>
        </div>
    <div class="form-group">
        <p class="required"><label for="id_role">Role:</label>
        <select class="form-control" name="role" id="role" required>
            <option selected="selected">USER</option>
            <option>ADMIN</option>
        </select>
    </div>
    <a href="/admin/users/" class="btn btn-default">Back</a>
    <button type="submit" class="btn btn-success pull-right">Submit</button>
</form>

<p></p>
<#if errors??>
<ul>
    <#list errors as error>
        <li>${error.defaultMessage}</li>
    </#list>
</ul>
</#if>

</#macro>

<@display_page/>


