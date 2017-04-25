<#macro page_head>
    <title>Demo Application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="http://getbootstrap.com/examples/dashboard/dashboard.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</#macro>

<#macro page_body>
    <h1>Basic Page</h1>
    <p>This is the body of the page!</p>
</#macro>

<#macro side_menu>
    <ul class="nav nav-sidebar">
        <li class="active"><a href="/admin/"><i class="fa fa-tachometer fa-fw" aria-hidden="true"></i> Dashboard</a></li>
        <li><a href="/admin/users/"><i class="fa fa-users fa-fw" aria-hidden="true"></i> Users</a></li>
        <li><a href="/admin/games/"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Games</a></li>
        <li><a href="#"><i class="fa fa-euro fa-fw" aria-hidden="true"></i> Wallets</a></li>
        <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">User Operations</li>
        <li><a href="#"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> Play Operations</a></li>
        <li><a href="#"><i class="fa fa-credit-card fa-fw" aria-hidden="true"></i> Credit Operations</a></li>
        <li><a href="#"><i class="fa fa-ticket fa-fw" aria-hidden="true"></i> Buy Operations</a></li>
        <li style="padding: 10px 25px 10px 15px;font-size: 12px; color: #4b646f;">Admin Operations</li>
        <li><a href="#"><i class="fa fa-eye fa-fw" aria-hidden="true"></i> View Operations</a></li>
        <li><a href="#"><i class="fa fa-gamepad fa-fw" aria-hidden="true"></i> Game Operations</a></li>
    </ul>
</#macro>

<#macro navbar>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/admin/"><i class="fa fa-fort-awesome" aria-hidden="true"></i> IWG Admin Panel</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/admin/users/">Users</a></li>
                    <li><a href="/admin/games/">Games</a></li>
                    <li><a href="#">Wallets</a></li>
                    <li><a href="#">Play Operations</a></li>
                    <li><a href="#">Credit Operations</a></li>
                    <li><a href="#">Buy Operations</a></li>
                    <li><a href="#">View Operations</a></li>
                    <li><a href=${logoutUri}>Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
</#macro>

<#macro display_page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <@page_head/>
    </head>

    <body>
        <@navbar/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <@side_menu/>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <div>
                        <@page_body/>
                    </div>
                </div>
            </div>
        </div>
        </body>
    </html>
</#macro>