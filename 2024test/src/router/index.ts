
import { createRouter, createWebHistory } from 'vue-router'
import staff from '@/components/staff.vue'
import login from '@/components/login.vue'
import account from '@/components/account.vue'
import college from '@/components/college.vue'
import firstapply from '@/components/firstapply.vue'
import firstapplyresult from '@/components/firstapplyresult.vue'
import result from '@/components/result.vue'
import score from '@/components/score.vue'
import teachercheck from '@/components/teachercheck.vue'
import teachersubmit from '@/components/teachersubmit.vue'
import teacher from '@/components/teacher.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name:'staff',
      path:'/staff/:username/:password',
      component:staff,
      props:true,
      children:[{
        name:'account',
        path:'/account',
        component:account
        
      },
      {
        name:'firstapply',
        path:'/firstapply',
        component:firstapply
        
      },
      {
        name:'firstapplyresult',
        path:'/firstapplyresult',
        component:firstapplyresult
        
      },
      {
        name:'result',
        path:'/result',
        component:result
        
      },
      {
        name:'score',
        path:'/score',
        component:score
        
      }
    ]
    },
    {
      name:'login',
      path:'/login',
      component:login
    },
    {
      path:'/',
      redirect: '/login'
    },
    
    {
      name:'teacher',
      path:'/teacher/:username/:password',
      component:teacher,
      props:true,
      children:[
        {
          name: 'teachercheck',
          path: '/teachercheck/:username/:password',  // 相对路径，不需要包含参数
          component: teachercheck,
          props: true
        },
        {
          name: 'teachersubmit',
          path: '/teachersubmit/:username/:password',  // 相对路径，不需要包含参数
          component: teachersubmit,
          props: true
        }
        
      ]
    },
    {
      name:'college',
      path:'/college',
      component:college
    }
  ]
})

export default router
