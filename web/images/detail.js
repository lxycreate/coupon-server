// 域名加端口号
var base_url = 'http://localhost:8088';

//搜索框
var js_ceil_box;
//详情区域
var js_mid;

// 初始化函数
window.onload = function () {
    initScroll();
    initMid();
    // getGoodsDetail();
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
        // // 滚动到底部加载更多数据   end
        // 滚动到顶部   start
        // console.log(scroll_top);
        if (scroll_top > window_height) {
            js_mid.is_show_totop = true;
        } else {
            js_mid.is_show_totop = false;
        }
        // 滚动到顶部   end
    }
}

//初始化详情区域
function initMid() {
    js_mid = new Vue({
        el: '.js_mid',
        data: {
            goods_detail: '',
            goods_list: [],
            goods_id: '541108477389',
            is_show_totop: false
        },
        created: function () {
            this.initGoodsDetail();
        },
        methods: {
            initGoodsDetail: function () {
                console.log(window.location.search)
                var temp = decodeURI(window.location.search);
                if (temp != '' && temp != null) {
                    this.goods_id = temp.substring(10, temp.length);
                }
                console.log(this.goods_id);

                // 加上这个后退异常
                // var url = window.location.href;
                // var valiable = url.split('?')[0];
                // window.history.pushState({}, 0, valiable);
                // 加上这个后退异常

                if (this.goods_id != null && this.goods_id != '') {
                    getGoodsDetail(this.goods_id);
                }
            },
            goToDetail: function (goods_id) {
                window.location.href = "detail.html?goods_id=" + goods_id;
                console.log(goods_id);
            },
            scrollToTop: function () {
                Velocity(document.documentElement, 'scroll', {
                    offset: 0
                }, 2000);
            }
            // 
        }
    })
}

//搜索
function search() {
    js_ceil_box.search();
    return false;
}

//获取商品详情
function getGoodsDetail(goods_id) {
    axios({
        url: base_url + '/getGoodsDetail',
        method: 'get',
        params: {
            goods_id: goods_id
        }
    }).then(function (response) {
        if (response != null) {
            loadData(response);
        }
        console.log(response);
    }).catch(function (error) {
        console.log(error);
    });
}

//装填数据
function loadData(response) {
    if (response.data.goods_detail != null) {
        js_mid.goods_detail = response.data.goods_detail;
    }
    if (response.data.goods_list != null) {
        js_mid.goods_list = response.data.goods_list;
    }
}