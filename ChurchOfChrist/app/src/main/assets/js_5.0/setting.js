$(document).ready(function () {

    
//  Open and Close Share div    
    
    $("sup").on('click', function(){
        $('#share').show(200);
        $('#shareinfo').html('');
        $('main').css('opacity','0.1');
        
    });
    $('#close_share').on('click', function(){
        $('#share').hide(200);
        $('main').css('opacity','1');
     
    });
    
});