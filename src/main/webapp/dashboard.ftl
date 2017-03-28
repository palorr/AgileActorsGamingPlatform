<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li class="active"><a href="#">Dashboard</a></li>
    <li><a href="/admin/users/">Users</a></li>
    <li><a href="/admin/games/">Games</a></li>
</ul>
</#macro>

<#macro page_body>
    <h2>Instant Win Game Admin Dashboard</h2>
    <p>The first page after admin login</p>
</#macro>

<@display_page/>