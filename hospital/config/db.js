const mongoose=require("mongoose");

const MONGO_URL=process.env.MONGO_URL;


const connectDB = async ()=>{
    try {
        console.log("Connecting to:", MONGO_URL);
        await mongoose.connect(MONGO_URL,{
            useNewUrlParser:true,
            useUnifiedTopology:true,
        });
        console.log("MongoDB connected successfully");
    } catch (error) {
        console.error("MongoDB connection failed:", error.message);
        process.exit(1);
    }
};

module.exports=connectDB;