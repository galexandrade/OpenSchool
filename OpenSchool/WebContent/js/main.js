$(function(){
	load_content("modules/admin_home.html");
	
	$("#menu_home").click(function(){
		load_content("modules/admin_home.html");
	});
	
	$("#menu_message").click(function(){
		load_content("modules/messages.html");
	});
});

function load_content(url_content){
	$.ajax({
		url: url_content,
		dataType: "html",
		success: function(content){
			$(".conteudo_panel .conteudo_panel_int").html(content);
		}
	});
}
