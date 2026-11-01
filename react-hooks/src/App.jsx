import { useEffect, useState } from 'react'

import './App.css'

function App() {
  const[text,setText]=useState(''); 
  const[name,setName]=useState('vikash');

  //variation 1 every change 
  // useEffect( () =>{
  //   console.log("UI rendered");
  // })

  //variation 2 first render
  // useEffect( ()=>{
  //   console.log("ui rendered");
  // },[]);

  //variation 3 first render+ whenever dependency change
  // useEffect(()=>{
  //   console.log("changed observed");
  // },[name]);

  //variation 4 to handle unmounting of a component
  useEffect(()=>{
    //add event listner
    console.log("listener added");

    return ()=>{
      console.log("listener removed");
    }
  },[text]);

  function changeHandler(event){
    console.log(text);
    setText(event.target.value);
  }
  return(
    <div>
      <input type="text" onChange={changeHandler} />

    </div>
  )
}

export default App
