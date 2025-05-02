<template>
	<div class="pitch max">
		<div class="top-half">
			<div class="ten-yard-circle"></div>
			<div class="penalty-area">
				<div class="spot"></div>
			</div>
			<div class="six-yard-box"></div>
			<div class="corner top-left"></div>
			<div class="corner top-right"></div>
		</div>
		<div class="half-way-line"></div>
		<div class="centre-circle">
			<div class="spot"></div>
		</div>
		<div class="bottom-half">
			<div class="ten-yard-circle"></div>
			<div class="penalty-area">
				<div class="spot"></div>
			</div>
			<div class="six-yard-box"></div>
			<div class="corner bottom-left"></div>
			<div class="corner bottom-right"></div>
		</div>
	</div>


	<img :src="imgurl1" :class="box1">
	<img :src="imgurl2" :class="box2">
	<img :src="imgurl3" :class="box3">
	<img :src="imgurl4" :class="box4">
	<img :src="imgurl5" :class="box5">
	<img :src="imgurl6" :class="box6">
	<img :src="imgurl7" :class="box7">
	<img :src="imgurl8" :class="box8">
	<img :src="imgurl9" :class="box9">
	<img :src="imgurl10" :class="box10">
	<img :src="imgurl11" :class="box11">
	<!-- <el-image :src="imgurl1" :class="box" error="errorImg"/> -->
	 <!-- <el-image :src="imgurl2" :class="box" /> -->
<!--	<el-image :src="imgurl3" class="box3" />
	<el-image :src="imgurl4" class="box4" />
	<el-image :src="imgurl5" class="box5" />
	 <el-image :src="imgurl6" class="box6" />
	<el-image :src="imgurl7" class="box7" /> -->
<!--	<el-image :src="imgurl8" class="box8" />
	<el-image :src="imgurl9" class="box9" />
	<el-image :src="imgurl10" class="box10" />
	<el-image :src="imgurl11" class="box11" /> -->
	<!-- <el-image :src="imgurl1"  class="box1" style="width: 100px; height: 100px ; position: absolute; left: 20px; " />      -->


	<!-- 
	<el-form-item label="商品图片">
        <el-image :src="imgurl" style="width: 100px; height: 100px" />
    </el-form-item> -->
	<!-- <div class="box1">
		

	</div> -->
	<!-- <div class="box1">
	<img class="img" alt="" src="../material/Picture/10.jpeg">
	</div>
	<div class="box2">
	<img class="img" alt="" src="../material/Picture/12.jpeg">
	</div>
	<div class="box3">
	<img class="img" alt="" src="../material/Picture/11.jpeg">
	</div>
	<div class="box4">
	<img class="img" alt="" src="../material/Picture/7.jpeg">
	</div>
		<div class="box5">
	<img class="img" alt="" src="../material/Picture/1.jpeg">
	</div>
		<div class="box6">
	<img class="img" alt="" src="../material/Picture/8.jpeg">
	</div>
		<div class="box7">
	<img class="img" alt="" src="../material/Picture/9.jpeg">
	</div>
		<div class="box8">
	<img class="img" alt="" src="../material/Picture/11.jpeg">
	</div>
		<div class="box9">
	<img class="img" alt="" src="../material/Picture/5.jpeg">
	</div>
		<div class="box10">
	<img class="img" alt="" src="../material/Picture/7.jpeg">
	</div> -->
