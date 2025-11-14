import express from "express";
import connectDB from "./db/connectDB.js";
import { createDoc } from "./models/movie.js";
import { alldocs } from "./models/movie.js";

const app = express();
const PORT = process.env.PORT || 8000;
const DataBase_url = process.env.mongoURI || "mongodb://localhost:27017/Movies";
connectDB(DataBase_url);
// createDoc();
alldocs();
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
