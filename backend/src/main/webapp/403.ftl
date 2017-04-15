<#include "base.ftl">

<html>
  <head>
    <title>Spring Security Login</title>
  </head>

  <body onload="document.f.username.focus();">
    <h1>Spring Security Login Error (Freemarker)</h1>

    <p> Vlasis error page</P>

    <#if error.isPresent()>
        <p>The email or password you have entered is invalid, try again.</p>
    </#if>

  </body>
</html>