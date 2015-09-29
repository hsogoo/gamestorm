var ComponentsEditors = function () {
    
    var handleSummernote = function () {
        $('#summernote').summernote({height: 300});
    }

    return {
        init: function () {
            handleSummernote();
        }
    };

}();