<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
<html>
<br><br><br><br>
<h1 align="center">Activity-Misc. Post what you wanna play and find a mate.</h1>

<form  action="PostMisc" method="get">
<table align="center">
<tr><td><h2>I want to <input type="text" name="activity" value="enter activity here"> <input type="text" name="maker" value="enter sub activity here"></h2></td></tr>
<tr><td><h2>on <input type="date" name="date" ></h2></td></tr> 
<tr><td><h2>at <select name="loc">
  <option value="MTCC">MTCC</option>
  <option value="Galvin Library">Galvin Library</option>
  <option value="Keating">Keating</option>
  <option value="Stuart Building">Stuart Builiding</option>
</select></h2></td></tr> 
<tr><td><input type="submit" value="Post and find mates" class="button"></td><tr>
</table>
</form>
<h3 align="center">Other Activities</h3>
<h3 align="center"><a href="Study">Study</a> || <a href="Party">Party</a> || <a href="Movie">Movie</a> || <a href="Play">Sport</a><h3>
<h4 align="center"><a href="Home">Click here to go back to home</a><h4>
<body>

<div id="mySidenav" class="sidenav">
  
  <a href="#">About</a>
  <a href="Play">Play</a>
  <a href="#">Study</a>
  <a href="#">Party</a>
  <a href="#">Movies</a>
</div>



     
</body>
</html> 

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>