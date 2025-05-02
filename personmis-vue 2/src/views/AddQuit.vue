<template>
  <NavMain></NavMain>
  <div class="box">
  <br>
   <el-form ref="addForm" :model="addForm" :rules="rules" style="width:50%;"  label-width="50%" >
    <el-form-item label="员工编号"  prop="staff_id">
      <el-input v-model="addForm.staff_id"  placeholder="请输入员工编号" @blur="getBeforePost"></el-input>
    </el-form-item>
    <el-form-item label="员工姓名"  prop="sname">
      <el-input v-model="addForm.sname" disabled></el-input>
    </el-form-item>
    <el-form-item label="离职类型" prop="qtype">
      <el-select v-model="addForm.qtype" placeholder="请选择离职类型">
        <el-option v-for="(item,index) in qtypes" :key="index" :label="item" :value="item"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="离职日期"  prop="qdate">
      <el-date-picker v-model="addForm.qdate" type="date" placeholder="选择离职日期" style="width:100%"></el-date-picker>
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
       qtypes:[ "辞职","辞退","退休","开除","不录用"] ,
       addForm: {},
      //验证规则
      rules: {
          staff_id: [{required: true, message: '请输入员工编号', trigger: 'blur'}],
          sname: [{ required: true, message: '请选择调动后岗位', trigger: 'change' }],
          qtype: [{ required: true, message: '请选择调动类型', trigger: 'change' }],
          qdate: [{ required: true, message: '请选择调动日期', trigger: 'change' }]
      },
       loadingbut: false, 
       loadingbuttext: '新增'
    }
  },
  methods: {
    getBeforePost(){
      this.$axios
          .get('/getBeforePost?id=' + this.addForm.staff_id)
          .then(successResponse => {
              this.addForm.sname = successResponse.data.sname
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
                .post('/addQuit', this.addForm)//直接提交表单
                    .then(successResponse => {
                        if (successResponse.data === "ok") {
                            this.$alert('添加成功', {confirmButtonText: '确定' })
                            this.$router.replace({path: '/quit'})
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