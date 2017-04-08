<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="/admin/"><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</a></li>
        <li><a href="/admin/users/"><i class="fa fa-users" aria-hidden="true"></i> Users</a></li>
        <li class="active"><a href="/admin/games/"><i class="fa fa-gamepad" aria-hidden="true"></i> Games</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2>Game Details</h2>
    <p>Showing game details</p>
    <ul class="list-group">
        <li class="list-group-item"><strong>ID: </strong>${game.getId()}</li>
        <li class="list-group-item"><strong>Name: </strong>${game.getName()}</li>
        <li class="list-group-item"><strong>Description: </strong>${game.getDescription()}</li>
        <li class="list-group-item"><strong>Buy Credits: </strong>${game.getBuy_credits()}</li>
        <li class="list-group-item"><strong>Win Credits: </strong>${game.getWin_credits()}</li>
        <li class="list-group-item"><strong>Yield: </strong>${game.getYield()}</li>
    </ul>
    <a type="button" class="btn btn-primary" href="/admin/games">Back</a>
</#macro>

<@display_page/>