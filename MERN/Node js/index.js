import * as readline from "node:readline/promises";
import { stdin, stdout } from "node:process";

const rl = readline.createInterface({
  input: stdin,
  output: stdout,
});

async function menu() {
  console.log("📁File System Manager");

  const options = [
    "Create Folder",
    "Create File",
    "Write to File",
    "Delete the File",
    "Delete Folder",
    "List Items",
    "Exit",
  ];
  options.forEach((item, i) => console.log(`${i + 1}.${item}`));

  const answer = await rl.question("\nSelect the Option:");
  console.log(answer);
}

menu();
