INSERT INTO t_genres (id, genre_action)
VALUES
    (1, 'Action'),
    (2, 'Adventure'),
    (3, 'Comedy'),
    (4, 'Horror'),
    (5, 'Drama');
INSERT INTO t_movies_statistics (id, m_statistics_likes_count, m_statistics_views_count)
VALUES
    (5, 78250, 8026088),
    (8, 45150, 8346637),
    (24, 134467, 17869675),
    (25, 145574, 8784886),
    (26, 242608, 23943076);

INSERT INTO t_thumbnail (id, thumbnail_height, thumbnail_url, thumbnail_width)
VALUES
    (21, 90, 'https://i.ytimg.com/vi/QHbihHSABao/default.jpg', 120),
    (22, 360, 'https://i.ytimg.com/vi/QHbihHSABao/hqdefault.jpg', 480),
    (23, 720, 'https://i.ytimg.com/vi/QHbihHSABao/maxresdefault.jpg', 1280),
    (24, 180, 'https://i.ytimg.com/vi/QHbihHSABao/mqdefault.jpg', 320),
    (25, 480, 'https://i.ytimg.com/vi/QHbihHSABao/sddefault.jpg', 640),
    (36, 90, 'https://i.ytimg.com/vi/D6YU5vI_62w/default.jpg', 120),
    (37, 360, 'https://i.ytimg.com/vi/D6YU5vI_62w/hqdefault.jpg', 480),
    (38, 720, 'https://i.ytimg.com/vi/D6YU5vI_62w/maxresdefault.jpg', 1280),
    (39, 180, 'https://i.ytimg.com/vi/D6YU5vI_62w/mqdefault.jpg', 320),
    (40, 480, 'https://i.ytimg.com/vi/D6YU5vI_62w/sddefault.jpg', 640),
    (91, 90, 'https://i.ytimg.com/vi/aF-umPNo1hE/default.jpg', 120),
    (92, 360, 'https://i.ytimg.com/vi/aF-umPNo1hE/hqdefault.jpg', 480),
    (93, 720, 'https://i.ytimg.com/vi/aF-umPNo1hE/maxresdefault.jpg', 1280),
    (94, 180, 'https://i.ytimg.com/vi/aF-umPNo1hE/mqdefault.jpg', 320),
    (95, 480, 'https://i.ytimg.com/vi/aF-umPNo1hE/sddefault.jpg', 640),
    (116, 90, 'https://i.ytimg.com/vi/m-a3hoAjzbM/default.jpg', 120),
    (117, 360, 'https://i.ytimg.com/vi/m-a3hoAjzbM/hqdefault.jpg', 480),
    (118, 720, 'https://i.ytimg.com/vi/m-a3hoAjzbM/maxresdefault.jpg', 1280),
    (119, 180, 'https://i.ytimg.com/vi/m-a3hoAjzbM/mqdefault.jpg', 320),
    (120, 480, 'https://i.ytimg.com/vi/m-a3hoAjzbM/sddefault.jpg', 640),
    (121, 90, 'https://i.ytimg.com/vi/chqJqng2WAs/default.jpg', 120),
    (122, 360, 'https://i.ytimg.com/vi/chqJqng2WAs/hqdefault.jpg', 480),
    (123, 720, 'https://i.ytimg.com/vi/chqJqng2WAs/maxresdefault.jpg', 1280),
    (124, 180, 'https://i.ytimg.com/vi/chqJqng2WAs/mqdefault.jpg', 320),
    (125, 480, 'https://i.ytimg.com/vi/chqJqng2WAs/sddefault.jpg', 640),
    (126, 90, 'https://i.ytimg.com/vi/KnGQOVeWYpI/default.jpg', 120),
    (127, 360, 'https://i.ytimg.com/vi/KnGQOVeWYpI/hqdefault.jpg', 480),
    (128, 720, 'https://i.ytimg.com/vi/KnGQOVeWYpI/maxresdefault.jpg', 1280),
    (129, 180, 'https://i.ytimg.com/vi/KnGQOVeWYpI/mqdefault.jpg', 320),
    (130, 480, 'https://i.ytimg.com/vi/KnGQOVeWYpI/sddefault.jpg', 640);

INSERT INTO t_thumbnails (id, default_thumbnail_id, high_thumbnail_id, maxres_thumbnail_id, medium_thumbnail_id, standard_thumbnail_id)
VALUES
    (5, 21, 22, 23, 24, 25),
    (8, 36, 37, 38, 39, 40),
    (19, 91, 92, 93, 94, 95),
    (24, 116, 117, 118, 119, 120),
    (25, 121, 122, 123, 124, 125),
    (26, 126, 127, 128, 129, 130);

