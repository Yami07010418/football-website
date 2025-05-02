<template>
    <NavMain></NavMain>
<div class="box1">
<br>
<el-form ref="selectForm" :model="selectForm" style="width:50%;"  label-width="50%" > 
  <el-row>
    <el-col :span="12">
        <el-form-item label="员工编号"  prop="staff_id">
            <el-input v-model="selectForm.staff_id"  placeholder="请输入员工编号"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="员工姓名"  prop="sname">
            <el-input v-model="selectForm.sname"  placeholder="请输入员工姓名"></el-input>
        </el-form-item>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
        <el-form-item label="离职类型"  prop="qtype">
            <el-select v-model="selectForm.ttype" placeholder="请选择离职类型">
                <el-option v-for="(item,index) in qtypes" :key="index" :label="item" :value="item"></el-option>
            </el-select>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="查询开始日期"  prop="startdate">
                <el-date-picker v-model="selectForm.startdate" type="date" placeholder="选择开始日期" style="width:100%"></el-date-picker>
        </el-form-item> 
    </el-col>
  </el-row>
  <el-row>
   <el-col :span="12">
        <el-form-item label="查询结束日期"  prop="enddate">
                <el-date-picker v-model="selectForm.enddate" type="date" placeholder="选择结束日期" style="width:100%"></el-date-picker>
        </el-form-item>  
    </el-col>
   <el-col :span="8">
        <el-form-item>
            <el-button type="primary" @click="selectQuitsByCon">查询</el-button>
        </el-form-item>
    </el-col>
    </el-row>
</el-form>
</div>
<div>
  <el-table
    :data="tableData"  :header-cell-style="headClass" 
     :cell-style="{ textAlign: 'center' }"
    :default-sort = "{prop: 'staff_id', order: 'descending'}">
    <el-table-column prop="staff_id" label="员工编号"  sortable></el-table-column>
    <el-table-column prop="sname" label="员工名称"></el-table-column>
    <el-table-column prop="qtype"  label="离职类型"></el-table-column>
    <el-table-column prop="qdate1" label="离职时间" sortable></el-table-column>
    <el-table-column prop="opdate1" label="操作时间" sortable></el-table-column>
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
    this.loadQuit()
  },
  data () {
     return {
        qtypes:[ "辞职","辞退","退休","开除","不录用"]  ,
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
    loadQuit (){
      this.$axios
          .get('/getQuit?currentPage=' + this.currentPage + '&&pageSize=' + this.pageSize)
          .then(successResponse => {
              this.tableData = successResponse.data.quits
              this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    //条件查询
    selectQuitsByCon(){
        this.selectForm.act = "byCon"
        this.$axios
          .post('/selectQuitsByCon', this.selectForm)//直接提交表单
          .then(successResponse => {
             this.tableData = successResponse.data.quits
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
        this.selectQuitsByCon()
      }else{
         this.loadQuit()
      }
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