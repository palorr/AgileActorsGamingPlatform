<#macro page_head>
    <title>Demo Application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</#macro>

<#macro page_body>
    <h1>Basic Page</h1>
    <p>This is the body of the page!</p>
</#macro>

<#macro display_page>
<!DOCTYPE html>
<html lang="en">
<head>
    <@page_head/>
</head>
<body>
<div class="container">
    <@page_body/>
</div>
</body>
</html>
</#macro>