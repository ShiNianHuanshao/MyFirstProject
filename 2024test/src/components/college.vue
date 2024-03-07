<template>
     <el-container class="layout-container-demo">
    <el-aside width="200px">
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><message /></el-icon>Navigator One
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <el-menu-item index="1-1"></el-menu-item>
              <el-menu-item index="1-2">Option 2</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
         
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px"
              ><setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>Tom</span>
        </div>
      </el-header>
      <el-button plain @click="dialogVisible = true">
    添加调研计划
  </el-button>

  <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="500"
    :before-close="handleClose"
  >
  <el-form :model="form" label-width="120px">
    <el-form-item label="专业名称">
      <el-input v-model="form.major" />
    </el-form-item>
    <el-form-item label="调剂人数">
      <el-input v-model="form.number" />
    </el-form-item>
    <el-form-item label="政治要求">
      <el-input v-model="form.politics" />
    </el-form-item>
    <el-form-item label="英语要求">
      <el-input v-model="form.english" />
    </el-form-item>
    <el-form-item label="数学要求">
      <el-input v-model="form.math" />
    </el-form-item>
    <el-form-item label="调剂总分要求">
      <el-input v-model="form.scoreneed" />
    </el-form-item>
    <el-form-item label="Activity time">
      <el-col :span="11">
        <el-date-picker
          v-model="form.deadline"
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
  </el-dialog>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="name" label="学生姓名" width="180" />
    <el-table-column prop="number" label="学号" width="180" />
    <el-table-column prop="score" label="总成绩" width="180" />
    <el-table-column prop="english" label="英语成绩" width="180" />
    <el-table-column prop="math" label="数学成绩" width="180" />
    <el-table-column prop="current" label="政治成绩" width="180" />
    <el-table-column prop="majorscore" label="专业成绩" width="180" />
    <el-table-column prop="apply" label="是否能够加入复试" width="180" />
    <el-table-column prop="average" label="复试平均分" width="180" />
    <el-table-column prop="major" label="申请专业" />
    <el-table-column prop="state" label="是否通过录取" width="180" />
    <el-table-column fixed="right" label="Operations" width="120">
  <template #default="scope">
    <el-button link type="primary" size="small" @click="pass(scope.row)">
      通过
    </el-button>
    <el-button link type="primary" size="small">不通过</el-button>
  </template>
</el-table-column>
  </el-table>
  <el-button @click="changefirstapply">自动审查学生资质</el-button>
    </el-container>
  </el-container>
    
</template>
<script setup lang="ts">

import { reactive,ref} from 'vue';
import axios from 'axios'
import { ElMessageBox } from 'element-plus'
let dialogVisible = ref(false)
const form = reactive({
  number:'',
  needstudent:'',
  major:'',
  scoreneed:'',
  politics:'',
  english:'',
  math:'',
  deadline:''
})
let number=ref('')
let tableData = ref([{
  name: '',
  number:'',
  major:'',
  score:'',
  current:'1',
  english:'',
  math:'',
  majorscore:'',
  state:'',
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
}])
const onSubmit = () => {
  dialogVisible.value = false
  axios.post("http://localhost:8080/insertneedstudent",form).then(
                    result => {
                    }).catch(error => {
                        console.error(error);
                    });
}
const handleClose = (done: () => void) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
  }
  function changefirstapply(){
    axios.post("http://localhost:8080/changefirstapply").then(
                    result => {
                        if (result.data ) {
                            tableData.value=result.data
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
  }
  function pass(row: { number: any; })
  {
    console.log(row.number)
    axios.post("http://localhost:8080/changethirdapply",{number:row.number}).then(
                    result => {
                        if (result.data) {
                            tableData.value=result.data
                        } else {
                        }
                    }).catch(error => {
                        console.error(error);
                    });
  }
</script>