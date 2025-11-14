import * as fs from "fs";

//Callback function
await fs.mkdir("D:\\vamsha2", function (error) {
  if (error) throw error;
  console.log("Directory created successfully");
});
