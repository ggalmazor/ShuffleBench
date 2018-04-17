const shuffle = require('fisher-yates');
const lcg = require('compute-lcg');
const fs = require('fs');
const Stream = require('stream');

const range = max => {
	const numbers = [];
	while(numbers.length < max)
		numbers.push(numbers.length + 1);
	return numbers;
}

const randomNumber = digits => () => Math.trunc(Math.random() * 10 ** digits);

const lemario = fs.readFileSync('../resources/data/lemario.txt', 'utf8')
       .split("\n")
       .map(line => line.trim())
       .filter(line => line.length > 0);

const seeds = range(100).map(randomNumber(10));
fs.writeFileSync('../resources/data/seeds.txt', seeds.join("\n"));
seeds.forEach(seed => {
	const readable = Stream.Readable();
	const writeable = fs.createWriteStream(`../resources/shuffle/js/lemario_shuffle_${seed}.txt`, { flags : 'w' });
	readable.pipe(writeable);
	shuffle(lemario, lcg(seed)).forEach(line => readable.push(`${line}\n`));
	readable.push(null);
});
