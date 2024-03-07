<template>
<el-button @click="check">查询 </el-button>
<el-text>学生成绩{{form.average  }}</el-text>
<el-form-item label="反馈">
      <el-input v-model="retu" />
    </el-form-item>
    <el-button @click="retur">提交</el-button>
</template>
<script setup lang="ts">
import axios from 'axios'
import {ref} from 'vue'
import {reactive} from 'vue'
const { username, password } = defineProps(['username', 'password']);
let form = reactive({
  name: '',
  number:'',
  major:'',
  score:'',
  current:'',
  english:'',
  math:'',
  majorscore:'',
  state:'0',
  because:'',
  button:'',
  firstteacher:'',
  secondteacher:'',
  thirdteacher:'',
  average:'',
  firstname:'',
  secondname:'',
  thirdname:'',
  apply:'',
  time:''
})
let result =ref('')
let retu =ref('')
function check(){
    axios.post("http://localhost:8080/checkbyteacher").then(
                    result => {
                        if (result.data) {
                            Object.assign(form, result.data)
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
}
function retur(){
    form.because=retu.value
    form.apply="0"
    axios.post("http://localhost:8080/updatefirstapply",form).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}



</script>