import React, { useState } from "react";

const Card = ({ id, image, info, price, name, removeTour }) => {
    const [readmore, setReadMore] = useState(false);
    const description = readmore ? info : `${info.substring(0, 200)}....`;

    function readmoreHandler() {
        setReadMore(!readmore);
    }


    return (
        <div className="w-[400px] h-max m-[1rem] p-[1rem] flex flex-wrap flex-col rounded-3xl items-center shadow-md ">
            <img src={image} className=" w-[300px] aspect-square object-cover " alt="img"/>
            <div className=" m-[20px] ">
                <div className="tourDetails">
                    <h4 className="text-[#1faa59] text-[1.3rem] ">₹ {price}</h4>
                    <h4 className="text-[1.5rem] ">{name}</h4>
                </div>
                <div className="description">
                    {description}
                    <span className="text-[#12b8c8] capitalize cursor-pointer " onClick={readmoreHandler}>
                        {readmore ? `show less` : `read more`}
                    </span>
                </div>
            </div>
            <button className="text-center  mt-[18px] p-[10px] border border-[#b4161b] cursor-pointer
            text-[18px]  bg-[#b4161b21] ease-[<0.2s>] text-black rounded-sm hover:bg-red-500 hover:text-white " onClick={() => removeTour(id)}>
                Not Interested
            </button>
        </div >
    );
};

export default Card;
