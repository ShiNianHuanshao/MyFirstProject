<template>
  <el-text>学生成绩{{ tableData.score }}</el-text>
 <el-text>报名号{{ tableData.number }}</el-text>
      <el-input v-model="retestScore"></el-input>
      <el-button @click="onSubmit">提交</el-button>
      <el-button @click="seek">查询</el-button>
</template>

<script setup lang="ts">
import axios from 'axios';
import { ref, reactive } from 'vue';
const { username, password } = defineProps(['username', 'password']);

let tableData = ref(
  {
    name: '',
    number: '',
    major: '',
    score: '',
    current: '',
    english: '',
    math: '',
    majorscore: '',
    state: '',
    because: '',
    button: '',
    firstteacher: '',
    secondteacher: '',
    thirdteacher: '',
    average: '',
    firstname: '',
    secondname: '',
    thirdname: '',
    apply: '',
    time: ''
  }
);
let retestScore = ref('');
function seek() {
  console.log(username)
  axios.post("http://localhost:8080/seekstudentneedbyteacher",{username} )
  .then(response => {
    if (response.data) {
      tableData = response.data;
    } else {
      // 处理无数据的情况
    }
  })
  .catch(error => {
    console.error(error);
  });
}

const onSubmit = () => {
  if(username.value==tableData.value.firstname)
  tableData.value.firstteacher=retestScore.value
  {axios.post("http://localhost:8080/updatefirstapply", { retestScore: retestScore.value }).then(
    result => {
      // Handle the result if needed
    }).catch(error => {
      console.error(error);
    });}
    if(username.value==tableData.value.secondteacher)
    {
      tableData.value.secondteacher=retestScore.value
      axios.post("http://localhost:8080/updatefirstapply", { retestScore: retestScore.value }).then(
    result => {
      // Handle the result if needed
    }).catch(error => {
      console.error(error);
    });
    }
    if(username.value==tableData.value.thirdteacher)
    {
      tableData.value.thirdteacher=retestScore.value
      axios.post("http://localhost:8080/updatefirstapply", { retestScore: retestScore.value }).then(
    result => {
      // Handle the result if needed
    }).catch(error => {
      console.error(error);
    });
    }
}
import { onMounted} from 'vue'
onMounted(() => {
  // 页面加载时执行 seek 方法初始化表格数据
  seek();
});
</script>