INSERT INTO t_movies_snippet (id, m_snippet_default_audio_lang, m_snippet_default_lang, m_snippet_description, m_snippet_title, m_snippet_rating, m_snippet_release_date, m_snippet_runtime)
VALUES
    (5, 'ru', 'ru', 'Родители Юрия и Виталия Орловых покинули Украину и обосновались в Америке: у них маленький ресторанчик на Брайтон-Бич. Дети же не стремятся идти по родительским стопам. Юрий начинает торговать оружием и с помощью брата быстро завоевывает свое место под солнцем. Но чем выше он поднимается, тем ближе к нему подбирается агент Интерпола.#боевик #зарубежные2021 Подбори фильмов на канале Watch Action Переходи по ссылкам : Watch Action Боевики канала - https://www.youtube.com/watch?v=oHnuQzB8fNw&list=PLYJXCdcmL7DYNPEjjmzzs1Pk3--0XKTkOTOP боевиков канала Watch Action - https://www.youtube.com/watch?v=QHbihHSABao&list=PLYJXCdcmL7DY81SAQKGeSc6SXIps46jKC', 'Оружейный барон', 7.6, '2005-09-16 10:28:06', '01:59:49'),
    (8, 'ru', 'ru', 'Наконец мы приняли решение и запустили новый канал FILMSTER [Shorts], где мы будем выпускать короткометражные фильмы. Но это ещё не всё! Если вы уже сняли свой короткий метр или у вас есть замечательная идея, которую хотели бы реализовать в виде короткометражки, мы готовы помочь. Мы можем отправить ваш фильм на фестиваль или воплотить вашу идею в жизнь. Связаться с нами можно по почте или в телеграме @KinoreelPR. Ждем ваших идей и работ!____ Бадди — красавец и по совместительству мастер на все руки — отправляется чинить ограду в доме бывшего морского пехотинца Уолтера. Из-за внезапно налетевшего урагана Бадди вынужден остаться на ночь в доме Уолтера и его прекрасной но опасной жены. Между хозяином и гостем начинается опасная игра ставка в которой — жизнь.Год: 2018 Страна: СШA Жанр: триллер Режиссер: Стивен С. Кампанелли Сценарист: Ивер Уильям Джаллах Рич РонатПродюсер: Б. Билли Грейф Джастин Бегно Терри БёрдКомпозитор: Джош ЭтчлиАктеры: Николас Кейдж КаДи Стрикленд Люк Бенвард Келси Грэммер Сулай Энао Оливер Тревена  Эмили Мари ПалмерВозрастной рейтинг: 18+#триллер #FLM', 'Хозяин ', 6.1, '2019-12-06 10:28:06', '01:36:58'),
    (24, 'ru', 'ru', 'Наконец мы приняли решение и запустили новый канал FILMSTER [Shorts], где мы будем выпускать короткометражные фильмы. Но это ещё не всё! Если вы уже сняли свой короткий метр или у вас есть замечательная идея, которую хотели бы реализовать в виде короткометражки, мы готовы помочь. Мы можем отправить ваш фильм на фестиваль или воплотить вашу идею в жизнь. Связаться с нами можно по почте или в телеграме @KinoreelPR. Ждем ваших идей и работ!____ «Недотепа!» — так называют Боба Хо соседи не подозревая что на самом деле он — секретный агент. Однажды соседка просит Боба посидеть с ее детишками. Никто не мог подумать что эта затея обернется настоящим кошмаром: один из маленьких подопечных “китайского няня” случайно вводит в компьютер секретный код чем навлекает на голову Боба массу неприятностей. Год: 2009Страна: США Жанр: семейный комедия экшнРежиссер: Брайан ЛевантСценарист: Джонатан Бернштейн Джеймс Грир Грегори ПуарьеПродюсер: Композитор: Дэвид Ньюман Актеры: Джеки Чан Эмбер ВаллеттаВозрастной рейтинг: 6+#семейный #комедия #экшн #PRD #NORUS', 'Шпион по соседству', 5.4, '2023-07-21 12:29:00', '06:29:00'),
    (25, 'ru', 'en', 'Если ты родился во Франции, но c русской душой — ты веришь в дружбу и всегда приходишь на помощь, можешь собрать ППШ с закрытыми глазами и готов на оскорбление ответить ударом в зубы. И даже если ты чистокровный француз, ты знаешь — русские своих не бросают! В главных ролях    Ахмед Силла     Альбан Иванов    Жюдит Эль Зейн    Орнелла Флёри    Амир Эль Касем    Кристиан Бюжо    Давид Салль    Жан-Филипп Риччи    Пьер-Мари Москони   Лоранс Яэль', 'Дружить по-русски! ', 7.1, '2019-09-11 11:55:00', '01:37:34'),
    (26, 'en', 'en', 'Зачётный препод 1 (фильм 2013) смотреть онлайн.Главный герой первой части - опытный мошенник по имени Зеки Мюллер классически оказывается за решеткой после очередного дела. Срок то он отсидел полностью, но после освобождения ему необходимо найти спрятанную на строительной площадке добычу. Каково же удивление бывшего зэка, когда на месте стройки он видит новую действующую школу. Ничего не остается, как найти способ проникнуть в учебное заведение, чтобы отыскать награбленное. Зеки принимает решение устроиться в школу на должность сторожа, но во время собеседования происходит недопонимание между ним и директором, которое приводит к совершенно иному исходу. Теперь Зеки Мюллер будет работать преподавателем в школе, а также классным руководителем весьма сложного 10-Б. Мошеннику теперь придется найти общий язык с неугомонными подростками, не забывая о собственной цели. Название: Fack ju GöhteГод выхода: 2013Актеры: Элиас ЭмБарек, Каролина Херфурт, Катя Риман, Яна Палласке, Алвара Хёфельс, Йелла ХаазеРежиссер: Бора Дагтекин Страна: ГерманияЖанр: Фильмы, Комедии', 'Зачётный препод ', 7.1, '2013-11-07 07:51:00', '01:51:00');

