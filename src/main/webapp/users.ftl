<#include "base.ftl">

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li class="active"><a href="/admin/users/">Users</a></li>
        <li><a href="/admin/games/">Games</a></li>
    </ul>
</#macro>

<#macro page_body>
    <h2>Users</h2>
    <p>Showing all database users</p>
    <a href="/admin/users/create" class="btn btn-primary pull-right">Create User</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.role()}</td>
                <td>
                    <a type="button" class=" btn btn-xs btn-primary" href="/admin/users/${user.getId()}">Details</a>
                    <a type="button" class=" btn btn-xs btn-default" href="/admin/users/${user.getId()}/edit"><i class="fa fa-pencil" aria-hidden="true"></i> Edit</a>
                    <a type="button" class=" btn btn-xs btn-danger" href="/admin/users/${user.getId()}/delete"><i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</#macro>

<@display_page/>
