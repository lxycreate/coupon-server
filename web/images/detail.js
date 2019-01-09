// 域名加端口号
var base_url = 'http://localhost:8088';

//搜索框
var js_ceil_box;

// 初始化函数
window.onload = function () {
    initScroll();
}

// 滚动事件   开始
function initScroll() {
    js_ceil_box = new Vue({
        el: ".js_ceil_box",
        data: {
            is_fixed: false,
            is_show: true,
            search_word: ""
        },
        methods: {
            search: function () {
                if (this.search_word != '') {
                    window.location.href = "search.html?search=" + encodeURI(this.search_word);
                }
            }
            // 
        }
    });

    // 当搜索框设置为fixed后，控制该元素显示，放在搜索框的位置
    var js_ceil_filler = new Vue({
        el: ".js_ceil_filler",
        data: {
            is_show: false
        }
    });
    window.onscroll = function () {
        // 滚动条距离顶部的高度
        var scroll_top = document.documentElement.scrollTop;
        //  获取屏幕可是宽度
        var client_width = document.documentElement.clientWidth;
        // 搜索框吸顶  start
        if (scroll_top < 100) {
            js_ceil_box.is_fixed = false;
            js_ceil_box.is_show = true;
            js_ceil_filler.is_show = false;
        }

        if (client_width >= 992 && scroll_top >= 100) {
            js_ceil_box.is_fixed = true;
            js_ceil_box.is_show = true;
            js_ceil_filler.is_show = true;
        }
        if (client_width < 992 && scroll_top > 120) {
            js_ceil_box.is_fixed = true;
            js_ceil_box.is_show = false;
            js_ceil_filler.is_show = true;
        }
        // 搜索框吸顶   end

        // // 滚动到底部加载更多数据   start
        // //可视区的高度
        var window_height = document.documentElement.clientHeight;
        // //滚动条的总高度
        // var scroll_height = document.documentElement.scrollHeight;

        // if (scroll_top + window_height + 1 >= scroll_height && js_goods_area.can_ajax && js_goods_area.is_more_goods) {
        //     loadNextPage();
        // }
        // // 滚动到底部加载更多数据   end
        // 滚动到顶部   start
        // if (scroll_top > window_height) {
        //     js_goods_area.is_show_totop = true;
        // } else {
        //     js_goods_area.is_show_totop = false;
        // }
        // 滚动到顶部   end
    }
}

//搜索
function search() {
    js_ceil_box.search();
    return false;
}