INSERT INTO t_movies (id, movies_id, movie_snippet_id, movie_statistics_id, movie_thumbnails_id)
VALUES
    (5, 'QHbihHSABao', 5, 5, 5),
    (8, 'D6YU5vI_62w', 8, 8, 8),
    (24, 'm-a3hoAjzbM', 24, 24, 24),
    (25, 'chqJqng2WAs', 25, 25, 25),
    (26, 'KnGQOVeWYpI', 26, 26, 26);

INSERT INTO t_movies_genres (movie_id, genres_id)
VALUES
    (5, 3),
    (8, 2),
    (24, 1),
    (24, 3),
    (25, 3),
    (26, 3);

INSERT INTO t_permissions (id, permission_name)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');


INSERT INTO t_users (user_email, user_first_name, user_last_name, user_password)
VALUES
    ('adik@gmail.com', 'Adilzhan', 'Otebekov', '$2a$10$0s8cOGWWn3nD6OfXgwjYTeVKlBTna/ii3B2l1lLVjCT9clmzXaEDu'),
    ('kaira@gmail.com', 'Kairat', 'Muratov', '$2a$10$JnIPQhlyAOkTpzPvRHTSXObR7Um3ygf3GCMRA5NSO0vYEeCIjikFq');

INSERT INTO t_users_permissions (user_id, permissions_id) VALUES
                                                                    (1, 1),
                                                                    (1, 2),
                                                                    (2, 1),
                                                                    (2, 2);

