function daysInMonth(month, year) {
  return new Date(year, month+1, 0).getDate();
}

var weeks = ['周日','周一','周二','周三','周四','周五','周六'];

var year = new Date().getFullYear();
var dayStr = '';
var month = new Date().getMonth();	//获取当前月份

// 每个月的第一天
var firstDay = new Date(year,month,1); 
var dayInMonth = daysInMonth(month,year);
// 每个月的最后一天
var lastDay = new Date(year,month,dayInMonth);

// 第一天星期几(0-6)
var weekday = firstDay.getDay(); 
// 最后一天星期几
var lastDayWeekDay = lastDay.getDay();
// 每一个都是从1号开始
var date = 1;

dayStr += '<tr><td>'+weeks.join('</td><td>') + '</td></tr>';

// 补齐前面的空格
for(var i = 0; i < weekday; i++){
    dayStr +='<td></td>';
}

for(;date <= dayInMonth;date++){
    dayStr +="<td class='data'>"+ date + "</td>";
    weekday++

    if(weekday%7 == 0){
        weekday = 0;
        dayStr ='<tr>'+dayStr+'</tr>';
    }
}

// 补齐后面的空格
for(var j = 0; j < (7 - lastDayWeekDay - 1); j++){
    dayStr += '<td></td>';
}

$('.day').html(dayStr);

$('.data:eq(20)').css({'color':'#fff','background':'#519c4a','display':'flex','flex-direction':'column'});
$('.data:eq(20)').append('<i class="weui-icon-success-no-circle" style="margin-top:-6px;color: #fff;"></i>')