import http from "http";

// create server
const server = http.createServer((req, res) => {
  //Routing
  if (req.url === "/") {
    res.write("<h1>Hello from node js</h1>");
  } else if (req.url === "/about") {
    res.write("<h1>About page</h1>");
  } else {
    res.write("<h1>404 not found</h1>");
  }
});

server.listen(8000, () => {
  console.log("Server is running on port 8000");
});
