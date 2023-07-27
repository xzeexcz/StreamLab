-- t_genres
ALTER TABLE t_genres
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_movies_statistics
ALTER TABLE t_movies_statistics
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_thumbnail
ALTER TABLE t_thumbnail
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_thumbnails
ALTER TABLE t_thumbnails
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

ALTER TABLE t_thumbnails
    ADD CONSTRAINT FK1u6rgsjxf0t3lmyah6rn6lpok FOREIGN KEY (default_thumbnail_id) REFERENCES t_thumbnail (id),
    ADD CONSTRAINT FK20kamw1vliqfb7twvexu2tpr7 FOREIGN KEY (standard_thumbnail_id) REFERENCES t_thumbnail (id),
    ADD CONSTRAINT FK4tn1jt7cs5e83bnlxniam1neu FOREIGN KEY (medium_thumbnail_id) REFERENCES t_thumbnail (id),
    ADD CONSTRAINT FKgecc1ih0j9wx22bq8114onefd FOREIGN KEY (maxres_thumbnail_id) REFERENCES t_thumbnail (id),
    ADD CONSTRAINT FKppfoy0w4csopg3u7x4s9qenob FOREIGN KEY (high_thumbnail_id) REFERENCES t_thumbnail (id);

-- t_movies_snippet
ALTER TABLE t_movies_snippet
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_movies
ALTER TABLE t_movies
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

ALTER TABLE t_movies
    ADD CONSTRAINT FK28g5aq6usjec3cy8mwuoapvsi FOREIGN KEY (movie_statistics_id) REFERENCES t_movies_statistics (id),
    ADD CONSTRAINT FK71i0ud9ow5hwc6susetlgfoj0 FOREIGN KEY (movie_thumbnails_id) REFERENCES t_thumbnails (id),
    ADD CONSTRAINT FKfxqymeonmms5ns2owpmp1t8qx FOREIGN KEY (movie_snippet_id) REFERENCES t_movies_snippet (id);

-- t_movies_genres
ALTER TABLE t_movies_genres
    ADD CONSTRAINT FKgkmvgig59aoxnfb6eqo6dtpo3 FOREIGN KEY (genres_id) REFERENCES t_genres (id),
    ADD CONSTRAINT FKqdwh35t1n25qhohl9mv5xk7me FOREIGN KEY (movie_id) REFERENCES t_movies (id);

-- t_permissions

-- t_users


-- t_users_permissions
ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK1aqgc2651y14fjqdvq9ytfwc1 FOREIGN KEY (user_id) REFERENCES t_users (id),
    ADD CONSTRAINT FKpmfc242wvr5kwdv44324cdbna FOREIGN KEY (permissions_id) REFERENCES t_permissions (id);

-- t_video_snippet
ALTER TABLE t_video_snippet
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_video_statistics
ALTER TABLE t_video_statistics
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_video_thumbnail
ALTER TABLE t_video_thumbnail
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

-- t_video_thumbnails
ALTER TABLE t_video_thumbnails
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

ALTER TABLE t_video_thumbnails
    ADD CONSTRAINT FK1dt12x0mg2vymyqk3mgpnts6t FOREIGN KEY (v_maxres_thumbnail_id) REFERENCES t_video_thumbnail (id),
    ADD CONSTRAINT FKjo8lqnii7963uedf5ht5eg9q1 FOREIGN KEY (v_medium_thumbnail_id) REFERENCES t_video_thumbnail (id),
    ADD CONSTRAINT FKk159v7ayoc3qimu3lknfddsxy FOREIGN KEY (v_high_thumbnail_id) REFERENCES t_video_thumbnail (id),
    ADD CONSTRAINT FKmnrh8us6quqlwo0b4xqjobky3 FOREIGN KEY (v_standard_thumbnail_id) REFERENCES t_video_thumbnail (id),
    ADD CONSTRAINT FKo6b7ch486t1qmo7chmc3teufp FOREIGN KEY (v_default_thumbnail_id) REFERENCES t_video_thumbnail (id);

-- t_videos
ALTER TABLE t_videos
    ALTER COLUMN id SET DATA TYPE BIGINT,
    ALTER COLUMN id SET NOT NULL,
    ADD PRIMARY KEY (id);

ALTER TABLE t_videos
    ADD CONSTRAINT FK91pioo1nl9pa6ai62xcpbbl10 FOREIGN KEY (t_video_thumbnails_id) REFERENCES t_video_thumbnails (id),
    ADD CONSTRAINT FKdmjh6bvjc4ii7du4wpps055p4 FOREIGN KEY (t_video_statistics_id) REFERENCES t_video_statistics (id),
    ADD CONSTRAINT FKm28e3hsmvuso4ymlfyqgtu2h9 FOREIGN KEY (t_video_snippet_id) REFERENCES t_video_snippet (id);
