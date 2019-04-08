<?php
    $errorEmail=$errorPass=$errorRPass=$errorMPass=$errorFPass=$errorName=$errorPhone=NULL;
    $emailExists=$nameExists=NULL;
    
    //Check input user/password
    if(isset($_POST['btnRegister'])) {
        if($_POST['txtEmail'] == NULL) {
            $errorEmail = 'Email is required';
        } else {
            $inputEmail = $_POST['txtEmail'];
        }
        if($_POST['txtName'] == NULL) {
            $errorName = 'Display name is required';
        } else {
            $inputName = $_POST['txtName'];
        }
        if($_POST['txtPass'] == NULL) {
           $errorPass = 'Password is required';
        } else if($_POST['txtRPass'] == NULL) {
            $errorRPass= 'Repeat password';
        } else if($_POST['txtPass'] != $_POST['txtRPass']) {
            $errorMPass= 'Password does not match the Repeat password';
        }
        if(isset($_POST['txtPass'])) {
            $inputPass = $_POST['txtPass'];
            if (preg_match("/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/",$inputPass)){
                $pass = md5($inputPass);
            } else {
                $errorFPass = 'Minimum eight characters, at least one uppercase letter, 
                               one lowercase letter and one number';
            }
        }
        $joinDate= date("Y-m-d");
        if (isset($_POST['phoneNumber'])) {
            $phoneNumber= $_POST['phoneNumber'];
            if (preg_match("/^[0-9]{8,15}/",$phoneNumber)) {
                $phone = $phoneNumber;
            } else {
                $errorPhone='Enter invalid Phonenumber(Max 15 digits)';
            }
        }

        //Ket noi csdl
        if(isset($inputEmail,$inputPass,$inputName,$phone,$pass)) {
            $conn = mysqli_connect('localhost','root','','TruyenQQ');
            if(!$conn) {
                die('connection failed');
            }
           
            //check user exist
            $getEmailExists="SELECT * FROM NguoiDung WHERE Email='$inputEmail'";
            $result1= mysqli_query($conn,$getEmailExists);
            $getNameExists="SELECT * FROM users WHERE TenDangNhap='$inputName'";
            $result2= mysqli_query($conn,$getNameExists);
            if(mysqli_num_rows($result1)>0) {
                $emailExists = "Email exists. Try again";
            } else if(mysqli_num_rows($result2)>0) {
                $nameExists = "Display name exists. Try again";
            } else {
                //insert user
                $insertUser = "INSERT INTO  NguoiDung(TenDangNhap,Email,Password,NgayThamGia,Level) VALUES('$inputName','$inputEmail','$pass','$joinDate',1)";
                $resultInsert = mysqli_query($conn,$insertUser);
                if (!$resultInsert) {
                    die('insert error');
                }
            }
            mysqli_close($conn);
        }
    }
?>
    