INSERT INTO t_video_snippet (id, v_snippet_default_audio_lang, v_snippet_default_lang, v_snippet_description, v_snippet_rating, v_snippet_release_date, v_snippet_runtime, v_snippet_title)
VALUES
    (2, 'en', 'en', 'Buy Feastables anywhere to get a secret MrBeast video: https://bit.ly/_feastables. Go watch Pete Davidson s new show Bupkis now live on Peacock! https://youtu.be/2x6h2VJ_m-c Check out the all new Icon of the Seas coming 2024: https://bit.ly/Icon_OfThe_Seas Also, check out the ship Harmony of the Seas which is actually 18 floors, not 17! https://bit.ly/Harmony_OfThe_Seas New Merch - https://mrbeast.store SUBSCRIBE OR I TAKE YOUR DOG----------------------------------------------------------------follow all of these or i will kick you• Facebook - https://www.facebook.com/MrBeast6000/• Twitter - https://twitter.com/MrBeast•  Instagram - https://www.instagram.com/mrbeast•  Im Hiring! - https://www.mrbeastjobs.com/--------------------------------------------------------------------', 6.5, '2020-10-20 18:32:33', '12:21:21', '$1 vs $1,000,000,000 Yacht!'),
    (3, 'en-US', 'en', 'New Merch - https://mrbeast.store. SUBSCRIBE OR I TAKE YOUR DOG. Follow all of these or i will kick you• Facebook - https://www.facebook.com/MrBeast6000/• Twitter - https://twitter.com/MrBeast•  Instagram - https://www.instagram.com/mrbeast--------------------------------------------------------------------', 6.5, '2020-10-20 18:32:33', '07:12:34', 'I Got Hunted By The FBI'),
    (5, 'ru', 'en', 'Карта в моем эксклюзивном дизайне и кучей кэшбэка — https://l.tinkoff.ru/marmokju?erid=2VtzqvmiBbh --------------------------------------------------------------------------------------- Главы00:00 Спонсор00:18 Большой брат02:17 Интро 02:37 Опасный квест 13:21 Эффект первого удара14:07 Обезьяны и шахматы 14:52 Маленький человек с большими… 15:53 Блевотные горки 17:05 Монолог 18:26 Рамки 18:45 Бонус 19:21 Рамки 19:31 Еще бонус19:42 Рамки---------------------------------------------------------------------------------------● Дискорд - https://discord.gg/marmok● TikTok - https://www.tiktok.com/@marmok__tiktok● Наш GTA RP сервер https://gta5rp.com/start● Marmok телеграм https://t.me/marmok_yt● Паблик Вконтакте http://vk.com/mr.marmok● Лайв канал http://youtube.com/channel/UCkxpiTIU50N3_dNt4WMMZyw ---------------------------------------------------------------------------------------Трек в конце используется на правах NCS:Track: Moav - I Do not Wanna Know [NCS Release]Music provided by NoCopyrightSounds.Watch: http://ncs.lnk.to/IDWKAT/youtubeFree Download / Stream: http://ncs.io/IDWK---------------------------------------------------------------------------------------Права на фоновую музыку:Production Music courtesy of Epidemic Sound!', 8.8, '2023-07-19 02:02:00', '02:02:00', '(VR) Я прикончил человека-паука [BONELAB и 20+ Модов]'),
    (6, 'en', 'en', 'GRV Filmed & Edited by Gerald Nonato (@geraldnonadoez) Good Times 2023 presented by The Company, WSPA, & AIM Bay Area San Mateo Performing Arts Center 05.27.2023 #vibrvncy www.vibrvncy.com www.youtube.com/vibrvncy  www.facebook.com/vibrvncy instagram @vibrvncytwitter @vibrvncy #goodtimes2023 instagram @companyfam', 8.8, '2023-07-21 11:47:00', '05:47:00', 'GRV | Good Times 2023 [@VIBRVNCY Front Row 4K]'),
    (13, 'en-US', 'en', 'Travis Scott, Live In Los Angeles. Rolling Loud Los Angeles, California 2023.Setlist:0:00 - Hold That Heat 2:16 - Highest In The Room 4:33 - Butterfly Effect 8:04 - The Scotts 9:40 - Stargazing13:58 - Carousel17:00 - Mamacita 18:44 - No Bystanders20:50 - Way Back 24:22 - Praise God25:33 - Upper Echelon 26:21 - Mafia28:56 - Antidote 32:01 - Sicko Mode 35:07 - Goosebumps Find me EVERYWHERE with 1 click: https://linktr.ee/RagerboiJosh.Follow me on Social Media:Instagram: https://www.instagram.com/ragerboijoshTwitter: https://twitter.com/RagerboiJoshTikTok: https://www.tiktok.com/@ragerboijosh Snapchat: https://www.snapchat.com/add/ragerboijosh.Follow and STREAM MY MUSIC:Spotify: https://open.spotify.com/artist/4ScTcqUbkHeQS0SnELCAiNSoundCloud: https://soundcloud.com/ragerboijoshApple Music: https://music.apple.com/us/artist/ragerboi-josh/1639375320 Pandora: https://www.pandora.com/artist/ragerboi-josh/AR7Kkg2fnk73c4k Tidal: https://tidal.com/browse/artist/33806094Deezer: https://www.deezer.com/us/artist/179678057Audiomack: https://audiomack.com/adhdyungboiShazam: https://www.shazam.com/artist/ragerboi-josh/1639375320Amazon Music: https://music.amazon.com/artists/B0B9CK1M2M/ragerboi-josh', 7.4, '2023-07-21 11:54:00', '05:54:00', 'Travis Scott Live @ Rolling Loud LA 2023 [Full Set] (4K60HDR)');

