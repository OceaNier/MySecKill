function remainTime() {
    var startTime = $("#startTime").html();
    var s1 = new Date(startTime.replace("/-/g", "/"));
    var s2 = new Date();
    var date3 = s1.getTime() - s2.getTime(); //相差时间戳
    if (date3 > 2) {
        $("#buyBtn").attr({"disabled": "disabled"});
        var days = Math.floor(date3 / (24 * 3600 * 1000)); //剩余天数
        var hours = Math.floor(date3 % (24 * 3600 * 1000) / (3600 * 1000)); //剩余小时数
        var minutes = Math.floor(date3 % (3600 * 1000) / (60 * 1000)); //剩余分钟数
        var seconds = Math.floor(date3 % (60 * 1000) / 1000);
        $("#remainTime").html("距离开始剩余：" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒");
        // alert("剩余" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒");}
    } else {
        $("#buyBtn").removeAttr("disabled");
        $("#remainTime").html("");
        remainTime1();
        $.ajax({
            type: "get",
            url: "/pageHomeAction/produceJs",
            success: function (msg) {

            }
        })
    }
}

function remainTime1() {
    var endTime = $("#endTime").html();
    var s1 = new Date(endTime.replace("/-/g", "/"));
    var s2 = new Date();
    var date3 = s1.getTime() - s2.getTime(); //相差时间戳
    if (date3 > 2) {
        var days = Math.floor(date3 / (24 * 3600 * 1000)); //剩余天数
        var hours = Math.floor(date3 % (24 * 3600 * 1000) / (3600 * 1000)); //剩余小时数
        var minutes = Math.floor(date3 % (3600 * 1000) / (60 * 1000)); //剩余分钟数
        var seconds = Math.floor(date3 % (60 * 1000) / 1000);
        $("#remainTime").html("距离结束剩余：" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒");
        // alert("剩余" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒");}
    } else {
        $("#remainTime").html("");
        // $.ajax({
        //     type: "get",
        //     url: "/pageHomeAction/produceJs",
        //     success: function (msg) {
        //
        //     }
        // })
    }
}

setInterval('remainTime()', 500);