import signupImg from "../assets/signup.png"
import Template from "../Components/Template"


const Signup=({setIsLoggedIn})=>{
    return(
        <Template
            title="Welcome Back"
            desc1="Build skills for today,tomorrow, and beyond." 
            desc2="Education to future-proof your career."
            image={signupImg}
            formtype="signup"
            setIsLoggedIn={setIsLoggedIn} 
        />
    )
}

export default Signup