import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Department from '../views/Department.vue'
import AddDepartment from '../views/AddDepartment.vue'
import Post from '../views/Post.vue'
import AddPost from '../views/AddPost.vue'
import AddStaff from '../views/AddStaff.vue'
import Staff from '../views/Staff.vue'
import PeroidOp from '../views/PeroidOp.vue'  
import AddTransferStaff from '../views/AddTransferStaff.vue'  
import TransferStaff from '../views/TransferStaff.vue' 
import AddQuit from '../views/AddQuit.vue' 
import Quit from '../views/Quit.vue' 
import NewStaffReport from '../views/NewStaffReport.vue' 
import QuitStaffReport from '../views/QuitStaffReport.vue' 
import TransferStaffReport from '../views/TransferStaffReport.vue' 
import Football from '../views/Football.vue'
import LoginCoach from '../views/LoginCoach.vue' 
import Plan from '../views/Plan.vue'
import AddPlan from '../views/AddPlan'
import SalesStatisticsView from '../views/SalesStatisticsView.vue'
import Player from '../views/Player.vue'
import AddPlayer from '../views/AddPlayer.vue'
import Register from '../views/RegisterView.vue'
import PlanCoach from '../views/PlanCoach.vue'
import PlayerUpdate from '../views/PlayerUpdate.vue'
import AddPlayerCoach from '../views/AddPlayerCoach.vue'
import FootballCoach from '../views/FootballCoach.vue'
// import AddPlayerCoach from '../views/AddPlayerCoach'
const routes = [
  //打开程序直接跳转到登录页面
  {
    path: '/',
    //重定向到login
    redirect:'/login',
    meta:{auth:true}//登录不需要验证权限
  },
  {
    path: '/login',
    component: Login,
    meta:{auth:true}
  },
  //部门管理
  {
    path: '/department',
    component: Department
  },
  {
    path: '/adddepartment',
    component: AddDepartment
  },
  //岗位管理
  {
    path: '/post',
    component: Post
  },
  {
    path: '/addpost',
    component: AddPost
  },
  //员工管理
  {
    path: '/addStaff',
    component: AddStaff
  },
  {
    path: '/staff',
    component: Staff
  },
  //试用期管理
  {
    path: '/peroidOp',
    component: PeroidOp
  },
  //岗位调动管理
  {
    path: '/addTransferStaff',
    component: AddTransferStaff
  },
  {
    path: '/transferStaff',
    component: TransferStaff
  },
   //离职管理
  {
    path: '/addQuit',
    component: AddQuit
  },
  {
    path: '/quit',
    component: Quit
  },
  //报表管理
  {
    path: '/newStaffReport',
    component: NewStaffReport
  },
  {
    path: '/quitStaffReport',
    component: QuitStaffReport
  },
  {
    path: '/transferStaffReport',
    component: TransferStaffReport
  },
  {
    path: '/football',
    component: Football
  },
  //教练登录
  {
    path: '/LoginCoach',
    name: 'adminLogin',
    component: LoginCoach
  },
  //新增球员计划
  {
    path:'/plan',
    component: Plan
  },
  {
    path:'/addplan',
    component:AddPlan
  },{
    path:'/salesStatisticsView',
    component:SalesStatisticsView
  },{
    path:'/player',
    component:Player
  },{
    path:'/addplayer',
    component:AddPlayer
  },{
    path:'/register',
    component:Register
  },{
    path:'/plancoach',
    component:PlanCoach
  },{
    path:'/playerupdate',
    component:PlayerUpdate
  },{
    path:'/addplayercoach',
    component:AddPlayerCoach
  },{
    path:'/footballcaoch',
    component:FootballCoach
  }
]
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