</template>
<script>
export default {
	created: function () {
		// this.loadStaffs(),
		this.loadPost()
	},
	data() {
		return {
			box1:'',
			box3:'',
			imgurl:'',
			imgurl1: '',
			imgurl2: '',
			imgurl3: '',
			imgurl4: '',
			imgurl5: '',
			imgurl6: '',
			imgurl7: '',
			imgurl8: '',
			imgurl9: '',
			imgurl10: '',
			imgurl11: '',

		}
	},
	methods: {
		loadPost() {
			this.$axios
				.get('/getplayercoach')
				.then(successResponse => {
					// alert(JSON.stringify(successResponse.data.player))
					// if(successResponse.data.player.post_id == 4)
					// this.imgurl= require('../assets/' + successResponse.data.player[5].picture)
					this.box1='box0'
					this.box2='box0'
					this.box3='box0'
					this.box4='box0'
					this.box5='box0'
					this.box6='box0'
					this.box7='box0'
					this.box8='box0'
					this.box9='box0'
					this.box10='box0'
					this.box11='box0'
					this.box12='box0'
					for (let i = 0; i < successResponse.data.player.length; i++) {
						// alert(JsuccessResponse.data.player )
						if (successResponse.data.player[i].post_id == 1) {
							
							this.imgurl1 = require('../assets/' + successResponse.data.player[i].picture)
							this.box1='box1'
						}
						
						if (successResponse.data.player[i].post_id == 2) {

							this.imgurl2 = require('../assets/' + successResponse.data.player[i].picture)
							this.box2='box2'
						}
						if (successResponse.data.player[i].post_id == 3) {

							this.imgurl3 = require('../assets/' + successResponse.data.player[i].picture)
							this.box3='box3'
						}
						if (successResponse.data.player[i].post_id == 4) {

							this.imgurl4 = require('../assets/' + successResponse.data.player[i].picture)
							this.box4='box4'
						}
						if (successResponse.data.player[i].post_id == 5) {

							this.imgurl5 = require('../assets/' + successResponse.data.player[i].picture)
							this.box5='box5'
						} 
						if (successResponse.data.player[i].post_id == 6) {

							this.imgurl6 = require('../assets/' + successResponse.data.player[i].picture)
							this.box6='box6'
						}
						 if (successResponse.data.player[i].post_id == 7) {

							this.imgurl7 = require('../assets/' + successResponse.data.player[i].picture)
							this.box7='box7'
						}
						if (successResponse.data.player[i].post_id == 8) {

							this.imgurl8 = require('../assets/' + successResponse.data.player[i].picture)
							this.box8='box8'
						}
						if (successResponse.data.player[i].post_id == 9) {

							this.imgurl9 = require('../assets/' + successResponse.data.player[i].picture)
							this.box9='box9'
						}
						if (successResponse.data.player[i].post_id == 10) {

							this.imgurl10 = require('../assets/' + successResponse.data.player[i].picture)
							this.box10='box10'
						}
						if (successResponse.data.player[i].post_id == 11) {

							this.imgurl11 = require('../assets/' + successResponse.data.player[i].picture)
							this.box11='box11'
						}
						// if (successResponse.data.player[i].post_id == 12) {

						// 	this.imgurl12 = require('../assets/' + successResponse.data.player[i].picture)
						// 	this.box12='box12'
						// }


						// data11.push(successResponse.data.player[i].picture)
						// data22.push(successResponse.data.player[i].post_id)
						// data22.push(res.data.player[i].price)
						// data33.push(res.data.player[i].score)
					}
				})
				.catch(failResponse => {
					this.$alert(failResponse.response.status)
				})
		},
	}



}
</script>
<style scoped>
@charset "UTF-8";

* {
	box-sizing: border-box;
}

.pitch {
	background-color: #696;
	background-image: repeating-linear-gradient(#696, #696 6.9230769231vh, #6c9d6c 6.9230769231vh, #6c9d6c 13.8461538462vh);
	border: solid 0.1384615385vh #fff;
	box-shadow: 0 0 2.7692307692vh 2.7692307692vh #696;
	font-size: 3.5px;
	left: 50%;
	overflow: hidden;
	position: absolute;
	z-index: 1;
	top: 50%;
	transform: translate(-50%, -50%);

}

.pitch.max {
	height: 90vh;
	width: 69.2307692308vh;
}

.pitch.min {
	height: 69.2307692308vh;
	width: 34.6153846154vh;
}

.pitch .spot {
	background-color: #fff;
	border-radius: 50%;
	height: 0.5538461538vh;
	left: 50%;
	position: absolute;
	width: 0.5538461538vh;
}

.pitch .half-way-line {
	background-color: #fff;
	height: 0.1384615385vh;
	left: 0;
	position: absolute;
	right: 0;
	top: 50%;
	transform: translate(0, 0.0692307692vh);
}

.pitch .centre-circle {
	border: solid 0.1384615385vh #fff;
	border-radius: 50%;
	height: 13.8461538462vh;
	left: 50%;
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%);
	width: 13.8461538462vh;
}

