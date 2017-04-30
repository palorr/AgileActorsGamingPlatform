<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
        <li><a href="${adminUsersUri}"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
        <li class="active"><a href="#"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
        <li><a href="/admin/wallets/"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
        <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">User Operations</li>
        <li><a href="/admin/play_operations/"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
        <li><a href="/admin/credit_operations/"><i class="fa fa-credit-card fa-fw" aria-hidden="true"></i> Credit Operations</a></li>
        <li><a href="/admin/buy_operations/"><i class="fa fa-ticket fa-fw" aria-hidden="true"></i> Buy Operations</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2>Game Details</h2>
    <p>Showing game details</p>
    <ul class="list-group">
        <li class="list-group-item"><strong>ID: </strong>${game.getId()}</li>
        <li class="list-group-item"><strong>Name: </strong>${game.getName()}</li>
        <li class="list-group-item"><strong>Avatar url: </strong>${game.getAvatar()}</li>
        <li class="list-group-item"><strong>Description: </strong>${game.getDescription()}</li>
        <li class="list-group-item"><strong>Buy Credits: </strong>${game.getBuy_credits()}</li>
        <li class="list-group-item"><strong>Win Credits: </strong>${game.getWin_credits()}</li>
        <li class="list-group-item"><strong>Yield: </strong>${game.getYield()}</li>
    </ul>
    <a type="button" class="btn btn-primary" href=${adminGamesUri}>Back</a>
</#macro>

<@display_page/>