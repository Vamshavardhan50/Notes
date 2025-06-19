//Custome Readable/Writeable streams
const { write } = require("fs");
const { Readable, Writeable } = require("stream");

//  

const writeableStream = new Writeable({
  write() {},

  // or

  // write:function(){}
});
