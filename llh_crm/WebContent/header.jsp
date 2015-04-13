<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>DROP DOWN MENU BAR</title>
<link href='http://fonts.googleapis.com/css?family=Francois+One' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Days+One' rel='stylesheet' type='text/css'>
<style type="text/css">
*{
	margin-bottom: 0px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	}
body{
	background:url(IMAGES/background.jpg);
	position:fixed;
	height:100%;
	width:100%;
	}
h1{
	color: rgba(255,255,255,1);
	font-family: 'Days One', sans-serif;
	position: relative;
	font-size: 50px;
	top: 41px;
	left: 493px;
	}
ul{
	list-style:none;
	}
#container{
	margin-top: 105px;
	margin-left: 300px;
	height: 50px;
	}
.menu li{
	position:relative;
	float: left;
	
	text-align: center;
	display: block;
	height: 50px;
	width: 150px;
	line-height: 50px;
	border-right: 1px solid rgba(51,51,51,1);
	}
.left{
	border-top-left-radius:50px;
	border-bottom-left-radius:50px;
	}
.right{
	border-top-right-radius:50px;
	border-bottom-right-radius:50px;
	border:0px;
	}

.menu li .sub{
	visibility:hidden;
	}

.menu li:hover .sub{
	visibility: visible;
	}
.fold{
	border-bottom-left-radius:10px;
	border-bottom-right-radius:10px;
	}
.menu li ul li{
	border-top:1px solid rgba(0,0,0,1);
	padding-top:1px;
	transition:all .1s ease 0s;
	}

	
</style>
</head>

<body>
<h1>TECHNO.TUT</h1>
<div id="container">
<ul class="menu">

<li class="left">HOME</li>
<!-----------------------------------end--------------------------------------------------------->
<li>SERVICES
<ul class="sub">
<li>MEDIA</li>
<li>ADVERTISE</li>
<li class="fold">DESG</li>
</ul>
</li>
<!----------------------------------------------------------end1------------------------------------->
<li>PORTFOLIO
<ul class="sub">
<li>MEDIA</li>
<li>ADVERTISE</li>
<li class="fold">DESG</li>
</ul>
</li>

<!----------------------------------------------------------end1------------------------------------->
<li>BLOG
<ul class="sub">
<li>MEDIA</li>
<li>ADVERTISE</li>
<li class="fold">DESG</li>
</ul>
</li>

<!----------------------------------------------------------end1------------------------------------->
<li class="right">CONTACT</li>

<!----------------------------------------------------------end1------------------------------------->
</ul>
</div>


</body>
</html>
