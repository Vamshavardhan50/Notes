import http from "http";

// create server
const server = http.createServer((req, res) => {
  console.log(req);
  res.setHeader("Content-Type", "text/html");
  // res.statusCode = 404;
  // res.statusMessage = "Not Found";
  res.write("Hello from node js");

});

server.listen(8000, () => {
  console.log("Server is running on port 8000");
});
