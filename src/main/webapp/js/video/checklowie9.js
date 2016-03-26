var browser = navigator.appName
var b_version = navigator.appVersion
var version = b_version.split(";");
var trim_Version = version[1].replace(/[ ]/g, "");
if (browser == "Microsoft Internet Explorer") {
    if (trim_Version == "MSIE6.0" || trim_Version == "MSIE7.0" || trim_Version == "MSIE8.0") {
        alert("您的浏览器版本太低，请将浏览器升级到IE9及9以上版本或者安装其他浏览器，获得更好的浏览体验！");
    }
}