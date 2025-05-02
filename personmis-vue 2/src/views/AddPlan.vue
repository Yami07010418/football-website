<template>
    <NavMain></NavMain>
    <div class="box">
      <br>
     <el-form ref="addForm" :model="addForm" :rules="rules"  style="width:50%;"  label-width="50%" >
      <el-form-item label="计划日期"  prop="plandate">
                <el-date-picker v-model="addForm.plandate" type="date" placeholder="选择计划日期" style="width:100%"></el-date-picker>
        </el-form-item> 
    <el-form-item label="部门(人员)位置名称"  prop="dname">
    <el-input v-model="addForm.dname"  placeholder="请输入部门名"></el-input>
  </el-form-item>
   <el-form-item label="部门类型" prop="dtype">
      <el-select v-model="addForm.dtype" placeholder="请选择部门类型">
        <el-option v-for="(item,index) in dtypes" :key="index" :label="item" :value="item"></el-option>
      </el-select>
    </el-form-item>
    <!-- <el-form-item label="电话"  prop="dtel">
      <el-input v-model="addForm.dtel"  placeholder="请输入电话"></el-input>
    </el-form-item> -->
    <!-- <el-form-item label="传真"  prop="dfax">
      <el-input v-model="addForm.dfax"  placeholder="请输入部门传真"></el-input>
    </el-form-item> -->
    <el-form-item label="详细训练计划描述"  prop="description">
      <el-input v-model="addForm.description" type="textarea"  placeholder="请输入描述"></el-input>
    </el-form-item>
    <!-- <el-form-item label="上级部门" prop="supdepartment">
      <el-select v-model="addForm.supdepartment" placeholder="请选择部门类型">
        <el-option v-for="(item,index) in supdepartments" :key="index" :label="item.dname" :value="item.id"></el-option>
      </el-select>
    </el-form-item> -->
    <el-form-item>
      <el-button type="primary" @click="add(addForm)" :loading="loadingbut"><el-icon class="el-icon-plus"></el-icon>{{loadingbuttext}}</el-button>
      <el-button type="danger" @click="cancel"><el-icon class="el-icon-refresh"></el-icon>重置</el-button>
    </el-form-item>
  </el-form>
   </div>
   <Navbottom></Navbottom>
  </template>
  
  <script>
  import NavMain from '@/components/NavMainCoach.vue'
  import Navbottom from '../components/Navbottom.vue'
  export default {
    components:{
      NavMain,
      Navbottom
    },
    data () {
      return {
         dtypes:[  '足球运动员', '教练', '技术分析师', '球探', '后勤'] ,
         supdepartments:[ {id: '', dname: ''}] ,//定义空数组接收后台数据
         addForm: {},
         //验证规则
        rules: {
            dname: [{required: true, message: '请输入部门名称', trigger: 'blur'}],
            dtype: [{required: true, message: '请选择部门类型', trigger: 'change'}]
        },
        loadingbut: false, 
        loadingbuttext: '新增'
      }
    },
    created: function () {
        this.loadSupdepartment()
    },
    methods: {
      add(){
         this.$refs['addForm'].validate((valid) => {
            if (valid) {
              this.loadingbut = true;
              this.loadingbuttext = '添加中...';
              this.$axios
                .post('/addPlan',{
                dname: this.addForm.dname,
                plandate:this.addForm.plandate,
                dtype:this.addForm.dtype,
                description:this.addForm.description,
                coach_id :sessionStorage.getItem('bid')
                })//直接提交表单
                .then(successResponse => {
                  if (successResponse.data === "ok") {
                    this.$alert('添加成功', {confirmButtonText: '确定' })
                    this.$router.replace({path: '/plan'})
                  }else {
                    this.$alert('添加失败', {confirmButtonText: '确定' })
                    this.loadingbut = false;
                    this.loadingbuttext = '新增';
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
      loadSupdepartment(){
          this.$axios
            .get('/getPlan')
            .then(successResponse => {
                this.supdepartments = successResponse.data
            })
            .catch(failResponse => {
              this.$alert(failResponse.response.status)
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
        height: 340px;
        margin-left: 20%;
      }
  .el-select{
      width:100%
  }
  </style>