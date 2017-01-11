$(function(){
    var height = $("#live_message").parent().css("height");
    height = height.replace("px", "");
    height -= 70;
    $("#live_message").css("height", height + "px");
    
    $('.conversation_body').animate({ scrollTop: $(this).height() }, "slow");
    
    $("#live_message .contacts_body .user_list").click(function(){
        $("#live_message .contacts").addClass("hidden-xs");
        $("#live_message .conversation").removeClass("hidden-xs");
    });
    
    $("#live_message .message_header .icon_return").click(function(){
        $("#live_message .contacts").removeClass("hidden-xs");
        $("#live_message .conversation").addClass("hidden-xs");
    });
});
