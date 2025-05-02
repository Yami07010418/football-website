<template>
  <NavMain></NavMain>
  <div class="box">
   <el-form ref="addForm" :model="addForm" :rules="rules" style="width:50%;"  label-width="50%" >
    <el-input v-model="addForm.beforepost_id" type="hidden"></el-input>
    <el-form-item label="员工编号"  prop="staff_id">
      <el-input v-model="addForm.staff_id"  placeholder="请输入员工编号" @blur="getBeforePost"></el-input>
    </el-form-item>
    <el-form-item label="员工姓名"  prop="sname">
      <el-input v-model="addForm.sname" disabled></el-input>
    </el-form-item>
    <el-form-item label="之前岗位"  prop="beforepost_name">
      <el-input v-model="addForm.beforepost_name" disabled></el-input>
    </el-form-item>
    <el-form-item label="调动后岗位" prop="afterpost_id">
      <el-select v-model="addForm.afterpost_id" placeholder="请选择岗位类型">
        <el-option v-for="(item,index) in posts" :key="index" :label="item.pname" :value="item.id"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="调动类型" prop="ttype">
      <el-select v-model="addForm.ttype" placeholder="请选择岗位类型">
        <el-option v-for="(item,index) in ttypes" :key="index" :label="item" :value="item"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="调动日期"  prop="tdate">
      <el-date-picker v-model="addForm.tdate" type="date" placeholder="选择调动日期" style="width:100%"></el-date-picker>
    </el-form-item>  
    <el-form-item>
      <el-button type="primary" @click="add(addForm)" :loading="loadingbut">{{loadingbuttext}}</el-button>
      <el-button type="danger" @click="cancel">重置</el-button>
    </el-form-item>
</el-form>
 </div>
</template>
<script>
import NavMain from '@/components/NavMain.vue'
export default {
  components:{
    NavMain
  },
  data () {
    return {
       ttypes:[ "升职","降职","数据录入错误"] ,
       posts: [ {id: '', pname: ''}] ,
       addForm: {},
      //验证规则
      rules: {
          staff_id: [{required: true, message: '请输入员工编号', trigger: 'blur'}],
          afterpost_id: [{ required: true, message: '请选择调动后岗位', trigger: 'change' }],
          ttype: [{ required: true, message: '请选择调动类型', trigger: 'change' }],
          tdate: [{ required: true, message: '请选择调动日期', trigger: 'change' }]
      },
       loadingbut: false, 
       loadingbuttext: '新增'
    }
  },
   created: function () {
      this.loadPost()
  },
  methods: {
    loadPost(){
        this.$axios
          .get('/getPost')
          .then(successResponse => {
              this.posts = successResponse.data
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    getBeforePost(){
      this.$axios
          .get('/getBeforePost?id=' + this.addForm.staff_id)
          .then(successResponse => {
              this.addForm.beforepost_id = successResponse.data.beforepost_id
              this.addForm.sname = successResponse.data.sname
              this.addForm.beforepost_name = successResponse.data.beforepost_name
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    add(){
        this.$refs['addForm'].validate((valid) => {
            if (valid) {
                this.loadingbut = true;
                this.loadingbuttext = '添加中...';
                this.$axios
                .post('/addTransfer', this.addForm)//直接提交表单
                    .then(successResponse => {
                        if (successResponse.data === "ok") {
                            this.$alert('添加成功', {confirmButtonText: '确定' })
                            this.$router.replace({path: '/transferStaff'})
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
      height: 200px;
      margin-left: 20%;
  }
.el-select{
    width:100%
  }
</style>