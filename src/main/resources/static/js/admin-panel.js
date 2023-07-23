function loadVideosForTable() {
    $.ajax({
        url: '/videos/all',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let video = json[i];
                html += `
                <tr>
                <td>${video.videoSnippetDTO.title}</td>
                <td>${video.videoStatisticsDTO.viewsCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td>${video.videoStatisticsDTO.likesCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td><button class="btn btn-sm btn-primary" onclick="openModalVideo('${encodeURIComponent(video.url)}')">EDIT</button></td>
                <td><button class="btn btn-sm btn-danger" onclick="openModalVideoDelete('${encodeURIComponent(video.url)}')">DELETE</button></td>
                </tr>
            `;
            }
            $('#videoTable').html(html);
        }
    });
}

function openModalVideo(url) {
    var videoUrl = decodeURIComponent(url);
    sessionStorage.setItem('video_id', videoUrl);
    var url = '/videos/'+videoUrl;
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(video) {
            $('#editTitleTab').val(video.videoSnippetDTO.title);
            $('#editDescrTab').val(video.videoSnippetDTO.description);
            $('#editLikesTab').val(video.videoStatisticsDTO.likesCount);
            $('#editViewsTab').val(video.videoStatisticsDTO.viewsCount);

            $('#editVideoModal').modal('show');
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function saveChangesVideo() {
    var videoUrl = sessionStorage.getItem('video_id');
    var newVideoTitle = document.getElementById('editTitleTab').value;
    var newVideoDescription = document.getElementById('editDescrTab').value;
    var newVideoViewsCount = document.getElementById('editViewsTab').value;
    var newVideoLikesCount = document.getElementById('editLikesTab').value;

    if (newVideoTitle !== '' && newVideoDescription !== '' && newVideoViewsCount !== '' && newVideoLikesCount !== '') {

        var newInfo = {
            videoTitle: newVideoTitle,
            videoDescription : newVideoDescription,
            videoViewsCount : newVideoViewsCount,
            videoLikesCount : newVideoLikesCount
        }

        $.ajax({
            url: '/videos/update/'+videoUrl,
            type: 'PUT',
            dataType: 'json',
            data: newInfo,
            success: function (response) {
                $('#editVideoModal').modal('hide');
                loadVideosForTable();
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        })
    } else {
        alert('Please, complete all fields!');
    }
}

function loadMoviesForTable() {
    $.ajax({
        url: '/movie/all',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let movie = json[i];
                html += `
                <tr>
                <td>${movie.movieSnippetDTO.title}</td>
                <td>${movie.movieStatisticsDTO.viewsCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td>${movie.movieStatisticsDTO.likesCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td><button class="btn btn-sm btn-primary" onclick="openModalMovie('${encodeURIComponent(movie.movieId)}')">EDIT</button></td>
                <td><button class="btn btn-sm btn-danger" onclick="openModalMovieDelete('${encodeURIComponent(movie.movieId)}')">DELETE</button></td>
                </tr>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#movieTable').html(html);
        }
    });
}
function openModalMovie(movieId) {
    var movieUrl = decodeURIComponent(movieId);
    sessionStorage.setItem('movie_id', movieUrl);
    var url = '/movie/details/'+movieUrl;
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(movie) {
            $('#movieTitleTab').val(movie.movieSnippetDTO.title);
            $('#movieDescrTab').val(movie.movieSnippetDTO.description);
            $('#movieLikesTab').val(movie.movieStatisticsDTO.likesCount);
            $('#movieViewsTab').val(movie.movieStatisticsDTO.viewsCount);

            // Откройте модальное окно
            $('#editMovieModal').modal('show');
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function openModalMovieDelete(movieId) {
    var movieUrl = decodeURIComponent(movieId);
    sessionStorage.setItem('movie_url', movieUrl);
    $('#deleteMovieModal').modal('show');

}
function deleteMovie() {
    var movieUrl = sessionStorage.getItem('movie_url');
    var url2 = '/movie/delete?movie_url='+movieUrl;
    $.ajax({
        url: url2,
        type: 'DELETE',
        dataType: 'text',
        success: function (response) {
            if(response==='Success') {
                $('#deleteMovieModal').modal('hide');
                loadMoviesForTable();
            }
        },
        error: function (error) {
            console.error(error);
        }
    });
}
function openModalVideoDelete(videoId) {
    var videoUrl = decodeURIComponent(videoId);
    sessionStorage.setItem('video_url', videoUrl);
    $('#deleteVideoModal').modal('show');

}
function deleteVideo() {
    var video_id = sessionStorage.getItem('video_url');
    var url2 = '/videos/delete?video_url='+video_id;
    $.ajax({
        url: url2,
        type: 'DELETE',
        dataType: 'text',
        success: function (response) {
            if(response==='Success') {
                $('#deleteVideoModal').modal('hide');
                loadVideosForTable();
            }
        },
        error: function (error) {
            console.error(error);
        }
    });
}

function saveChangesMovie() {
    var movieUrl = sessionStorage.getItem('movie_id');
    var newMovieTitle = document.getElementById('movieTitleTab').value;
    var newMovieDescription = document.getElementById('movieDescrTab').value;
    var newMovieViewsCount = document.getElementById('movieViewsTab').value;
    var newMovieLikesCount = document.getElementById('movieLikesTab').value;

    if (newMovieTitle !== '' && newMovieDescription !== '' && newMovieViewsCount !== '' && newMovieLikesCount !== '') {

        var newInfo = {
            movieTitle: newMovieTitle,
            movieDescription : newMovieDescription,
            movieViewsCount : newMovieViewsCount,
            movieLikesCount : newMovieLikesCount
        }

        $.ajax({
            url: '/movie/update/'+movieUrl,
            type: 'PUT',
            dataType: 'json',
            data: newInfo,
            success: function (response) {
                $('#editMovieModal').modal('hide');
                loadMoviesForTable();
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        })
    } else {
        alert('Please, complete all fields!');
    }
}

function loadUsersForTable() {
    $.ajax({
        url: '/users',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let user = json[i];
                html += `
                <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><button class="btn btn-sm btn-primary" onclick="openRoleModal('${user.email}')"</button>CHANGE ROLES</td>
                                <td><button class="btn btn-sm btn-danger" onclick="openModalUserDelete('${user.email}')" >DELETE</button></td>
                </tr>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#usersTable').html(html);
        }
    });
}
function openRoleModal(userEmail) {
    sessionStorage.setItem('user_id', userEmail);
    $.ajax({
        url: '/users/' + userEmail,
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            var user = json;
            var rolesContainer = $('#rolesContainer');
            rolesContainer.empty();

            var allRoles = ['ROLE_USER', 'ROLE_ADMIN']; // Замените на список всех ролей

            allRoles.forEach(function(role) {
                var roleContainer = $('<div>');
                var checkBox = $('<input type="checkbox">')
                    .attr('name', 'roles')
                    .attr('value', role);

                var hasRole = user.permissions.some(function(permission) {
                    return permission.role === role;
                });

                if (hasRole) {
                    checkBox.prop('checked', true);
                }

                var label = $('<label>').text(role);
                roleContainer.append(checkBox, label);
                rolesContainer.append(roleContainer);
            });

            $('#RoleModal').modal('show');
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}

function updateRolesForUser() {
    var formData = $('#yourFormId').serializeArray();
    var selectedRoles = [];

    formData.forEach(function(field) {
        if (field.name === 'roles' && field.value) {
            selectedRoles.push(field.value);
        }
    });

    if(selectedRoles.length === 0) {
        alert('Please select at least one role');
        return;
    }

    var userId = sessionStorage.getItem('user_id');

    $.ajax({
        url: '/users/'+userId+'/roles',
        type: 'PUT',
        dataType: 'text',
        data: JSON.stringify(selectedRoles),
        contentType : 'application/json',
        success: function (response) {
            if(response === 'Success')
            $('#RoleModal').modal('hide');
        }, error: function (xhr, status, error) {
            console.error(error);
        }
    });
}
function openModalUserDelete(userId) {
    sessionStorage.setItem('user_id', userId);
    $('#DeleteUserModal').modal('show');

}

function deleteUser() {
    var userId = sessionStorage.getItem('user_id');
    $.ajax({
        url: '/users/'+userId+'/delete',
        type: 'DELETE',
        dataType: 'text',
        contentType : 'application/json',
        success: function (response) {
            if(response === 'Success')
                $('#DeleteUserModal').modal('hide');
                loadUsersForTable();
        }, error: function (xhr, status, error) {
            console.error(error);
        }
    });
}

