<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="${adminUri}"><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</a></li>
        <li class="active"><a href="${adminUsersUri}"><i class="fa fa-users" aria-hidden="true"></i> Users</a></li>
        <li><a href="${adminGamesUri}"><i class="fa fa-gamepad" aria-hidden="true"></i> Games</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2>User Details</h2>
    <p>Showing user details</p>
    <ul class="list-group">
        <li class="list-group-item"><strong>ID: </strong>${user.getId()}</li>
        <li class="list-group-item"><strong>Name: </strong>${user.getName()}</li>
        <li class="list-group-item"><strong>Surname: </strong>${user.getSurname()}</li>
        <li class="list-group-item"><strong>Username: </strong>${user.getUsername()}</li>
        <li class="list-group-item"><strong>Password: </strong>${user.getPassword()}</li>
        <li class="list-group-item"><strong>Role: </strong>${user.getRole().getName()?lower_case}</li>
    </ul>
    <a type="button" class="btn btn-primary" href="${adminUsersUri}">Back</a>
</#macro>

<@display_page/>