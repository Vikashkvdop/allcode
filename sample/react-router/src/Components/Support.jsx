import React from "react"
import { useNavigate } from "react-router-dom"


const Support=()=>{
    const navigate=useNavigate();
    function clickHandler(){
        navigate(-1);
    }
    return(
        <div>
            This page is Support page
            <div>
                <button onClick={clickHandler} >Go Back</button>
            </div>
        </div>
    )
}

export default Support