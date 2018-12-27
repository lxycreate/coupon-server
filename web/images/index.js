// 域名加端口号
var base_url = 'http://127.0.0.1:8088';
// 搜索框对象
var vueSearch;
// 筛选条件对象
var js_filter_container;
// 排序方式
var js_sort_way;
//商品列表
var js_goods_area;

//Ajax获取数所需的参数
var search_data = {};


// 初始化函数
window.onload = function () {
    // searchGoods();
    // initGoodsList();

    // 搜索框吸顶
    initScroll();
    // 筛选
    initCatalogBox();
    // 排序
    initSortBtn();
    // 商品列表
    initGoodsList();
    // 窗口大小监听
    watchWindow();
    var s = 'abc';
    console.log('长度：' + s.length);
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

// 筛选对象  开始
function initCatalogBox() {
    // Vue App
    js_filter_container = new Vue({
        el: '.js_filter_container',
        data: {
            // 目录选择
            catalog_name: "分类:",
            catalog_value: '0',
            catalog_items: [{
                    name: "全部", // 目录名
                    value: 1, //目录对应值
                    is_select: true //是否被选中
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
            // 多选筛选条件
            filter_name: '筛选:',
            filter_value: '', //当前(选中/取消)的是哪个,相应的从参数添加/删除
            filter_items: [{
                    name: '淘抢购', //名称   
                    index: 1, //必须使用自定义的index，否则监听filter_value的函数中出现异常出现-0
                    an_name: 'is_qiang', //搜索时的对应的参数名
                    is_select: false, //是否被选中
                    is_small_select: false //是否被选中(中小屏幕)
                }, {
                    name: '聚划算',
                    index: 2,
                    an_name: 'is_ju',
                    is_select: false,
                    is_small_select: false
                },
                {
                    name: '天猫',
                    index: 3,
                    an_name: 'is_tmall',
                    is_select: false,
                    is_small_select: false
                }, {
                    name: '金牌卖家',
                    index: 4,
                    an_name: 'is_gold',
                    is_select: false,
                    is_small_select: false
                }, {
                    name: '极有家',
                    index: 5,
                    an_name: 'is_ji',
                    is_select: false,
                    is_small_select: false
                }, {
                    name: '海淘',
                    index: 6,
                    an_name: 'is_hai',
                    is_select: false,
                    is_small_select: false
                },
                {
                    name: '运费险',
                    index: 7,
                    an_name: 'is_yun',
                    is_select: false,
                    is_small_select: false
                }
            ],
            //更多 筛选条件
            more_filter_name: '更多:',
            //券后价格区间筛选
            quan_item: {
                name: '券后价格区间',
                start_price: '', //最低价
                end_price: '' //最高价
            },
            //评分筛选
            score_item: {
                name: '动态评分≥',
                value: '',
                tip: ' (0分-5分)'
            },
            //销量筛选
            sale_item: {
                name: '总销量≥',
                value: ''
            },
            is_show_confirm: false, //是否显示“清空 确认按钮”
        },
        created: function () {
            // 初始化目录
            this.catalog_value = '1';
        },
        watch: {
            // 监听目录参数
            catalog_value: function () {
                // 参数中添加目录信息
                addProperty('goods_cid', this.catalog_value);
            },
            // 监听筛选参数
            filter_value: function () {
                var index = parseInt(this.filter_value);
                if (index < 0) {
                    index = -index;
                    deleteProperty(this.filter_items[index - 1].an_name);
                } else {
                    addProperty(this.filter_items[index - 1].an_name, '1');
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
            //是否显示隐藏的清空和确认按钮
            isShowConfirmBtn: function () {
                if (this.quan_item.start_price == '' && this.quan_item.end_price == '' && this.sale_item.value == '' && this.score_item.value == '') {
                    this.is_show_confirm = false;
                } else {
                    this.is_show_confirm = true;
                }
            },
            // 单选目录事件
            selectCatalogItem: function (value) {
                this.catalog_value = value;
                for (var i = 0; i < this.catalog_items.length; ++i) {
                    this.catalog_items[i].is_select = false;
                }
                this.catalog_items[value - 1].is_select = true;
            },
            // 多选筛选条件事件
            multiSelect: function (index) {
                // 多选取消选中
                if (this.filter_items[index - 1].is_select) {
                    this.filter_items[index - 1].is_select = false;
                    this.filter_value = "-" + index;
                    if (isMidSmallScreen()) {
                        //小屏幕下选中背景变橙色标志
                        this.filter_items[index - 1].is_small_select = false;
                    }
                }
                // 多选选中
                else {
                    this.filter_items[index - 1].is_select = true;
                    this.filter_value = index;
                    if (isMidSmallScreen()) {
                        this.filter_items[index - 1].is_small_select = true;
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
// 筛选对象  结束

// 排序按钮   开始
function initSortBtn() {
    // Vue App
    js_sort_way = new Vue({
        el: '.js_sort_way',
        data: {
            is_show_side: false, //侧边栏当前是否显示
            sort_item: [{
                name: '综合', //名称
                type: '', //类型
                is_select: true //是否选中
            }, {
                name: '销量',
                type: 'goods_sale',
                is_select: false
                // 销量只有降序排序
            }, {
                name: '价格',
                type: 'goods_price',
                is_select: false,
                is_up: false //升序排序
            }],
            //  列表显示方式
            toggle_list: {
                is_first_icon: true
            }
        },
        methods: {
            // 价格排序
            sortByPrice() {
                this.changeSelectedColor(2);
                this.transformIcon();
                this.sort_item[2].is_up = !this.sort_item[2].is_up;
            },
            //  切换价格排序的icon
            transformIcon() {
                Velocity(this.$refs.js_transform, 'stop');
                if (!this.sort_item[2].is_up) {
                    Velocity(this.$refs.js_transform, {
                        'margin-top': '8px',
                        rotateZ: '-180deg'
                    });
                    // 价格升序排序
                    addProperty('sort', 'price asc');
                } else {
                    Velocity(this.$refs.js_transform, {
                        'margin-top': '12px',
                        rotateZ: '0deg'
                    });
                    // 价格降序排序
                    addProperty('sort', 'price desc');
                }
            },
            // 重置价格排序的icon
            resetPriceIcon: function () {
                Velocity(this.$refs.js_transform, 'stop');
                Velocity(this.$refs.js_transform, {
                    'margin-top': '12px',
                    rotateZ: '0deg'
                });
                this.sort_item[2].is_up = false;
            },
            // 切换列表显示方式
            toggleList: function () {
                this.toggle_list.is_first_icon = !this.toggle_list.is_first_icon;
            },
            // 显示筛选侧边
            showSide: function () {
                if (isMidSmallScreen() && !this.is_show_side) {
                    this.stopSideAnimate();
                    this.is_show_side = true;
                    Velocity(this.$refs.js_confirm_btn, {
                        'margin-left': '-298px'
                    });
                    Velocity(js_filter_container.$refs.js_filter_container, {
                        'margin-left': '-300px'
                    });
                    console.log('显示侧边栏');
                }
            },
            // 隐藏筛选侧边
            hideSide: function () {
                if (isMidSmallScreen() && this.is_show_side) {
                    this.stopSideAnimate();
                    this.is_show_side = false;
                    Velocity(this.$refs.js_confirm_btn, {
                        'margin-left': '5px'
                        // 必须带px单位
                        // 设置为5px而不是0px是为了消除box-shadow的影响(侧边显示一些颜色块)
                    });
                    Velocity(js_filter_container.$refs.js_filter_container, {
                        'margin-left': '5px'
                        // 同上
                    });
                    console.log('隐藏侧边栏');
                }
            },
            // 切换侧边显示状态
            toggleSide: function () {
                if (this.is_show_side) {
                    this.hideSide();
                } else {
                    this.showSide();
                }
            },
            // 停止侧边动画(防止操作频率过快导致异常)
            stopSideAnimate: function () {
                Velocity(this.$refs.js_confirm_btn, 'stop');
                Velocity(js_filter_container.$refs.js_filter_container, 'stop');
            },
            // 切换排序方式
            changeSortWay: function (index, way) {
                this.changeSelectedColor(index);
                addProperty('sort', way);
            },
            // 改变被选中的排序按钮的颜色
            changeSelectedColor: function (index) {
                // 价格图标按钮重置
                if (index != 2) {
                    this.resetPriceIcon();
                }
                for (var i = 0; i < this.sort_item.length; ++i) {
                    this.sort_item[i].is_select = false;
                }
                this.sort_item[index].is_select = true;
            },
            // 清空
            clear: function () {
                js_filter_container.Clear();
            },
            // 确认
            confirm: function () {
                js_filter_container.Confirm();
            }
            // 事件 end
        }
    });
    // Vue App
}
// 排序按钮   结束

//商品列表   开始
function initGoodsList() {
    js_goods_area = new Vue({
        el: ".js_goods_area",
        data: {
            items: [{
                title: "123"
            }]
        }
    });
}
// 商品列表  结束

// 监测窗口大小变化
function watchWindow() {
    checkWindowWidth();
    window.onresize = function () {
        checkWindowWidth();
    }
}

// 判断窗口大小，根据窗口大小显示或隐藏元素
function checkWindowWidth() {
    if (!isMidSmallScreen()) {
        js_filter_container.catalog_name = "分类:";
        js_filter_container.filter_name = "筛选:";

        //虽然实际使用中几乎不存在设备的尺寸突然变大变小(除了开发者模式调试)
        //还是将该元素定位重置
        js_filter_container.$refs.js_filter_container.style.marginLeft = '0px';
        js_sort_way.$refs.js_confirm_btn.style.marginLeft = '0px';
    } else {
        js_filter_container.catalog_name = "分类";
        js_filter_container.filter_name = "筛选";

        //虽然实际使用中几乎不存在设备的尺寸突然变大变小(除了开发者模式调试)
        //还是将该元素定位重置
        // 这里不能将元素定位重置，当弹出输入法框的时候会触发onsize事件，从而调用这个事件
        // 造成侧栏自动隐藏
        // js_sort_way.hideSide();
        //小屏幕就显示列表切换按钮

    }
}

//判断当前是不是中小屏幕
function isMidSmallScreen() {
    var screen_width = document.body.clientWidth;
    if (screen_width >= 992) {
        return false;
    }
    return true;
}

// 鼠标按下事件（显示或隐藏侧边栏）   开始
function mouseDown(event) {
    var point = event || window.event;
    var screen_width = document.body.clientWidth;
    if (screen_width < 992 && screen_width - point.clientX > 300 && event.target != js_sort_way.$refs.js_show_side) {
        console.log('在侧栏外');
        js_sort_way.hideSide();
    }
    if (event.target == js_sort_way.$refs.js_show_side) {
        console.log("单击筛选");
    }
}
// 鼠标按下事件   结束

//添加搜索参数属性
function addProperty(pro_name, pro_value) {
    search_data[pro_name] = pro_value;
    console.log('添加属性：' + pro_name + '  属性值为：' + pro_value);
    console.log(JSON.stringify(search_data));
}

//删除搜索参数中的属性
function deleteProperty(pro_name) {
    if (search_data.hasOwnProperty(pro_name)) {
        delete search_data[pro_name];
        console.log('删除属性' + pro_name);
    }
    console.log(JSON.stringify(search_data));
}

// 搜索商品
function searchGoods() {
    var pageNum = 1;
    var searchWord = 'macbook';
    var sortWay = 'sale_num';
    axios({
        url: base_url + '/getGoods/searchGoods',
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

function test() {
    axios({
        url: base_url + '/test',
        method: 'get',
        params: {
            test: 1
        }
    }).then(function (response) {
        console.log(response);
    }).catch(function (error) {

    });
}