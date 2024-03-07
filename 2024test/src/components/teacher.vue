<template>  <el-container class="layout-container-demo">
    <el-aside width="200px">
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon></el-icon>Navigator One
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <el-menu-item @click="teachersubmit" index="1-1">提交复试成绩</el-menu-item>
              <el-menu-item @click="teachercheck" index="1-2">成绩复查审核</el-menu-item>
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
              ></el-icon>
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
    <router-view></router-view>
    </el-container>
  </el-container>

</template>
<script>
export default{
    name:'teacher'
}
</script>
<script setup>
import { useRouter } from 'vue-router';
const router = useRouter();
import axios from "axios";
import account from './account.vue'
import { ref } from 'vue'
import { reactive } from 'vue'
import { ElMessageBox } from 'element-plus'
const form = reactive({
  name: '',
  number:'',
  major:'',
  score:'',
  current:'',
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
})

const { username, password } = defineProps(['username', 'password']);

function teachercheck() {
    router.push( {name:'teachercheck',params
    :{
username,
password
    }
  }
    );
}

function teachersubmit() {
    router.push( {name:'teachersubmit',params
    :{
username,
password
    }
  });
}
</script>