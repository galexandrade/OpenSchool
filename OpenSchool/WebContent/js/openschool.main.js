$(function(){
    //load_content("modules/home_dashboard.html");
    load_content("modules/live_message.html");
    
    $(".menu_item a").click(function(){
        load_content($(this).attr("href"));
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
