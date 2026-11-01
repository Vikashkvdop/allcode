
const express = require("express");
const dotenv = require("dotenv");
const userRoutes= require('./routes/User');
const prescriptionRoutes= require('./routes/Prescription');
const conditionRoutes= require('./routes/Condition');
// Load env variables first
dotenv.config();

const connectDB = require("./config/db");

const app = express();

const PORT = process.env.PORT || 4000;

app.use(express.json());

connectDB();

app.use("/api/auth",userRoutes);
app.use("/api/prescription",prescriptionRoutes);
app.use("/api/condition", conditionRoutes);

app.listen(PORT, () => {
  console.log(`Server is running at ${PORT}`);
});
