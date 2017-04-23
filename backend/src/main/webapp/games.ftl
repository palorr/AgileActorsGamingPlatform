<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="/admin/"><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</a></li>
        <li><a href="/admin/users/"><i class="fa fa-users" aria-hidden="true"></i> Users</a></li>
        <li class="active"><a href="#"><i class="fa fa-gamepad" aria-hidden="true"></i> Games</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2><i class="fa fa-gamepad" aria-hidden="true"></i> Games</h2>
    <p>Showing all database games</p>
    <a href="/admin/create_game" class="btn btn-primary pull-right">Create Game</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Buy Credits</th>
            <th>Win Credits</th>
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
                <td>
                    <a type="button" class=" btn btn-xs btn-primary" href="${adminGamesUri}${game.getId()}">Details</a>
                    <a type="button" class=" btn btn-xs btn-default" href="${adminUpdateGame}${game.getId()}"><i class="fa fa-pencil" aria-hidden="true"></i> Edit</a>
                    <a type="button" class=" btn btn-xs btn-danger" href="${adminDeleteGame}${game.getId()}"><i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</#macro>

<@display_page/>
