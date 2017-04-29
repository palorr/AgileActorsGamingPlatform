<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
    <li><a href="${adminUsersUri}"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
    <li><a href="${adminGamesUri}"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
    <li><a href="/admin/wallets"><i class="fa fa-euro" aria-hidden="true"></i> Wallets</a></li>
    <li><a href="#"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
</ul>
</#macro>

<#macro page_body>
<h2><i class="fa fa-trophy" aria-hidden="true"></i> Play Operations</h2>
<p>Showing all database users' play operations</p>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Game</th>
        <th>Credits</th>
        <th>Try</th>
        <th>Win</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
        <#list operations as operation>
        <tr>
            <td>${operation.getId()}</td>
            <td>${operation.getUser().getName()} ${operation.getUser().getSurname()}</td>
            <td>${operation.getGame().getName()}</td>
            <td>${operation.getWinCredits()}</td>
            <td><#if operation.getIsTry()><i class="fa fa-check fa-fw" aria-hidden="true"></i></#if></td>
            <td><#if operation.getIsWin()><i class="fa fa-check fa-fw" aria-hidden="true"></i></#if></td>
            <td>${operation.getDate()}</td>
        </tr>
        </#list>
    </tbody>
</table>
</#macro>

<@display_page/>
