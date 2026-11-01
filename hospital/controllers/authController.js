const user = require("../models/user");
const bcrypt= require('bcryptjs');
const jwt= require('jsonwebtoken');
const dotenv = require("dotenv");
dotenv.config();


exports.signup=async (req,res)=>{
    try {
        const {name,email,password,accountType}=req.body;

        //validation
        if(!name || !email || !password || !accountType){
            return res.status(403).json({
                success:false,
                message:"All fields are required"
            });
        }

        const existingUser=await user.findOne({email});
        if(existingUser){
            return res.status(400).json({
                success:false,
                message:"User is already exist"
            });
        }

        const hashedPassword=await bcrypt.hash(password,10);

        const User=await user.create({
            name,
            email,
            password:hashedPassword,
            accountType
        });

        return res.status(200).json({
            success:true,
            message:'User registered successfully',
            User,
        });
    } catch (error) {
        console.error(error);
        return res.status(500).json({
            success:false,
            message:'User cannot be registered. Please try again later'
        });
    }
};



exports.login = async (req, res) => {
    try {
        const { email, password } = req.body;

        if (!email || !password) {
            return res.status(403).json({
                success: false,
                message: "All fields are required."
            });
        }

        const User = await user.findOne({ email });
        if (!User) {
            return res.status(401).json({
                success: false,
                message: "User is not registered, please signup."
            });
        }

        const isMatch = await bcrypt.compare(password, User.password);
        if (!isMatch) {
            return res.status(401).json({
                success: false,
                message: "Password is incorrect"
            });
        }

        const payload = {
            email: User.email,
            id: User._id,
            accountType: User.accountType
        };

        console.log("JWT_SECRET =", process.env.JWT_SECRET); // debug line

        const token = jwt.sign(payload, process.env.JWT_SECRET, {
            expiresIn: "2h"
        });

        res.status(200).json({
            success: true,
            token,
            user: {
                id: User._id,
                email: User.email,
                accountType: User.accountType
            },
            message: "Logged in Successfully"
        });
    } catch (error) {
        console.log(error);
        return res.status(500).json({
            success: false,
            message: "Login failure, Please try again"
        });
    }
};
