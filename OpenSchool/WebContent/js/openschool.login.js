$(function(){
	try{
		if(window.sessionStorage || window.localStorage){
			if(window.sessionStorage.getItem("user") !== null)
				window.location.href = "index.html";
			else if(window.localStorage.getItem("user") !== null){
				window.sessionStorage.setItem("user", window.localStorage.getItem("user"));
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
    		if (result == "true"){
    			$("#form-login .alert").addClass("hidden");
    			
    			alert($("#remember").is(":checked"));
    			if($("#remember").is(":checked"))
    				window.localStorage.setItem("user", $("#input-email").val());
    			window.sessionStorage.setItem("user", $("#input-email").val());
    			
    			window.location.href = "index.html";
    		}    			
    		else
    			$("#form-login .alert").removeClass("hidden");
    	});
    	return false;
    });
});
