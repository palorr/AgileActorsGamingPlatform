<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li class="active"><a href="/admin/users/">Users</a></li>
    <li><a href="/admin/games/">Games</a></li>
</ul>
</#macro>

<#macro page_body>
<h2>User Form</h2>
<p>Create or edit existing user</p>
<form action=${url} name="user" method="post">
    <div class="form-group" >
        <p class="required"> <label for="id_name">Name:</label>
            <input <#if user??>value=${user.getName()}</#if> class="form-control" id="id_name" maxlength="30" name="name" type="text"  placeholder="Enter name"/></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_surname">Surname:</label>
            <input <#if user??>value=${user.getSurname()}</#if> class="form-control" id="id_surname" name="surname" type="text" placeholder="Enter surname" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_username">Username:</label>
            <input <#if user??>value=${user.getUsername()}</#if> class="form-control" id="id_username" name="username" type="text" placeholder="Enter username" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_password">Password:</label>
            <input <#if user??>value=${user.getPassword()}</#if> class="form-control" id="id_password" name="password" type="password" placeholder="Enter password" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_role">Role id:</label>
            <input <#if user??>value=${user.getRole().getId()}</#if> class="form-control" id="id_role" name="role" type="number" placeholder="Enter role id" /></p>
    </div>
    <a href="/admin/users/" class="btn btn-default">Back</a>
    <button type="submit" class="btn btn-success pull-right">Submit</button>

</form>
</#macro>

<@display_page/>
