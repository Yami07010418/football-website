<template>
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
</template>
<script>
export default {
    name: 'Navbottom',
}
</script>
<style scoped>
.bottom{
  width: 100%px;
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
  height: 120px;
  align-items:  center;
}
</style>