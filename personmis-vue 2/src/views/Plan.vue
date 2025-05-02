<template>
    <el-container>
    <NavMain></NavMain>
    <el-main style="background-color: ;">
    <div class="box1">
      <br>
      <el-form ref="selectForm" :model="selectForm" style="width:50%;" label-width="50%">
        <el-form-item label="部门(人员)名称" prop="dname" >
          <el-input v-model="selectForm.dname" placeholder="请输入部门名"></el-input>
        </el-form-item>
        <el-form-item label="部门类型" prop="dtype">
          <el-select v-model="selectForm.dtype" placeholder="请选择部门类型">
            <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selectPlansByCon"><el-icon class="el-icon-search"></el-icon>查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="box2">
      <el-table :data="tableData" :header-cell-style="headClass" :cell-style="{ textAlign: 'center' }"
        :default-sort="{ prop: 'id', order: 'descending' }">
        <el-table-column prop="id" label="ID" sortable></el-table-column>
        <!-- <el-table-column prop="startdate1" label="计划日期" sortable></el-table-column> -->
        <el-table-column prop="dname" label="名称"></el-table-column>
        <el-table-column prop="dtype" label="类型"></el-table-column>
           <el-table-column prop="description" label="训练计划" ></el-table-column>
        <!-- <el-table-column prop="establishmentdate1" label="成立日期" sortable></el-table-column> -->
        <el-table-column label="操作">
          <template #default="scope">
            <el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row, 'update')"><el-icon
                class="el-icon-edit"></el-icon>编辑</el-button>
            <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row, 'detail')"><el-icon
                class="el-icon-view"></el-icon>详情</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)"><el-icon
                class="el-icon-delete"></el-icon>删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  
    <div class="block">
      <el-pagination @current-change="handleCurrentChange" v-model:currentPage="currentPage" :page-size="pageSize"
        layout="total, prev, pager, next" :total="total">
      </el-pagination>
    </div>
    <el-dialog title="部门修改" v-model="dialogVisibleDetail" width="40%">
      <el-form ref="detailData" :model="detailData" style="width:80%;" label-width="40%">
        <el-form-item label="训练日期" prop="plandate" >
          <el-input v-model="detailData.plandate"></el-input>
        </el-form-item>
        <el-form-item label="部门(人员)名称" prop="dname" >
          <el-input v-model="detailData.dname"></el-input>
        </el-form-item>
        <el-form-item label="部门类型" prop="dtype">
          <el-select v-model="detailData.dtype">
            <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="电话" prop="dtel">
          <el-input v-model="detailData.dtel"></el-input>
        </el-form-item>
        <el-form-item label="传真" prop="dfax">
          <el-input v-model="detailData.dfax"></el-input>
        </el-form-item> -->
        <el-form-item label="球队计划" prop="description">
          <el-input v-model="detailData.description" type="textarea"></el-input>
        </el-form-item>
        <!-- <el-form-item label="上级部门" prop="supdepartment">
          <el-select v-model="detailData.supdepartment">
            <el-option v-for="(item, index) in supdepartments" :key="index" :label="item.dname" :value="item.id"></el-option>
          </el-select>
        </el-form-item> -->
        <el-form-item>
          <el-button type="primary" @click="update(detailData)"><el-icon class="el-icon-edit"></el-icon>修改</el-button>
          <el-button type="danger" @click="cancel"><el-icon class="el-icon-refresh"></el-icon>重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  
    <el-dialog title="部门详情" v-model="dialogVisible" width="50%">
      <el-form ref="detailData" :model="detailData" disabled style="width:80%;" label-width="40%">
        <el-form-item label="训练日期" prop="plandate" >
          <el-input v-model="detailData.plandate"></el-input>
        </el-form-item>
        <el-form-item label="部门名称" prop="dname">
          <el-input v-model="detailData.dname"></el-input>
        </el-form-item>
        <el-form-item label="部门类型" prop="dtype">
          <el-select v-model="detailData.dtype">
            <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="电话" prop="dtel">
          <el-input v-model="detailData.dtel"></el-input>
        </el-form-item>
        <el-form-item label="传真" prop="dfax">
          <el-input v-model="detailData.dfax"></el-input>
        </el-form-item> -->
        <el-form-item label="球队计划" prop="description">
          <el-input v-model="detailData.description" type="textarea"></el-input>
        </el-form-item>
        <!-- <el-form-item label="上级部门" prop="supdepartment">
          <el-select v-model="detailData.supdepartment">
            <el-option v-for="(item, index) in supdepartments" :key="index" :label="item.dname" :value="item.id"></el-option>
          </el-select>
        </el-form-item> -->
      </el-form>
    </el-dialog>
  
   </el-main>
    <el-footer>
      <div class="bottom">
        <ul>
          <li>
            <img src="../assets/league_title.svg" alt="">19
          </li>
          <li>
            <img src="../assets/european_cup.svg" alt="">6
          </li>
          <li>
            <img src="../assets/fa_cup.svg" alt="">8
          </li>
          <li>
            <img src="../assets/uefa_cup.svg" alt="">3
          </li>
          <li>
            <img src="../assets/league_cup.svg" alt="">9
          </li>
          <li>
            <img src="../assets/uefa_super_cup.svg" alt="">4
          </li>
        </ul>
    </div>
    </el-footer>
  </el-container>
  </template>
  <script>
  import NavMain from '@/components/NavMainCoach.vue'
  export default {
    components: {
      NavMain
    },
    created: function () {
      this.loadPlans()
    },
    data() {
      return {
        dtypes: ['', '足球运动员', '教练', '技术分析师', '球探', '后勤'],
        selectForm: {
          currentPage: 1,
          pageSize: 1,
          act: ''
        },
        currentPage: 1,
        tableData: [{}],//定义空数组接收数据
        pageSize: 2,//一页显示多少条数据
        total: 0,
        dialogVisible: false,//详情对话框是否显示
        dialogVisibleDetail: false,
        detailData: {},
        supdepartments: [{ id: '', dname: '' }],//定义空数组接收后台数据
        // 假数据
        // resdata: {
        //   "total": 2,
        //   "departs": [
        //     {
        //       "id": 1,
        //       "dname": "大外",
        //       "dtype": "公司",
        //       "dtel": "15942619740",
        //       "dfax": null,
        //       "description": null,
        //       "supdepartment": null,
        //       "establishmentdate": null,
        //       "establishmentdate1": "2023-05-13",
        //       "supdepartment1": null
        //     },
        //     {
        //       "id": 6,
        //       "dname": "软件",
        //       "dtype": "部门",
        //       "dtel": "15942619740",
        //       "dfax": null,
        //       "description": null,
        //       "supdepartment": 1,
        //       "establishmentdate": null,
        //       "establishmentdate1": "2023-05-13",
        //       "supdepartment1": null
        //     }
        //   ],
        //}
     }
    },
    methods: {
      loadPlans() {
        // 假数据
        // this.tableData = this.resdata.departs
        // this.total = this.resdata.total
  
        this.$axios
          .post('/getPlansByUid',{
            coach_id :sessionStorage.getItem('bid'),
            currentPage: this.currentPage,
            pageSize: this.pageSize,
          }
          ).then(successResponse => { 
            // alert(JSON.stringify(successResponse.data.plans))
            // alert(successResponse.data.total)
            this.tableData = successResponse.data.plans
            this.total = successResponse.data.total
            console.log("data:" + successResponse.data.plans)
            console.log("total:" + successResponse.data.total)
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
      },
      //条件查询
      selectPlansByCon() {
        this.selectForm.act = "byCon"
        this.$axios
          .post('/selectPlansByCon', this.selectForm)//直接提交表单
          .then(successResponse => {
            this.tableData = successResponse.data.plans
            this.total = successResponse.data.total
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, { confirmButtonText: '确定' })
          })
      },
      // 表头样式设置
      headClass() {
        return 'text-align: center;background:rgb(242,242,242);color:rgb(140,138,140)'
      },
      //页码变换
      handleCurrentChange(val) {
        this.currentPage = val
        if (this.selectForm.act === 'byCon') {
          this.selectForm.currentPage = this.currentPage
          this.selectForm.pageSize = this.pageSize
          this.selectPlansByCon()
        } else {
          this.loadPlans()
        }
      },
      //编辑与详情
      handleEdit(index, row, act) {
        console.log(index, row);
        this.$axios
          .get('/getPlanDetail?id=' + row.id)
          .then(successResponse => {
            //  alert(JSON.stringify(successResponse.data.plans))
            this.detailData = successResponse.data.aPlan
            // this.supdepartments = successResponse.data.plans;
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status)
          })
        if (act === 'update')
          this.dialogVisibleDetail = true
        else
          this.dialogVisible = true
      },
      handleDelete(index, row) {
        console.log(index, row);
        this.$confirm('删除部门, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios
            .post('/deletePlan?id=' + row.id)
            .then(successResponse => {
              if (successResponse.data === "ok") {
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                });
                //删除成功后重新加载
                this.loadPlans()
              } else {
                this.$alert('不能删除有关联数据！', { confirmButtonText: '确定' })
              }
            })
            .catch(failResponse => {
              this.$alert(failResponse.response.status, { confirmButtonText: '确定' })
            })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      cancel() {
        this.$refs['detailData'].resetFields()
      },
      update() {
        this.$axios
          .post('/updatePlan', this.detailData)//直接提交表单
          .then(successResponse => {
            if (successResponse.data === "ok") {
              this.$alert('修改成功', { confirmButtonText: '确定' })
              this.dialogVisibleDetail = false
              //修改成功后重新加载
              this.loadPlans()
            } else {
              this.$alert('修改失败', { confirmButtonText: '确定' })
              this.dialogVisibleDetail = false
            }
          })
          .catch(failResponse => {
            this.$alert(failResponse.response.status, { confirmButtonText: '确定' })
          })
      }
    }
  } 
  </script>
  <style scoped>
  .box1 {
  
    width: 80%;
    height: 200px;
    margin-left: 20%;
  }
  
  .box2 {
    margin-left: 5px;
    margin-right: 5px;
  }
  
  .el-select {
    width: 100%
  }
  .bottom{
    width: 100%;
    height: 160px;
    background-color: rgb(242, 239, 239);
  }
  img{
    display: block;
  }
  ul{
    list-style: none;
    width: 100%;
    height: 100px;
    line-height: 100px;
    display: flex;
    justify-content: space-evenly;
  }
  li{
    align-items:  center;
  }
  
  </style>