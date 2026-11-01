const File=require("../models/File");
const cloudinary=require("cloudinary").v2; 

//local fie setup handler function
exports.localFileUpload=async (req,res)=>{
    try{
        //fetch file
        const file=req.files.file;
        console.log("File here",file);

        let path=__dirname + "/files/" + Date.now() + `${file.name.split('.'[1])}` ;
        console.log("Path ->",path)

        file.mv(path,(err)=>{
            console.log(err);
        });
        res.json({
            success:true,
            Message:'Local File Uploaded Successfully',
        });
    }catch(error){
        console.log("Not able to upload the file on server");
        console.log(error);
    }
}

function isFileTypeSupported(type,supportedTypes){
    return supportedTypes.includes(type);
}

async function uploadFileToCloudinary(file,folder,quality ){
    const options={folder};
    if(quality){
        options.quality=quality;
    }
    options.resource_type="auto";
    return await cloudinary.uploader.upload(file.tempFilePath,options);
}

//image upload handler
exports.imageUpload=async (req,res)=>{
    try{
        //data fetch
        const {name,tags,email}=req.body;
        console.log(name,tags,email);

        const file=req.files.imageFile;
        console.log(file);

        //validation
        const supportedTypes=["jpg","jpeg","png"];
        const fileType=file.name.split('.')[1].toLowerCase();

        if(!isFileTypeSupported(fileType,supportedTypes)){
            return res.status(400).json({
                success:false,
                Message:'File format not supported',
            })
        }

        //file fromat supported 
        const response=await uploadFileToCloudinary(file,"VikashDb");
        console.log(response);

        //Save entry into Database
        const fileData=await File.create({
            name,
            tags,
            email,
            imageUrl:response.secure_url,
        })

        res.json({
            success:true,
            imageUrl:response.secure_url,
            message:'Image uploaded Successfully',
        })
    } catch(error){
        console.error(error);
        res.status(400).json({
            success:false,
            message:'Something went wrong',
        });
    }
}


// video upload handler

exports.videoUpload=async (req,res)=>{
    try{
        // data fetch
        const {name,tags,email}=req.body;
        console.log(name,tags,email);

        const file=req.files.videoFile;

        //validation
        const supportedTypes=["mp4","mov"];
        const fileType=file.name.split('.')[1].toLowerCase();
        console.log("File Type:",fileType);

        // To do add a upper limit of 5MB for video
        if(!isFileTypeSupported(fileType,supportedTypes)){
            return res.status(400).json({
                success:false,
                message:'File format not supported',
            })
        }

        // if file format supported 
        console.log("Upoalding to vikashDb");
        const response=await uploadFileToCloudinary(file,"VikashDb");
        console.log(response);


        // create entry in database
        const fileData=await File.create({
            name,
            tags,
            email,
            imageUrl:response.secure_url,
            message:'Video Successfully Uploaded',
        })
    } catch(error){
        console.error(error);
        res.status(400).json({
            success:false,
            message:'Something went wrong',
        })
    }
}


//image size reducer
exports.imageSizeReducer=async (req,res)=>{
    try{
         //data fetch
         const {name,tags,email}=req.body;
         console.log(name,tags,email);
 
         const file=req.files.imageFile;
         console.log(file);
 
         //validation
         const supportedTypes=["jpg","jpeg","png"];
         const fileType=file.name.split('.')[1].toLowerCase();
 
         if(!isFileTypeSupported(fileType,supportedTypes)){
             return res.status(400).json({
                 success:false,
                 Message:'File format not supported',
             })
         }
 
         //file fromat supported 
         const response=await uploadFileToCloudinary(file,"VikashDb",30);
         console.log(response);
 
         //Save entry into Database
         const fileData=await File.create({
             name,
             tags,
             email,
             imageUrl:response.secure_url,
         })
 
         res.json({
             success:true,
             imageUrl:response.secure_url,
             message:'Image uploaded Successfully',
         })
    }catch(error){
        console.error(error);
        res.status(400).json({
            success:false,
            message:"Something went Wrong",
        });
    }
}
