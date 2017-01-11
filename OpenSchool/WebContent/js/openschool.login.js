$(function(){
	$("#input-email").focus();
	
    $("#form-login form").submit(function(){    	
    	$.ajax({
    		url: "http://localhost:8080/OpenSchool/rest/user/authenticate/"+$("#input-email").val()+"/"+$("#input-pass").val()
    	}).done(function(result){
    		if (result == "true")
    			$("#form-login .alert").addClass("hidden");
    		else
    			$("#form-login .alert").removeClass("hidden");
    	});
    	return false;
    });
});
