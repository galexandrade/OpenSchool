$(function(){
	load_content("modules/home_dashboard.html");
        
    $(".menu_item a").click(function(){
        load_content($(this).attr("href"));
        return false;
    });
    
    $("#logout").click(function(){
    	window.sessionStorage.clear();
    	window.localStorage.clear();
    	window.location.href = "login.html";
    	return false;
    });
});

function load_content(url_content){
    $.ajax({
        url: url_content,
        dataType: "html",
        success: function(content){
            $("#page_content").html(content);
        }
    });
} 
