import { createStore } from 'vuex'
//里面存放状态变量
export default createStore({
  state: {
    //初始时候给一个 isLogin='0' 表示用户未登录 标记当前是否登录window.sessionStorage得到当前会话看看有没有user的对象 登录就有对象
    isLogin:window.sessionStorage.getItem('user') == null ? '0' : window.sessionStorage.getItem('user')
  },
  mutations: {//在这个方法里进行修改不能直接修改通过changelogin来修改islogin
    changeLogin(state, data) {
      state.isLogin = data;
      window.sessionStorage.setItem('user', data)
    }
  }
})
