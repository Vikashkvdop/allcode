
import { useRef } from 'react'
import './App.css'

function App() {
  
  let btnRef=useRef();
 function handleColor(){
  btnRef.current.style.backgroundColor='red'
 } 

  return (
    <div>
      <button ref={btnRef}>Change color</button>
      <button onClick={handleColor}>color Changer</button>
    </div>
  )
}

export default App
