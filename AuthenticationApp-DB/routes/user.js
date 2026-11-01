const express=require("express");
const router=express.Router();

const {login,signup}=require("../controllers/auth");
const {auth, isStudent, isAdmin}=require("../middlewares/Auth");
const User=require("../models/users");

router.post("/login",login);
router.post("/signup",signup);


//testing protected routes for single middlerware
router.get("/test",auth,(req,res)=>{
    res.json({
        success:true,
        message:"Welcome to the protected route for Tests",
    });
})


//Protected Route
router.get("/student",auth , isStudent,(req,res)=>{
    res.json({
        success:true,
        message:'Welcome to the Protected route for Students',
    });
})

router.get("/admin",auth,isAdmin,(req,res)=>{
    res.json({
        success:true,
        message:"Welcome to the Protected route for Admin",
    })
});

router.get("/getEmail",auth,async (req,res)=>{
    try{
        const id=req.user.id;
        const user=await User.findById(id);

        res.status(200).json({
            success:true,
            user:user,
            message:'Welcome to the email route',
        })
    }
    catch(error){
        res.status(500).json({
            success:false,
            error:error.message,
            message:'Error while getting id',
        })
    }
})

module.exports=router;