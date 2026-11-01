import React, { useState } from 'react';
import './App.css';
import './data.jsx';
import Tours from './components/Tours.jsx';
import data from './data.jsx'

const App = () => {
   
  const [tours, setTours] = useState(data);

  function removeTour(id) {
    const newTours = tours.filter(tour => tour.id !== id);
    setTours(newTours);
  }
  
  if (tours.length === 0) {
      return (
        <div className="h-[100vh] flex justify-center items-center flex-col ">
          <h2>No Tours Left</h2>
          <button className="mt-[18px] p-[12px] border rounded-sm  border-gray-200 hover:bg-[rgb(255,255,255)] hover:text-black ease-[<0.2s>] " onClick={() => setTours(data)}>Refresh</button>
        </div>
      );
    }
  return (
      <div className="app">
       
        <Tours tours={tours} removeTours={removeTour} />
      </div>
    )
};

export default App;
