$(document).ready(function() {
	$("img").click(function() {
        $.ajax({
            data : {
            	changedIndex: $(this).attr("id"),
            },
            success : function(responseText) {
                location.reload();
            }
        });
    });
});