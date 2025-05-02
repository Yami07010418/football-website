<template>
    <div class="box">
        <el-dialog title="前台用户注册" v-model="dialogVisible" @close="goClose()">
            <el-form ref="registerFormRef" :model="registerForm" :rules="rules">
                <el-form-item label="邮箱" prop="uname">
                    <el-input v-model="registerForm.uname" placeholder="请输入邮箱"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="upwd">
                    <el-input v-model="registerForm.upwd" show-password="true" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="reupwd">
                    <el-input v-model="registerForm.reupwd" show-password="true" placeholder="请再次输入密码"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="register(registerFormRef)">注册</el-button>
                    <el-button type="danger" @click="cancel(registerFormRef)">重置</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script setup>
import { useRouter, useRoute } from 'vue-router'// eslint-disable-line no-unused-vars
import { reactive, getCurrentInstance } from 'vue'// eslint-disable-line no-unused-vars
import { ElMessage, ElMessageBox } from 'element-plus'// eslint-disable-line no-unused-vars
const axios = getCurrentInstance().appContext.config.globalProperties.$axios// eslint-disable-line no-unused-vars
const router = useRouter()// eslint-disable-line no-unused-vars
const route = useRoute()// eslint-disable-line no-unused-vars
const registerForm = reactive({})// eslint-disable-line no-unused-vars
const registerFormRef = reactive({})// eslint-disable-line no-unused-vars

// 验证两次密码是否一致的自定义验证器
const validatePasswordMatch = (rule, value, callback) => {
  if (value !== registerForm.upwd) {// eslint-disable-line no-unused-vars
    callback(new Error('两次密码输入不一致'));// eslint-disable-line no-unused-vars
  } else {
    callback();
  }
}

const rules = reactive({// eslint-disable-line no-unused-vars
    uname: [{ required: true, message: "请输入名字", trigger: 'blur' }],
    upwd: [{ required: true, message: "请输入密码", trigger: 'blur' },
    { min: 5, max: 20, message: "密码长度6-20字符", trigger: 'blur' }],
    reupwd: [{ required: true, message: "请输入密码", trigger: 'blur' },
    { min: 5, max: 20, message: "密码长度6-20字符", trigger: 'blur' },
    { validator: validatePasswordMatch, trigger: 'blur' }]
})
let dialogVisible = true// eslint-disable-line no-unused-vars

const register = async(formData) => {// eslint-disable-line no-unused-vars
    if(!formData) 
        return
    await formData.validate((valid, fields) => {
        if(valid){
           console.log('register: before post.')
           axios.post('register', registerForm)
           .then(res => {
                if(res.data.msgId === 'A001')
                {
                    ElMessage('该邮箱已注册！')
                }
                else if (res.data.msgId === 'A002') {
                        ElMessage({ message: '注册成功', type: 'success' })
                        let path = route.query.redirect
                        let username = registerForm.uname;
                        router.replace({ path: path === '/' || path === undefined ? '/LoginCoach' : path, query: { username }})
                }
                else
                {
                    ElMessage.error('注册失败！')
                }
           })
           .catch(error =>{
                alert(1)
                ElMessage.error(error)
           })     
        }
        else {
            console.log('error submit!', fields)
            ElMessageBox.alert('表单验证失败')
        }
    })
}

const cancel = (formData) => {// eslint-disable-line no-unused-vars
    if (!formData)
        return
    formData.resetFields()
}
const goClose = () => {// eslint-disable-line no-unused-vars
    router.replace('/')
}
</script>

<style scoped>
.box{
    width: 100%;
    height: 180px;
}
</style>