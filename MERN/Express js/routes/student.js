import express from "express";

const router = express.Router();

router.get("/all", (req, res) => {
  res.send("All students");
});
router.post("/create", (req, res) => {
  res.send("sign in new  students");
});
router.put("/update", (req, res) => {
  res.send("update students ID");
});
router.delete("/delete", (req, res) => {
  res.send("Remove students from DB");
});

export default router;
