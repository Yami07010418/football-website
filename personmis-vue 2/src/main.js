// 引入createApp函数
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/lib/theme-chalk/index.css'
//引入图标
//import * as ElementPlusIconsVue from '@element-plus/icons-vue'

//创建vue实例
const vapp = createApp(App)
//设置反向代理，前端请求默认发送到 http://localhost:8443/personmis
//axios设置这样和后台进行数据交互
const axios = require('axios')//使用 axios 来完成 ajax 请求。
//全局注册，之后可在其他组件中通过 this.$axios 发送数据
axios.defaults.baseURL = 'http://localhost:8443/personmis'
//axios挂载到vue实例
vapp.config.globalProperties.$axios = axios
//注册所有图标
// for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
//   vapp.component(key, component)
// }
// 挂载到app上index.html里面的app
vapp.use(ElementPlus).use(store).use(router).mount('#app')
vapp.prototype.$hostURL='http://localhost:8443'
//验证是否登录
//钩子函数系统调用路由跳转前系统主动调用
//如果没登录的话要进行验证登陆之后跳转到要进入的页面
router.beforeEach((to,from,next)=>{
    //如果路由器需要验证
    if(!to.matched.some(m=>m.meta.auth)){
      //对路由进行验证
      if (store.state.isLogin == '0') {
        alert("您没有登录，无权访问！", {confirmButtonText: '确定' })
        // 未登录则跳转到登陆界面，query:{ redirect: to.fullPath}表示把当前路由信息传递过去方便登录后跳转回来；
        next({
          path: 'login',
          //当前要跳转到的页面存入query
          query: {redirect: to.fullPath}
        })
      } else { // 已经登陆
        next() //正常跳转到设置好的页面
      }
    }else{
      next()
    }
  }
)

