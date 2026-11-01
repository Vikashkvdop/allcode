import { Link } from "react-router-dom"
import Logo from "../assets/Logo.svg"
import toast from "react-hot-toast";

const Navbar=(props)=>{
    let IsLoggedIn=props.isLoggedIn;
    let setIsLoggedIn=props.setIsLoggedIn;
    return(
        <div className="flex justify-between items-center w-11/12 max-w-[1160px] py-4 mx-auto  " >
            <Link>
            <img src={Logo} alt="" width={160} height={32} loading="lazy" />
            </Link>

            <nav>
                <ul className="flex text-gray-100 gap-x-6 " >
                    <li>
                        <Link to="/" >Home</Link>
                    </li>

                    <li>
                        <Link to="/" >About</Link>
                    </li>

                    <li>
                        <Link to="/" >Contact</Link>
                    </li>
                </ul>
            </nav>

            <div className="flex items-center gap-x-4  " >
                { !IsLoggedIn &&
                    <Link to="/login" >
                    <button className="bg-gray-800 text-gray-100 py-[8px] px-[12px] rounded-[8px] border border-gray-700 "
                    >Log in</button>
                    </Link>
                }
                { !IsLoggedIn &&
                    <Link to="/signup" >
                    <button className="bg-gray-800 text-gray-100 py-[8px] px-[12px] rounded-[8px] border border-gray-700 "
                    >Sign up</button>
                    </Link>
                }
                {  IsLoggedIn &&
                    <Link to="/" >
                    <button onClick={()=>{
                        setIsLoggedIn(false);
                        toast.success("Logged Out");
                    }}
                    className="bg-gray-800 text-gray-100 py-[8px] px-[12px] rounded-[8px] border border-gray-700 "
                    >Log Out</button>
                    </Link>
                }
                { IsLoggedIn &&
                    <Link to="/dashboard" >
                    <button className="bg-gray-800 text-gray-100 py-[8px] px-[12px] rounded-[8px] border border-gray-700 "
                    >Dashboard</button>
                    </Link>
                }
            </div>

        </div>
    )
}

export default Navbar