<template>
    <NavMain></NavMain>
<div class="box1">
<br>
<el-form ref="selectForm" :model="selectForm" style="width:50%;"  label-width="50%" > 
  <el-form-item label="职务名称(场上位置)"  prop="pname">
    <el-input v-model="selectForm.pname"  placeholder="请输入部门名"></el-input>
  </el-form-item>
 <el-form-item label="职务类型" prop="ptype">
    <el-select v-model="selectForm.ptype" placeholder="请选择岗位类型">
      <el-option v-for="(item,index) in ptypes" :key="index" :label="item" :value="item"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="selectPostsByCon">查询</el-button>
  </el-form-item>
</el-form>
</div>
<div class="box2">
  <el-table
    :data="tableData"  :header-cell-style="headClass" 
     :cell-style="{ textAlign: 'center' }"
    :default-sort = "{prop: 'id', order: 'descending'}">
    <el-table-column prop="id" label="ID" sortable></el-table-column>
    <el-table-column prop="pname" label="名称"></el-table-column>
    <el-table-column prop="ptype"  label="类型"></el-table-column>
    <el-table-column prop="organization" label="编制人数" sortable></el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button
          size="mini"  type="success"
          @click="handleEdit(scope.$index, scope.row, 'update')">编辑</el-button>
       <el-button
          size="mini" type="primary"
          @click="handleEdit(scope.$index, scope.row, 'detail')">详情</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
  <el-dialog title="岗位修改" v-model="postDialogVisible"  width="40%">
   <el-form ref="updateForm" :model="updateForm"  style="width:80%;"  label-width="40%"  >
  <el-form-item label="岗位名称"  prop="pname">
    <el-input v-model="updateForm.pname"></el-input>
  </el-form-item>
 <el-form-item label="岗位类型" prop="ptype">
    <el-select v-model="updateForm.ptype">
      <el-option v-for="(item,index) in ptypes" :key="index" :label="item" :value="item"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="编制人数"  prop="organization">
    <el-input v-model="updateForm.organization" ></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="update(updateForm)" :loading="loadingbut">{{loadingbuttext}}</el-button>
    <el-button type="danger" @click="cancel">重置</el-button>
  </el-form-item>
</el-form>
</el-dialog>
<!--岗位详情-->
<el-dialog title="岗位详情" v-model="postDetailDialogVisible"  width="40%">
   <el-form ref="updateForm" :model="updateForm" disabled style="width:80%;"  label-width="40%"  >
  <el-form-item label="岗位名称"  prop="pname">
    <el-input v-model="updateForm.pname"></el-input>
  </el-form-item>
 <el-form-item label="岗位类型" prop="ptype">
    <el-select v-model="updateForm.ptype">
      <el-option v-for="(item,index) in ptypes" :key="index" :label="item" :value="item"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="编制人数"  prop="organization">
    <el-input v-model="updateForm.organization"></el-input>
  </el-form-item>
</el-form>
</el-dialog>
<Navbottom></Navbottom>
</template>
<script>
import NavMain from '@/components/NavMain.vue'
import Navbottom from '../components/Navbottom.vue'
export default {
  components:{
    NavMain,
    Navbottom
  },
  created: function () {
    this.loadPosts()
  },
  data () {
     return {
        ptypes:['','球员','教练组','技术人员','球探'],
        selectForm: {
          currentPage: 1,
          pageSize: 1,
          act: ''
        },
        currentPage: 1,
        tableData: [{}],//定义空数组接收数据
        pageSize: 10,
        total: 0,
        //编辑
        updateForm: {},
        loadingbut: false, 
        loadingbuttext: '修改',
        postDialogVisible: false,//编辑对话框是否显示
        postDetailDialogVisible: false,
      }
  },
  methods: {
    loadPosts (){
      this.$axios
          .get('/getPostByPage?currentPage=' + this.currentPage + '&&pageSize=' + this.pageSize)
          .then(successResponse => {
              this.tableData = successResponse.data.posts
              this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
    },
    selectPostsByCon(){
        this.selectForm.act = "byCon"
        this.$axios
          .post('/selectPostByCon', this.selectForm)//直接提交表单
          .then(successResponse => {
             this.tableData = successResponse.data.posts
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
    //页码变化
    handleCurrentChange(val) {
      this.currentPage = val
      if(this.selectForm.act === 'byCon'){
        this.selectForm.currentPage = this.currentPage
        this.selectForm.pageSize = this.pageSize
        this.selectPostsByCon()
      }else{
         this.loadPosts()
      }
    },
    handleEdit(index, row, act) {
      console.log(index, row);
      this.$axios
          .get('/getPostDetail?id=' + row.id )
          .then(successResponse => {
              this.updateForm = successResponse.data
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
      if(act === 'update')
        this.postDialogVisible = true
      else
        this.postDetailDialogVisible = true
    },
    handleDelete(index, row) {
      console.log(index, row);
      this.$confirm('删除岗位, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios
          .post('/deletePost?id=' + row.id)
          .then(successResponse => {
            if (successResponse.data === "ok") {
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              //删除成功后重新加载
              this.loadPosts()
            }else {
              this.$alert('不能删除有关联数据！', {confirmButtonText: '确定' })
            }
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
    },
    update(){
        this.loadingbut = true;
        this.loadingbuttext = '修改中...';
        this.$axios
          .post('/updatePost', this.updateForm)//直接提交表单
          .then(successResponse => {
            if (successResponse.data === "ok") {
              this.$alert('修改成功', {confirmButtonText: '确定' })
              this.postDialogVisible = false
              this.loadPosts()
            }else {
              this.$alert('修改失败', {confirmButtonText: '确定' })
            }
            this.loadingbut = false;
            this.loadingbuttext = '修改';
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
          })
    },
    cancel(){
           this.$refs['updateForm'].resetFields()
    }
  }
} 
</script>
<style scoped>
  .box1{
      width: 80%;
      height: 200px;
      margin-left: 20%;
    }
  .box2{
    margin-left: 5px;
    margin-right: 5px;
   }
  .el-select{
    width:100%
  }
</style>