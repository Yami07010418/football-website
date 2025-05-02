<template>
  <NavMain></NavMain>
  <div class="box">
    <br>
   <el-form ref="addForm" :model="addForm" :rules="rules" style="width:50%;"  label-width="50%" >
  <el-form-item label="岗位名称"  prop="pname">
    <el-input v-model="addForm.pname"  placeholder="请输入部门名"></el-input>
  </el-form-item>
 <el-form-item label="岗位类型" prop="ptype">
    <el-select v-model="addForm.ptype" placeholder="请选择岗位类型">
      <el-option v-for="(item,index) in ptypes" :key="index" :label="item" :value="item"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="编制人数"  prop="organization">
    <el-input v-model="addForm.organization"  placeholder="请输入编制人数"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="add(addForm)" :loading="loadingbut">{{loadingbuttext}}</el-button>
    <el-button type="danger" @click="cancel">重置</el-button>
  </el-form-item>
</el-form>
 </div>
 
 <Navbottom></Navbottom>
</template>

<script>
//@相当于src
import NavMain from '@/components/NavMain.vue'
import Navbottom from '../components/Navbottom.vue'
export default {
  components:{
    NavMain,
    Navbottom
  },
  data () {
    return {
       ptypes:[ '球员','教练组','技术人员','球探'] ,
       addForm: {},
      //验证规则
      rules: {
          pname: [{required: true, message: '请输入岗位名称', trigger: 'blur'}],
          ptype: [{ required: true, message: '请选择岗位类型', trigger: 'change' }]
      },
       loadingbut: false, 
       loadingbuttext: '新增'
    }
  },
  methods: {
    add(){
        this.$refs['addForm'].validate((valid) => {
            if (valid) {
                this.loadingbut = true;
                this.loadingbuttext = '添加中...';
                this.$axios
                .post('/addPost', this.addForm)//直接提交表单
                    .then(successResponse => {
                        if (successResponse.data === "ok") {
                            this.$alert('添加成功', {confirmButtonText: '确定' })
                            this.$router.replace({path: '/post'})
                        }else {
                            this.$alert('添加失败', {confirmButtonText: '确定' })
                            this.loadingbut = false;
                            this.loadingbuttext = '新增';
                        }
                    })
                    .catch(failResponse => {
                        this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
                    })
            } else {
                this.$alert('表单验证失败', {confirmButtonText: '确定' })
                return false;
            }
        })
    },
    cancel(){
           this.$refs['addForm'].resetFields()
      }
  } 
}
</script>
<style scoped>
.box{
      width: 80%;
      height: 335px;
      margin-left: 20%;
    }
.el-select{
    width:100%
}
</style>