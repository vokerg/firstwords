insert into questions (id, img_src, audio_src, name) values (1, 'http://www.ap7.ru/wp-content/uploads/2015/07/Novyiy-rossiyskiy-chudo-vertolet.jpg', 'samolet.m4a', 'Вертолет');


insert into questions (id, img_src, audio_src, name) values (2, 'http://in-news.ru/images/stories/news-rasskazova/samolet-shassi.jpg', 'samolet.m4a', 'Самолет');

insert into categories (id, cat_name) values (1, 'Avia');

insert into question_category (id, id_question, id_category)
values (1, 1, 1);


insert into question_category (id, id_question, id_category)
values (2, 2, 1);