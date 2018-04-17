const shuffle = require('fisher-yates');
const ParkMiller = require('park-miller');
const fs = require('fs');

const lemario = fs.readFileSync('../resources/data/lemario.txt', 'utf8').split("\n");
const random = new ParkMiller(9965168727);

// Got to use old function because shuffle
// depends on scope switching
function nextFloat() {
  return random.float();
}

shuffle(lemario, nextFloat)
    .slice(0, 10)
    .forEach(line => console.log(line));
