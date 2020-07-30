$(document).ready(function () {
	$("#author_name, #author").val(username);
	
	$("#success").hide();
	
	$("#commentForm").validate({
		rules: {
			title: {
				required: true,
				maxlength: 20
			},
			message: {
				required: true,
				minlength: 50,
				maxlength: 250
			}
		},
		
		messages: {
			title: {
				required: "Please enter title.",
				maxlength: "The maximum charactor is 20."
			},
			message: {
				required: "Please enter article.",
				minlength: "Password must be atlease 50 characters.",
				maxlength: "The maximum charactor is 250."
			}
		},
		submitHandler: function(form) {
			$.ajax({
				type: "POST",
				url: "/api/v1/comments/",
				dataType: 'json',
				data: $("#commentForm").serialize(),
				success: function (response) {
					var response = JSON.stringify(response);
					
					// convert string to JSON
					response = $.parseJSON(response);
					
					console.log(response.status);

					$("#success").show();
					$("#title").val('');
					$("#message").val('');
				},
				error: function (error) {
					console.log(error.status);
					$("#success").hide();
					$("#title").val('');
					$("#message").val('');
				}
			});
		}
	});
});