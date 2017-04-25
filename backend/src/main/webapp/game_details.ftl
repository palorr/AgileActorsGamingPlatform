<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
        <li><a href="${adminUsersUri}"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
        <li class="active"><a href="#"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
        <li><a href="/admin/wallets/"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
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
    </ul>
    <a type="button" class="btn btn-primary" href=${adminGamesUri}>Back</a>
</#macro>

<@display_page/>