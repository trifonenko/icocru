$(document).ready(function () {
    $('main > p').each(function(){
        var idsup = $(this).children('sup').attr('id');
        var vsurl = 'https://okbible.ru/books/01_genesis' + '#' + idsup;
        var vers = $(this).text().replace(/[0-9]/g, '');
        var vrs = vers.replace(/\n/g, '');
        var book = $(this).siblings('h1').text(); // Находим h1 это имя книги
        var chapter = $(this).prevAll('h4').eq(0).text().replace(/\D/g, ''); // Находим ближайщий вверх h4 это номер главы
        var numb = $(this).children('sup').text();
        var coord = book + ' ' + chapter + ':' + numb; // собираем все вместе
        $('body').before(coord + '*' + vrs + '*' + vsurl+ '\n');
    });
    $('head').remove();
    $('footer').remove();
    $('body').remove();
    $("br").each(function(){
        $(this).remove();
        });
});
