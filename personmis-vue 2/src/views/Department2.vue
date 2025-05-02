<template>
  <NavMain></NavMain>
  <div class="box1">
    <br>
    <el-form ref="selectForm" :model="selectForm" style="width:50%;" label-width="50%">
      <el-form-item label="部门名称" prop="dname">
        <el-input v-model="selectForm.dname" placeholder="请输入部门名"></el-input>
      </el-form-item>
      <el-form-item label="部门类型" prop="dtype">
        <el-select v-model="selectForm.dtype" placeholder="请选择部门类型">
          <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="selectDepartmentsByCon"><el-icon class="el-icon-search"></el-icon>查询</el-button>
      </el-form-item>
    </el-form>
  </div>
  <div class="box2">
    <el-table :data="tableData" :header-cell-style="headClass" :cell-style="{ textAlign: 'center' }"
      :default-sort="{ prop: 'id', order: 'descending' }">
      <el-table-column prop="id" label="ID" sortable></el-table-column>
      <el-table-column prop="dname" label="名称"></el-table-column>
      <el-table-column prop="dtype" label="类型"></el-table-column>
      <el-table-column prop="establishmentdate1" label="成立日期" sortable></el-table-column>
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
      <el-form-item label="部门名称" prop="dname">
        <el-input v-model="detailData.dname"></el-input>
      </el-form-item>
      <el-form-item label="部门类型" prop="dtype">
        <el-select v-model="detailData.dtype">
          <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="电话" prop="dtel">
        <el-input v-model="detailData.dtel"></el-input>
      </el-form-item>
      <el-form-item label="传真" prop="dfax">
        <el-input v-model="detailData.dfax"></el-input>
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input v-model="detailData.description" type="textarea"></el-input>
      </el-form-item>
      <el-form-item label="上级部门" prop="supdepartment">
        <el-select v-model="detailData.supdepartment">
          <el-option v-for="(item, index) in supdepartments" :key="index" :label="item.dname" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="update(detailData)"><el-icon class="el-icon-edit"></el-icon>修改</el-button>
        <el-button type="danger" @click="cancel"><el-icon class="el-icon-refresh"></el-icon>重置</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <el-dialog title="部门详情" v-model="dialogVisible" width="50%">
    <el-form ref="detailData" :model="detailData" disabled style="width:80%;" label-width="40%">
      <el-form-item label="部门名称" prop="dname">
        <el-input v-model="detailData.dname"></el-input>
      </el-form-item>
      <el-form-item label="部门类型" prop="dtype">
        <el-select v-model="detailData.dtype">
          <el-option v-for="(item, index) in dtypes" :key="index" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="电话" prop="dtel">
        <el-input v-model="detailData.dtel"></el-input>
      </el-form-item>
      <el-form-item label="传真" prop="dfax">
        <el-input v-model="detailData.dfax"></el-input>
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input v-model="detailData.description" type="textarea"></el-input>
      </el-form-item>
      <el-form-item label="上级部门" prop="supdepartment">
        <el-select v-model="detailData.supdepartment">
          <el-option v-for="(item, index) in supdepartments" :key="index" :label="item.dname" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
import { reactive, toRefs, onBeforeMount } from "vue"
import NavMain from '@/components/NavMain.vue'
import axios from "axios";

export default {
  name: "Department",
  // created: function () {
  //   this.loadDepartments()
  // },
  setup() {

    onBeforeMount(() => {
      console.log("dongzongran...")
      loadDepartments()
    })

    const data = reactive({
      dtypes : ['', '公司', '部门', '车间', '生产线', '班组'],
      selectForm : {
        currentPage: 1,
        pageSize: 1,
        act: ''
      },
      currentPage : 1,
      tableData : [{}], //定义空数组接收数据
      pageSize : 2,
      total : 0,
      dialogVisible : false, //详情对话框是否显示
      dialogVisibleDetail : false,
      detailData : {},
      supdepartments : [{ id: '', dname: '' }] //定义空数组接收后台数据
    })

    const loadDepartments = () => {
      axios
        .get('/getDepartmentByPage?currentPage=' + data.currentPage + '&&pageSize=' + data.pageSize)
        .then(successResponse => {
          data.tableData = successResponse.data.departs
          data.total = successResponse.data.total
        })
        .catch(failResponse => {
          alert(failResponse.response.status)
        })
    }

    const selectDepartmentsByCon = () => {
      data.selectForm.act = "byCon"
      axios
        .post('/selectDepartmentsByCon', data.selectForm)//直接提交表单
        .then(successResponse => {
          data.tableData = successResponse.data.departs
          data.total = successResponse.data.total
        })
        .catch(failResponse => {
          alert(failResponse.response.status, { confirmButtonText: '确定' })
        })
    }

    const headClass = () => {
      return 'text-align: center;background:rgb(242,242,242);color:rgb(140,138,140)'
    }

    const handleCurrentChange = (val) => {
      data.currentPage = val
      if (data.selectForm.act === 'byCon') {
        data.selectForm.currentPage = data.currentPage
        data.selectForm.pageSize = data.pageSize
        selectDepartmentsByCon()
      } else {
        loadDepartments()
      }
    }

    const handleEdit = (index, row, act) => {
      console.log(index, row);
      axios
        .get('/getDepartmentDetail?id=' + row.id)
        .then(successResponse => {
          data.detailData = successResponse.data.aDepart
          data.supdepartments = successResponse.data.departs;
        })
        .catch(failResponse => {
          alert(failResponse.response.status)
        })
      if (act === 'update')
        data.dialogVisibleDetail = true
      else
        data.dialogVisible = true
    }

    const handleDelete = (index, row) => {
      console.log(index, row);
      confirm('删除部门, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios
          .post('/deleteDepartment?id=' + row.id)
          .then(successResponse => {
            if (successResponse.data === "ok") {
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              //删除成功后重新加载
              loadDepartments()
            } else {
              alert('不能删除有关联数据！', { confirmButtonText: '确定' })
            }
          })
          .catch(failResponse => {
            alert(failResponse.response.status, { confirmButtonText: '确定' })
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }

    const cancel = () => {
      this.$refs['detailData'].resetFields()
    }

    const update = () => {
      axios
        .post('/updateDepartment', this.detailData)//直接提交表单
        .then(successResponse => {
          if (successResponse.data === "ok") {
            alert('修改成功', { confirmButtonText: '确定' })
            data.dialogVisibleDetail = false
            //修改成功后重新加载
            loadDepartments()
          } else {
            alert('修改失败', { confirmButtonText: '确定' })
            data.dialogVisibleDetail = false
          }
        })
        .catch(failResponse => {
          alert(failResponse.response.status, { confirmButtonText: '确定' })
        })
    }

    return {
      loadDepartments,
      selectDepartmentsByCon,
      headClass,
      handleCurrentChange,
      handleEdit,
      handleDelete,
      cancel,
      update,
      ...toRefs(data),
      NavMain
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
</style>