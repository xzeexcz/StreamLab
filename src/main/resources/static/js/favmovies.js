function getAllFavMovies() {
    $.ajax({
        url: '/favourites',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            let html = '';
            for (let i = 0; i <= data.length; i++) {
                let favm = data[i];
                html += `
              <div class="col-xl-3 col-lg-4 col-md-6">
                <div class="gen-carousel-movies-style-3 movie-grid style-3">
                  <div class="gen-movie-contain">
                    <div class="gen-movie-img">
                      <img src="${favm.movie.thumbnails.maxresThumbnail.url}" alt="streamlab-image">
                      <div class="gen-movie-add">
                        <div class="wpulike wpulike-heart">
                          <div class="wp_ulike_general_class wp_ulike_is_not_liked">
                            <button type="button" class="wp_ulike_btn wp_ulike_put_image"></button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="gen-info-contain">
                      <div class="gen-movie-info">
                        <h3><a onclick="movieDetails('${encodeURIComponent(favm.movie.movieId)}')">${favm.movie.movieSnippet.title}</a></h3>
                      </div>
                      <div class="gen-movie-meta-holder">
                        <ul>
                          <li>${favm.movie.movieSnippet.rating}</li>
                          <li><a href="action.html"><span>${movie.genres.map(function(genre) {
                    return genre.genreName}).join(', ')}</span></a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#moviesFavContainer').html(html);
        }
    });
}