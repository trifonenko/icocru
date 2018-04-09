
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