<template>
<el-dialog title="管理员登录" v-model="dialogVisible"  width="30%">
  <div class="box">
  <el-form ref="loginForm" :model="loginForm" :rules="rules" style="width:100%;"  label-width="20%">
  <el-form-item label="用户名" prop="uname">
    <!-- v-model数据双向绑定 -->
    <el-input v-model="loginForm.uname"  placeholder="请输入用户名"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="upwd">
    <el-input show-password v-model="loginForm.upwd" placeholder="请输入密码"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="login(loginForm)" :loading="loadingbut">{{loadingbuttext}}</el-button>
    <el-button type="danger" @click="cancel">重置</el-button>
  </el-form-item>
</el-form>
  </div>
</el-dialog>
</template>
<script>
  export default {
    name: 'Login',
    data () {
      return {
        loginForm: {},
        //验证规则
        rules: {
          uname: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          upwd: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
       loadingbut: false, 
       loadingbuttext: '登录',
       dialogVisible: true
      }
    },
    methods: {
      login (loginForm) {
        this.$refs['loginForm'].validate((valid) => {
          if (valid) {
            this.loadingbut = true
            this.loadingbuttext = '登录中...'
            this.$axios
            .post('/login',{
                uname: loginForm.uname,
                upwd: loginForm.upwd
              })
              .then(successResponse => {
                if (successResponse.data === "ok") {
                  //Message Box
                  this.$alert('登录成功', {confirmButtonText: '确定' })
                  this.$store.commit('changeLogin',this.loginForm.uname)
                  //访问要跳转的页面
                  let path = this.$route.query.redirect
                  //.replace跳转页面
                  this.$router.replace({path: path === '/' || path === undefined ? '/department': path})
                }else {
                  this.$alert('用户名或密码错误！', {confirmButtonText: '确定' })
                  this.loadingbut = false;
                  this.loadingbuttext = '登录';
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
              })
          }
          else {
              this.$alert('表单验证失败', {confirmButtonText: '确定' })
              return false;
          }
        })
      },
      cancel(){
           this.$refs['loginForm'].resetFields()
      }
    }
  }
</script>
<style scoped>
.box{
      width: 100%;
      height: 180px;
    }
</style>