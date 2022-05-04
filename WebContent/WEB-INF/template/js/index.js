
function validateForm(){
    console.log("also working")
    
    var validName= validateFullName();
    var validEmail = validateEmail();
    var validNumber = validateNumber();
    var validUsername= validateUsername();
    var validPassword= validatePassword();
    
    console.log(validName)
    console.log(validEmail)
    console.log(validNumber)
    console.log(validUsername)
    console.log(validPassword)
    
    if( validName == validEmail == validNumber == validUsername == validPassword == true){
        console.log("Everything valid")
        return true;
    }else{
        console.log("Not valid")
        return false;
    }
    
    
}

function validateFullName() {
  var fullName = document.getElementById('full_name').value;
  var elementBorder = document.getElementById("nameDiv");
  let elementError = document.getElementById('nameError');
  
  if (fullName === '') { 
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please enter your name.';
    return false;
    } else {
      elementError.innerHTML = '';
      elementBorder.classList.remove("error");
      elementBorder.classList.add("success");
      return true;
   
    }
}

function validateEmail() {
  var email = document.getElementById('email').value;
  var elementBorder = document.getElementById("emailDiv");
  let elementError = document.getElementById('emailError');
  //checking email for validation
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
function validateNumber(){
  var number = document.getElementById('number').value;
  var elementBorder = document.getElementById("numberDiv");
  let elementError = document.getElementById('numberError');
  //checking phone number for validation
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
function validateGender(){
  var gender = document.getElementById('Gender').value;
  var elementBorder = document.getElementById("genderDiv");
  let elementError = document.getElementById('genderError');
  //checking gender value for validation
  if (gender === '') {
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please select gender.';
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
  }
}
function validateUserType(){
  var gender = document.getElementById('UserType').value;
  var elementBorder = document.getElementById("usertypeDiv");
  let elementError = document.getElementById('usertypeError');
  //checking gender value for validation
  if (gender === '') {
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please select Usertype.';
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
  }
}
function validateUsername(){
  var username = document.getElementById('username').value;
  var elementBorder = document.getElementById("usernameDiv");
  let elementError = document.getElementById('usernameError');
  if (username === '') { 
    elementBorder.classList.remove("success");
    elementBorder.classList.add("error");
    elementError.innerHTML = 'Please enter your Username.';
    return false;
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
    return true;
  }
}
function validatePassword(){
  var password = document.getElementById('password').value;
  var elementBorder = document.getElementById("passwordDiv");
  let elementError = document.getElementById('passwordError');
  //checking password for validation
 if (!(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/.test(password))) {
  elementBorder.classList.remove("success");
  elementBorder.classList.add("error");
  elementError.innerHTML = 'Please enter a valid password.';
  return false;
  } else {
    elementError.innerHTML = '';
    elementBorder.classList.remove("error");
    elementBorder.classList.add("success");
    return true;
  }
}
 
//Enters the data into the JSON array
function checkValidation () {
var boleanValue=validateFullName();
console.log(boleanValue)
}