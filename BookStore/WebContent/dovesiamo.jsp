<!DOCTYPE html>
<html lang="en">
<head>
<title>Dove siamo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

#gmap_canvas img {
	max-width: none !important;
	background: none !important
}


</style>
</head>
<body>


	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1><%=getServletContext().getAttribute("azienda")%></h1>
		<p><%=getServletContext().getAttribute("slogan")%></p>
	</div>

	<%@ include file="navbar.jsp"%>


	<div class="container">
		<div class="row">
			<h2>Dove siamo</h2>
			<p>Ci troviamo al centro di Salerno, nei pressi dei principali
				negozi.</p>

			<script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
			<div style='overflow: hidden; height: 440px; width: 700px;'>
				<div id='gmap_canvas' style='height: 440px; width: 700px;'></div>
				<div>
					<small><a href="embedgooglemaps.com/it/">https://embedgooglemaps.com/it/</a></small>
				</div>
				<div>
					<small><a href="http://fbaddlikebutton.com/">fbaddlike
							button</a></small>
				</div>
				
			</div>
			<script type='text/javascript'>
				function init_map() {
					var myOptions = {
						zoom : 16,
						center : new google.maps.LatLng(40.6746969,
								14.771379499999966),
						mapTypeId : google.maps.MapTypeId.ROADMAP
					};
					map = new google.maps.Map(document
							.getElementById('gmap_canvas'), myOptions);
					marker = new google.maps.Marker({
						map : map,
						position : new google.maps.LatLng(40.6746969,
								14.771379499999966)
					});
					infowindow = new google.maps.InfoWindow(
							{
								content : '<strong>Libreria Salernitanas</strong><br>Salerno Corso Vittorio Emanuele 12<br>'
							});
					google.maps.event.addListener(marker, 'click', function() {
						infowindow.open(map, marker);
					});
					infowindow.open(map, marker);
				}
				google.maps.event.addDomListener(window, 'load', init_map);
			</script>


		</div>

	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>