INSERT INTO t_video_statistics (id, v_statistics_likes_count, v_statistics_views_count)
VALUES
    (2, 5049390, 159405188),
    (3, 40332400, 166982811),
    (5, 378964, 5187115),
    (6, 237, 9796),
    (13, 4131, 179955);

INSERT INTO t_video_thumbnail (id, v_thumbnail_height, v_thumbnail_url, v_thumbnail_width)
VALUES
    (6, 90, 'https://i.ytimg.com/vi/48h57PspBec/default.jpg', 120),
    (7, 360, 'https://i.ytimg.com/vi/48h57PspBec/hqdefault.jpg', 480),
    (8, 720, 'https://i.ytimg.com/vi/48h57PspBec/maxresdefault.jpg', 1280),
    (9, 180, 'https://i.ytimg.com/vi/48h57PspBec/mqdefault.jpg', 320),
    (10, 480, 'https://i.ytimg.com/vi/48h57PspBec/sddefault.jpg', 640),
    (11, 90, 'https://i.ytimg.com/vi/hxwpkM5w3Cc/default.jpg', 120),
    (12, 360, 'https://i.ytimg.com/vi/hxwpkM5w3Cc/hqdefault.jpg', 480),
    (13, 720, 'https://i.ytimg.com/vi/hxwpkM5w3Cc/maxresdefault.jpg', 1280),
    (14, 180, 'https://i.ytimg.com/vi/hxwpkM5w3Cc/mqdefault.jpg', 320),
    (15, 480, 'https://i.ytimg.com/vi/hxwpkM5w3Cc/sddefault.jpg', 640),
    (21, 90, 'https://i.ytimg.com/vi/4lLcv16u7po/default.jpg', 120),
    (22, 360, 'https://i.ytimg.com/vi/4lLcv16u7po/hqdefault.jpg', 480),
    (23, 720, 'https://i.ytimg.com/vi/4lLcv16u7po/maxresdefault.jpg', 1280),
    (24, 180, 'https://i.ytimg.com/vi/4lLcv16u7po/mqdefault.jpg', 320),
    (25, 480, 'https://i.ytimg.com/vi/4lLcv16u7po/sddefault.jpg', 640),
    (26, 90, 'https://i.ytimg.com/vi/ONFHf__dtsU/default.jpg', 120),
    (27, 360, 'https://i.ytimg.com/vi/ONFHf__dtsU/hqdefault.jpg', 480),
    (28, 720, 'https://i.ytimg.com/vi/ONFHf__dtsU/maxresdefault.jpg', 1280),
    (29, 180, 'https://i.ytimg.com/vi/ONFHf__dtsU/mqdefault.jpg', 320),
    (30, 480, 'https://i.ytimg.com/vi/ONFHf__dtsU/sddefault.jpg', 640),
    (61, 90, 'https://i.ytimg.com/vi/aF-umPNo1hE/default.jpg', 120),
    (62, 360, 'https://i.ytimg.com/vi/aF-umPNo1hE/hqdefault.jpg', 480),
    (63, 720, 'https://i.ytimg.com/vi/aF-umPNo1hE/maxresdefault.jpg', 1280),
    (64, 180, 'https://i.ytimg.com/vi/aF-umPNo1hE/mqdefault.jpg', 320),
    (65, 480, 'https://i.ytimg.com/vi/aF-umPNo1hE/sddefault.jpg', 640);

INSERT INTO t_video_thumbnails (id, v_default_thumbnail_id, v_high_thumbnail_id, v_maxres_thumbnail_id, v_medium_thumbnail_id, v_standard_thumbnail_id)
VALUES
    (2, 6, 7, 8, 9, 10),
    (3, 11, 12, 13, 14, 15),
    (5, 21, 22, 23, 24, 25),
    (6, 26, 27, 28, 29, 30),
    (13, 61, 62, 63, 64, 65);

INSERT INTO t_videos (id, video_id, t_video_snippet_id, t_video_statistics_id, t_video_thumbnails_id)
VALUES
    (2, '48h57PspBec', 2, 2, 2),
    (3, 'hxwpkM5w3Cc', 3, 3, 3),
    (5, '4lLcv16u7po', 5, 5, 5),
    (6, 'ONFHf__dtsU', 6, 6, 6),
    (13, 'aF-umPNo1hE', 13, 13, 13);
