import { useNavigate } from "react-router-dom"



const About=()=>{
    const navigate=useNavigate();
    const clickHandler=()=>{
        navigate("/support");
    }
    return(
        <div>
            This is About page

            <div>
            <button className="outline" onClick={clickHandler} >Support page</button>
            </div>
        </div>
    )
}
export default About