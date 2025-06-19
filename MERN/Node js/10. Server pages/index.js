import http from "http";
import fs from "fs";

const server = http.createServer((req, res) => {
  if (req.url === "/") {
    res.writeHead(200, "OK", { "Content-Type": "text/html" });
    fs.readFile("./public/home.html", (error, data) => {
      if (error) throw error;
      res.end(data);
    });
  }
});

server.listen(8000, () => console.log("Server is running on port 8000"));
