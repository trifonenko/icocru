$(document).ready(function () {
    $("#old_books_rmt").click(function () {
        $(".books_nav > .old_books > .list_books").slideToggle("slow");
        $(".books_nav > .old_books > .books_link").toggleClass("books_link_open");
        $(".translation_case").toggleClass("height_3350");
    });
});
$(document).ready(function () {
    $("#new_books_rmt").click(function () {
        $(".books_nav > .new_books > .list_books").slideToggle("slow");
        $(".books_nav > .new_books > .books_link").toggleClass("books_link_open");
        $(".translation_case").toggleClass("height_1500");
    });
});
$(document).ready(function () {
    $("#old_books_rst").click(function () {
        $(".books_nav_rst > .old_books > .list_books").slideToggle("slow");
        $(".books_nav_rst > .old_books > .books_link").toggleClass("books_link_open");
        $(".translation_case").toggleClass("height_3350b");
    });
});
$(document).ready(function () {
    $("#new_books_rst").click(function () {
        $(".books_nav_rst > .new_books > .list_books").slideToggle("slow");
        $(".books_nav_rst > .new_books > .books_link").toggleClass("books_link_open");
        $(".translation_case").toggleClass("height_1500b");
    });
});
$(document).ready(function () {
    $("#translation").click(function () {
        $(".books_nav").toggleClass("display_fx_none");
        $(".books_nav_rst").toggleClass("display_fx_yes");
    });
});