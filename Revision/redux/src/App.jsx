import { useState } from 'react'

import './App.css'
import { useDispatch, useSelector } from 'react-redux'
import { decrement, increment,incrementByAmount,reset } from './features/counter/counterSlice'

function App() {
  const count=useSelector((state)=>state.counter.value)
  const dispatch=useDispatch();

  const [amount,setAmount]=useState(0);

  function handleAmount(){
    dispatch(incrementByAmount(amount))
  }
  return (
    <div className='container'>
      <button className='increment' onClick={()=>dispatch(increment())}>Increment</button>
      <div className="">{count}</div>
      <button className="decrement" onClick={()=>dispatch(decrement())}>Decrement</button>

      <button className='reset'onClick={()=> dispatch(reset())} >Reset</button>

      <input type="Number"
      value={amount}
      placeholder='Enter Amount'
      onChange={(e)=> setAmount(e.target.value)}
       />
        
        <button onClick={handleAmount}>Increment by amount</button>
    </div>
  )
}

export default App
