//import mongoose to connect with databse and server

const mongoose=require("mongoose");

require("dotenv").config();

const connectWithDb=()=>{
    mongoose.connect(process.env.DATABASE_URL,{
        useNewUrlParser:true,
        useUnifiedTopology:true,
    })
    .then(console.log("Db connected sucessfully"))
    .catch((err)=>{
        console.log("Db facing connection issue");
        console.log(err);
        process.exit(1);
    })
};

module.exports=connectWithDb;  