// 域名加端口号
var baseUrl = 'http://127.0.0.1:8090';
// 搜索框对象
var vueSearch;
// 商品列表
var vueGoodsLlist;
// 筛选条件对象
var js_filter_container;
// 排序方式
var js_sort_way;
//Ajax参数
var search_data = {};
// 初始化函数
window.onload = function () {
    // searchGoods();
    // initGoodsList();
    initScroll();
    initCatalogBox();
    initSortBtn();
    watchWindow();
}

// 搜索框吸顶   开始
function initScroll() {
    var js_ceil_box = new Vue({
        el: ".js_ceil_box",
        data: {
            is_fixed: false,
            is_show: true,
            searchWord: ""
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
        var scroll_top = document.documentElement.scrollTop || document.body.scrollTop;
        //  获取屏幕可是宽度
        var client_width = document.documentElement.clientWidth || document.body.clientWidth;
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
    }
}
// 搜索框吸顶   结束
// 初始化筛选对象  开始
function initCatalogBox() {
    // Vue App
    js_filter_container = new Vue({
        el: '.js_filter_container',
        data: {
            catalog_name: "分类:",
            catalog_value: '0',
            catalog_items: [{
                    name: "全部",
                    value: 1,
                    is_select: true
                }, {
                    name: "女装",
                    value: 2,
                    is_select: false
                },
                {
                    name: "男装",
                    value: 3,
                    is_select: false
                },
                {
                    name: "内衣",
                    value: 4,
                    is_select: false
                },
                {
                    name: "数码家电",
                    value: 5,
                    is_select: false
                },
                {
                    name: "家具套装",
                    value: 6,
                    is_select: false
                },
                {
                    name: "美食",
                    value: 7,
                    is_select: false
                },
                {
                    name: "美妆个护",
                    value: 8,
                    is_select: false
                },
                {
                    name: "母婴",
                    value: 9,
                    is_select: false
                },
                {
                    name: "鞋包配饰",
                    value: 10,
                    is_select: false
                },
                {
                    name: "文体车品",
                    value: 11,
                    is_select: false
                },
                {
                    name: "其他",
                    value: 12,
                    is_select: false
                }
            ],
            filter_name: '筛选:',
            filter_value: '',
            filter_items: [{
                    name: '淘抢购',
                    value: '1',
                    an_name: 'taoqianggou',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '聚划算',
                    value: '2',
                    an_name: 'juhuasuan',
                    is_select: false,
                    is_small_screen: false
                },
                {
                    name: '天猫',
                    value: '3',
                    an_name: 'is_tmall',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '金牌卖家',
                    value: '4',
                    an_name: 'gold_seller',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '天猫超市',
                    value: '5',
                    an_name: 'chaoshi',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '极有家',
                    value: '6',
                    an_name: 'jiyoujia',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '海淘',
                    value: '7',
                    an_name: 'haitao',
                    is_select: false,
                    is_small_screen: false
                }, {
                    name: '今日发布',
                    value: '8',
                    an_name: 'today',
                    is_select: false,
                    is_small_screen: false
                },
                {
                    name: '运费险',
                    value: '9',
                    an_name: 'yunfeixian',
                    is_select: false,
                    is_small_screen: false
                }
            ],
            more_filter_name: '更多:',
            quan_item: {
                name: '券后价格区间',
                start_price: '',
                end_price: ''
            },
            score_item: {
                name: '动态评分≥',
                value: '',
                tip: ' (0分-5分)'
            },
            sale_item: {
                name: '总销量≥',
                value: ''
            },
            is_show_confirm: false,
            is_show_side: false,
            sort_item: [{
                    name: '综合',
                    value: ''
                }, {
                    name: '最新排序',
                    value: 'new'
                }, {
                    name: '价格升序',
                    value: 'price_asc'
                },
                {
                    name: '价格降序',
                    value: 'price_desc'
                }
            ],
            select_name: '综合',
            is_first: true
        },
        created: function () {
            // 初始化目录
            this.catalog_value = '1';
        },
        watch: {
            catalog_value: function () {
                //    参数中添加目录信息
                search_data.cate_id = this.catalog_value;
                console.log('添加属性' + this.catalog_value);
            },
            filter_value: function () {
                var temp = parseInt(this.filter_value);
                if (temp < 0) {
                    temp = -temp;
                    if (search_data.hasOwnProperty(this.filter_items[temp - 1].an_name)) {
                        delete search_data[this.filter_items[temp - 1].an_name];
                        console.log('删除属性' + this.filter_items[temp - 1].an_name);
                    }
                } else {
                    search_data[this.filter_items[temp - 1].an_name] = '1';
                    console.log('添加属性' + this.filter_items[temp - 1].an_name);
                }
            },
            'quan_item.start_price': function () {
                this.isShowConfirmBtn();
            },
            'quan_item.end_price': function () {
                this.isShowConfirmBtn();
            },
            'sale_item.value': function () {
                this.isShowConfirmBtn();
            },
            'score_item.value': function () {
                this.isShowConfirmBtn();
            }
        },
        methods: {
            isShowConfirmBtn: function () {
                if (this.quan_item.start_price == '' && this.quan_item.end_price == '' && this.sale_item.value == '' && this.score_item.value == '') {
                    this.is_show_confirm = false;
                } else {
                    this.is_show_confirm = true;
                }
            },
            selectCatalogItem: function (index) {
                this.catalog_value = index;
                for (var i = 0; i < this.catalog_items.length; ++i) {
                    this.catalog_items[i].is_select = false;
                }
                this.catalog_items[index - 1].is_select = true;
            },
            multiSelect: function (index) {
                var temp_width = document.body.clientWidth;
                if (this.filter_items[index - 1].is_select) {
                    this.filter_items[index - 1].is_select = false;
                    this.filter_value = "-" + index;
                    if (temp_width <= 991) {
                        this.filter_items[index - 1].is_small_screen = false;
                    }
                } else {
                    this.filter_items[index - 1].is_select = true;
                    this.filter_value = index;
                    if (temp_width <= 991) {
                        this.filter_items[index - 1].is_small_screen = true;
                    }
                }
            },
            clear: function () {
                console.log('Clear');
            },
            confirm: function () {
                console.log('Confirm');
            }
        }
    });
    // Vue App
}
// 初始化筛选对象  结束

// 初始化排序按钮   开始
function initSortBtn() {
    // Vue App
    js_sort_way = new Vue({
        el: '.js_sort_way',
        data: {
            sort_item: [{
                    name: '综合',
                    value: ''
                }, {
                    name: '最新排序',
                    value: 'new'
                }, {
                    name: '价格升序',
                    value: 'price_asc'
                },
                {
                    name: '价格降序',
                    value: 'price_desc'
                }
            ],
            select_name: '综合',
            is_first: true,
            is_toggle_icon: true,
            is_show_toggle: false
        },
        watch: {
            is_toggle_icon: function () {

            }
        },
        methods: {
            clear: function () {
                js_filter_container.Clear();
            },
            confirm: function () {
                js_filter_container.Confirm();
            },
            showSide: function (event) {
                var screen_width = document.body.clientWidth;
                if (screen_width < 992 && !js_filter_container.is_show_side) {
                    this.stopSideAnimate();
                    js_filter_container.is_show_side = true;
                    Velocity(this.$refs.js_confirm_btn, {
                        'margin-left': '-298px',
                    });
                    Velocity(js_filter_container.$refs.js_filter_container, {
                        'margin-left': '-300px'
                    });
                    console.log('显示侧边栏');
                }
            },
            hideSide: function () {
                var screen_width = document.body.clientWidth;
                if (screen_width < 992 && js_filter_container.is_show_side) {
                    this.stopSideAnimate();
                    js_filter_container.is_show_side = false;
                    Velocity(this.$refs.js_confirm_btn, {
                        'margin-left': '5px'
                    });
                    Velocity(js_filter_container.$refs.js_filter_container, {
                        'margin-left': '5px'
                    });
                    console.log('隐藏侧边栏');
                }
            },
            toggleSide: function () {
                if (js_filter_container.is_show_side) {
                    this.hideSide();
                } else {
                    this.showSide();
                }
            },
            stopSideAnimate: function () {
                Velocity(this.$refs.js_confirm_btn, 'stop');
                Velocity(js_filter_container.$refs.js_filter_container, 'stop');
            },
            changeSortWay: function (sort_way) {

            }
        }
    });
    // Vue App
}
// 初始化排序按钮   结束


// 监测窗口大小变化
function watchWindow() {
    checkWindowWidth();
    window.onresize = function () {
        checkWindowWidth();
    }
}

// 判断窗口大小
function checkWindowWidth() {
    var screen_width = document.body.clientWidth;
    if (screen_width >= 992) {
        js_filter_container.catalog_name = "分类:";
        js_filter_container.filter_name = "筛选:";
        js_filter_container.sale_item.name = "总销量≥";
        js_filter_container.score_item.name = "动态评分≥";
        js_sort_way.is_show_toggle = false;
    } else {
        js_filter_container.catalog_name = "分类";
        js_filter_container.filter_name = "筛选";
        js_filter_container.sale_item.name = "总销量";
        js_filter_container.score_item.name = "动态评分";
        js_sort_way.is_show_toggle = true;
    }
}

//初始化商品列表
function initGoodsList() {
    vueSearch = new Vue({
        el: ".js_goods_list",
        data: {
            items: [{
                title: "123"
            }]
        }
    });
}

// 搜索商品
function searchGoods() {
    var pageNum = 1;
    var searchWord = 'macbook';
    var sortWay = 'sale_num';
    axios({
        url: baseUrl + '/getGoods/searchGoods',
        method: 'get',
        params: {
            pageNum: pageNum,
            searchWord: searchWord,
            sortWay: sortWay
        }
    }).then(function (response) {
        console.log(response);
    }).catch(function (error) {

    });
}

// 鼠标按下事件   开始
function mouseDown(event) {
    var point = event || window.event;
    var screen_width = document.body.clientWidth;
    if (screen_width < 992 && screen_width - point.clientX > 300 && event.target != js_sort_way.$refs.show_side) {
        console.log('在侧栏外');
        js_sort_way.hideSide();
    }
    if (event.target == js_sort_way.$refs.show_side) {
        console.log('same');
    }
}
// 鼠标按下事件   结束