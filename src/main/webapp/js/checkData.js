/**
 * 
 检测注册
 */
 function check_register_data(){
        var user_value           = V('userLoginAccount','v');
        var userLoginPwd         = V('userLoginPwd','v');
        var register_comfirm_pwd = V('register_comfirm_pwd','v');       
        if(user_value == '邮箱' || user_value == ''){           
            mtl_tip('re_user','请输入用户名！(您的注册邮箱)',null,null,'hidden');         
            return false;
        }else{
             if(!mtl_checkemail(user_value)){
                  mtl_tip('re_user','邮箱格式不正确',null,null,'hidden');
                  return false;
             }
        }
        if(userLoginPwd == ''){
             mtl_tip('re_pwd','请设置密码！',null,null,'hidden');
             return false;
        }
        if(register_comfirm_pwd == ''){
             mtl_tip('re_pwd_comfirm','请输入确认密码！',null,null);
             return false;
        }
        if(userLoginPwd != register_comfirm_pwd){
             mtl_tip('re_pwd_comfirm','输入的确认密码不一致！',null,null);
             return false;
        }
         return true;           
 }
 
/**
 * 检测用户名的合法性
 * data 为ajax 请求的返回值
  0 为检测通过 1为已经存在  2为数据不是由汉字，字母，数字和下横线组合，
  3 长度30
 */
 function check_user(data){
    
    if(data == 0){
        mtl_tip('re_user','该用户名已经存在，请重新输入！',null,null);
       return false;
        
    }else if(data == -1){
        
         mtl_tip('re_user','邮箱格式不正确。',null,null,'hidden');
         return false; 
  
    }else if(data == 1){
        /*V('status','o').val(1);*/
        mtl_tip('re_user','该用户名可用！',null,null,'show');
        return true;
    }
 }
 /**
  * 登录数据能为空
  */
 function check_login(){
        var user_value    = V('l_user','v');
        var userLoginPwd  = V('l_pwd','v');
        if(user_value == '邮箱/手机号' || user_value == ''){
           mtl_tip('login_user','请输入邮箱/手机号！',null,null,'hidden');         
           return false;
        }
        if(userLoginPwd == ''){
           mtl_tip('login_pwd','请输入密码！',null,null,'hidden');         
           return false;
        }
        return true;
 }

 