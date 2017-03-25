<#include "base.ftl">

<#macro page_body>
    <h2>User Details</h2>
    <p>Showing user details</p>
    <ul class="list-group">
        <li class="list-group-item"><strong>ID: </strong>${user.getId()}</li>
        <li class="list-group-item"><strong>Name: </strong>${user.getName()}</li>
        <li class="list-group-item"><strong>Surname: </strong>${user.getSurname()}</li>
        <li class="list-group-item"><strong>Username: </strong>${user.getUsername()}</li>
        <li class="list-group-item"><strong>Password: </strong>${user.getPassword()}</li>
        <li class="list-group-item"><strong>Role: </strong>${user.role()}</li>
    </ul>
    <a type="button" class="btn btn-primary" href="/users">Back</a>
</#macro>

<@display_page/>