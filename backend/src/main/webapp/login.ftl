<#include "base.ftl">

<html>
  <head>
    <title>Spring Security Login</title>
  </head>

  <body onload="document.f.username.focus();">
    <h1>Spring Security Login (Freemarker)</h1>

    <p> Vlasis </P>
    <form name="f" action="/login" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <table>
        <tr><td>User:</td><td><input type='text' name='username' value=''/></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password' value=''/></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
        <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
      </table>
    </form>

    <#if error.isPresent()>
        <p>The email or password you have entered is invalid, try again.</p>
    </#if>

  </body>
</html>