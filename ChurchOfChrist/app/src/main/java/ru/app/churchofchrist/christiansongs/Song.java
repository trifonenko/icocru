package ru.app.churchofchrist.christiansongs;

import ru.app.churchofchrist.R;

/**
 * Шаблон для объектов Song.
 */
class Song {
    private String name;//Имя песни.
    private int textResId;//Текст песни.
    private int chordsResId;//Аккорды.
    private String linkAudio;//Ссылка на аудио;
    private int linkVideo;//Ссылка на видео;
    private static final Song[] arraySongs = {
            new Song("001. Аллилуйя", R.string.text_song_a001, R.string.text_song_a001acc, R.string.text_song_a001vid),
            new Song("002. Аллилуйя, Аллилуйя", R.string.text_song_a002, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("003. Аллилуйя # Hallelujah Леонарда Коэна", R.string.text_song_a003, R.string.text_song_a003acc, R.string.text_song_a003vid),
            new Song("004. Аллилуйя, Воцарился Господь!", R.string.text_song_a004, R.string.text_song_no_acc, R.string.text_song_a004vid),

            new Song("005. Беда приходит к нам", R.string.text_song_b001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("006. Берег", R.string.text_song_b002, R.string.text_song_b002acc, R.string.text_song_no_vid),
            new Song("007. Без Тебя я не смогу", R.string.text_song_b003, R.string.text_song_b003acc, R.string.text_song_b003vid),
            new Song("008. Бежать, чтоб победить", R.string.text_song_b004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("009. Благ наш Господь", R.string.text_song_b005, R.string.text_song_b005acc, R.string.text_song_b005vid),
            new Song("010. Благодарны мы", R.string.text_song_b006, R.string.text_song_b006acc, R.string.text_song_b006vid),
            new Song("011. Благодарю Тебя, Господь мой", R.string.text_song_b007, R.string.text_song_no_acc, R.string.text_song_b007vid),
            new Song("012. Бог Всемогущий", R.string.text_song_b008, R.string.text_song_b008acc, R.string.text_song_b008vid),
            new Song("013. Бог Верный", R.string.text_song_b009, R.string.text_song_no_acc, R.string.text_song_b009vid),
            new Song("014. Бог так любит всех детишек # детская", R.string.text_song_b010, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("015. Бог этого города", R.string.text_song_b011, R.string.text_song_no_acc, R.string.text_song_b011vid),
            new Song("016. Будет с тобой Господь v.1", R.string.text_song_b012, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("017. Будет с тобой Господь v.2", R.string.text_song_b013, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("018. Буду искать я Тебя", R.string.text_song_b014, R.string.text_song_no_acc, R.string.text_song_b014vid),
            new Song("019. Буду славить Тебя", R.string.text_song_b015, R.string.text_song_no_acc, R.string.text_song_b015vid),
            new Song("020. Будь со мной # В любом бою", R.string.text_song_b016, R.string.text_song_b016acc, R.string.text_song_b016vid),
            new Song("021. Будь со мной", R.string.text_song_b017, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("022. Будь со мною, о мой Господь", R.string.text_song_b018, R.string.text_song_no_acc, R.string.text_song_b018vid),
            new Song("023. Будь смел", R.string.text_song_b019, R.string.text_song_no_acc, R.string.text_song_b019vid),
            new Song("024. Будь к нам милостив", R.string.text_song_b020, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("025. Будет всегда Господь", R.string.text_song_b021, R.string.text_song_b021acc, R.string.text_song_no_vid),

            new Song("026. В Его руках", R.string.text_song_v001, R.string.text_song_v001acc, R.string.text_song_no_vid),
            new Song("027. В трепете мы", R.string.text_song_v002, R.string.text_song_no_acc, R.string.text_song_v002vid),
            new Song("028. В Царстве Бога", R.string.text_song_v003, R.string.text_song_v003acc, R.string.text_song_v003vid),
            new Song("029. Вдоль по Виа Долороса", R.string.text_song_v004, R.string.text_song_no_acc, R.string.text_song_v004vid),
            new Song("030. Велик наш Господь v.1", R.string.text_song_v005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("031. Велик наш Господь v.2", R.string.text_song_v006, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("032. Великолепный Бог", R.string.text_song_v007, R.string.text_song_v007acc, R.string.text_song_no_vid),
            new Song("033. Велика среди народов", R.string.text_song_v008, R.string.text_song_v008acc, R.string.text_song_v008vid),
            new Song("034. Вечность", R.string.text_song_v009, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("035. Взываю к Тебе", R.string.text_song_v010, R.string.text_song_no_acc, R.string.text_song_v010vid),
            new Song("036. Вместе с Тобой", R.string.text_song_v011, R.string.text_song_no_acc, R.string.text_song_v011vid),
            new Song("037. Во всех поколениях", R.string.text_song_v012, R.string.text_song_v012acc, R.string.text_song_v012vid),
            new Song("038. Во мне живет Его любовь", R.string.text_song_v013, R.string.text_song_v013acc, R.string.text_song_v013vid),
            new Song("039. Во Христе я все смогу", R.string.text_song_v014, R.string.text_song_no_acc, R.string.text_song_v014vid),
            new Song("040. Вовеки", R.string.text_song_v015, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("041. Воин закаленный", R.string.text_song_v016, R.string.text_song_v016acc, R.string.text_song_v016vid),
            new Song("042. Воспевают все народы", R.string.text_song_v017, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("043. Воспой", R.string.text_song_v018, R.string.text_song_v018acc, R.string.text_song_v018vid),
            new Song("044. Воспрянь, Христов народ!", R.string.text_song_v019, R.string.text_song_no_acc, R.string.text_song_v019vid),
            new Song("045. Вот полночь", R.string.text_song_v020, R.string.text_song_no_acc, R.string.text_song_v020vid),
            new Song("046. Вперед", R.string.text_song_v021, R.string.text_song_no_acc, R.string.text_song_v021vid),
            new Song("047. Всевышнему Слава", R.string.text_song_v022, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("048. Все воины Христа", R.string.text_song_v023, R.string.text_song_v023acc, R.string.text_song_no_vid),
            new Song("049. Всемогущий Бог", R.string.text_song_v024, R.string.text_song_v024acc, R.string.text_song_v024vid),
            new Song("050. Вся земля хвалу поет", R.string.text_song_v025, R.string.text_song_no_acc, R.string.text_song_v025vid),
            new Song("051. Все народы", R.string.text_song_v026, R.string.text_song_v026acc, R.string.text_song_no_vid),

            new Song("052. Главная заповедь", R.string.text_song_g001, R.string.text_song_g001acc, R.string.text_song_g001vid),
            new Song("053. Господу я молюсь", R.string.text_song_g002, R.string.text_song_g002acc, R.string.text_song_g002vid),
            new Song("054. Господь – прибежище наше", R.string.text_song_g003, R.string.text_song_g003acc, R.string.text_song_g003vid),
            new Song("055. Господь, сделал Он # детская", R.string.text_song_g004, R.string.text_song_g004acc, R.string.text_song_no_vid),
            new Song("056. Господь всего", R.string.text_song_g005, R.string.text_song_g005acc, R.string.text_song_g005vid),
            new Song("057. Господь во Своем храме", R.string.text_song_g006, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("058. Господь мой пастух", R.string.text_song_g007, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("059. Господь наш Бог, Тебе поем хвалу", R.string.text_song_g008, R.string.text_song_no_acc, R.string.text_song_g008vid),
            new Song("060. Господь наш Бог - Великий Царь", R.string.text_song_g009, R.string.text_song_no_acc, R.string.text_song_g009vid),
            new Song("061. Господь придет", R.string.text_song_g010, R.string.text_song_no_acc, R.string.text_song_g010vid),

            new Song("062. Да будет Отцу", R.string.text_song_d001, R.string.text_song_d001acc, R.string.text_song_d001vid),
            new Song("063. Да восхвалят Тебя", R.string.text_song_d002, R.string.text_song_d002acc, R.string.text_song_d002vid),
            new Song("064. Давайте вместе мы пойдем", R.string.text_song_d003, R.string.text_song_d003acc, R.string.text_song_d003vid),
            new Song("065. Дай же мне руку", R.string.text_song_d004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("066. Дай мне нести Твой вечный мир", R.string.text_song_d005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("067. Душа воспой", R.string.text_song_d006, R.string.text_song_d006acc, R.string.text_song_no_vid),

            new Song("068. Евангелие", R.string.text_song_e001, R.string.text_song_e001acc, R.string.text_song_e001vid),
            new Song("069. Если кто-нибудь счастлив", R.string.text_song_e002, R.string.text_song_e002acc, R.string.text_song_no_vid),
            new Song("070. Если ты в беде", R.string.text_song_e003, R.string.text_song_e003acc, R.string.text_song_e003vid),
            new Song("071. Есть сила в крови", R.string.text_song_e004, R.string.text_song_e004acc, R.string.text_song_no_vid),

            new Song("072. Жатва велика", R.string.text_song_zh001, R.string.text_song_no_acc, R.string.text_song_zh001vid),
            new Song("073. Жду я", R.string.text_song_zh002, R.string.text_song_zh002acc, R.string.text_song_zh002vid),
            new Song("074. Жизнь у нас одна", R.string.text_song_zh003, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("075. За Твою любовь", R.string.text_song_z001, R.string.text_song_no_acc, R.string.text_song_z001vid),
            new Song("076. За эти слезы", R.string.text_song_z002, R.string.text_song_no_acc, R.string.text_song_z002vid),
            new Song("077. Закон Твоих уст", R.string.text_song_z003, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("078. Здравствуй, Господь!", R.string.text_song_z004, R.string.text_song_z004acc, R.string.text_song_z004vid),

            new Song("079. Ибо так возлюбил Бог этот мир", R.string.text_song_i001, R.string.text_song_no_acc, R.string.text_song_i001vid),
            new Song("080. Из-за любви", R.string.text_song_i002, R.string.text_song_i002acc, R.string.text_song_i002vid),
            new Song("081. Иисус Господь", R.string.text_song_i003, R.string.text_song_no_acc, R.string.text_song_i003vid),
            new Song("082. Иисус, мой Спаситель", R.string.text_song_i004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("083. Имя Твое выше всех", R.string.text_song_i005, R.string.text_song_no_acc, R.string.text_song_i005vid),
            new Song("084. Искал я, искал", R.string.text_song_i006, R.string.text_song_i006acc, R.string.text_song_i006vid),

            new Song("085. Каждый день", R.string.text_song_k001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("086. Как воздух для меня", R.string.text_song_k002, R.string.text_song_k002acc, R.string.text_song_k002vid),
            new Song("087. Как много чудес", R.string.text_song_k003, R.string.text_song_k003acc, R.string.text_song_k003vid),
            new Song("088. Как величественно Имя Твое", R.string.text_song_k004, R.string.text_song_k004acc, R.string.text_song_k004vid),
            new Song("089. Как лань желает", R.string.text_song_k005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("090. Как можно больше", R.string.text_song_k006, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("091. Как славен наш Бог", R.string.text_song_k007, R.string.text_song_k007acc, R.string.text_song_k007vid),
            new Song("092. Когда я поднимаю взор", R.string.text_song_k008, R.string.text_song_k008acc, R.string.text_song_k008vid),
            new Song("093. Когда я с Тобой", R.string.text_song_k009, R.string.text_song_no_acc, R.string.text_song_k009vid),
            new Song("094. К славной земле я иду", R.string.text_song_k010, R.string.text_song_k010acc, R.string.text_song_k010vid),
            new Song("095. Кто хочет иметь друзей # детская", R.string.text_song_k011, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("096. Легенда # Чайковский", R.string.text_song_l001, R.string.text_song_no_acc, R.string.text_song_l001vid),
            new Song("097. Лицом к лицу", R.string.text_song_l002, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("098. Ликуй", R.string.text_song_l003, R.string.text_song_l003acc, R.string.text_song_l003vid),
            new Song("099. Люблю Тебя", R.string.text_song_l004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("100. Любовь Твоя", R.string.text_song_l005, R.string.text_song_l005acc, R.string.text_song_l005vid),
            new Song("101. Любовь Твоя сильна", R.string.text_song_l006, R.string.text_song_no_acc, R.string.text_song_l006vid),
            new Song("102. Любовью Бога", R.string.text_song_l007, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("103. Люди мечты v.1", R.string.text_song_l008, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("104. Люди мечты v.2", R.string.text_song_l009, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("105. Льется ангельская песня", R.string.text_song_l010, R.string.text_song_l010acc, R.string.text_song_l010vid),

            new Song("106. Меня услышал Ты", R.string.text_song_m001, R.string.text_song_m001acc, R.string.text_song_m001vid),
            new Song("107. Меня Господь освободил", R.string.text_song_m002, R.string.text_song_m002acc, R.string.text_song_no_vid),
            new Song("108. Милость Его пребудет вечно", R.string.text_song_m003, R.string.text_song_m003acc, R.string.text_song_m003vid),
            new Song("109. Милости Твоей довольно", R.string.text_song_m004, R.string.text_song_no_acc, R.string.text_song_m004vid),
            new Song("110. Мир царит в моем сердце", R.string.text_song_m005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("111. Много комнат есть # детская", R.string.text_song_m006, R.string.text_song_m006acc, R.string.text_song_no_vid),
            new Song("112. Можно только представить", R.string.text_song_m007, R.string.text_song_no_acc, R.string.text_song_m007vid),
            new Song("113. Мой Бог мне песню поет", R.string.text_song_m008, R.string.text_song_m008acc, R.string.text_song_m008vid),
            new Song("114. Мой Бог превыше всех", R.string.text_song_m009, R.string.text_song_no_acc, R.string.text_song_m009vid),
            new Song("115. Мой Господь дорогой", R.string.text_song_m010, R.string.text_song_m010acc, R.string.text_song_m010vid),
            new Song("116. Мой дом на небесах", R.string.text_song_m011, R.string.text_song_m011acc, R.string.text_song_m011vid),
            new Song("117. Молитва", R.string.text_song_m012, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("118. Молитва за смелость", R.string.text_song_m013, R.string.text_song_no_acc, R.string.text_song_m013vid),
            new Song("119. Молитесь за мир", R.string.text_song_m014, R.string.text_song_m014acc, R.string.text_song_m014vid),
            new Song("120. Молю я Боже", R.string.text_song_m015, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("121. Мир холодным стал", R.string.text_song_m016, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("122. Муж скорбей", R.string.text_song_m017, R.string.text_song_m017acc, R.string.text_song_m017vid),
            new Song("123. Мы с верой победим", R.string.text_song_m018, R.string.text_song_no_acc, R.string.text_song_m018vid),
            new Song("124. Мы солдаты # детская", R.string.text_song_m019, R.string.text_song_m019acc, R.string.text_song_m019vid),

            new Song("125. На горе Господней", R.string.text_song_n001, R.string.text_song_n001acc, R.string.text_song_n001vid),
            new Song("126. На Тебя надежда моя", R.string.text_song_n002, R.string.text_song_n002acc, R.string.text_song_n002vid),
            new Song("127. На крыльях зари", R.string.text_song_n003, R.string.text_song_no_acc, R.string.text_song_n003vid),
            new Song("128. На небесах", R.string.text_song_n004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("129. Начиная новый день", R.string.text_song_n005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("130. Наш Бог – Великий Бог", R.string.text_song_n006, R.string.text_song_n006acc, R.string.text_song_n006vid),
            new Song("131. Наш Бог так велик", R.string.text_song_n007, R.string.text_song_n007acc, R.string.text_song_n007vid),
            new Song("132. Наш Господь", R.string.text_song_n008, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("133. Наш путь на вершину", R.string.text_song_n009, R.string.text_song_n009acc, R.string.text_song_n009vid),
            new Song("134. Не объять Твои небеса", R.string.text_song_n010, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("135. Нет, не найти нам такого друга", R.string.text_song_n011, R.string.text_song_n011acc, R.string.text_song_no_vid),
            new Song("136. Новое сердце", R.string.text_song_n012, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("137. Новая Аллилуйя", R.string.text_song_n013, R.string.text_song_n013acc, R.string.text_song_n013vid),

            new Song("138. О Царстве Бога", R.string.text_song_o001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("139. О, Господь, к Тебе", R.string.text_song_o002, R.string.text_song_o002acc, R.string.text_song_no_vid),
            new Song("140. Облако, радуга # детская", R.string.text_song_o003, R.string.text_song_o003acc, R.string.text_song_no_vid),
            new Song("141. Огонь Духа", R.string.text_song_o004, R.string.text_song_no_acc, R.string.text_song_o004vid),
            new Song("142. Ода к радости", R.string.text_song_o005, R.string.text_song_no_acc, R.string.text_song_o005vid),
            new Song("143. Оживи", R.string.text_song_o006, R.string.text_song_o006acc, R.string.text_song_o006vid),
            new Song("144. Океаны", R.string.text_song_o007, R.string.text_song_o007acc, R.string.text_song_no_vid),
            new Song("145. Окрыленные мечтой", R.string.text_song_o008, R.string.text_song_no_acc, R.string.text_song_o008vid),
            new Song("146. Он вернется вновь за мной", R.string.text_song_o009, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("147. Он Господь", R.string.text_song_o010, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("148. Он сила и песня моя", R.string.text_song_o011, R.string.text_song_o011acc, R.string.text_song_o011vid),
            new Song("149. Он сказал", R.string.text_song_o012, R.string.text_song_o012acc, R.string.text_song_o012vid),
            new Song("150. Осанна в небесах", R.string.text_song_o013, R.string.text_song_o013acc, R.string.text_song_o013vid),
            new Song("151. Отец, я Тебя люблю", R.string.text_song_o014, R.string.text_song_o014acc, R.string.text_song_no_vid),
            new Song("152. Отец святой", R.string.text_song_o015, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("153. Песнь восхваления", R.string.text_song_p001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("154. Песнь побеждающего", R.string.text_song_p002, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("155. Петь, петь, петь", R.string.text_song_p003, R.string.text_song_no_acc, R.string.text_song_p003vid),
            new Song("156. По вере", R.string.text_song_p004, R.string.text_song_p004acc, R.string.text_song_p004vid),
            new Song("157. По всей земле", R.string.text_song_p005, R.string.text_song_no_acc, R.string.text_song_p005vid),
            new Song("158. Победа во Иисусе", R.string.text_song_p006, R.string.text_song_no_acc, R.string.text_song_p006vid),
            new Song("159. Победа, победа", R.string.text_song_p007, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("160. Поем Аллилуйя", R.string.text_song_p008, R.string.text_song_p008acc, R.string.text_song_p008vid),
            new Song("161. Позволь мне быть ближе", R.string.text_song_p009, R.string.text_song_no_acc, R.string.text_song_p009vid),
            new Song("162. Помни Меня", R.string.text_song_p010, R.string.text_song_no_acc, R.string.text_song_p010vid),
            new Song("163. Попутного ветра", R.string.text_song_p011, R.string.text_song_p011acc, R.string.text_song_no_vid),
            new Song("164. Посмотри на небеса", R.string.text_song_p012, R.string.text_song_p012acc, R.string.text_song_p012vid),
            new Song("165. Потому что мы можем любить", R.string.text_song_p013, R.string.text_song_p013acc, R.string.text_song_no_vid),
            new Song("166. Превыше небес", R.string.text_song_p014, R.string.text_song_no_acc, R.string.text_song_p014vid),
            new Song("167. Прекрасна милость", R.string.text_song_p015, R.string.text_song_p015acc, R.string.text_song_p015vid),
            new Song("168. Превыше всего", R.string.text_song_p016, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("169. Приготовь меня", R.string.text_song_p017, R.string.text_song_p017acc, R.string.text_song_p017vid),
            new Song("170. Приготовь мое сердце", R.string.text_song_p018, R.string.text_song_no_acc, R.string.text_song_p018vid),
            new Song("171. Призвание", R.string.text_song_p019, R.string.text_song_no_acc, R.string.text_song_p019vid),
            new Song("172. Прийдите святые", R.string.text_song_p020, R.string.text_song_p020acc, R.string.text_song_p020vid),
            new Song("173. Прославляем мы Царя царей", R.string.text_song_p021, R.string.text_song_p021acc, R.string.text_song_p021vid),
            new Song("174. Пусть бушует шторм", R.string.text_song_p022, R.string.text_song_p022acc, R.string.text_song_no_vid),
            new Song("175. Путь святых", R.string.text_song_p023, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("176. Радуйся мир", R.string.text_song_r001, R.string.text_song_r001acc, R.string.text_song_r001vid),
            new Song("177. Радость, радость", R.string.text_song_r002, R.string.text_song_r002acc, R.string.text_song_no_vid),
            new Song("178. Раcпятие Христа", R.string.text_song_r003, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("179. Решил идти я вслед за Иисусом", R.string.text_song_r004, R.string.text_song_r004acc, R.string.text_song_r004vid),
            new Song("180. Решил идти я вслед за Иисусом v.2", R.string.text_song_r005, R.string.text_song_r005acc, R.string.text_song_no_vid),

            new Song("181. С Тобой", R.string.text_song_s001, R.string.text_song_s001acc, R.string.text_song_no_vid),
            new Song("182. С Тобой я не боюсь", R.string.text_song_s002, R.string.text_song_no_acc, R.string.text_song_s002vid),
            new Song("183. Самый великий", R.string.text_song_s003, R.string.text_song_s003acc, R.string.text_song_s003vid),
            new Song("184. Свет нашей жизни Ты", R.string.text_song_s004, R.string.text_song_no_acc, R.string.text_song_s004vid),
            new Song("185. Свободен я", R.string.text_song_s005, R.string.text_song_s005acc, R.string.text_song_s005vid),
            new Song("186. Свят, свят, свят", R.string.text_song_s006, R.string.text_song_no_acc, R.string.text_song_s006vid),
            new Song("187. Святая ночь", R.string.text_song_s007, R.string.text_song_s007acc, R.string.text_song_s007vid),
            new Song("188. Святый Боже", R.string.text_song_s008, R.string.text_song_no_acc, R.string.text_song_s008vid),
            new Song("189. Сердце мое открой", R.string.text_song_s009, R.string.text_song_s009acc, R.string.text_song_s009vid),
            new Song("190. Скажу о Нем", R.string.text_song_s010, R.string.text_song_no_acc, R.string.text_song_s010vid),
            new Song("191. Скоро, очень скоро", R.string.text_song_s011, R.string.text_song_s011acc, R.string.text_song_s011vid),
            new Song("192. Слава Иисусу", R.string.text_song_s012, R.string.text_song_no_acc, R.string.text_song_s012vid),
            new Song("193. Слава и хвала Тебе, Господь!", R.string.text_song_s013, R.string.text_song_no_acc, R.string.text_song_s013vid),
            new Song("194. Слава Тебе", R.string.text_song_s014, R.string.text_song_s014acc, R.string.text_song_s014vid),
            new Song("195. Слава, слава v.1", R.string.text_song_s015, R.string.text_song_s015acc, R.string.text_song_s015vid),
            new Song("196. Слава, слава v.2", R.string.text_song_s016, R.string.text_song_s016acc, R.string.text_song_s016vid),
            new Song("197. Слава, слава, Аллилуйя", R.string.text_song_s017, R.string.text_song_no_acc, R.string.text_song_s017vid),
            new Song("198. Славим мы Тебя", R.string.text_song_s018, R.string.text_song_no_acc, R.string.text_song_s018vid),
            new Song("199. Славит Душа моя Господа", R.string.text_song_s019, R.string.text_song_s019acc, R.string.text_song_s019vid),
            new Song("200. Славь Душа", R.string.text_song_s020, R.string.text_song_no_acc, R.string.text_song_s020vid),
            new Song("201. Славь Его", R.string.text_song_s021, R.string.text_song_no_acc, R.string.text_song_s021vid),
            new Song("202. Славься Господь", R.string.text_song_s022, R.string.text_song_no_acc, R.string.text_song_s022vid),
            new Song("203. Славьте Бога", R.string.text_song_s023, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("204. Следуй за Мной", R.string.text_song_s024, R.string.text_song_s024acc, R.string.text_song_s024vid),
            new Song("205. Совершенный Бог", R.string.text_song_s025, R.string.text_song_s025acc, R.string.text_song_s025vid),
            new Song("206. Создай во мне v.1", R.string.text_song_s026, R.string.text_song_no_acc, R.string.text_song_s026vid),
            new Song("207. Создай во мне v.2", R.string.text_song_s027, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("208. Создал меня", R.string.text_song_s028, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("209. Спаситель", R.string.text_song_s029, R.string.text_song_s029acc, R.string.text_song_s029vid),
            new Song("210. Спаситель мира", R.string.text_song_s030, R.string.text_song_no_acc, R.string.text_song_s030vid),
            new Song("211. Сто дорог на земле", R.string.text_song_s031, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("212. Строим Царство Бога # детская", R.string.text_song_s032, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("213. Твоя верность велика", R.string.text_song_t001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("214. Тебе мы поем", R.string.text_song_t002, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("215. Тебя лишь душа моя жаждет", R.string.text_song_t003, R.string.text_song_t003acc, R.string.text_song_t003vid),
            new Song("216. Тихая ночь", R.string.text_song_t004, R.string.text_song_t004acc, R.string.text_song_no_vid),
            new Song("217. Только в Боге", R.string.text_song_t005, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("218. Ты всегда со мной", R.string.text_song_t006, R.string.text_song_no_acc, R.string.text_song_t006vid),
            new Song("219. Ты дал нам лучшее", R.string.text_song_t007, R.string.text_song_no_acc, R.string.text_song_t007vid),
            new Song("220. Ты не печалься", R.string.text_song_t008, R.string.text_song_t008acc, R.string.text_song_t008vid),
            new Song("221. Ты со мною", R.string.text_song_t009, R.string.text_song_no_acc, R.string.text_song_t009vid),
            new Song("222. Ты - Святой Бог", R.string.text_song_t010, R.string.text_song_t010acc, R.string.text_song_no_vid),

            new Song("223. У ног Твоих", R.string.text_song_u001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("224. У подножья креста", R.string.text_song_u002, R.string.text_song_u002acc, R.string.text_song_u002vid),
            new Song("225. Узнай моё сердце", R.string.text_song_u003, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("226. Услышь меня", R.string.text_song_u004, R.string.text_song_no_acc, R.string.text_song_no_vid),

            new Song("227. Храню в душе завет Отца", R.string.text_song_kh001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("228. Христа да славит", R.string.text_song_kh002, R.string.text_song_kh002acc, R.string.text_song_kh002vid),

            new Song("229. Целый мир Тебе поёт", R.string.text_song_ts001, R.string.text_song_ts001acc, R.string.text_song_ts001vid),
            new Song("230. Церковь предназначения", R.string.text_song_ts002, R.string.text_song_ts002acc, R.string.text_song_ts002vid),

            new Song("231. Эль Шаддай", R.string.text_song_ee001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("232. Эта сила", R.string.text_song_ee002, R.string.text_song_no_acc, R.string.text_song_ee002vid),
            new Song("233. Это наш день", R.string.text_song_ee003, R.string.text_song_ee003acc, R.string.text_song_ee003vid),

            new Song("234. Я буду ждать", R.string.text_song_ya001, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("235. Я знаю искупитель жив", R.string.text_song_ya002, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("236. Я люблю тебя, Церковь", R.string.text_song_ya003, R.string.text_song_ya003acc, R.string.text_song_ya003vid),
            new Song("237. Я приду на Небесный праздник Твой", R.string.text_song_ya004, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("238. Я спокоен # детская", R.string.text_song_ya005, R.string.text_song_ya005acc, R.string.text_song_no_vid),
            new Song("239. Я строю себе дом", R.string.text_song_ya006, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("240. Я не боюсь", R.string.text_song_ya007, R.string.text_song_no_acc, R.string.text_song_no_vid),
            new Song("241. Я рад, Я рад", R.string.text_song_ya008, R.string.text_song_ya008acc, R.string.text_song_ya008vid),
            new Song("242. Я искал свой путь", R.string.text_song_ya009, R.string.text_song_ya009acc, R.string.text_song_ya009vid),
    };

    private Song(String name, int textResId, int chordsResId, int linkVideo) {
        this.name = name;
        this.textResId = textResId;
        this.chordsResId = chordsResId;
        this.linkVideo = linkVideo;
    }

    //Возвращает список имен песен.
    static String[] getArrayListNameSongs() {
        String[] arrayListNameSongs = new String[arraySongs.length];
        for (int i = 0; i < arrayListNameSongs.length; i++) {
            arrayListNameSongs[i] = arraySongs[i].getName();
        }
        return arrayListNameSongs;
    }

    public String getName() {
        return name;
    }

    public int getText() {
        return textResId;
    }

    static Song[] getArraySongs() {
        return arraySongs;
    }

    int getChordsResId() {
        return chordsResId;
    }

    int getLinkVideo() {
        return linkVideo;
    }
}
