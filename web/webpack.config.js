var webpack = require('webpack');

module.exports = {
    //入口文件的配置项
    entry: ["babel-polyfill", "./app/js"],
    //出口文件的配置项
    output: {
        path: './images/build/',
        filename: 'build.js'
    },
    //模块：例如解读CSS,图片如何转换，压缩
    module: {},
    //插件，用于生产模版和各项功能
    plugins: [],
    //配置webpack开发服务功能
    devServer: {}
}