import { useState } from 'react'

import './App.css'
import { Link, NavLink, Route, Routes } from 'react-router-dom'
import Home from './Components/Home'
import Support from './Components/support'
import About from './Components/About'
import Contactus from './Components/Contactus'
import Notfound from './Components/Notfound'
import Mainheader from './Components/Mainheader'

function App() {
  

  return (
    <div>

      <nav>
        <ul>
          <li>
            <NavLink to="/" >Home</NavLink>
          </li>
          <li>
            <NavLink to="support">Support</NavLink>
          </li>
          <li>
            <NavLink to="about">About</NavLink>
          </li>
          <li>
            <NavLink to="contact">Contact Us</NavLink>
          </li>
          
        </ul>
      </nav>
      <Routes>
       <Route path='/' element={<Mainheader/>} >
      <Route index element={<Home/>}/>
      <Route path='/support' element={<Support/>} />
      <Route path='/about' element={<About/>} />     
      <Route path='/contact' element={<Contactus/>} />
      <Route path='*' element={<Notfound/>} />
      </Route>

    </Routes>
    </div>
  )
}

export default App
