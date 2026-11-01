import { useState } from 'react'

import './App.css'
import Random from './components/Random'
import Tag from './components/Tag'
import dotenv from  'dotenv'

function App() {
  const API_KEY=process.env.REACT_APP_GIPHY_API_KEY
  console.log(API_KEY);
  return (
   <div className='w-full h-screen flex flex-col background relative overflow-x-hidden items-center ' >

    <h1 className='bg-white rounded-lg text-center  w-11/12 mt-[40px]  
    font-bold px-10 py-2 text-3xl  ' >RANDOM GIFS</h1>
    <div className='flex flex-col w-full items-center gap-y-10 mt-[30px] ' >
     <Random/>
     <Tag/>
    </div>
    
   </div>
  )
}

export default App
