function dateFormater(time){
    var day = new Date(time);
    var Year = 0,Month = 0,Day = 0,Hour = 0;
    var CurrentDate = "";
    //初始化时间
    Year = day.getFullYear();//ie火狐下都可以
    Month = day.getMonth() + 1;
    Day = day.getDate();
    Hour = day.getHours();
    // Minute = day.getMinutes();
    // Second = day.getSeconds();
    CurrentDate += Year + "年";
    if (Month >= 10) {
        CurrentDate += Month + "月";
    } else {
        CurrentDate += "0" + Month + "月";
    }
    if (Day >= 10) {
        CurrentDate += Day+ "日 ";
    } else {
        CurrentDate += "0" + Day+ "日 ";
    }
    /*if (Hour >= 10) {
        CurrentDate += Hour + "时";
    } else {
        CurrentDate += "0" + Hour + "时";
    }*/
    return CurrentDate;
}