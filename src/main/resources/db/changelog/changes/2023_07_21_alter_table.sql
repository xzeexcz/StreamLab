ALTER TABLE `t_genres`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_genres`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;
ALTER TABLE `t_movies_statistics`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_movies_statistics`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;
ALTER TABLE `t_thumbnail`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_thumbnail`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;
COMMIT;
ALTER TABLE `t_thumbnails`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK1u6rgsjxf0t3lmyah6rn6lpok` (`default_thumbnail_id`),
    ADD KEY `FKppfoy0w4csopg3u7x4s9qenob` (`high_thumbnail_id`),
    ADD KEY `FKgecc1ih0j9wx22bq8114onefd` (`maxres_thumbnail_id`),
    ADD KEY `FK4tn1jt7cs5e83bnlxniam1neu` (`medium_thumbnail_id`),
    ADD KEY `FK20kamw1vliqfb7twvexu2tpr7` (`standard_thumbnail_id`);
ALTER TABLE `t_thumbnails`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
ALTER TABLE `t_thumbnails`
    ADD CONSTRAINT `FK1u6rgsjxf0t3lmyah6rn6lpok` FOREIGN KEY (`default_thumbnail_id`) REFERENCES `t_thumbnail` (`id`),
    ADD CONSTRAINT `FK20kamw1vliqfb7twvexu2tpr7` FOREIGN KEY (`standard_thumbnail_id`) REFERENCES `t_thumbnail` (`id`),
    ADD CONSTRAINT `FK4tn1jt7cs5e83bnlxniam1neu` FOREIGN KEY (`medium_thumbnail_id`) REFERENCES `t_thumbnail` (`id`),
    ADD CONSTRAINT `FKgecc1ih0j9wx22bq8114onefd` FOREIGN KEY (`maxres_thumbnail_id`) REFERENCES `t_thumbnail` (`id`),
    ADD CONSTRAINT `FKppfoy0w4csopg3u7x4s9qenob` FOREIGN KEY (`high_thumbnail_id`) REFERENCES `t_thumbnail` (`id`);
COMMIT;
ALTER TABLE `t_movies_snippet`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_movies_snippet`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;
ALTER TABLE `t_movies`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKfxqymeonmms5ns2owpmp1t8qx` (`movie_snippet_id`),
    ADD KEY `FK28g5aq6usjec3cy8mwuoapvsi` (`movie_statistics_id`),
    ADD KEY `FK71i0ud9ow5hwc6susetlgfoj0` (`movie_thumbnails_id`);
ALTER TABLE `t_movies`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
ALTER TABLE `t_movies`
    ADD CONSTRAINT `FK28g5aq6usjec3cy8mwuoapvsi` FOREIGN KEY (`movie_statistics_id`) REFERENCES `t_movies_statistics` (`id`),
    ADD CONSTRAINT `FK71i0ud9ow5hwc6susetlgfoj0` FOREIGN KEY (`movie_thumbnails_id`) REFERENCES `t_thumbnails` (`id`),
    ADD CONSTRAINT `FKfxqymeonmms5ns2owpmp1t8qx` FOREIGN KEY (`movie_snippet_id`) REFERENCES `t_movies_snippet` (`id`);
COMMIT;
ALTER TABLE `t_movies_genres`
    ADD KEY `FKgkmvgig59aoxnfb6eqo6dtpo3` (`genres_id`),
    ADD KEY `FKqdwh35t1n25qhohl9mv5xk7me` (`movie_id`);
ALTER TABLE `t_movies_genres`
    ADD CONSTRAINT `FKgkmvgig59aoxnfb6eqo6dtpo3` FOREIGN KEY (`genres_id`) REFERENCES `t_genres` (`id`),
    ADD CONSTRAINT `FKqdwh35t1n25qhohl9mv5xk7me` FOREIGN KEY (`movie_id`) REFERENCES `t_movies` (`id`);
