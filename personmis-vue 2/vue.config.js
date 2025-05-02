module.exports = {
    //在本地会创建一个虚拟服务端，虚拟服务器访问后端的服务器不存在跨域
    devServer: {
      port: 8000,   //如果不设置，默认8080
    },

    //在浏览器地址栏中加项目名，这个可根据需要看是否需要
    publicPath: '/personmis-vue/',
}