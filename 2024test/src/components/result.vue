<template>
    <el-form-item label="报名号">
      <el-input v-model="number" />
    </el-form-item>
    <el-button @click="checkscore"></el-button>
    <el-text>{{ resul}}</el-text>
</template>
<script setup lang="ts">
import axios from 'axios'
import {ref} from 'vue'
let number=ref('')
let resul=ref('')
function checkscore(){
    axios.post("http://localhost:8080/checkresult",{userid:number.value}).then(
                    result => {
                        if (result.data ) {
                         resul.value=result.data
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
}
</script>