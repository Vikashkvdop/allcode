import React from 'react'
import Card from './Card';
const Tours = (props) => {

    function removeHandler(id) {
        console.log(id);
        props.removeTours(id);
    }

    return (
        <div className='flex justify-center flex-row flex-wrap'>
            <div>
                <h2 className=' border-[10px] border-dashed border-[#0111a0] rounded-3xl text-5xl m-[6vh] p-[5vw] '>Plan with Love</h2>
            </div>
            <div className='flex justify-center flex-row flex-wrap max-w-[1300px] m-auto  '>
                {
                    props.tours.map((tour) => {
                        return <Card {...tour} key={tour.id} removeTour={removeHandler} />;
                    })
                }
            </div>
        </div>
    )
}

export default Tours;