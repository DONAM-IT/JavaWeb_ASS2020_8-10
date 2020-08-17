function hideShowPassword(order) {
    var x = document.getElementById("password" + order);
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function setSelectGender(order, gender) {
    let x = document.getElementById("gender" + order);
    x.value = gender;
}

function setSelectGenderInRegister(gender) {
    let x = document.getElementById("gender");
    x.value = gender;
}
