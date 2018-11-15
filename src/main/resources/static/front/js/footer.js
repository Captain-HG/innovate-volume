 $(document).ready(function(){
			  $(".OpeningLabs").click(function(){
			
			  	if($(this).find("i").hasClass("layui-icon-triangle-d")){
			  		$(this).find("i").removeClass("layui-icon-triangle-d").addClass("layui-icon-triangle-r");
			  	}else if($(this).find("i").hasClass("layui-icon-triangle-r")){
			  		$(this).find("i").removeClass("layui-icon-triangle-r").addClass("layui-icon-triangle-d");
			  	}
			  $(".menuList").toggle();
			  });
			});