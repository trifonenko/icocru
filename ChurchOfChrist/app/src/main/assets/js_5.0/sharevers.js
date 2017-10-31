$(document).ready(function () {
	   $("sup").click(function(){
    var aa = $(this).attr('id'); // Находим id элемента sup    
	var bb = window.location.pathname + '#' + aa; // bb - это адрес страницы с якорем на элемент с найденным id
	   window.location.replace(bb); // меняем url страницы на новый с якоре
	   $("sup").parent().css({"background-color": "transparent", "padding": "0"}); // сбрасываем стили sup 
	   $("sup:target").parent().css({"background-color": "#E4EDEF", "padding": "10px"}); // устанавливаем новый стиль на активный sup
	var bc = window.location.href; // еще раз уточняем полный url страницы. Зачем? На всякий случай. 
	var cc = 'HTML ссылка: <a href="' + bc + '" target="_blank">Стих из Библии</a>';
	var vv = $(this).parent().html(); // html содержимое родителя sup т.е. содержимое самого отрывка из <p> 
    var nt = $(this).parent().text().replace(/[0-9]/g, ''); // только текст - содержимое родителя sup, убираем номер стиха
        if (nt.length > 30) {
            nt = nt.split(' ',[100]).join(" ");
        } // разделяем строку на слова по признаку пробела, выводим только 5 слов и соединяем их пробелом, а не запятой, как принято по умолчанию
    var book = $(this).parent().siblings('h1').text(); // Находим h1 это имя книги
    var chapter = $(this).parent().prevAll('h4').eq(0).text().replace(/\D/g, ''); // Находим ближайщий вверх h4 это номер главы, оставляем только цифры
    var vers = $(this).text(); // номер стих содержимое <sup>
    var coord = book + ' ' + chapter + ':' + vers; // собираем все вместе
    var newtitle = coord + ' - ' + nt;
		   $('title').text(newtitle); 
		   $("meta[property='og:title']").attr('content',newtitle);
		   $("meta[name='twitter:title']").attr('content',newtitle);
    var dd = "Поделитесь стихом из Библии с друзьями:";
	var ee = 'Адрес ссылки на стих ' + coord + ': ' + bc;
	   $('#shareinfo').prepend('<h4>' + dd + '</h4>' + '<h6>' + coord + '</h6>' + '<blockqoute>' + vv + '</blockqoute>'); // содержимое popup окна
	});
    $("sup:target").parent().css({"background-color": "#E4EDEF", "padding": "10px"}); // стиль для sup:target во вновь открытом окне
});  