.pitch .centre-circle .spot {
	top: 50%;
	transform: translate(-50%, -25%);
}

.pitch .ten-yard-circle {
	border: solid 0.1384615385vh #fff;
	border-radius: 50%;
	height: 13.8461538462vh;
	left: 50%;
	position: absolute;
	transform: translate(-50%, 0);
	width: 13.8461538462vh;
}

.pitch .corner {
	border: solid 0.1384615385vh #fff;
	border-radius: 50%;
	height: 1.3846153846vh;
	position: absolute;
	width: 1.3846153846vh;
}

.pitch .penalty-area {
	border: solid 0.1384615385vh #fff;
	left: 50%;
	height: 12.4615384615vh;
	position: absolute;
	transform: translate(-50%, 0);
	width: 30.4615384615vh;
}

.pitch .six-yard-box {
	border: solid 0.1384615385vh #fff;
	left: 50%;
	height: 4.1538461538vh;
	position: absolute;
	transform: translate(-50%, 0);
	width: 13.8461538462vh;
}

.pitch .top-half .ten-yard-circle {
	clip: rect(11.0769230769vh, 13.8461538462vh, 13.8461538462vh, 0vh);
	top: 1.2461538462vh;
}

.pitch .top-half .penalty-area {
	top: -0.1384615385vh;
}

.pitch .top-half .penalty-area .spot {
	top: 8.3076923077vh;
	transform: translate(-50%, -50%);
}

.pitch .top-half .six-yard-box {
	top: -0.1384615385vh;
}

.pitch .top-half .corner {
	top: 0;
}

.pitch .top-half .corner.top-left {
	left: 0;
	transform: translate(-50%, -50%);
}

.pitch .top-half .corner.top-right {
	right: 0;
	transform: translate(50%, -50%);
}

.pitch .bottom-half .ten-yard-circle {
	bottom: 1.2461538462vh;
	clip: rect(0vh, 13.8461538462vh, 2.7692307692vh, 0vh);
}

.pitch .bottom-half .penalty-area {
	bottom: -0.1384615385vh;
}

.pitch .bottom-half .penalty-area .spot {
	bottom: 8.3076923077vh;
	transform: translate(-50%, 50%);
}

.pitch .bottom-half .six-yard-box {
	bottom: -0.1384615385vh;
}

.pitch .bottom-half .corner {
	bottom: 0;
}

.pitch .bottom-half .corner.bottom-left {
	left: 0;
	transform: translate(-50%, 50%);
}

.pitch .bottom-half .corner.bottom-right {
	right: 0;
	transform: translate(50%, 50%);
}
.box0{

	width: 0px;
	height: 0px;
	display: block;
}
.box1 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;
	top: 60px;
	left: 900px;
	position: fixed;
	display: inline-block;

}

.box2 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;
	position: fixed;
	top: 120px;
	left: 730px;
	display: inline-block;
}

.box3 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 60px;
	left: 550px;
	display: inline-block;
}

.box4 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 10px;
	left: 730px;
	display: inline-block;
}

.box5 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;
	position: fixed;
	top: 280px;
	left: 600px;
	display: inline-block;
}

.box6 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;
	position: fixed;
	top: 280px;
	left: 850px;
	display: inline-block;
}

.box7 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 400px;
	left: 730px;
	display: inline-block;
}

.box8 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 400px;
	left: 500px;
	display: inline-block;
}

.box9 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 500px;
	left: 650px;
	display: inline-block;
}

.box10 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;

	position: fixed;
	top: 500px;
	left: 800px;
	display: inline-block;
}

.box11 {
	z-index: 10;
	width: 100px;
	height: 100px;
	border-radius:50%;
	position: fixed;
	top: 600px;
	left: 720px;
	display: inline-block;
}

.img {
	width: 100px;
	height: 100px;
	border-radius: 50%;

}
</style>