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
    <h2>Game Form</h2>
    <p>Create or edit existing game</p>
    <form action=${url} name="game" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <#if game??><input type="hidden" name="id" id ="id" value="${game.getId()}"/></#if>
        <div class="form-group" >
            <p class="required"> <label for="id_name">Name:</label>
                <input
                    <#if game??>value="${game.getName()}"</#if>
                    class="form-control"
                    id="id_name"
                    maxlength="30"
                    name="name"
                    type="text"
                    placeholder="Enter name"
                />
            </p>
        </div>
        <div class="form-group" >
            <p class="required"> <label for="id_avatar">Avatar:</label>
                <input
                    <#if game??>value="${game.getAvatar()}"</#if>
                    class="form-control"
                    id="id_avatar"
                    name="avatar"
                    type="url"
                    placeholder="Enter avatar url"
                />
            </p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_description">Description:</label>
                <textarea
                    class="form-control"
                    id="id_description"
                    name="description"
                    placeholder="Enter description"><#if game??>${game.getDescription()}</#if></textarea>
            </p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_buy_credits">Buy Credits:</label>
                <input
                    <#if game??>value="${game.getBuy_credits()}"</#if>
                    class="form-control"
                    id="id_buy_credits"
                    name="buy_credits"
                    type="number"
                    placeholder="Enter buy credits"
                />
            </p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_win_credits">Win Credits:</label>
                <input
                    <#if game??>value="${game.getWin_credits()}"</#if>
                    class="form-control"
                    id="id_win_credits"
                    name="win_credits"
                    type="number"
                    placeholder="Enter win credits"
                />
            </p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_yield">Yield:</label>
                <input
                    <#if game??>value="${game.getYield()}"</#if>
                    class="form-control"
                    id="id_yield"
                    name="yield"
                    type="number"
                    step="0.01"
                    placeholder="Enter yield"
                />
            </p>
        </div>
        <a href="/admin/games/" class="btn btn-default">Back</a>
        <button type="submit" class="btn btn-success pull-right">Submit</button>

    </form>
</#macro>

<@display_page/>
