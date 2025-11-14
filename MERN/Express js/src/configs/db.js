import mongoose from "mongoose";

export const connectDB =  () => {
  const conn = mongoose.connect("mongodb://localhost:27017/test");
  console.log(`MongoDB Connected`);
};
