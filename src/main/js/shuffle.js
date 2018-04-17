const shuffle = require('fisher-yates');
const ParkMiller = require('park-miller');
const fs = require('fs');
const Stream = require('stream');

const lemario = fs.readFileSync('../resources/data/lemario.txt', 'utf8').split("\n");

const range = max => {
  const numbers = [];
  while (numbers.length < max)
    numbers.push(numbers.length + 1);
  return numbers;
};

const randomNumber = digits => () => Math.trunc(Math.random() * 10 ** digits);

const seeds = range(100).map(randomNumber(10));
fs.writeFileSync('../resources/data/seeds.txt', seeds.join("\n"));
seeds.forEach(seed => {
  const readable = Stream.Readable();
  const writeable = fs.createWriteStream(`../resources/shuffle/js/lemario_shuffle_${seed}.txt`, {flags: 'w'});
  readable.pipe(writeable);

  const random = new ParkMiller(seed);
  // Got to use old function because shuffle
  // depends on scope switching
  function nextFloat() {
    return random.float();
  }

  shuffle(lemario, nextFloat).forEach(line => readable.push(`${line}\n`));
  readable.push(null);
});
