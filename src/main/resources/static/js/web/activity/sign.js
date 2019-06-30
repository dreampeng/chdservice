//-----------------------------layui start-----------------------------------
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('form', function () {
    let index;
    const form = layui.form;
    form.render();

    let sliarrn = [];
    let $tbody = $('#tbody'),
        wk = true,
        slidate = new Date(),
        _nullnei = '',
        de = slidate.getDate() + 1;
    const monthFirst = new Date(slidate.getFullYear(), parseInt(slidate.getMonth()), 1).getDay();//获取当月的1日等于星期几
    const d = new Date(slidate.getFullYear(), parseInt(slidate.getMonth() + 1), 0); //获取月
    let totalDay = d.getDate();//获取当前月的天数

    //遍历日历网格
    for (index = 1; index <= 6; index++) {
        _nullnei += "<tr>";
        for (let j = 1; j <= 7; j++) {
            _nullnei += '<td></td>';
        }
        _nullnei += "</tr>";
    }
    $tbody.html(_nullnei);

    //遍历网格内容
    const $slitd = $tbody.find("td");
    for (index = 0; index < totalDay; index++) {
        $slitd.eq(index + monthFirst).html("<p>" + parseInt(index + 1) + "</p>")
    }

    Funmore();//已过日期全部标志为未签到
    Funmonth();//查询已签到
    Funback();//给当前日加样式

    function Funback() {
        let temo = $slitd.eq(parseInt(de + monthFirst - 2));
        temo.html("<p><a href='javacript:void(0);'>" + parseInt(de - 1) + "</a></p>");
        temo.on("click", function () {


            if (wk === true) {
                sendAjax("/activity/sign/sign", null, function (retData) {
                    let retCode = retData.code;
                    if (retCode === "0000") {
                        msgInfo("签到成功");
                    } else {
                        msgWarn(retData.msg);
                    }
                    Funmonth();
                }, true);
            }
        });
    }

    function Funmore() {
        for (let i = 0; i < de + monthFirst - 2; i++) {
            $slitd.eq(i).addClass('weiqian')
        }
    }


    function Funmonth() {
        sendAjax("/activity/sign/get", null, function (retData) {
            let retCode = retData.code;
            if (retCode === "0000") {
                sliarrn = retData.data;
            } else {
                msgWarn(retData.msg);
            }
            if (sliarrn.indexOf(parseInt(de - 1).toString()) > -1) {
                let temo = $slitd.eq(parseInt(de + monthFirst - 2));
                temo.html("<p>" + parseInt(de - 1) + "</p>");
                temo.addClass('los');
                temo.unbind("click");
            }
        }, false);
        for (let i = 0; i < totalDay; i++) {
            for (let j = 0; j < sliarrn.length; j++) {
                if (i === sliarrn[j]) {
                    $slitd.eq(i + monthFirst - 1).removeClass('weiqian');
                    $slitd.eq(i + monthFirst - 1).addClass('los');
                }
            }
        }
    }
});