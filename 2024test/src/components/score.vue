<template>
    <el-form-item label="报名号">
      <el-input v-model="number" />
    </el-form-item>
    <el-button @click="onsubmit">
        申请成绩复查
    </el-button>
</template>
<script setup lang="ts">
import {ref} from 'vue'
import axios from 'axios';
let number =ref('')
function onsubmit(){
    axios.post("http://localhost:8080/changescore",number.value).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}
</script>
