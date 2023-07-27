CREATE TABLE t_movies (
                          id BIGSERIAL NOT NULL,
                          movies_id VARCHAR(255) DEFAULT NULL,
                          movie_snippet_id BIGINT DEFAULT NULL,
                          movie_statistics_id BIGINT DEFAULT NULL,
                          movie_thumbnails_id BIGINT DEFAULT NULL
);

CREATE TABLE t_movies_genres (
                                 movie_id BIGINT NOT NULL,
                                 genres_id BIGINT NOT NULL
);

CREATE TABLE t_movies_snippet (
                                  id BIGSERIAL NOT NULL,
                                  m_snippet_default_audio_lang VARCHAR(255) DEFAULT NULL,
                                  m_snippet_default_lang VARCHAR(255) DEFAULT NULL,
                                  m_snippet_description TEXT DEFAULT NULL,
                                  m_snippet_title VARCHAR(255) DEFAULT NULL,
                                  m_snippet_rating DOUBLE PRECISION DEFAULT NULL,
                                  m_snippet_release_date TIMESTAMP DEFAULT NULL,
                                  m_snippet_runtime TIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE t_movies_statistics (
                                     id BIGSERIAL NOT NULL,
                                     m_statistics_likes_count BIGINT DEFAULT NULL,
                                     m_statistics_views_count BIGINT DEFAULT NULL
);

CREATE TABLE t_permissions (
                               id BIGSERIAL PRIMARY KEY,
                               permission_name VARCHAR(255)
);

CREATE TABLE t_users (
                         id BIGSERIAL PRIMARY KEY ,
                         user_email VARCHAR(255),
                         user_first_name VARCHAR(255),
                         user_last_name VARCHAR(255),
                         user_password VARCHAR(255)
);

CREATE TABLE t_videos (
                          id BIGSERIAL NOT NULL,
                          video_id VARCHAR(255) DEFAULT NULL,
                          t_video_snippet_id BIGINT DEFAULT NULL,
                          t_video_statistics_id BIGINT DEFAULT NULL,
                          t_video_thumbnails_id BIGINT DEFAULT NULL
);

CREATE TABLE t_thumbnail (
                             id BIGSERIAL NOT NULL,
                             thumbnail_height INT DEFAULT NULL,
                             thumbnail_url VARCHAR(255) DEFAULT NULL,
                             thumbnail_width INT DEFAULT NULL
);

CREATE TABLE t_thumbnails (
                              id BIGSERIAL NOT NULL,
                              default_thumbnail_id BIGINT DEFAULT NULL,
                              high_thumbnail_id BIGINT DEFAULT NULL,
                              maxres_thumbnail_id BIGINT DEFAULT NULL,
                              medium_thumbnail_id BIGINT DEFAULT NULL,
                              standard_thumbnail_id BIGINT DEFAULT NULL
);

CREATE TABLE t_users_permissions (
                                     user_id BIGINT,
                                     permissions_id BIGINT
);

CREATE TABLE t_video_snippet (
                                 id BIGSERIAL NOT NULL,
                                 v_snippet_default_audio_lang VARCHAR(20) DEFAULT NULL,
                                 v_snippet_default_lang VARCHAR(20) DEFAULT NULL,
                                 v_snippet_description TEXT DEFAULT NULL,
                                 v_snippet_rating DOUBLE PRECISION DEFAULT NULL,
                                 v_snippet_release_date TIMESTAMP DEFAULT NULL,
                                 v_snippet_runtime TIME DEFAULT CURRENT_TIMESTAMP,
                                 v_snippet_title VARCHAR(200) DEFAULT NULL
);

CREATE TABLE t_video_statistics (
                                    id BIGSERIAL NOT NULL,
                                    v_statistics_likes_count BIGINT DEFAULT NULL,
                                    v_statistics_views_count BIGINT DEFAULT NULL
);

CREATE TABLE t_video_thumbnail (
                                   id BIGSERIAL NOT NULL,
                                   v_thumbnail_height INT DEFAULT NULL,
                                   v_thumbnail_url VARCHAR(255) DEFAULT NULL,
                                   v_thumbnail_width INT DEFAULT NULL
);

CREATE TABLE t_video_thumbnails (
                                    id BIGSERIAL NOT NULL,
                                    v_default_thumbnail_id BIGINT DEFAULT NULL,
                                    v_high_thumbnail_id BIGINT DEFAULT NULL,
                                    v_maxres_thumbnail_id BIGINT DEFAULT NULL,
                                    v_medium_thumbnail_id BIGINT DEFAULT NULL,
                                    v_standard_thumbnail_id BIGINT DEFAULT NULL
);

CREATE TABLE t_genres (
                          id BIGSERIAL NOT NULL,
                          genre_action VARCHAR(20) DEFAULT NULL
);
