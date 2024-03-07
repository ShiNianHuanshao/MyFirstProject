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
              <el-menu-item @click="firstapply" index="1-1">调剂申请</el-menu-item>
              <el-menu-item @click="firstapplyresult" index="1-2">查看申请结果</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item @click="account" index="1-3">浏览调剂计划</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>Option4</template>
              <el-menu-item @click="score" index="1-4-1">成绩复查申请</el-menu-item>
              <el-menu-item @click="result" index="1-4-1">查看录取通知</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><icon-menu /></el-icon>Navigator Two
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <el-menu-item index="2-1">Option 1</el-menu-item>
              <el-menu-item index="2-2">Option 2</el-menu-item>
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
   
     <router-view></router-view>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import axios from "axios";
import { ref } from 'vue'
import { useRouter } from 'vue-router';
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
defineProps(['username','password'])
const router = useRouter();
function firstapply(){
  router.push('/firstapply')
}
function firstapplyresult(){
  router.push('/firstapplyresult')
}
function account(){
  router.push('/account')
}
function score(){
  router.push('/score')
}
function result(){
  router.push('/result')
}
</script>

<style scoped>
.layout-container-demo {
  width: 100%;
}
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>