COMMIT;
ALTER TABLE `t_permissions`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_permissions`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;
ALTER TABLE `t_users`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_users`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;
ALTER TABLE `t_users_permissions`
    ADD KEY `FKpmfc242wvr5kwdv44324cdbna` (`permissions_id`),
    ADD KEY `FK1aqgc2651y14fjqdvq9ytfwc1` (`user_id`);
ALTER TABLE `t_users_permissions`
    ADD CONSTRAINT `FK1aqgc2651y14fjqdvq9ytfwc1` FOREIGN KEY (`user_id`) REFERENCES `t_users` (`id`),
    ADD CONSTRAINT `FKpmfc242wvr5kwdv44324cdbna` FOREIGN KEY (`permissions_id`) REFERENCES `t_permissions` (`id`);
COMMIT;
ALTER TABLE `t_video_snippet`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_video_snippet`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;
ALTER TABLE `t_video_statistics`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_video_statistics`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;
ALTER TABLE `t_video_thumbnail`
    ADD PRIMARY KEY (`id`);
ALTER TABLE `t_video_thumbnail`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;
COMMIT;
ALTER TABLE `t_video_thumbnails`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKo6b7ch486t1qmo7chmc3teufp` (`v_default_thumbnail_id`),
    ADD KEY `FKk159v7ayoc3qimu3lknfddsxy` (`v_high_thumbnail_id`),
    ADD KEY `FK1dt12x0mg2vymyqk3mgpnts6t` (`v_maxres_thumbnail_id`),
    ADD KEY `FKjo8lqnii7963uedf5ht5eg9q1` (`v_medium_thumbnail_id`),
    ADD KEY `FKmnrh8us6quqlwo0b4xqjobky3` (`v_standard_thumbnail_id`);
ALTER TABLE `t_video_thumbnails`
    ADD CONSTRAINT `FK1dt12x0mg2vymyqk3mgpnts6t` FOREIGN KEY (`v_maxres_thumbnail_id`) REFERENCES `t_video_thumbnail` (`id`),
    ADD CONSTRAINT `FKjo8lqnii7963uedf5ht5eg9q1` FOREIGN KEY (`v_medium_thumbnail_id`) REFERENCES `t_video_thumbnail` (`id`),
    ADD CONSTRAINT `FKk159v7ayoc3qimu3lknfddsxy` FOREIGN KEY (`v_high_thumbnail_id`) REFERENCES `t_video_thumbnail` (`id`),
    ADD CONSTRAINT `FKmnrh8us6quqlwo0b4xqjobky3` FOREIGN KEY (`v_standard_thumbnail_id`) REFERENCES `t_video_thumbnail` (`id`),
    ADD CONSTRAINT `FKo6b7ch486t1qmo7chmc3teufp` FOREIGN KEY (`v_default_thumbnail_id`) REFERENCES `t_video_thumbnail` (`id`);
COMMIT;
ALTER TABLE `t_videos`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKm28e3hsmvuso4ymlfyqgtu2h9` (`t_video_snippet_id`),
    ADD KEY `FKdmjh6bvjc4ii7du4wpps055p4` (`t_video_statistics_id`),
    ADD KEY `FK91pioo1nl9pa6ai62xcpbbl10` (`t_video_thumbnails_id`);
ALTER TABLE `t_videos`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
ALTER TABLE `t_videos`
    ADD CONSTRAINT `FK91pioo1nl9pa6ai62xcpbbl10` FOREIGN KEY (`t_video_thumbnails_id`) REFERENCES `t_video_thumbnails` (`id`),
    ADD CONSTRAINT `FKdmjh6bvjc4ii7du4wpps055p4` FOREIGN KEY (`t_video_statistics_id`) REFERENCES `t_video_statistics` (`id`),
    ADD CONSTRAINT `FKm28e3hsmvuso4ymlfyqgtu2h9` FOREIGN KEY (`t_video_snippet_id`) REFERENCES `t_video_snippet` (`id`);
COMMIT;

