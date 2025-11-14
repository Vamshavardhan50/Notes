import express from "express";
import User from "./user.model.js";

const router = express.Router();

router.post("/", async (req, res) => {
  const { name, email, password } = req.body;
  await User.create({ name, email, password });
  console.log(name, email, password);
  res.json({ message: "All ok" });
});

export default router;
