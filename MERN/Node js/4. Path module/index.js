//Path module
import path from 'path';

//Basename
console.log(path.basename("c:\\nodejs\\app.js",".js"));

//Directory name
console.log(path.dirname("c:\\nodejs\\app.js",));

//Extension name
console.log(path.extname("c:\\nodejs\\app.js",));

//Join
console.log(path.join('c','nodejs','vamsha.js'));

//Parse
console.log(path.parse("c:\\nodejs\\app.js"));

//Resolve
console.log(path.resolve("c:\\nodejs\\app.js"));


//Normalize
console.log(path.normalize("c:\\nodejs\\app.js"));

//Relative
console.log(path.relative("c:\\nodejs\\app.js","c:\\nodejs\\vamsha.js"));


