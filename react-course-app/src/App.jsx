import { useEffect, useState } from 'react'
import React from 'react'
import './App.css'
import { apiUrl,filterData } from './data'
import Navbar from './Components/Navbar'
import Filter from './Components/Filter'
import Cards from './Components/Cards'
import { toast } from 'react-toastify'

function App() {
  
   const[courses,setCourses]=useState('');
   const [category,setCategory]=useState(filterData[0].title);
   useEffect(()=>{
    const fetchData=async()=>{
      try{
        const res=await fetch(apiUrl);
        const output =await res.json();
        //save data into variable
        setCourses(output.data);
      }
      catch(error){
        toast.error("Something went wrong");

      }
    }
    fetchData();
   },[]);
  return (
    <div className='min-h-screen flex flex-col bg-gray-800' >
       <Navbar></Navbar>

       <div className='bg-gray-800'>
       <Filter filterData={filterData} category={category} setCategory={setCategory} />
        

        <div className='w-11/12 max-w-[1200px] mx-auto flex justify-center items-center min-h-[50vh] flex-wrap '>
        <Cards courses={courses} category={category} />
        </div>
       </div>
    </div>
  )
}

export default App
