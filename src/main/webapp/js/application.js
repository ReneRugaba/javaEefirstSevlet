$(document).ready(function(){
       $('input').last().on("click",function(){
            $.ajax({
                url: "books",
                data: $('form').serialize(),
                success: function(result) {
                    $('li').remove()
                   $.each(result,function(i){
                        $('<li>'+result[i].title+'</li>').appendTo("ul")
                   })
                }
            })
       })
})