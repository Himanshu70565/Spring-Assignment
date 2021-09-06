function validateForm(){
    let username=document.loginForm.username.value;
    let password=document.loginForm.password.value;
    let labelUsername=document.getElementById("userId");
    let labelPassword=document.getElementById("userPassword");
    labelUsername.innerText="";
    labelPassword.innerText="";
    
    if(isEmpty(username)){
        labelUsername.innerText="Username field is empty";
        labelUsername.style.color="red";
        return false;
    }
    
    if(isEmpty(password)){
        labelPassword.innerText="Password field is empty";
        labelPassword.style.color="red";
        return false;
    }
    return true;
}


function isEmpty(field){
    field=field.trim();
    if(field==null||field==""){
        return true;
    }
    return false;
}