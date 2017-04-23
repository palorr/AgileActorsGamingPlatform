<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li><a href="/admin/users/">Users</a></li>
    <li class="active"><a href="/admin/games/">Games</a></li>
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
        <a href="/admin/games/" class="btn btn-default">Back</a>
        <button type="submit" class="btn btn-success pull-right">Submit</button>

    </form>
</#macro>

<@display_page/>
