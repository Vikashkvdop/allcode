import { useState } from "react"
import toast from "react-hot-toast"
import { AiOutlineEye,AiOutlineEyeInvisible } from "react-icons/ai"
import { useNavigate } from "react-router-dom"




const SignupForm=({setIsLoggedIn})=>{

    const [formData,setFormData]=useState({firstname:"",lastname:"",email:"",password:"",confirmpassword:""})
    const navigate=useNavigate();
    function changeHandler(event){
       setFormData((prevData)=>(
        {
            ...prevData,
            [event.target.name]:event.target.value
        }
       ))
    }

    const [showPassword,setShowPassword]=useState(false);
    const [confirmPassword,setConfirmPassword]=useState(false);

    function submitHandler(event){
        event.preventDefault();
        if(formData.password !=formData.confirmpassword){
            toast.error("Password do not match");
            return;
        }
        setIsLoggedIn(true);
        toast.success("Account Created");

        // const accountData={
        //     ...formData
        // };
        // console.log(accountData);
        navigate("/dashboard");
    }
    const [accountType,setAccountType]=useState("student");
    return(
        <div  >
            <div className="flex bg-gray-800 p-1 gap-x-1 my-6 rounded-full max-w-max " >
            <button className={`${accountType==="student" ? 
            "bg-gray-900 text-gray-50":
            "bg-transparent text-gray-300"} py-2 px-5 rounded-full transition-all duration-200`}
            onClick={()=>setAccountType("student")}
            >
                Student
            </button>

            <button className={`${accountType==="instructor" ? 
            "bg-gray-900 text-gray-50":
            "bg-transparent text-gray-300"} py-2 px-5 rounded-full transition-all duration-200`}
             onClick={()=>setAccountType("instructor")}
            >
                Instructor
            </button>
            </div>

            <form onSubmit={submitHandler}
            className="flex flex-col w-full gap-y-4 mt-6" >
                {/* first and last name */}
               <div className="flex gap-x-2 " >
               <label htmlFor="" className="w-full" >
                    <p className="text-[0.875rem] text-gray-50 mb-1 leading-[1.375rem] "
                    >First Name <sup className="text-pink-400">*</sup> </p>

                    <input type="text" required
                    name="firstname" onChange={changeHandler}
                    placeholder="Enter First name" value={formData.firstname}
                    className="bg-gray-800 rounded-[0.5rem] text-gray-50 w-full p-[12px] border-b-gray-400 " />
                </label>

                <label htmlFor="" className="w-full" >
                    <p className="text-[0.875rem] text-gray-50 mb-1 leading-[1.375rem] "
                    >Last Name <sup className="text-pink-400">*</sup> </p>

                    <input type="text" required
                    name="lastname" onChange={changeHandler}
                    placeholder="Enter last name" value={formData.lastname} 
                    className="bg-gray-800 rounded-[0.5rem] text-gray-50 w-full p-[12px] border-b-gray-400 "/>
                </label>
               </div>

               {/* Add email id */}

               <label htmlFor="">
                    <p className="text-[0.875rem] text-gray-50 mb-1 leading-[1.375rem] "
                    >Email Address <sup className="text-pink-400">*</sup> </p>

                    <input type="email" required
                    name="email" onChange={changeHandler}
                    placeholder="Enter Email id" value={formData.email}
                    className="bg-gray-800 rounded-[0.5rem] text-gray-50 w-full p-[12px] border-b-gray-400 " />
                </label>

                {/* create password and confirm password */}
                <div className="flex gap-x-2 " >
                <label htmlFor="" className="w-full relative">
                    <p className="text-[0.875rem] text-gray-50 mb-1 leading-[1.375rem] "
                    >Create Paaword <sup className="text-pink-400">*</sup> </p>

                    <input type={showPassword ? ("text"):("password")} required
                    name="password" onChange={changeHandler}
                    placeholder="Enter Password" value={formData.password}
                    className="bg-gray-800 rounded-[0.5rem] text-gray-50 w-full p-[12px] border-b-gray-400 " />

                    <span className="absolute right-3 top-[38px] cursor-pointer "
                    onClick={()=>setShowPassword((prev)=>!prev)} >
                    {
                        showPassword ? (<AiOutlineEyeInvisible fontSize={24} fill="#AFB2BF"/>):
                        (<AiOutlineEye fontSize={24} fill="#AFB2BF"/>)
                    }
                    </span>
                </label>

                <label htmlFor="" className="w-full relative" >
                    <p className="text-[0.875rem] text-gray-50 mb-1 leading-[1.375rem] "
                    >Confirm Paaword <sup className="text-pink-400">*</sup> </p>

                    <input type={confirmPassword ? ("text"):("password")} required
                    name="confirmpassword" onChange={changeHandler}
                    placeholder="Confirm Password" value={formData.confirmpassword}
                    className="bg-gray-800 rounded-[0.5rem] text-gray-50 w-full p-[12px] border-b-gray-400 " />

                    <span className="absolute right-3 top-[38px] cursor-pointer  " 
                    onClick={()=>setConfirmPassword((prev)=>!prev)} >
                    {
                        confirmPassword ? (<AiOutlineEyeInvisible fontSize={24} fill="#AFB2BF" />):
                        (<AiOutlineEye fontSize={24} fill="#AFB2BF"/>)
                    }
                    </span>
                </label>
                </div>
                <button type="submit" className="bg-yellow-300 rounded-[8px] font-medium text-gray-900 px-[12px] py-[8px] mt-6 " >
                    Create Account
                </button>
            </form>
        </div>
    )
}

export default SignupForm