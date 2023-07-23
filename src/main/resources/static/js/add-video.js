function addVideo() {
    event.preventDefault();
    // Получение значений полей из формы
    var videoUrl = $('#video-add-url').val();
    var videoRating = $('#video-add-rating').val();
    var videoRunTime = $('#video-add-time').val();
    // Дата и время текущего момента
    var currentDate = new Date();
    var formattedRunTime = currentDate.toISOString().slice(0, 10) + 'T' + videoRunTime + ':00Z';

    // Проверка заполнения полей
    if (videoUrl.trim() === '' || videoRating.trim() === '') {
        alert('Пожалуйста, заполните все поля');
        return;
    }

    // Проверка формата рейтинга
    var ratingRegex = /^\d+(\.\d{1})?$/;
    if (!ratingRegex.test(videoRating)) {
        alert('Пожалуйста, введите рейтинг в формате X.X');
        return;
    }

    $.ajax({
        url: '/videos/add-video/' + encodeURIComponent(videoUrl) + '?runTime='+videoRunTime+'&releaseDate='+formattedRunTime+'&rating='+videoRating,
        type: 'POST',
        success: function(response) {
            window.location.href="/videos";
            console.log('Video added successfully');
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error: ' + status + ' - ' + error);
        }
    });
}