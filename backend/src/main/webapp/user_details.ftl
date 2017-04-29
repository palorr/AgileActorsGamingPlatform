<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
        <li class="active"><a href="#"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
        <li><a href="${adminGamesUri}"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
        <li><a href="/admin/wallets/"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
        <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">User Operations</li>
        <li><a href="/admin/play_operations/"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
        <li><a href="/admin/credit_operations/"><i class="fa fa-credit-card fa-fw" aria-hidden="true"></i> Credit Operations</a></li>
        <li><a href="/admin/buy_operations/"><i class="fa fa-ticket fa-fw" aria-hidden="true"></i> Buy Operations</a></li>
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