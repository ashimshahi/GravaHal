$(document).ready(function() {
	$("img").click(function() {
		alert($(this).attr("id"));
        $.ajax({
        	url : 'http://localhost/gravaHal/updateGame',
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