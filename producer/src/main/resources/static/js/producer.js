$(function(){
    var con_hei =document.body.clientHeight - $('#head').height() - $('#foot').height();
    $('#content').height(con_hei);
});
function postData(obj,type){
    var that = $(obj),dat= that.prev().html(),count = 6,timer = null;
    var btn = that.val();
    that.attr('disabled',true);
    that.css('background', '#666');
    clearInterval(timer); //清除计时器
    timer = setInterval(function(){
        if(count>1){
            count--;
            that.val(  count +"s" );
        }else{
            that.attr('disabled',false).css('background', '#3c4a67').val(  btn );
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
            url : 'http://localhost:8081/sendA',
            type : 'POST',
            traditional:true,
            cache:false,
            dataType:'jsonp',
            data : {
                data : dat,
                operate :"切换"
            }
           /* success : function(data) {
                alert('上架成功！')
            },
            error : function() {
                alert('服务器异常请重试！')
            }*/
        })
    }else{
        $.ajax({
            url : 'http://localhost:8081/sendB',
            type : 'POST',
            traditional:true,
            cache:false,
            dataType:'jsonp',
            data : {
                data : dat,
                operate :"执行"
            }
           /* success : function(data) {

            },
            error : function() {
                alert('服务器异常请重试！')
            }*/
        })
    }

}

