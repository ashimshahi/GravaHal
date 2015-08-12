$(document).ready(function() {
	$("img").click(function() {
		alert($(this).attr("id"));
        $.ajax({
        	url : "/updateGame",
            data : {
            	changedIndex: $(this).attr("id"),
            	lastState: null
            },
            success : function(responseText) {
                location.reload();
            }
        });
    });
});