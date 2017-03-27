<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="/admin/users/">Users</a></li>
        <li class="active"><a href="/admin/games/">Games</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2>Games</h2>
    <p>Showing all database games</p>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Buy Credits</th>
            <th>Win Credits</th>
            <th>Yield</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <#list games as game>
            <tr>
                <td>${game.getId()}</td>
                <td>${game.getName()}</td>
                <td>${game.getDescription()}</td>
                <td>${game.getBuy_credits()}</td>
                <td>${game.getWin_credits()}</td>
                <td>${game.getYield()}</td>
                <td><a type="button" class=" btn btn-xs btn-primary" href="/admin/games/${game.getId()}">Details</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</#macro>

<@display_page/>
