//main function caled when form gets submitted
function validateForm(){
    
    //getting values from form
    var validEmail = validateEmail();
    var validNumber = validateNumber();
    var validPassword= validatePassword();
    
    //disables form submit when something not valid
    if( validName == validEmail == validNumber == validUsername == validPassword == true){
        return true;
    }else{
        return false;
    }  
    
}

//validates email using regex
function validateEmail() {
  //getting values
  var email = document.getElementById('email').value;
  //css elements
  var elementBorder = document.getElementById("emailDiv");
  let elementError = document.getElementById('emailError');
  
  //checking email for validation using regex
  if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please enter your email.';
    return false;
  }else{
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
    return true;
  } 
}

//validating phone number
function validateNumber(){

//getting values
  var number = document.getElementById('number').value;
  //getting css values
  var elementBorder = document.getElementById("numberDiv");
  let elementError = document.getElementById('numberError');
  
  //checking phone number for validation using regex
  if (!(number.match(/^\d{10}$/))) {
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please enter your Phone number.';
    return false;
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
    return true;
  }
}

//validate password
function validatePassword(){
//getting values
  var password = document.getElementById('password').value;
  //getting values =css
  var elementBorder = document.getElementById("passwordDiv");
  let elementError = document.getElementById('passwordError');
  
  //checking password for validation using regex
 if (!(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/.test(password))) {
  elementBorder.classList.remove("success");
  elementBorder.classList.add("error");
  return false;
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
    return true;
  }
}
 
