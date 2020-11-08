function addToTrash(bookId) {
    $.post('ajax/test.html', function (data) {
        $('.result').html(data);
        alert('Загрузка завершена.');
    });

}



