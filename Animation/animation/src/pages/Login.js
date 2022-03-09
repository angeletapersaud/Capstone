import React, { useState, useContext,useEffect } from "react";
import { UserContext } from "../App";
import GhibliService from '../services/GhibliService';

function Login(props) {
  let [usernameLogin, setUsernameLogin] = useState("");
  let [passwordLogin, setPasswordLogin] = useState("");
  let [submittedLogin, setSubmittedLogin] = useState("false");

  // useEffect(()=>{
  //   document.getElementById("signoutBtn").hidden = false
  // })
  const userContext = useContext(UserContext);
  const handleChangeLogin = (event) => {
    if (event.target.id === "usernameLogin") {
      setUsernameLogin(event.target.value);
    } else {
      setPasswordLogin(event.target.value);
    }
  };

  //handle logout by calling dispatch with action type Loggin In
   const handleSubmitLogin = (event) => {
     let isLoggedIn = false
    event.preventDefault();
    console.log(usernameLogin);
    console.log(passwordLogin);
     GhibliService.logInToAnimationSite(usernameLogin,passwordLogin).then((res) => {
      if(res.data==='Successfully Logged In'){
          console.log('Successfully Logged In');
          isLoggedIn = true;
      }

      if(isLoggedIn){
        //consume useContext hook
        userContext.userDispatch({ type: "Logged In", usernameLogin });
        setUsernameLogin("");
        setPasswordLogin("");
        setSubmittedLogin((prevSubmitted) => "true");
        //document.getElementById("signoutBtn").hidden = false;
        
        }
         else{
           userContext.userDispatch({ type: "Invalid Creds", usernameLogin });
         }
      });
    
  };

  //handle logout by calling dispatch  with action type Logged Out
  function handleSubmitLogout() {
    //consume useContext hook 
    userContext.userDispatch({ type: "Logged Out" });
    setSubmittedLogin((prevSubmitted) => "false");
    //document.getElementById("signoutBtn").hidden = true;
  }

  return (
    <div id="LoginPgContainer">
       <div id="signoutBtnDiv">
        <button hidden = {submittedLogin === 'true'? false : true}   id="signoutBtn" onClick={() => handleSubmitLogout()}>
          Logout!
        </button>
       </div> 
      <div id="Login-Page" hidden={false}>
        <div id="formcontainer-Login">
          <form id="LoginForm" onSubmit={handleSubmitLogin}>
            <h2 id="logintitle">LOGIN</h2>
            <label className="form-label" htmlFor="usernameSignIn">
              Username:
            </label>
            <input
              id="usernameLogin"
              onChange={handleChangeLogin}
              value={usernameLogin}
            />

            <label className="form-label" htmlFor="passwordSignIn">
              Password:
            </label>
            <div id="passwordLogin"></div>
            <input
              id="passwordLogin"
              onChange={handleChangeLogin}
              value={passwordLogin}
              type="password"
            />
            <div>
              <button id="signinBtn">Login!</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
