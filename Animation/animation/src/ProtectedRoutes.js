import React, { useState,useEffect }  from 'react'
import {Outlet, Navigate} from 'react-router'
import Login from './pages/Login'
//import GhibliService from "./services/GhibliService";

function ProtectedRoutes(props) {
   function isLoginValid(){
       //console.log('props.user:'+props.user);
       if(props.user.includes('Logged in as'))
       {
           return true;
       }
      
      return false;
   }

  return (
    // isLoginValid() ? <Outlet/> : <Login/>
    isLoginValid() ? <Outlet/> : <Navigate to = "login"/>
  )
}

export default ProtectedRoutes