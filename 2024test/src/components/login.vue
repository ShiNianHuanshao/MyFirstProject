<template>
    <div class="login-back">
      <div class="  login-container" >
        <h2>考研信息管理系统</h2>
        <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules" label-position="top">
          <el-form-item prop="username" label="用户名">
            <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-radio-group v-model="userType" >
            <el-radio label="admin">管理员登录</el-radio>
            <el-radio label="user">用户登录</el-radio>
          </el-radio-group>
          <el-form-item>
            <el-button  type="primary" @click="login">登录</el-button>
            <el-button  @click="register">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
   
  <script setup>
  import {reactive, ref} from 'vue';
  import { useRouter } from 'vue-router';
  import axios from "axios";
  import {ElMessage} from "element-plus";
  const router = useRouter();
  const slideAnimation = ref('false');
   
   
  const userType = ref('admin');
  const imageU = ''
  const loginForm = reactive({
    username: '',
    password: '',
  });
  const loginRules = ref({     //若输入框为空，提示
    username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
    password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  });
  const loginFormRef = ref(null);
 

  const adminLogin = () => {
    const username = loginForm.username;
    const password = loginForm.password;
    localStorage.setItem('username', JSON.stringify(username));
     // 执行管理员登录逻辑
     console.log("Username:", loginForm.username);// 确保在调用 staff 函数之前 username 是正确的

     router.push('/college');
   
  };
 
  const login = () => {
    loginFormRef.value.validate(valid => {
      if (valid) {
        // 在这里进行登录逻辑处理
        if (userType.value === 'admin') {
          // 管理员登录
          adminLogin()
        } else {
          // 用户登录
          userLogin()
        }
      }
    });
  };
  const userLogin = () => {
    const username = loginForm.username;
    const password = loginForm.password;
    localStorage.setItem('username', JSON.stringify(username));
    console.log(username,password)
    axios.post("http://localhost:8080/stafflogin",{
                userid:username,
                password:password
            }).then(
                    result => {
                        if (result.data && result.data.data) {
                            if(result.data.data=="student")
                            {
                                alert("欢迎学生登录")
                                router.push({
                                  name:'staff',
                              params:{
                                username:username,
                                password:password
                              }}
                                )
                            }
                            if(result.data.data=="college")
                            {
                            alert("用户欢迎登录")
                            router.push('/college')
                            }
                            if(result.data.data=="teacher")
                            {
                            alert("欢迎教师登录")
                            router.push({
                                  name:'teacher',
                                  params:{
                                username:username,
                                password:password
                              }}
                                )
                            
                            }
                    
                        } 
                    }).catch(error => {
                        alert("用户名或密码错误")
                        ElMessage.error('失败');
                        console.error(error); 
                    });
  }
  
  const register = () => {
    // 跳转到注册页面的路由逻辑
    if (userType.value === 'admin') {
      router.push('/sign')
      // 管理员登录
    } else {
      // 用户登录
      router.push('/sign')
    }
  };

  </script>
   
  <style>
  .l-title{
    margin-top: 200px;
    font-size: 30px;
    text-align: center;
    justify-content: center;
  }
  .login-back {
    display: flex;
    flex-direction: row;
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-image: url("src/风景2.jpg");
  }
  .login-container {
    margin: 100px 0 0 600px ;
    max-width: 500px;
    height: 500px;
    padding: 40px;
    /*margin-top: 200px;*/
    /*margin-left: 1300px;*/
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #cccccc;
    opacity: 0.9; /* 设置透明度为 50% */
  }
  .login-container h2 {
    text-align: center;
    margin-top:50px ;
    margin-bottom: 50px;
  }
  .el-form-item .el-button {
    margin-left: 50px; /* 设置按钮之间的间距 */
    margin-right: 30px;
  }
  .el-radio-group .el-radio {
    margin-left: 30px;
  }
  .login-c{
    margin: 200px 0 0 600px;
    padding: 0;
    width: 382px;
    height: 580px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #cccccc;
    opacity: 0.9; /* 设置透明度为 50% */
  }
   
  </style>