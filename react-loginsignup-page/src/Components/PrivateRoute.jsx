import { Children } from "react"
import { Navigate } from "react-router-dom";


const PrivateRoute=({isLoggedIn,childern})=>{

    
  if(isLoggedIn){
    return childern;
  }
  else{
    return <Navigate to="/login" />
  }
}

export default PrivateRoute