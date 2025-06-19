import * as fs from "fs/promises";

//Creating Directory / Folder
// try {
//   await fs.mkdir("D:\\vamsha");
//   console.log("Directory created successfully");
// } catch (error) {
//   console.log(error);
// }

//Remove Directory / Folder
// try {
//   await fs.rmdir("D:\\vamsha");
//   console.log("Directory removed successfully");
// } catch (error) {
//   console.log(error);
// }

//Reading the content from the file
// try {
//   const files = await fs.readFile("D:\\vamsha");
//   console.log("Read the content successfully");
//   console.log(files);
// } catch (error) {
//   console.log(error);
// }

// Reading the content from the file
// try {
//   const files = await fs.readFile("D:\\vamsha\\New Text Document.txt", "utf-8");
//   console.log("Read the content from the file");
//   console.log(files);
// } catch (error) {
//   console.log(error);
// }

//Create and write the content to the file
// try {
//   await fs.writeFile("README.md", "Hello Vamsha");
//   console.log("File created and content written successfully");
// } catch (error) {
//   console.log(error);
// }

//Append the content to the file
// try {
//   await fs.appendFile("README.md", "Hello shainu");
//   console.log("File  Updated  successfully");
// } catch (error) {
//   console.log(error);
// }



//Copy the file
// try {
//   await fs.appendFile("README.md", "info.txt");
//   console.log("Copied Successfully");
// } catch (error) {
//   console.log(error);
// }


//Get the file info
// try {
//   const fileInfo = await fs.stat("README.md");
//   console.log(fileInfo);
// } catch (error) {
//   console.log(error);
// }



//ES6

fs.mkdir("D:\\vamsha",(error)=>{
  if(error) throw error;
  console.log("Directory created successfully");
})
