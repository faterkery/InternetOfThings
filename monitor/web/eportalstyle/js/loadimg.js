// 图片后加载
window.onload = window.onscroll = window.onresize = function() {
    var imgArr = document.getElementsByTagName("img");
    var noLoadingArr = noLoadingImg(imgArr);
    var sTop = document.documentElement.scrollTop || document.body.scrollTop;
    var iHeight = document.documentElement.clientHeight + sTop;
    var iiTop = iiBottom = 0;
    var m = null;
    
    if (noLoadingArr.length) {
        for (var i = 0; i < noLoadingArr.length; i++) {
            m = noLoadingArr[i].parentElement;
            
            iiTop = getHight(m) ;//- 300;
            iiBottom = iiTop + m.offsetHeight;
            if (((iiTop > sTop && iiTop < iHeight) || (iiBottom > sTop && iiBottom < iHeight)) && noLoadingArr[i].getAttribute("loadsrc") != null) {
                loadingImg(i, noLoadingArr)
            }
        }
    }
    function loadingImg(j, noLoadingArr) {
        var opts = null, alpha = 0;
        opts = setInterval(function() {
            noLoadingArr[j].src = noLoadingArr[j].getAttribute("loadsrc");
            noLoadingArr[j].setAttribute("shid", 1);
            alpha += 2;
            if (alpha > 100) {
                alpha = 100
            }
            noLoadingArr[j].style.opacity = alpha / 100;
            noLoadingArr[j].style.filter = "alpha(opacity=" + alpha + ")";
            if (alpha == 100) {
                clearInterval(opts)
            }
        }, 13)
    }
    function noLoadingImg(noLoadingArr) {
        
        var noImg = [];
        for (var i = 0; i < noLoadingArr.length; i++) {
            if (noLoadingArr[i].getAttribute("shid") != 1 && noLoadingArr[i].getAttribute("loadsrc") != null) {
                noImg.push(imgArr[i])
            }
        }
        return noImg
    }
    function getHight(e) {
        return e.offsetTop + (e.offsetParent ? arguments.callee(e.offsetParent) : 0)
    }
};