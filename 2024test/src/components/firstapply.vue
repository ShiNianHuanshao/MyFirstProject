<template>
     <el-form :model="form" label-width="120px">
    <el-form-item label="姓名">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="报名号">
      <el-input v-model="form.number" />
    </el-form-item>
    <el-form-item label="总分">
      <el-input v-model="form.score" />
    </el-form-item>
    <el-form-item label="思想政治理论">
      <el-input v-model="form.current" />
    </el-form-item>
    <el-form-item label="英语">
      <el-input v-model="form.english" />
    </el-form-item>
    <el-form-item label="数学">
      <el-input v-model="form.math" />
    </el-form-item>
    <el-form-item label="专业综合">
      <el-input v-model="form.majorscore" />
    </el-form-item>
    <el-form-item label="调剂专业">
      <el-select v-model="form.major" placeholder="请选择你的专业">
        <el-option label="计算机专业" value="计算机专业" />
        <el-option label="软件工程专业" value="软件工程专业" />
        <el-option label="电子信息工程专业" value="电子信息工程专业专业" />
      </el-select>
    </el-form-item>
    <el-form-item label="Activity time">
      <el-col :span="11">
        <el-date-picker
          v-model="form.time"
          type="date"
          placeholder="Pick a date"
          style="width: 100%"
        />
      </el-col>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</template>
<script setup lang="ts">
import { reactive } from 'vue'
import axios from 'axios'

let form = reactive({
  name: '',
  number:'',
  major:'',
  score:'',
  current:'1',
  english:'',
  math:'',
  majorscore:'',
  state:'0',
  because:'',
  button:'',
  firstteacher:'0',
  secondteacher:'0',
  thirdteacher:'0',
  average:'0',
  firstname:'',
  secondname:'',
  thirdname:'',
  apply:'0',
  time:''
})

const onSubmit = () => {
  const payload = {
    name: form.name,
    number: form.number,
    major: form.major,
    score: form.score,
    current: form.current,
    english: form.english,
    math: form.math,
    majorscore: form.majorscore,
    state: form.state,
    because: form.because,
    button: form.button,
    firstteacher: form.firstteacher,
    secondteacher: form.secondteacher,
    thirdteacher: form.thirdteacher,
    average: form.average,
    firstname: form.firstname,
    secondname: form.secondname,
    thirdname: form.thirdname,
    apply: form.apply,
    time: form.time
  };
  axios.post("http://localhost:8080/insertfirstapply", payload).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}
</script>