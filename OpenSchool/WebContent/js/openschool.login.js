$(function(){
	USER_SESSION = "tokenId";
	try{
		if(window.sessionStorage || window.localStorage){
			if(window.sessionStorage.getItem(USER_SESSION) !== null)
				window.location.href = "index.html";
			else if(window.localStorage.getItem(USER_SESSION) !== null){
				window.sessionStorage.setItem(USER_SESSION, window.localStorage.getItem(USER_SESSION));
				window.location.href = "index.html";
			}				
		}
	}catch(e){
		$("#form-login .alert").removeClass("hidden").find(".message").text("Session Storage not allowed, please, allow it!");
	}	
	
	$("#input-email").focus();
	
    $("#form-login form").submit(function(){    	
    	$.ajax({
    		url: "http://localhost:8080/OpenSchool/rest/user/authenticate/"+$("#input-email").val()+"/"+$("#input-pass").val()
    	}).done(function(result){
    		if (result !== "false"){
    			$("#form-login .alert").addClass("hidden");
    			
    			if($("#remember").is(":checked"))
    				window.localStorage.setItem(USER_SESSION, result);
    			window.sessionStorage.setItem(USER_SESSION, result);
    			
    			window.location.href = "index.html";
    		}    			
    		else
    			$("#form-login .alert").removeClass("hidden");
    	});
    	return false;
    });
});
