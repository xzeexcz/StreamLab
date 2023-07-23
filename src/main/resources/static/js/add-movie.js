function loadGenres2() {
    $.ajax({
        url: '/genres',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var options = data;


            var container = $('#checkboxContainer');

            var checkboxBlock = $('<div>').addClass('row p-4');
            checkboxBlock.appendTo(container);

            for (var i = 0; i < options.length; i++) {
                var checkboxDiv = $('<div>').addClass('col-lg-12 checkbox-spacing');
                checkboxDiv.appendTo(checkboxBlock);

                var checkbox = $('<input>').addClass('form-check-input');
                checkbox.attr('type', 'checkbox');
                checkbox.attr('name', 'genre');
                checkbox.attr('value', options[i].id);
                checkbox.appendTo(checkboxDiv);

                var label = $('<label>').addClass('form-check-label');
                label.text(options[i].genreName);
                label.appendTo(checkboxDiv);
            }
        }, error: function(xhr, status, error) {
            console.log('AJAX Error: ' + status + ' - ' + error);
        }
    });
}
function addMovie() {
    event.preventDefault();
    var movieUrl = $('#movie-add-url').val();
    var movieRating = $('#movie-add-rating').val();
    var movieRunTime = $('#movie-add-time').val();
    var currentDate = new Date();
    var formattedRunTime = currentDate.toISOString().slice(0, 10) + 'T' + movieRunTime + ':00Z';

    if (movieUrl.trim() === '' || movieRating.trim() === '') {
        alert('Please complete all fields');
        return;
    }

    var ratingRegex = /^\d+(\.\d{1})?$/;
    if (!ratingRegex.test(movieRating)) {
        alert('Pleasy insert rating in X.X format');
        return;
    }

    var selectedGenres = $('input[name="genre"]:checked').map(function() {
        return parseInt($(this).val());
    }).get();



    console.log(selectedGenres);
    console.log(movieRunTime);
    console.log(parseFloat(movieRating));
    console.log(formattedRunTime);

    $.ajax({
        url: '/movie/add-movie/' + encodeURIComponent(movieUrl) + '?genresId='+selectedGenres+'&runtime='+movieRunTime+'&releaseDate='+formattedRunTime+'&rating='+movieRating,
        type: 'POST',
        success: function(response) {
            window.location.href="/movies";
            console.log('Movie added successfully');
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error: ' + status + ' - ' + error);
        }
    });
}


