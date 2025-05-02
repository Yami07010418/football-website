<!-- 每个页面的最上方的导航栏 -->
<template>
  
  <div class="out">
    <img class="liverpool" src="../assets/liverpoolfc.png" alt="">
    <img class="pattern" src="../assets/R.jpg" alt="">
    <img class="pattern2" src="../assets/Liverpool2.jpg" alt="">
    <h3>利物浦足球俱乐部管理</h3>
  </div>
 

<el-menu
  :default-active="activeIndex"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#ed0e15"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-submenu index="1">
    <template #title>计划管理</template>
    <!-- 跳转到哪由路由决定 -->
    <el-menu-item index="1-1"><router-link to="/plan" class="a">训练计划</router-link></el-menu-item>
    <el-menu-item index="1-2"><router-link to="/addplan" class="a">新增训练计划</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="2">
    <template #title>球员数据管理</template>
    <el-menu-item index="2-1"><router-link to="/salesStatisticsView" class="a">球员数据</router-link></el-menu-item>
    <el-menu-item index="2-2"><router-link to="/playerupdate" class="a">修改球员数据</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="3">
    <template #title>球队阵容管理</template>
    <el-menu-item index="3-1"><router-link to="/football" class="a">球队阵容</router-link></el-menu-item>
    <el-menu-item index="3-2"><router-link to="/addplayercoach" class="a">新增阵容</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="4">
    <template #title>球员考核管理</template>
    <el-menu-item index="4-1"><router-link to="/player" class="a">管理球员考核</router-link></el-menu-item>
    <el-menu-item index="4-2"><router-link to="/addplayer" class="a">新增球员考核</router-link></el-menu-item>
  
  </el-submenu>
  <!-- <el-menu-item index="5"><router-link to="/peroidOp" class="a">试训管理</router-link></el-menu-item>
  <el-submenu index="6">
      <template #title>球员转会管理</template>
      <el-menu-item index="5-1"><router-link to="/addTransferStaff" class="a">录入岗位调动</router-link></el-menu-item>
      <el-menu-item index="5-2"><router-link to="/transferStaff" class="a">查询调动球员</router-link></el-menu-item>
  </el-submenu>
   <el-submenu index="7">
      <template #title>球员离队管理</template>
      <el-menu-item index="6-1"><router-link to="/addQuit" class="a">录入离队球员</router-link></el-menu-item>
      <el-menu-item index="6-2"><router-link to="/quit" class="a">查询已离队球员</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="8">
      <template #title>球员数据管理</template>
      <el-menu-item index="7-1"><router-link to="/newStaffReport" class="a">新聘球员报表</router-link></el-menu-item>
      <el-menu-item index="7-2"><router-link to="/quitStaffReport" class="a">离队球员报表</router-link></el-menu-item>
      <el-menu-item index="7-3"><router-link to="/transferStaffReport" class="a">岗位调动报表</router-link></el-menu-item>
      <el-menu-item index="7-4"><router-link to="/football" class="a">场上位置</router-link></el-menu-item>
      <el-menu-item index="7-5"><router-link to="/salesStatisticsView" class="a">球员数据</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="9">
      <template #title>训练计划管理</template>
      <el-menu-item index="8-1"><router-link to="/plan" class="a">每日训练计划显示</router-link></el-menu-item>
      <el-menu-item index="8-2"><router-link to="/addplan" class="a">新增训练计划</router-link></el-menu-item>
  </el-submenu> -->
  <!-- <el-submenu index="9">
      <template #title>球员考核管理</template>
  </el-submenu>
  <el-submenu index="10">
      <template #title>球队队史管理</template>
  </el-submenu> -->
  <el-menu-item index="11" ><router-link to="/Login" class="a">管理员登录</router-link></el-menu-item>
  <el-menu-item index="12" @click="handleLogout">退出登录</el-menu-item>
  <el-menu-item index="13" ><router-link to="/register" class="a">注册</router-link></el-menu-item>
  
</el-menu>

</template>
<script >
  export default {
    name: 'NavMain',
    data() {
      return {
        //员工信息中心点亮
        activeIndex: '9'
      }
      
    },
    
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        //修改loginin状态 这样把none存入login 把islogin变成0
        handleLogout() {
        this.$store.commit('changeLogin', null)      
        this.$store.commit('changeLogin', null)      
        //跳转到跟目录就push/
        this.$router.push('/')
        }
    }
  }
</script>
<style>
.liverpool{
  position: relative;
  left: 100px;

}
.pattern{

  height: 100px;
  position: relative;
  left: -700px;
  top: 20px;
}
.pattern2{
  height: 100px;
  position: relative;
  left: 600px;
  top: 20px;
}

  img{
    height: 100px;
  }
  h3{
    margin: 0px;
    padding: 0px;
  }

   .a{
       text-decoration: none;
       color: rgb(253, 253, 253);
   }
</style>
