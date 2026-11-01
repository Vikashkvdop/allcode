const express = require('express');
const { supabase, supabaseAdmin } = require('./config/supabase');
const app = express();

const authRoute=require('./routes/auth.route');
const procurementRoute=require('./routes/procurement.routes');
const morgan = require('morgan');



app.use(express.json({ limit: '5mb' }));
app.use(morgan('dev'));


// Routes 
app.use('/auth',authRoute);
app.use('/procurement',procurementRoute);


async function testConnection() {
  const {  error } = await supabaseAdmin
  
  if (error) {
    console.error('Error connecting to Supabase:', error)
  } else {
    console.log('Connected successfully! Supabase')
  }
}

testConnection()


app.get('/', (req, res) => {
  res.send('HR Module Backend is running ');
});

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));

module.exports=app;