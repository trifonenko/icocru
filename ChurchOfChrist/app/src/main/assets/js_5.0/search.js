$(document).ready(function () {
    $("#searchbtn").click(function () {
        $(".search").toggleClass("search_yes");
    });

    $(".close").click(function () {
        $(".search").toggleClass("search_yes");
    });
	
    $('#search_button').click(function() {
        		// получаем то, что написал пользователь
        		var searchString = $('#search_box').val();
				var range = $('.continput > .forinput > input[type="radio"]:checked').val();
                var trans = $('#translation').val();
				// формируем строку запроса
        		// если searchString не пустая
        	if(searchString) {
            	// делаем ajax запрос
            	$.ajax({
                	type: "POST",
                	url: "../search.php",
					data: {
                        query: searchString,
                        rng: range,
                        trn: trans,
	            },
                // выполнится  до AJAX запроса
                beforeSend: function(html) { 
                    $("#divResult").html('');
                    $("#search_desc").show();
                    $("#span").html(searchString);
               	},
               // выполнится после AJAX запроса
               success: function(html){ 
                    $("#divResult").show();
                    $("#divResult").append(html);
    	       }
    	    });
    	    }
    	    return false;
    	});
});


