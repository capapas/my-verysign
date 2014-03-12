
/** LoadMap
 * @author tesniere.cedric@gmail.com
 *********************************************************/
function loadMap(address, elementId) {

	/* Déclaration des variables  */
	var geocoder = new google.maps.Geocoder();
	var latLng = new google.maps.LatLng(48.8566667, 2.3509871); // Valeur par defaut si l'adresse n'est pas trouvé
	var markers = new Array();
	var i = 0;

	/* Appel au service de geocodage avec l'adresse en paramètre */
	geocoder.geocode( { 'address': address}, function(results, status) {

		/* Si l'adresse a pu être géolocalisée */
		if (status == google.maps.GeocoderStatus.OK) {

			/* Récupération de sa latitude et de sa longitude */
			latLng = results[0].geometry.location;
			map.setCenter(latLng);
				
			/* Affichage du marker */
			var marker = new google.maps.Marker({
				map: map,
				position: latLng,
  				title:"Google Office!"
			});

			/* Permet de supprimer le marker précédemment affiché */
			markers.push(marker);

			if(markers.length > 1)
				markers[(i-1)].setMap(null);
			i++;
		} else {
			alert("Le geocodage pour " + address + " n\'a pu etre effectue pour la raison suivante: " + status);
		}
	});
	'', 'map_container'
	// Option d'affichage de la carte
    var myOptions = {
      zoom: 17,
      center: latLng,
      mapTypeId: google.maps.MapTypeId.HYBRID,
	  mapTypeControlOptions: {
		style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
		position: google.maps.ControlPosition.TOP_CENTER
	  }
    };

    // Affichage de la map
    var map = new google.maps.Map(document.getElementById(elementId),myOptions);

}