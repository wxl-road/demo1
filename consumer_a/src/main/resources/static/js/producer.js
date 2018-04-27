$(function(){
    var con_hei =document.body.clientHeight - $('#head').height() - $('#foot').height();
    $('#content').height(con_hei);
});
function postData(obj,type){
    var that = $(obj),data = that.prev().innerHTML,count = 6,timer = null;
    var btn = obj.val()
    that.attr('disabled',true);
    that.css('background', '#666');
    clearInterval(timer); //清除计时器
    timer = setInterval(function(){
        if(count>1){
            count--;
            that.val(  count +"s" );
        }else{
            that.attr('disabled',false).css('background', '#3c4a67').val(  "上架" );
            that.on({
                mouseover : function(){
                    that.css('background', '#22304a');
                } ,
                mouseout : function(){
                    that.css('background', '#3c4a67');
                }
            }) ;
            clearInterval(timer); //清除计时器
        }
    },1000);

    if(type == 'a'){
        $.ajax({
            url : '',
            type : 'POST',
            traditional:true,
            cache:false,
            data : {
                data : data,
                operate :"切换"
            },
            success : function(data) {

            },
            error : function() {
                alert('服务器异常请重试！')
            }
        })
    }else{
        $.ajax({
            url : '',
            type : 'POST',
            traditional:true,
            cache:false,
            data : {
                data : data,
                operate :"执行"
            },
            success : function(data) {

            },
            error : function() {
                alert('服务器异常请重试！')
            }
        })
    }

}

