<template>
    
     <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="major" label="专业名称" width="180" />
    <el-table-column prop="number" label="调剂人数" width="180" />
    <el-table-column prop="scoreneed" label="调剂总分要求" width="180" />
    <el-table-column prop="politics" label="政治要求" width="180" />
    <el-table-column prop="english" label="英语要求" width="180" />
    <el-table-column prop="math" label="数学要求" width="180" />
    <el-table-column prop="deadline" label="截止时间"  />
  </el-table>
  <el-button @click="seek">查询</el-button>
</template>

<script setup>
import { onMounted, reactive, ref } from 'vue'
import axios from 'axios'
let input = ref('')
let tableData=ref([])
function seek(){
    axios.post("http://localhost:8080/seekstudentneed").then(
                    result => {
                      console.log(result.data);
                    
                        if (result.data) {
                          tableData.value=result.data
                          console.log(tableData.value);
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
}
onMounted(() => {
  // 页面加载时执行 seek 方法初始化表格数据
  seek();
});
</script>