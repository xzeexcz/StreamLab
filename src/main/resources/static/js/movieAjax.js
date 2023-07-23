function getAllMovies() {
    $.ajax({
        url: '/movie/all',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            let html = '';
            for (let i = 0; i < data.length; i++) {
                let movie = data[i];
                html += `
              <div class="col-xl-3 col-lg-4 col-md-6" onclick="movieDetails('${encodeURIComponent(movie.movieId)}')">
                <div class="gen-carousel-movies-style-3 movie-grid style-3">
                  <div class="gen-movie-contain">
                    <div class="gen-movie-img">
                      <img src="${movie.thumbnailsDTO.maxresThumbnail.url}" alt="streamlab-image">
                    </div>
                    <div class="gen-info-contain">
                      <div class="gen-movie-info">
                        <h3 ><a onclick="movieDetails('${encodeURIComponent(movie.movieId)}')">${movie.movieSnippetDTO.title}</a></h3>
                      </div>
                      <div class="gen-movie-meta-holder">
                        <ul>
                          <li>${movie.movieSnippetDTO.rating}</li>
                          <li><span class="text-danger" >${movie.genresDTOList.map(function(genre) {
                    return genre.genreName}).join(', ')}</span></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#moviesContainer').html(html);
        }
    });
}
function movieDetails(id) {
    sessionStorage.setItem('movieId', id);
    window.location.href = "/movies/"+id+"/details";
}
function getMovieDetails() {
    var movieId = sessionStorage.getItem('movieId');
    var url = '/movie/details/'+movieId;
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            renderMovieDetails(result);
        }
    });
}
function renderMovieDetails(data) {
    var movieTitle1 = data.movieSnippetDTO.title;
    var movieRating1 = data.movieSnippetDTO.rating;
    var movieViews1 = data.movieStatisticsDTO.viewsCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    var movieLikes1 = data.movieStatisticsDTO.likesCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    var movieDescription1 = data.movieSnippetDTO.description;
    var movieLanguage1 = data.movieSnippetDTO.defaultLanguage;
    var movieAudio1 = data.movieSnippetDTO.defaultAudioLanguage;
    var runTime = formatRunTime(data.movieSnippetDTO.runTime);
    var releaseDate = formatReleaseDate(data.movieSnippetDTO.releaseDate);
    $('#movieTitle').text(movieTitle1);
    $('#movieRating').text(movieRating1);
    $('#movieViews').text(movieViews1);
    $('#movieDescription').text(movieDescription1);
    $('#movieLanguage').text(movieLanguage1);
    $('#movieAudio').text(movieAudio1);
    $('#movieRunTime').text(runTime);
    $('#movieReleaseDate').text(releaseDate);
    $('#movieLikes').text(movieLikes1);
}
 function formatRunTime(runtime) {
     var parts = runtime.split(':');
     var hours = parseInt(parts[0]);
     var minutes = parseInt(parts[1]);

     var formattedTime = hours + 'h ' + minutes + 'min';
     return formattedTime;
 }
 function formatReleaseDate(releaseDate) {
    var date = new Date(releaseDate);
    var option = { day: 'numeric', month: 'short', year: 'numeric' };
    var formatDate = date.toLocaleDateString('en-US', option);
    return formatDate;
 }