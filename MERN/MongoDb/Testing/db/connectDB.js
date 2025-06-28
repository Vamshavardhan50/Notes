import mongoose from "mongoose";

const connectDB = async (DataBase_url) => {
  try {
    await mongoose.connect(DataBase_url);
    console.log("MongoDB connected successfully");
  } catch (err) {
    console.error("Error connecting to MongoDB:", err);
  }
};

export default connectDB;
