//Server Instantiate
const express=require('express');
const app=express();


//activate the server on 2000 port
app.listen(2000,()=>{
    console .log("server started at port no.2000")
});

//used to parse req.body in express-> out or post
const bodyParser=require('body-parser');

//specifically parse JSON data & add it to the request.Body object
app.use(bodyParser.json());

//Routes
app.get('/',(req,res)=>{
    res.send("helbbo bhai");
})



app.post('/api/cars',(request,response)=>{
    const {name,brand}=request.body;
    console.log(name);
    console.log(brand);
    response.send("car submitted Sucessfully.");
})

const mongoose=require('mongoose');
mongoose.connect('mongodb://localhost:27017/myDatabase',{
    useNewurlParser:true,
    useUnifiedTopology:true
})
.then(()=>{console.log("connection successful")})
.catch((error)=>{console.log("Recived an eroor")});