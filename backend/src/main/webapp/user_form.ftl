<#include "base.ftl">

<#macro side_menu>
<ul class="nav nav-sidebar">
    <li><a href="${adminUri}"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
    <li class="active"><a href="#"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
    <li><a href="${adminGamesUri}"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
    <li><a href="/admin/wallets/"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
    <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">User Operations</li>
    <li><a href="/admin/play_operations/"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
    <li><a href="/admin/credit_operations/"><i class="fa fa-credit-card fa-fw" aria-hidden="true"></i> Credit Operations</a></li>
    <li><a href="/admin/buy_operations/"><i class="fa fa-ticket fa-fw" aria-hidden="true"></i> Buy Operations</a></li>
</ul>
</#macro>

<#macro page_body>
<h2>User Form</h2>
<p>Create or edit existing user</p>
<form action=${url} name="user" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <#if user??><input type="hidden" name="id" id ="id" value="${user.getId()}"/></#if>
    <div class="form-group" >
        <p class="required"> <label for="id_name">Name:</label>
            <input
                <#if user??>value="${user.getName()}"</#if>
                class="form-control"
                id="id_name"
                name="name"
                type="text"
                placeholder="Enter name"
                pattern="[a-zA-Z\s]{2,20}"
                title="Name must be up to 20 characters long and contain only letters and spaces"
                required
            />
        </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_surname">Surname:</label>
            <input
                <#if user??>value="${user.getSurname()}"</#if>
                class="form-control"
                id="id_surname"
                name="surname"
                type="text"
                placeholder="Enter surname"
                pattern="[a-zA-Z\s]{2,20}"
                title="Last Name must be up to 20 characters long and contain only letters and spaces"
                required
            />
        </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_username">Username:</label>
            <input
                <#if user??>value="${user.getUsername()}"</#if>
                class="form-control"
                id="id_username"
                name="username"
                type="text"
                placeholder="Enter username"
                pattern="[a-zA-Z0-9]{4,16}"
                title="Username must be between 4 and 16 characters long. Accepted characters are letters and digits"
                required
            />
        </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_password">Password:</label>
            <input
                <#if user??>value="${user.getPassword()}"</#if>
                class="form-control"
                id="id_password"
                name="password"
                type="password"
                placeholder="Enter password"
                pattern="[a-zA-Z0-9@!#$]{4,16}"
                title="Password must be between 4 and 16 characters long. Accepted characters are letters, digits and special symbols (@!#$)"
                required
            />
        </p>
    </div>
    <div class="form-group">
        <p class="required"><label for="id_role">Role:</label>
            <select class="form-control" id="id_role" name="role">
                <#list roles as role>
                    <#if url != "/admin/create_user" && role.getId() == user.getRole().getId()>
                        <option value="${role.getId()}" selected>${role.getName()?lower_case}</option>
                    <#else>
                        <option value="${role.getId()}">${role.getName()?lower_case}</option>
                    </#if>
                </#list>
            </select>
        </p>
    </div>
    <a href="${adminUsersUri}" class="btn btn-default">Back</a>
    <button type="submit" class="btn btn-success pull-right">Submit</button>

</form>
</#macro>

<@display_page/>
