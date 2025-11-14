import express from "express";
import cors from "cors";
import { connectDB } from "./src/configs/db.js";
import userRoutes from "./src/User/user.route.js";
const app = express();


//Data base
try {
  connectDB();
} catch (error) {
  console.log(error);
  process.exit(1);
}


//middleware
app.use(cors());
app.use(express.json());

const reqLogger = (req, res, next) => {
  console.log(`${req.method} ${req.url} ${new Date().toISOString()}`);
  next();
};

app.use(reqLogger);
app.use(express.urlencoded({ extended: true }));
//Register Routes
app.use("/api/users",reqLogger, userRoutes);

app.listen(5000, () => {
  console.log("Server is runing 5000....");
});
