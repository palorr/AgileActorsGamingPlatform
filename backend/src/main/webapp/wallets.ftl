<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
    <li><a href="${adminUsersUri}"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
    <li><a href="${adminGamesUri}"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
    <li class="active"><a href="#"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
    <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">User Operations</li>
    <li><a href="/admin/play_operations/"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
    <li><a href="/admin/credit_operations/"><i class="fa fa-credit-card fa-fw" aria-hidden="true"></i> Credit Operations</a></li>
    <li><a href="/admin/buy_operations/"><i class="fa fa-ticket fa-fw" aria-hidden="true"></i> Buy Operations</a></li>
</ul>
</#macro>

<#macro page_body>
<h2><i class="fa fa-euro" aria-hidden="true"></i> Wallets</h2>
<p>Showing all database users' wallets</p>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Owner</th>
        <th>Credits</th>
    </tr>
    </thead>
    <tbody>
        <#list wallets as wallet>
        <tr>
            <td>${wallet.getId()}</td>
            <td><#if wallet.getUser()??>${wallet.getUser().getName()} ${wallet.getUser().getSurname()}</#if></td>
            <td>${wallet.getCredits()}</td>
        </tr>
        </#list>
    </tbody>
</table>
</#macro>

<@display_page/>
