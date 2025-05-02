<template>
 <NavMain></NavMain>
  <div class="box">
    <br>
   <el-form ref="addForm" :model="addForm" :rules="rules" style="width:100%;"  label-width="30%" >
   <el-row>
        <el-col :span="8">
            <el-form-item label="姓名"  prop="sname">
                <el-input v-model="addForm.sname"  placeholder="请输入姓名"></el-input>
            </el-form-item>  
        </el-col>
        <el-col :span="8">
            <el-form-item label="性别"  prop="sex">
                <el-radio v-model="addForm.sex" label="男">男</el-radio>
                <el-radio v-model="addForm.sex" label="女">女</el-radio>
            </el-form-item>  
        </el-col>
        <el-col :span="8">
            <el-form-item label="出生日期"  prop="birthday">
                <el-date-picker v-model="addForm.birthday" type="date" placeholder="选择出生日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="身份证号" prop="sid">
                <el-input v-model="addForm.sid"  placeholder="请输入身份证号"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="部门" prop="depart_id">
                <el-select v-model="addForm.depart_id" placeholder="请选择部门">
                    <el-option v-for="(item,index) in departments" :key="index" :label="item.dname" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="岗位" prop="post_id">
                <el-select v-model="addForm.post_id" placeholder="请选择岗位">
                    <el-option v-for="(item,index) in posts" :key="index" :label="item.pname" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="入职日期"  prop="entrydate">
                <el-date-picker v-model="addForm.entrydate" type="date" placeholder="选择入职日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
        <el-col :span="8">
            <el-form-item label="参加工作日期"  prop="joinworkdate">
                <el-date-picker v-model="addForm.joinworkdate" type="date" placeholder="选择参加工作日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
       <el-col :span="8">
            <el-form-item label="用工形式"  prop="workform">
                <el-radio v-model="addForm.workform" label="正式">正式</el-radio>
                <el-radio v-model="addForm.workform" label="临时">临时</el-radio>
            </el-form-item>  
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="人员来源" prop="staffsource">
                <el-select v-model="addForm.staffsource" placeholder="请选择人员来源">
                    <el-option v-for="(item,index) in staffsources" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="身价" prop="price">
                <el-input v-model="addForm.price"  placeholder="请输入身价"></el-input>
            </el-form-item>
        </el-col>
        <!-- <el-col :span="8">
            <el-form-item label="政治面貌" prop="politicalstatus">
                <el-select v-model="addForm.politicalstatus" placeholder="请选择政治面貌">
                    <el-option v-for="(item,index) in politicalstatuss" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col> -->
        <!-- <el-col :span="8">
            <el-form-item label="民族" prop="nation">
                <el-select v-model="addForm.nation" placeholder="请选择民族">
                    <el-option v-for="(item,index) in nations" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col> -->
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="国籍" prop="nativeplace">
                <el-input v-model="addForm.nativeplace"  placeholder="请输入国籍"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="联系电话" prop="stel">
                <el-input v-model="addForm.stel"  placeholder="请输入联系电话"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="电子邮件" prop="semail">
                <el-input v-model="addForm.semail"  placeholder="请输入电子邮件"></el-input>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="身高" prop="sheight">
                <el-input v-model="addForm.sheight"  placeholder="请输入身高"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="血型" prop="bloodtype">
                <el-select v-model="addForm.bloodtype" placeholder="请选择血型">
                    <el-option v-for="(item,index) in bloodtypes" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="婚姻状况" prop="maritalstatus">
                <el-radio v-model="addForm.maritalstatus" label="已婚">已婚</el-radio>
                <el-radio v-model="addForm.maritalstatus" label="未婚">未婚</el-radio>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="户口所在地" prop="registeredresidence">
                <el-input v-model="addForm.registeredresidence"  placeholder="请输入户口所在地"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="最高学历" prop="education" >
                <el-select v-model="addForm.education" placeholder="请选择最高学历">
                    <el-option v-for="(item,index) in educations" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="最高学位" prop="degree">
                <el-select v-model="addForm.degree" placeholder="请选择最高学位">
                    <el-option v-for="(item,index) in degrees" :key="index" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="毕业院校" prop="university">
                <el-input v-model="addForm.university"  placeholder="请输入毕业院校"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="所学专业" prop="major">
                <el-input v-model="addForm.major"  placeholder="请输入所学专业"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="毕业日期"  prop="graduationdate">
                <el-date-picker v-model="addForm.graduationdate" type="date" placeholder="选择毕业日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="试用期开始日期"  prop="startdate">
                <el-date-picker v-model="addForm.startdate" type="date" placeholder="选择试用期开始日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
        <el-col :span="8">
            <el-form-item label="试用期结束日期"  prop="enddate">
                <el-date-picker v-model="addForm.enddate" type="date" placeholder="选择参加试用期结束日期" style="width:100%"></el-date-picker>
            </el-form-item>  
        </el-col>
       <el-col :span="8">
            <el-form-item>
                <el-button type="primary" @click="add(addForm)" :loading="loadingbut">{{loadingbuttext}}</el-button>
                <el-button type="danger" @click="cancel">重置</el-button>
            </el-form-item>
      </el-col>
    </el-row>
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
        departments: [ {id: '', dname: ''}] ,//定义空数组接收后台数据
        posts: [ {id: '', pname: ''}] ,
        staffsources: [ '校园招聘','社会招聘','军转','其它'] ,
        politicalstatuss: ['党员', '预备党员', '团员'],
        nations: ["汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",
 "哈尼族","哈萨克族","傣族","黎族","傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",
 "土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族", "乌孜别克族",
"俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族","其它"],
        bloodtypes: ["A 型","B 型","AB 型","0 型","其他血型","未定血型"],
        educations: ["高中及以下","大专","本科","研究生"],
        degrees: ["无学位","学士","双学士","硕士","博士"],
        addForm: {},
        //验证规则
        rules: {
          sname: [{required: true, message: '请输入姓名', trigger: 'blur'}],
          sex: [{ required: true, message: '请选择性别', trigger: 'change' }],
          birthday: [{ required: true, message: '请选择出生日期', trigger: 'change' }],
          sid: [{required: true, message: '请输入身份证号', trigger: 'blur'}],
          depart_id: [{ required: true, message: '请选择部门', trigger: 'change' }],
          post_id: [{ required: true, message: '请选择岗位', trigger: 'change' }],
          entrydate: [{ required: true, message: '请选择入职日期', trigger: 'change' }],
          joinworkdate: [{ required: true, message: '请选择参加工作日期', trigger: 'change' }],
          workform: [{ required: true, message: '请选择用工形式', trigger: 'change' }],
          staffsource: [{ required: true, message: '请选择人员来源', trigger: 'change' }]
       },
       loadingbut: false, 
       loadingbuttext: '新增'
    }
  },
  created: function () {
      this.loadDepartment()
      this.loadPost()
  },
  methods: {
    loadDepartment(){
        this.$axios
          .get('/getDepartment')
          .then(successResponse => {
              this.departments = successResponse.data
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
    add(){
        this.$refs['addForm'].validate((valid) => {
            if (valid) {
                this.loadingbut = true;
                this.loadingbuttext = '添加中...';
                this.$axios
                .post('/addStaff', this.addForm)//直接提交表单
                .then(successResponse => {
                    if (successResponse.data === "ok") {
                    this.$alert('添加成功', {confirmButtonText: '确定' })
                    this.$router.replace({path: '/staff'})
                    }else {
                    this.$alert('添加失败', {confirmButtonText: '确定' })
                    this.loadingbut = false;
                    this.loadingbuttext = '新增';
                    }
                })
                .catch(failResponse => {
                    this.$alert(failResponse.response.status, {confirmButtonText: '确定' })
                })
            }else {
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
      width: 90%;
      margin-left: 5%;
    }
.el-select{
    width:100%
  }
</style>