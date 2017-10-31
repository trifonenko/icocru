 $(document).ready(function(){
    $(".swipe_menu").swipe({
              swipeStatus:function(event, phase, direction, distance, duration, fingers)
                  {
                      if (phase=="move" && direction =="right") {
                           $('.menu-hide').addClass('show');
                            $('.menu_tab').addClass('active');
                           return false;
                      }
                      if (phase=="move" && direction =="left") {
                            $('.menu-hide').removeClass('show');
                            $('.menu_tab').removeClass('active');
                           return false;
                      }
                  }
          }); 
// Open and close menu
  $('.menu_tab').click(function(){
    $('.menu-hide').toggleClass('show');
    $('.menu_tab').toggleClass('active');
  });
  $('a').click(function(){
    $('.menu-hide').removeClass('show');
    $('.menu_tab').removeClass('active');
  });
});

// Hide menu icon on scroll down
var senseSpeed = 3;
var previousScroll = 0;
$(window).scroll(function(event){
   var scroller = $(this).scrollTop();
   if (scroller-senseSpeed > previousScroll){
      $(".menu_tab").css("visibility", "hidden").css("opacity", "0");
      $("#totop img").css("opacity", "0.1");
   } else if (scroller+senseSpeed < previousScroll) {
      $(".menu_tab").css("visibility", "visible").css("opacity", "1");
      $("#totop img").css("opacity", "1");   
   }
   previousScroll = scroller;
});