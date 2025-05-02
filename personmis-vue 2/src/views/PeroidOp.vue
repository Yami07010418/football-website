<template>
    <NavMain></NavMain>
<div class="box1">
<br>
<el-form ref="selectForm" :model="selectForm" style="width:50%;"  label-width="50%" > 
  <el-row>
    <el-col :span="12">
        <el-form-item label="员工姓名"  prop="sname">
            <el-input v-model="selectForm.sname"  placeholder="请输入员工姓名"></el-input>
        </el-form-item>
    </el-col>
   <el-col :span="12">
        <el-form-item label="部门名称"  prop="depart_id">
            <el-select v-model="selectForm.depart_id" placeholder="请选择部门">
                <el-option v-for="(item,index) in departs" :key="index" :label="item.dname" :value="item.id"></el-option>
            </el-select>
        </el-form-item>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
        <el-form-item label="岗位名称"  prop="post_id">
            <el-select v-model="selectForm.post_id" placeholder="请选择岗位">
            <el-option v-for="(item,index) in posts" :key="index" :label="item.pname" :value="item.id"></el-option>
            </el-select>
        </el-form-item>
    </el-col>
   <el-col :span="12">
        <el-form-item label="试用期状态" prop="status">
            <el-select v-model="selectForm.status" placeholder="请选择状态">
            <el-option v-for="(item,index) in status" :key="index" :label="item" :value="item"></el-option>
            </el-select>
        </el-form-item>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
        <el-form-item label="开始日期"  prop="startdate">
                <el-date-picker v-model="selectForm.startdate" type="date" placeholder="选择开始日期" style="width:100%"></el-date-picker>
        </el-form-item> 
    </el-col>
   <el-col :span="12">
        <el-form-item label="结束日期"  prop="enddate">
                <el-date-picker v-model="selectForm.enddate" type="date" placeholder="选择结束日期" style="width:100%"></el-date-picker>
        </el-form-item>  
    </el-col>
  </el-row>
  <el-row>
   <el-col :span="20">
        <el-form-item>
            <el-button type="primary" @click="selectPeriodByCon">查询</el-button>
        </el-form-item>
    </el-col>
  </el-row>
</el-form>
</div>


<div>
  <el-table
    :data="tableData"  :header-cell-style="headClass" 
     :cell-style="{ textAlign: 'center' }"
    :default-sort = "{prop: 'id', order: 'descending'}">
    <el-table-column prop="id" label="ID" min-width="1" sortable></el-table-column>
    <el-table-column prop="sname" label="员工名称" min-width="1" ></el-table-column>
    <el-table-column prop="dname"  label="所在部门" min-width="1"></el-table-column>
    <el-table-column prop="pname"  label="岗位名称" min-width="1"></el-table-column>
    <el-table-column prop="status"  label="状态" min-width="1"></el-table-column>
    <el-table-column prop="startdate1" label="试用期开始日期" min-width="1" sortable></el-table-column>
    <el-table-column prop="enddate1" label="试用期结束日期" min-width="1" sortable></el-table-column>
    <el-table-column label="操作" min-width="2">
      <template #default="scope">
        <el-button
          size="mini"  type="success" v-if="scope.row.status=='正常'"
          @click="handleEdit(scope.$index, scope.row, '转正')">转正</el-button>
       <el-button
          size="mini" type="primary" v-if="scope.row.status=='正常'"
          @click="handleEdit(scope.$index, scope.row, '延期')">延期</el-button>
        <el-button size="mini" type="danger" v-if="scope.row.status=='正常'"
          @click="handleEdit(scope.$index, scope.row, '不录用')">不录用</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>


 <div class="block">
    <el-pagination
      @current-change="handleCurrentChange"
      v-model:currentPage="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="total">
    </el-pagination>
  </div>


</template>
<script>
import NavMain from '@/components/NavMain.vue'
export default {
  components:{
    NavMain
  },
  created: function () {
    this.loadDepartment()
    this.loadPost()
    this.loadPeriods()
  },
  data () {
     return {
        status: ["正常","转正","延期","不录用"] ,
        departs: [ {id: '', dname: ''}] ,//定义空数组接收后台数据
        posts: [ {id: '', pname: ''}] ,
        selectForm: {
          currentPage: 1,
          pageSize: 1,
          act: ''
        },
        currentPage: 1,
        tableData: [{}],//定义空数组接收数据
        pageSize: 10,
        total: 0
      }
  },
  methods: {
    loadDepartment(){
        this.$axios
          .get('/getDepartment')
          .then(successResponse => {
            // alert(JSON.stringify(successResponse.data))
              this.departs = successResponse.data
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })

    },
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
    loadPeriods (){
      this.$axios
          .get('/getPeriods?currentPage=' + this.currentPage + '&&pageSize=' + this.pageSize)
          .then(successResponse => {
            // alert(JSON.stringify(successResponse.data.periods))
              this.tableData = successResponse.data.periods
              this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    //条件查询
    selectPeriodByCon(){
        this.selectForm.act = "byCon"
        this.$axios
          .post('/selectPeriodByCon', this.selectForm)//直接提交表单
          .then(successResponse => {
             this.tableData = successResponse.data.periods
             this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
          })
    },
     // 表头样式设置
    headClass () {
        return 'text-align: center;background:rgb(242,242,242);color:rgb(140,138,140)'
    },
    //页码变换
    handleCurrentChange(val) {
      this.currentPage = val
      if(this.selectForm.act === 'byCon'){
        this.selectForm.currentPage = this.currentPage
        this.selectForm.pageSize = this.pageSize
        this.selectPeriodByCon()
      }else{
         this.loadPeriods()
      }
    },
    //编辑与详情
    handleEdit(index, row, status) {
      console.log(index, row);
      this.$axios
         .post('/periodOp?id=' + row.id +"&&status=" + status)
          .then(successResponse => {
            if (successResponse.data === "ok") {
              this.$alert('操作成功', {confirmButtonText: '确定' })
              this.loadPeriods()
            }else {
              this.$alert('操作失败！', {confirmButtonText: '确定' })
            }
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
          })
    }
  }
} 
</script>
<style scoped>
  .box1{
      width: 80%;
      height: 250px;
      margin-left: 20%;
    }
.el-select{
    width:100%
  }
</style>