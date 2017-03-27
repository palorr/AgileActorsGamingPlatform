<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li><a href="/admin/users/">Users</a></li>
    <li class="active"><a href="/admin/games/">Games</a></li>
</ul>
</#macro>


<#--private int buy_credits;-->
<#--private int win_credits;-->
<#--private Double yield;-->
<#--private String name;-->
<#--private String description-->

<#macro page_body>
    <h2>Game Form</h2>
    <p>Create or edit existing game</p>
    <form action="/admin/games/create" name="game" method="post">
        <div class="form-group" >
            <p class="required"> <label for="id_name">Name:</label>
                <input class="form-control"  id="id_name" maxlength="30" name="name" type="text"  placeholder="Enter name"/></p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_description">Description:</label>
                <input class="form-control" id="id_description" name="description" type="text" placeholder="Enter description" /></p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_buy_credits">Buy Credits:</label>
                <input class="form-control" id="id_buy_credits" name="buy_credits" type="number" placeholder="Enter buy credits" /></p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_win_credits">Win Credits:</label>
                <input class="form-control" id="id_win_credits" name="win_credits" type="number" placeholder="Enter win credits" /></p>
        </div>
        <div class="form-group">
            <p class="required"><label for="id_yield">Yield:</label>
                <input class="form-control" id="id_yield" name="yield" type="number" step="any" placeholder="Enter yield" /></p>
        </div>
        <a href="/admin/games/" class="btn btn-default">Back</a>
        <button type="submit" class="btn btn-success pull-right">Submit</button>

    </form>
</#macro>

<@display_page/>
