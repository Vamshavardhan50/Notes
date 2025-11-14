import fs, { read } from "fs";
import http from "http";

// create server
const server = http.createServer((req, res) => {
  if (req.url !== "/") {
    res.end();
  }
  // const readableStream = fs.readFileSync("sample.txt");
  // return res.end(readableStream);

  // const readableStream = fs.createReadStream("sample.txt");
  // readableStream.pipe(res);

  //copy a big file in a bad way
  // const file = fs.readFileSync("sample.txt");
  // fs.writeFileSync("output.txt", file);
  // res.end();

  //copy a big file in a good way

  const readStream = fs.createReadStream("sample.txt");
  const writeStream = fs.createWriteStream("output.txt");

  readStream.on("data", (chunk) => {
    writeStream.write(chunk);
  });
  res.end();
});

server.listen(5000, () => {
  console.log("Server is running on port 5000");
});
