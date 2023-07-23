function getAllVideos() {
    $.ajax({
        url: '/videos/all',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let video = json[i];
                html += `
              <div class="col-xl-3 col-lg-4 col-md-6" onclick="videoDetails('${encodeURIComponent(video.url)}')">
                <div class="gen-carousel-movies-style-3 movie-grid style-3">
                  <div class="gen-movie-contain">
                    <div class="gen-movie-img">
                      <img src="${video.videoThumbnailsDTO.maxresThumbnail.url}" alt="streamlab-image">
                    </div>
                    <div class="gen-info-contain">
                      <div class="gen-movie-info">
                        <h3><a onclick="videoDetails('${encodeURIComponent(video.url)}')">${video.videoSnippetDTO.title}</a></h3>
                      </div>
                      <div class="gen-movie-meta-holder">
                        <ul>
                          <li>${video.videoSnippetDTO.rating}</li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#videoContainer').html(html);
        }
    });
}
function videoDetails(videoId) {
    sessionStorage.setItem('lol',videoId);
    window.location.href = "/videos/"+videoId + "/details";
}
function getVideoDetails() {
    var videoId = sessionStorage.getItem('lol');
    var url = '/videos/' + videoId;

    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            renderVideoDetails(result);
        }
    });
}

function renderVideoDetails(data) {
    var videoTitle = data.videoSnippetDTO.title;
    var videoViewsCount = data.videoStatisticsDTO.viewsCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    var videoDescription1 = data.videoSnippetDTO.description;
    var videoLikes = data.videoStatisticsDTO.likesCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    $('#videoTitle').text(videoTitle);
    $('#videoViews').text(videoViewsCount);
    $('#videoDescription').html(videoDescription1);
    $('#videoLikes').text(videoLikes);
}

