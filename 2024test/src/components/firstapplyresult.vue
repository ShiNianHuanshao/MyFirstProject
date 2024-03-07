<template>
     <el-form-item label="报名号">
      <el-input v-model="number" />
    </el-form-item>
    <el-button plain @click="checkfirstresult">
    点击查询
  </el-button>

  <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="500"
    :before-close="handleClose">
    <span v-if="form.state===up">通过</span>
    <span v-else>不通过</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="unjoin">不参加</el-button>
        <el-button v-if="form.state===up" type="primary" @click="join">参加</el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup lang="ts">
const up='1'
import axios from 'axios';
import { ref } from 'vue'
import {reactive} from 'vue'
import { ElMessageBox } from 'element-plus'
const dialogVisible = ref(false)
let number=ref('')
let form= ref({
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
  firstteacher:'0',
  secondteacher:'0',
  thirdteacher:'0',
  average:'',
  firstname:'',
  secondname:'',
  thirdname:'',
  apply:'',
  time:''
})
function checkfirstresult(){
  dialogVisible.value= true
  axios.post("http://localhost:8080/checkfirstresult",{userid:number.value}).then(
                    result => {
                        if (result.data ) {
                         form.value=result.data
                         console.log(result.data)
                         console.log(form.value)
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
}
const handleClose = (done: () => void) => {
  ElMessageBox.confirm('你确定关闭这个对话框吗?')
    .then(() => {
      done()
      
    })
    .catch(() => {
      
    })
}
function unjoin(){
  form.value.state="2"
  axios.post("http://localhost:8080/updatefirstapply", form).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}
function join(){
  form.value.state="0"
  axios.post("http://localhost:8080/updatefirstapply",form).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}
</script>