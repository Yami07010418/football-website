<template>
    <NavMain></NavMain>
<div class="box1">
<br>
<el-form ref="selectForm" :model="selectForm" style="width:70%;"  label-width="30%" > 
  <el-row>
    <el-col :span="12">
        <el-form-item label="查询开始日期"  prop="startdate">
                <el-date-picker v-model="selectForm.startdate" type="date" placeholder="选择开始日期" style="width:100%"></el-date-picker>
        </el-form-item> 
    </el-col>
   <el-col :span="12">
        <el-form-item label="查询结束日期"  prop="enddate">
                <el-date-picker v-model="selectForm.enddate" type="date" placeholder="选择结束日期" style="width:100%"></el-date-picker>
        </el-form-item>  
    </el-col>
  </el-row>
  <el-row>
   <el-col :span="20">
        <el-form-item>
            <el-button type="primary" @click="selectQuitStaffReportByCon">查询</el-button>
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
    <el-table-column prop="sex" label="性别" min-width="1" ></el-table-column>
    <el-table-column prop="dname"  label="所在部门" min-width="1"></el-table-column>
    <el-table-column prop="pname"  label="岗位名称" min-width="1"></el-table-column>
    <el-table-column prop="qdate" label="离职日期"  min-width="1" sortable></el-table-column>
    <el-table-column prop="qtype" label="离职类型"  min-width="1"></el-table-column>
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
    this.loadQuitStaffReport()
  },
  data () {
     return {
        selectForm: {
          currentPage: 1,
          pageSize: 1,
          act: ''
        },
        currentPage: 1,
        tableData: [{}],//定义空数组接收数据
        pageSize: 1,
        total: 0
      }
  },
  methods: {
    loadQuitStaffReport (){
      this.$axios
          .get('/getQuitStaffReport?currentPage=' + this.currentPage + '&&pageSize=' + this.pageSize)
          .then(successResponse => {
              this.tableData = successResponse.data.newQuitReports
              this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    //条件查询
    selectQuitStaffReportByCon(){
        this.selectForm.act = "byCon"
        this.$axios
          .post('/selectQuitStaffReportByCon', this.selectForm)//直接提交表单
          .then(successResponse => {
             this.tableData = successResponse.data.newQuitReports
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
        this.selectQuitStaffReportByCon()
      }else{
         this.loadQuitStaffReport()
      }
    }
  }
} 
</script>
<style scoped>
  .box1{
      width: 80%;
      height: 150px;
      margin-left: 20%;
    }
.el-select{
    width:100%
  }
</style>