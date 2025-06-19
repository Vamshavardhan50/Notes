import { URL } from 'url';

const myurl = new URL('https://www.google.com:8000/search?q=nodejs');

console.log(myurl.href);
console.log(myurl.toString());
console.log(myurl.host);
console.log(myurl.hostname);
console.log(myurl.port);
console.log(myurl.pathname);
console.log(myurl.protocol);
console.log(myurl.search);
console.log(myurl.searchParams);
