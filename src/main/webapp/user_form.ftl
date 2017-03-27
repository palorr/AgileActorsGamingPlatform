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
<form action="/admin/users/create" name="user" method="post">
    <div class="form-group" >
        <p class="required"> <label for="id_name">Name:</label>
            <input class="form-control"  id="id_name" maxlength="30" name="name" type="text"  placeholder="Enter name"/></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_surname">Surname:</label>
            <input class="form-control" id="id_surname" name="surname" type="text" placeholder="Enter surname" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_username">Buy Credits:</label>
            <input class="form-control" id="id_username" name="username" type="number" placeholder="Enter username" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_password">Password:</label>
            <input class="form-control" id="id_password" name="password" type="password" placeholder="Enter password" /></p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_roles_id">Role id:</label>
            <input class="form-control" id="id_roles_id" name="roles_id" type="number" placeholder="Enter role id" /></p>
    </div>
    <a href="/admin/users/" class="btn btn-default">Back</a>
    <button type="submit" class="btn btn-success pull-right">Submit</button>

</form>
</#macro>

<@display_page/>
