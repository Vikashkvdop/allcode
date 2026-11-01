import { useState } from 'react'
import './App.css'
import Navbar from './Components/Navbar'
import { Route, Routes } from 'react-router-dom'
import Home from './Pages/Home'
import Dashboard from './Pages/Dashboard'
import Login from './Pages/Login'
import Signup from './Pages/Signup'
import PrivateRoute from './Components/PrivateRoute'

function App() {
  
  const [isLoggedIn,setIsLoggedIn]=useState(false);
  return (
   <div className='w-screen h-screen bg-gray-900 flex flex-col overflow-x-hidden ' >
    <Navbar isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} />

    <Routes>

      <Route path='/' element={<Home isLoggedIn={isLoggedIn} />} />
      
      <Route path='/login' element={<Login setIsLoggedIn={setIsLoggedIn} />} />
      <Route path='/signup' element={<Signup setIsLoggedIn={setIsLoggedIn} />} />
      <Route path='/dashboard' element={

        <PrivateRoute isLoggedIn={isLoggedIn} >
          <Dashboard/>
        </PrivateRoute>
        
        } />

    </Routes>
   </div>
  )
}

export default App
