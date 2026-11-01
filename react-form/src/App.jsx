import { useState } from 'react'

import './App.css'

function App() {
  const [formData,setFormData]=useState({firstName:"",lastName:"",email:"",comments:"",country:""
    ,address:"",city:"",state:"",pincode:"",comment:false,candidates:false,offers:false,rd:""
  });

  // console.log(formData); 

  function changeHandler(event){
    const {name,value,checked,type}=event.target

    setFormData(prevFormData => {
      return{
        ...prevFormData,
        [name]: type === "checkbox"?checked:value
      }
    })

  }

  const [submitted,setSubmitted]=useState(false);

  const submitHandler=(event)=>{
     event.preventDefault();
    //  console.log("printing entire form data");
     console.log(formData)
    
    setSubmitted(true);
    
  }

  return (
   <div className=' flex flec-col items-center justify-center  ' >
    { !submitted ? (
      <form action="" onSubmit={submitHandler} className='border' >
      <div className='m-3' >
        <div>
          <label htmlFor="firstName">First Name:</label>
        </div>
        
      <input type="text" placeholder='Vikash' onChange={changeHandler} 
      name='firstName' id='firstName'
      value={formData.firstName} required
      className='outline w-[700px] mt-1  ' />
      </div>
      

      <div className='m-3'>
        <div>
          <label htmlFor="lastName">Last Name:</label>
        </div>
      <input type="text" placeholder='Last Name' onChange={changeHandler} 
      name='lastName'
      value={formData.lastName}  id='lastName'
      className='outline w-[700px] mt-1'/>

      </div>
      
      <div className='m-3' >
        <div>
          <label htmlFor="email">Email ID</label>
        </div>
      <input type="email" placeholder='Enter your email here' onChange={changeHandler} name='email'
      value={formData.email} required
      id='email'
      className='outline w-[700px] mt-1' />
      </div>

      <div className='m-3'>
        <div>
        <label htmlFor="country">Country</label>
        </div>
        <select name="country" id="country"
        value={formData.country} onChange={changeHandler} 
        className='outline w-[700px] mt-1' >
          <option value="india">India</option>
          <option value="japan">Japan</option>
          <option value="nepal">Nepal</option>
          <option value="pakistan">Pakistan</option>
          <option value="china">China</option>
        </select>
      </div>

      <div className='m-3'>
        <label htmlFor="address">Street Adress</label>
        <br />
        <input type="text" id='address' placeholder='Permanent address min-30' name='address'
        onChange={changeHandler} value={formData.address} 
        className='outline w-[700px] mt-1'/>
      </div>

      <div className='m-3'>
        <label htmlFor="city">City</label>
        <br />
        <input type="text" id='city' placeholder='Dhanbad' name='city'
        onChange={changeHandler} value={formData.city} 
        className='outline w-[700px] mt-1'/>
      </div>

      <div className='m-3'>
        <label htmlFor="state">State</label>
        <br />
        <input type="text" id='state' placeholder='Jharkhand' name='state'
        onChange={changeHandler} value={formData.state} 
        className='outline w-[700px] mt-1'/>
      </div>

      <div className='m-3'>
        <label htmlFor="pincode">ZIP/PIN Code</label>
        <br />
        <input type='number' id='pincode' placeholder='815312' name='pincode' required
        onChange={changeHandler} value={formData.pincode} 
        className='outline w-[700px] mt-1'/>
      </div>
      
      <br />
      <fieldset className='m-3'>
        <legend>By Emails</legend>

        <div className='flex'>
        <input type="checkbox" checked={formData.comment} onChange={changeHandler} 
        name='comment' id='comments' />
        <div className='pt-6 pl-1' >
          <label htmlFor="comments"> Comments</label>
          <p className='opacity-50 ' >Get Notified when someone posts comments </p>
        </div>
        </div>

        <div className='flex'>
        <input type="checkbox" checked={formData.candidates} onChange={changeHandler} 
        name='candidates' id='candidates'  />
        <div className='pt-6 pl-1'>
          <label htmlFor="candidates" >Candidates</label>
          <p className='opacity-50 '>Get Notified when candidate apply for job</p>
        </div>
        </div>

        <div className='flex'>
        <input type="checkbox" checked={formData.offers} onChange={changeHandler} 
        name='offers' id='offers' />
        <div className='pt-6 pl-1'>
          <label htmlFor="offers">Offers</label>
          <p className='opacity-50 '>Get notified when candidate get accept or reject</p>
        </div>
        </div>
      </fieldset>
      
       <br />
      <fieldset className='m-3'>
        <legend>Push Notification</legend>
        <p>These are deliverd via sms or emails</p>

        <div>
          <input type="radio" onChange={changeHandler} name='rd' value={formData.rd} 
          id='rd1'/>
          <label htmlFor="rd1"> Everything</label>
        </div>

        <div>
          <input type="radio" onChange={changeHandler} name='rd' value={formData.rd} 
          id='rd2'/>
          <label htmlFor="rd2"> Same as email</label>
        </div>

        <div>
          <input type="radio" onChange={changeHandler} name='rd' value={formData.rd} 
          id='rd3'/>
          <label htmlFor="rd3"> No push notification</label>
        </div>
      </fieldset>

      <button className='text-white bg-blue-500 py-1 px-5 rounded font-bold m-3' >
        Save</button>
     
      
    </form>
    ):(
      <div>
        <h3>Submitted details</h3>
        <p><strong>Name:</strong> {formData.firstName} {formData.lastName}</p>
          <p><strong>Email:</strong> {formData.email}</p>
          <p><strong>Comment:</strong> {formData.comments}</p>
          <p><strong>Visibility:</strong> {formData.isVisible ? "Visible" : "Not Visible"}</p>
          <p><strong>Mode:</strong> {formData.mode}</p>
          <p><strong>Favourite Car:</strong> {formData.favCar}</p>
        <button onClick={()=> setSubmitted(false)} >Edit</button>
      </div>
    )}
   </div>
  ) 

}

export default App
